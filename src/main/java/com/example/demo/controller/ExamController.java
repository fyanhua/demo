package com.example.demo.controller;

import com.example.demo.model.Exam;
import com.example.demo.service.ExamQuestionService;
import com.example.demo.service.ExamService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;
import javax.servlet.http.HttpSession;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Controller
@RequestMapping("/exam")
public class ExamController {
    @Resource
    private ExamQuestionService examQuestionService;

    //属性注入
    @Resource
    private ExamService examService;


    //跳转到在线测试选择界面
    @RequestMapping("/toExam")
    public String toExam(){
        return "/exam";
    }

    //返回测试选择，返回数据为json数据

    @RequestMapping("/ExamList")
    @ResponseBody  // 用于转换对象为json
    public List<Exam> list(){
        List<Exam>  list=  examService.findExam();
        return list;
    }
    //返回考试题目
    @RequestMapping("/toExamPageList")
    public String toExamPage(Integer examId, Model model, HttpSession session) {
        //存储选择的id号
        session.setAttribute("examId",examId);
        //返回题目
        List<Map<String,Object>> questionsList  = examQuestionService.findExamRadioQuestions(examId);
        model.addAttribute("questionList", questionsList);
        return "/exampage";
    }




    @RequestMapping("/toExamPage1")
    public String toExamPage1(Model model){
        Map<String, String> map = new HashMap<>();
        map.put("name1", "value1");
        map.put("name2", "value2");
        map.put("name3", "value3");
        model.addAttribute("msg", map);
        return "welcome";
    }
}