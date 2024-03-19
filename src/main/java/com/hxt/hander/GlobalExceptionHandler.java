package com.hxt.hander;

import com.hxt.exception.BaseException;
import com.hxt.result.Result;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class GlobalExceptionHandler {
    /**
     * 捕获业务异常
     */
    @ExceptionHandler(BaseException.class)
    public Result ExceptionHandler(BaseException ex){
        return Result.error(ex.getMessage());
    }
}
