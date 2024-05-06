package org.fwx.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

/**
 * @ClassName ResponseStatusException
 * @Description 异常处理
 * @Author Fwx
 * @Date 2024/4/27 16:42
 * @Version 1.0
 */
@ResponseStatus(value = HttpStatus.FORBIDDEN, reason = "用户名或密码错误")
public class ResponseStatusException extends RuntimeException {
    private String message;

    public ResponseStatusException() {
    }

    public ResponseStatusException(String message) {
        this.message = message;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }
}
