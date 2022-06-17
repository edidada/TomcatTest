package com.javen.servlet;

import com.javen.annotion.WebServer;
import com.javen.servletabstract.HttpServlet;
import com.javen.servletinterface.HttpServetRequest;
import com.javen.servletinterface.HttpServetResponse;
import com.javen.util.ResponseUtil;

import java.io.IOException;

@WebServer(url = "/my")
public class MyServlet extends HttpServlet {
    @Override
    public void doGet(HttpServetRequest request, HttpServetResponse response) throws IOException {
        response.write(ResponseUtil.getResponseHeader200("this is get request"));
    }

    @Override
    public void doPost(HttpServetRequest request, HttpServetResponse response) throws IOException {
        response.write(ResponseUtil.getResponseHeader200("this is Post request"));
    }
}
