package com.javen.servletinterface;

public interface HttpServetRequest {
    /**
     * 获取请求类型
     * @return
     */
    String getType();

    /**
     * 写入请求类型
     * @return
     */
    void setType(String type);

    /**
     * 获取请求路径
     * @return
     */
    String getUrlMapping();

    /**
     * 写入请求路径
     * @return
     */
    void setUrlMapping(String url);

}
