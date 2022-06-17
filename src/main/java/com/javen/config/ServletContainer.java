package com.javen.config;

import com.javen.annotion.WebServer;
import com.javen.servletabstract.HttpServlet;
import com.javen.util.SearchClassUtil;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * servlet容器
 */
public class ServletContainer {
    /**
     * 存储servlet信息
     * key:请求路径
     * val:类信息
     */
    public static Map<String, Class<HttpServlet>> map = new HashMap<>();

    /**
     * 向map中放入数据
     */
    public static void init() {
        List<String> classPaths = SearchClassUtil.searchClass();
        System.out.println(classPaths);
        for(String path : classPaths){
            try {
                Class servlet = Class.forName(path);
                WebServer webServer = (WebServer) servlet.getDeclaredAnnotation(WebServer.class);
                map.put(webServer.url(), servlet);
            } catch (ClassNotFoundException e) {
                e.printStackTrace();
            }
        }

    }
}
