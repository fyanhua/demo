package com.example.demo.dto;

import com.example.demo.exception.CustomizeErrorCode;
import lombok.Data;

@Data
public class ResultDTO {
    private Integer code;
    private  String message;
    public  static ResultDTO errorOf(Integer code,String message){
        ResultDTO resultDTO = new ResultDTO();
        resultDTO.setCode(code);
        resultDTO.setMessage(message);
        return resultDTO;
    }

    public static Object errorOf(CustomizeErrorCode errorCode) {
        return errorOf(errorCode.getCode(),errorCode.getMessage());
    }
    public  static ResultDTO okOf(){
        return null
                ;
    }

}
