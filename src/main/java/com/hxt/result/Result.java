package com.hxt.result;


import com.hxt.constant.MessageConstant;
import lombok.Data;

@Data
public class Result<T> {
    private Integer code;
    private String  msg;
    private T data;

    public Result() {
    }

    public Result(Integer code, String msg) {
        this.code = code;
        this.msg = msg;
    }

    public Result(Integer code, String msg, T data) {
        this.code = code;
        this.msg = msg;
        this.data = data;
    }

    public static <T> Result<T> success(){
        Result<T> result = new Result<>();
        result.code = 200;
        result.msg = MessageConstant.SUCCESS;
        return result;
    }
    // 泛型方法的K和泛型类的T 并无联系。
    public static <K> Result<K> success(K data){
        Result<K> result = new Result<>();
        result.code = 200;
        result.msg = MessageConstant.SUCCESS;
        result.data = data;
        return result;
    }

    public static <T> Result<T> error(T data, String msg){
        Result<T> result = new Result<>();
        result.code = 110;
        result.data = data;
        result.msg = msg;
        return result;
    }

    public static <T> Result<T> error(String msg){
        Integer code = 110;
        Result<T> result = new Result<>(code, msg);
        return result;
    }
}
