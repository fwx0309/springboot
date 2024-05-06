package org.fwx.servlet;

import lombok.extern.slf4j.Slf4j;

import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import javax.servlet.annotation.WebListener;

/**
 * @ClassName MyServletContextListener
 * @Description TODO
 * @Author Fwx
 * @Date 2024/4/27 19:53
 * @Version 1.0
 */
@Slf4j
//@WebListener
public class MyServletContextListener implements ServletContextListener {
    @Override
    public void contextInitialized(ServletContextEvent sce) {
        log.info("*** MyServletContextListener contextInitialized ***");
    }

    @Override
    public void contextDestroyed(ServletContextEvent sce) {
        ServletContextListener.super.contextDestroyed(sce);
    }
}
