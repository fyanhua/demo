package com.example.demo.mapper;

import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Map;
@Repository
public interface ExamQuestionMapper {

    public List<Map<String,Object>> findExamRadioQuestions(Integer examId);
}
