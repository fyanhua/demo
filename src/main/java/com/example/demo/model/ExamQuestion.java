package com.example.demo.model;

import lombok.Data;
import lombok.ToString;

@ToString
@Data
public class ExamQuestion {
    private  Integer id;
    private  String subject;
    private  Integer examId;
    private String optiona;
    private String optionb;
    private String optionc;
    private String optiond;
    private String examName;

//    @Override
//    public String toString() {
//        return "Questions{" +
//                "id=" + id +
//                ", subject='" + subject + '\'' +
//                ", examId=" + examId +
//                ", examName='" + examName + '\'' +
//                ", optiona='" + optiona + '\'' +
//                ", optionb='" + optionb + '\'' +
//                ", optionc='" + optionc + '\'' +
//                ", optiond='" + optiond + '\'' +
//                '}';
//    }
}
