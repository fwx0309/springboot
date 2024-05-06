package org.fwx.servlet;

import lombok.extern.slf4j.Slf4j;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import java.io.IOException;

/**
 * @ClassName MyFilter
 * @Description TODO
 * @Author Fwx
 * @Date 2024/4/27 19:49
 * @Version 1.0
 */
@Slf4j
//@WebFilter(value = "/*")
public class MyFilter implements Filter {
    @Override
    public void init(FilterConfig filterConfig) throws ServletException {
        log.info("*** MyFilter初始化 ***");
    }

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        log.info("*** MyFilter执行了 ***");
        filterChain.doFilter(servletRequest, servletResponse);
    }

    @Override
    public void destroy() {
        log.info("*** MyFilter销毁了 ***");
    }
}
