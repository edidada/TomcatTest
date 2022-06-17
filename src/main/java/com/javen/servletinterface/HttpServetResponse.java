package com.javen.servletinterface;

import java.io.IOException;

public interface HttpServetResponse {
    /**
     * 写回数据，发送至客户端
     */
    void write(String context) throws IOException;
}
