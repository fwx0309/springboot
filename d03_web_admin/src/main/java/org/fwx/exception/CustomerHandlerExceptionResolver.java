package org.fwx.exception;

import org.springframework.core.Ordered;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.HandlerExceptionResolver;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * @ClassName CustomerHandlerExceptionResolver
 * @Description TODO
 * @Author Fwx
 * @Date 2024/4/27 16:59
 * @Version 1.0
 */
@Order(value = Ordered.HIGHEST_PRECEDENCE)  // MIN_VALUE = -2147483648 优先级，数字越小优先级越高
//@Order(value = 1)
@Component
public class CustomerHandlerExceptionResolver implements HandlerExceptionResolver {
    /**
     * 解析异常的函数。
     * 当处理器方法抛出异常时，此方法将被调用以解析异常并提供适当的响应。
     *
     * @param request  当前HTTP请求对象，用于获取请求信息。
     * @param response 当前HTTP响应对象，用于设置响应状态码和消息。
     * @param handler  抛出异常的处理器对象。
     * @param ex       抛出的异常对象。
     * @return 返回一个ModelAndView对象，通常用于重定向或展示错误页面。
     */
    @Override
    public ModelAndView resolveException(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex) {
        try {
            // 尝试通过响应对象发送错误信息，设置状态码为500，自定义错误信息为"自定义异常处理试图解析器"
            response.sendError(500,"自定义异常处理试图解析器");
        } catch (IOException e) {
            // 如果在发送错误信息时发生IO异常，则抛出运行时异常
            throw new RuntimeException(e);
        }
        // 返回一个空的ModelAndView对象，通常表示不进行视图渲染，或进行重定向操作
        return new ModelAndView();
    }



}
