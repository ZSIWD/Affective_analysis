package com.hxt.exception;

/**
 * 用户不存在异常类
 */
public class UserNotFoundException extends BaseException{
    public UserNotFoundException(){
    }
    public UserNotFoundException(String msg){
        super(msg);
    }
}
