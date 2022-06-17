package com.javen.realization;

import com.javen.servletinterface.HttpServetRequest;

/**
 * 实现类
 * 实现HttpServetRequest接口
 */
public class Request implements HttpServetRequest {
    private String type;
    private String url;
    @Override
    public String getType() {
        return this.type;
    }

    @Override
    public void setType(String type) {
        this.type = type;
    }

    @Override
    public String getUrlMapping() {
        return this.url;
    }

    @Override
    public void setUrlMapping(String url) {
        this.url = url;
    }
}
