package com.example.demo.service;

import java.util.List;
import java.util.Map;

public interface ExamQuestionService {

    public List<Map<String,Object>> findExamRadioQuestions(Integer examId);
}
