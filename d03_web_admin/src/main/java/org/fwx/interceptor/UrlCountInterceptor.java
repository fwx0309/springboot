package org.fwx.interceptor;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.HandlerInterceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * @ClassName UrlCountInterceptor
 * @Description TODO
 * @Author Fwx
 * @Date 2024/5/6 0:26
 * @Version 1.0
 */
@Component
public class UrlCountInterceptor implements HandlerInterceptor {
    @Autowired
    private StringRedisTemplate stringRedisTemplate;
    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        String requestURI = request.getRequestURI();
        stringRedisTemplate.opsForValue().increment(requestURI);
        return true;
    }
}
