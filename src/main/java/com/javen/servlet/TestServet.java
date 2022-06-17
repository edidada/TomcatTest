package com.javen.servlet;

import com.javen.annotion.WebServer;
import com.javen.servletabstract.HttpServlet;
import com.javen.servletinterface.HttpServetRequest;
import com.javen.servletinterface.HttpServetResponse;
@WebServer(url = "/test")
public class TestServet extends HttpServlet {
    @Override
    public void doGet(HttpServetRequest request, HttpServetResponse response) {

    }

    @Override
    public void doPost(HttpServetRequest request, HttpServetResponse response) {

    }
}
