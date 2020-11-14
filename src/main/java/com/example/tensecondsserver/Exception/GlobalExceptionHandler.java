package com.example.tensecondsserver.Exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.servlet.HandlerExceptionResolver;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.nio.file.NotLinkException;

@ControllerAdvice
public class GlobalExceptionHandler{
    @ExceptionHandler(IllegalArgumentException  .class)
    public ResponseEntity<String> errorNoKeywordAll(IllegalArgumentException illegalArgumentException){
        ResponseEntity<String> responseEntity = new ResponseEntity<>("すでに同じUsernameが使用されています。",HttpStatus.INTERNAL_SERVER_ERROR);
        return responseEntity;
    }
    @ExceptionHandler(NoKeyWordException.class)
    public ResponseEntity<String> noRecode(NoKeyWordException noKeyWordException){
        ResponseEntity<String> responseEntity = new ResponseEntity<>("まだレコードがありません。",HttpStatus.INTERNAL_SERVER_ERROR);
        return responseEntity;
    }

}
