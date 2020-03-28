package com.example.demo.controller;

import com.example.demo.model.Exam;
import com.example.demo.service.ExamService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Api(tags = "测试信息")
@Controller
@RequestMapping("/exam")
public class ExamController {
//    @Autowired
//    private ExamQuestionsService examQuestionsService;

    //属性注入
    @Resource
    private ExamService examService;


    //跳转到在线测试选择界面
    @RequestMapping("/toExam")
    public String toExam(){
        return "/exam";
    }

    //返回测试选择，返回数据为json数据
    @ApiOperation(value = "测试表选择")
    @RequestMapping("/ExamList")
    @ResponseBody  // 用于转换对象为json
    public List<Exam> list(){
        List<Exam>  list=  examService.findExam();
        return list;
    }
//    //返回考试题目
//    @RequestMapping("/toExamPageList")
//    public String toExamPage(Integer examid, Model model, HttpSession session) {
//        //存储选择的id号
//        session.setAttribute("exam_id",examid);
//
//        //返回题目
//        List<Map<String,Object>> questionsList  = examQuestionsService.findExamQuestions(examid);
//        model.addAttribute("radioQuestionsList", questionsList);
//        return "exam/exampage";
//    }




    @RequestMapping("/toExamPage1")
    public String toExamPage1(Model model){
        Map<String, String> map = new HashMap<String, String>();
        map.put("name1", "value1");
        map.put("name2", "value2");
        map.put("name3", "value3");
        model.addAttribute("msg", map);
        return "welcome";
    }
}