package org.fwx.exception;

import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

/**
 * @ClassName GlobalExceptionHandler
 * @Description 异常处理：@ControllerAdvice注解定义了一个全局的异常处理类。
 * @Author Fwx
 * @Date 2024/4/27 16:26
 * @Version 1.0
 */
@Slf4j
@ControllerAdvice
public class GlobalExceptionHandler {

    /**
     * 处理ArithmeticException和NullPointerException这两种异常。
     *
     * @param e 异常对象，捕获的异常信息将通过日志进行记录，并且会重定向到"login"页面。
     * @return 返回一个字符串"login"，用于指定发生异常后重定向到的页面。
     */
    @ExceptionHandler({ArithmeticException.class, NullPointerException.class})
    public String handleException(Exception e) {
        log.error("全局异常处理：{}", e); // 记录异常信息
        return "login"; // 重定向到登录页面
    }
}

