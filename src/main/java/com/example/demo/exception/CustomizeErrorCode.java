package com.example.demo.exception;

public enum CustomizeErrorCode implements ICustomizeErrorCode {
    QUESTION_NOT_FOUND(2001,"你找的问题不在了，要不要换个试试？"),
    TARGET_PARAM_NOT_FOUND(2002,"未选中问题"),
    NO_LOGIN(2003,"请先登录后重试");

    @Override
    public String getMessage(){ return message; }

    @Override
    public Integer getCode() {
        return code;
    }

    private String message;
    private Integer code;
    CustomizeErrorCode(Integer code, String message){
        this.code=code;
        this.message=message; }
}
