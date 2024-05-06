package org.fwx.interceptor;

import lombok.extern.slf4j.Slf4j;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * @ClassName LoginInterceptor
 * @Description TODO
 * @Author Fwx
 * @Date 2024/4/26 23:39
 * @Version 1.0
 */
@Slf4j
public class LoginInterceptor implements HandlerInterceptor {
    /**
     * 在处理请求之前进行拦截，用于判断用户是否已经登录。
     * 如果用户已登录，则放行；如果未登录，则重定向到登录页面，并提示需先登录。
     *
     * @param request  HttpServletRequest对象，用于获取请求信息
     * @param response HttpServletResponse对象，用于设置响应信息
     * @param handler  将要处理请求的处理器对象
     * @return boolean 返回true表示继续处理请求，返回false表示拦截请求并重定向到登录页
     * @throws Exception 抛出异常的处理
     */
    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        HttpSession session = request.getSession();
        // 检查session中是否已存在用户信息
        if (session.getAttribute("user") != null) {
            log.info("用户已登录，允许访问");
            return true; // 已登录，继续处理请求
        } else {
            // 未登录，设置提示信息并重定向到登录页面
            request.setAttribute("msg", "请先登录");
            request.getRequestDispatcher("/login").forward(request, response);
            log.info("用户未登录，拦截请求");
            return false; // 拦截请求
        }
    }


    @Override
    public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler, ModelAndView modelAndView) throws Exception {
        HandlerInterceptor.super.postHandle(request, response, handler, modelAndView);
    }

    @Override
    public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex) throws Exception {
        HandlerInterceptor.super.afterCompletion(request, response, handler, ex);
    }
}
