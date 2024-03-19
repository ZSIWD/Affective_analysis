package com.hxt.exception;

/**
 * 最基本的异常处理器
 * 继承自运行时异常
 */

public class BaseException extends RuntimeException {
    public BaseException() {
    }

    public BaseException(String message) {
        super(message);
    }
}
