package com.example.demo.error;

/**
 * 描述：业务异常
 * @author wangyu
 * @date 2019/5/17
 */

public class BusinessException extends RuntimeException {
    public BusinessException(){}

    public BusinessException(String message){
        super(message);
    }
}
