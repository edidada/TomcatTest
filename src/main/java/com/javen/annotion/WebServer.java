package com.javen.annotion;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;
import java.util.concurrent.ConcurrentHashMap;

@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.TYPE)
public @interface WebServer {
    String url() default "";
}

