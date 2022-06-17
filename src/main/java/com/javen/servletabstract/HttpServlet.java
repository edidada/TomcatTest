package com.javen.servletabstract;

import com.javen.servletinterface.HttpServetRequest;
import com.javen.servletinterface.HttpServetResponse;

import java.io.IOException;

/**
 * 抽象类
 * 判断请求类型，调用此类型方法
 */
public abstract class HttpServlet {

    public abstract void doGet(HttpServetRequest request, HttpServetResponse response) throws IOException;

    public abstract void doPost(HttpServetRequest request, HttpServetResponse response) throws IOException;

    public void service(HttpServetRequest request, HttpServetResponse response) throws IOException {
        if(request.getType().equals("GET")){
            doGet(request, response);
        }else if(request.getType().equals("POST")){
            doPost(request, response);
        }
    }
}
