package com.example.demo.mapper;

import com.example.demo.model.Exam;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ExamMapper {
  public   List<Exam> findExam();
}
