package com.example.demo.service.impl;

import com.example.demo.mapper.ExamMapper;
import com.example.demo.model.Exam;
import com.example.demo.service.ExamService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

@Service
public class ExamServiceImpl implements ExamService {
    @Resource
    private ExamMapper examMapper;
    @Override
    public List<Exam> findExam() {

        return examMapper.findExam();
    }
}
