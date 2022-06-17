package com.javen;

import com.javen.config.ServletContainer;
import com.javen.realization.Request;
import com.javen.realization.Response;
import com.javen.servletabstract.HttpServlet;
import com.javen.util.ResponseUtil;

import java.io.IOException;
import java.io.InputStream;
import java.net.ServerSocket;
import java.net.Socket;

public class MyTomcat {

    //获取类对象生成servlet对象
    public void dispatch(Request request,Response response) throws  Exception {
        Class<HttpServlet> httpServetClass = ServletContainer.map.get(request.getUrlMapping());
        if(httpServetClass !=null){
            HttpServlet servlet = httpServetClass.newInstance(); //生成servlet对象
            servlet.service(request,response);
        }
    }

    //启动tomcat的主方法
    public void startUp() throws  Exception {
        //加载servlet信息
        ServletContainer.init(); //启动阶段


        //定义ServerSocket8080端口
        ServerSocket serverSocket = new ServerSocket(8081);
        while (true){
            Socket socket = serverSocket.accept();
            new Thread(new Runnable() {
                @Override
                public void run() {
                    try {
                        handler(socket);
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                }
            }).start();
        }
    }

    //解析用户请求数据
    public void handler(Socket socket) throws Exception {
        InputStream inputStream = socket.getInputStream();
        //每个线程一个请求
        Request request = new Request();

        getInput(inputStream, request);  //解析http请求

        //获取输出通道、获取输出流
        Response response = new Response(socket.getOutputStream());

        if(request.getUrlMapping().equals("")){
            //放回404
            response.write(ResponseUtil.getResponseHeader404());
        }else if(ServletContainer.map.get(request.getUrlMapping()) == null){
            //访问的是静态资源
            response.writeHtml(request.getUrlMapping());
        }else {
            //访问的是动态资源
            dispatch(request,response);
        }

    }

    //解析http请求
    public void getInput(InputStream inputStream, Request request) throws IOException {
        int count = 0;
        while (count ==0){
            count = inputStream.available();
        }
        byte[] bytes = new byte[count];
        inputStream.read(bytes);
        String content = new String(bytes);
        System.out.println(content);
        if(content.equals("")){
            System.out.println("你有一个空请求......");
        }else {
            String firstLine = content.split("\\n")[0];
            request.setType(firstLine.split("\\s")[0]); //请求类型
            request.setUrlMapping(firstLine.split("\\s")[1]); //请求路径
        }
    }

    public static void main(String[] args) throws Exception {
        MyTomcat myTomcat = new MyTomcat();
        myTomcat.startUp();
    }
}
