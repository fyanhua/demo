package com.example.demo.model;

import lombok.Data;

import java.sql.Timestamp;

@Data
public class Exam {
    private Integer examId;
    private String examName;
    private Timestamp gmtCreate;
    private  String  creatorName;
    @Override
    public String toString() {
        return "Exam{" +
                "examId=" + examId +
                ", examName='" + examName + '\'' +
                '}';
    }
}
