package com.videoweb.videoweb.utils;

import org.springframework.context.support.GenericApplicationContext;

public class GeBean {
    private static GenericApplicationContext context = new GenericApplicationContext();

    static {
        context.refresh();
    }

    public static <T> T getBean(Class<T> beanClass) {
        return context.getBean(beanClass);
    }

    public static void destroy() {
        context.close();
    }
}
