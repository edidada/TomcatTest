package com.javen.util;

/**
 * 返回数据是应该添加的东西目的是让浏览器识别
 */
public class ResponseUtil {
    public  static  final String responseHeader200 = "HTTP/1.1 200 \r\n"+
            "Content-Type:text/html \r\n"+"\r\n";

    public  static  final String responseHeader404 = "HTTP/1.1 404 \r\n"+
            "Content-Type:text/html \r\n"+"\r\n" + "404";

    public static String getResponseHeader404(){
        return responseHeader404;
    }

    public static String getResponseHeader200(){
        return responseHeader200;
    }

    public static String getResponseHeader200(String context){
        return responseHeader200 + context;
    }

    public static void main(String[] args) {
        System.out.println("-----");
    }
}
