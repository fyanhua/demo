package com.example.demo.advice;

import com.example.demo.exception.CustomizeException;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@ControllerAdvice
public class CustomizeExceptionHandler {
    @ExceptionHandler(Exception.class)
    ModelAndView handle(Throwable e, HttpServletRequest request, Model model, HttpServletResponse response) {
        if (e instanceof CustomizeException){
            model.addAttribute("message",e.getMessage());
        }else{
        model.addAttribute("message","服务异常，请稍后再试");

        }
            return new ModelAndView("error");
        }

    }

