package com.example.swagger2.exception;

import lombok.Data;

public enum ServiceEnum {
    NOT_FOUND("404", "资源未找到"),
    ERROR("500", "服务器内部错误"),
    FORBIDDEN("403", "资源不可用");

    private String code ;
    private String message;

    ServiceEnum(String code, String message){
        this.code = code;
        this.message = message;
    }

    public String getCode() {
        return code;
    }

    public String getMessage() {
        return message;
    }

    @Override
    public String toString() {
        return "ServiceEnum{" +
                "code='" + code + '\'' +
                ", message='" + message + '\'' +
                '}';
    }
}
