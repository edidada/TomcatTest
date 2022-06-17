package com.javen.realization;

import com.javen.servletinterface.HttpServetResponse;
import com.javen.util.FileUtil;
import com.javen.util.ResponseUtil;

import java.io.File;
import java.io.IOException;
import java.io.OutputStream;
import java.nio.charset.StandardCharsets;
/**
 * 实现类
 * 实现HttpServetResponse接口
 */
public class Response implements HttpServetResponse{

    private OutputStream outputStream;

    public Response(OutputStream outputStream){
        this.outputStream = outputStream;
    }

    @Override
    public void write(String context) throws IOException {
        outputStream.write(context.getBytes(StandardCharsets.UTF_8));
    }

    /**
     * 返回静态资源
     * @param path
     */
    public void writeHtml(String path) throws Exception {
        //获取 resources 下边文件的路径
        String resourcesPath =  FileUtil.getResoucePath(path);
        File file = new File(resourcesPath);
        if(file.exists()){
            System.out.println("静态资源存在");
            FileUtil.writeFile(file,outputStream);
        }else {
            write(ResponseUtil.getResponseHeader404());
        }
    }

}
