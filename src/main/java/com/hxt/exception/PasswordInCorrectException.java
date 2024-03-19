package com.hxt.exception;

/**
 * 密码错误时的异常
 * 继承自基本异常类
 */
public class PasswordInCorrectException extends BaseException{

    public PasswordInCorrectException() {
    }

    public PasswordInCorrectException(String message) {
        super(message);
    }
}
