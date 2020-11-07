package com.example.tensecondsserver.Exception;

import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.servlet.HandlerExceptionResolver;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@ControllerAdvice
public class GlobalExceptionHandler{
    @ExceptionHandler(Exception.class)
    public String errorNoKeywordAll(Exception noKeyWordException) {
        System.out.print("こっちににきてr");
        return "ランキング外";
    }

}
