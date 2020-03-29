package com.example.demo.service.impl;

import com.example.demo.mapper.ExamQuestionMapper;
import com.example.demo.service.ExamQuestionService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;
import java.util.Map;
@Service
public class ExamQuestionServiceImpl implements ExamQuestionService {
    //属性注入
    @Resource
    private ExamQuestionMapper examQuestionMapper;

    @Override
    public List<Map<String,Object>> findExamRadioQuestions(Integer examId) {

        return examQuestionMapper.findExamRadioQuestions(examId);
    }

}
