package com.example.tensecondsserver.Exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class GlobalExceptionHandler{
    @ExceptionHandler(IllegalArgumentException  .class)
    public ResponseEntity<String> errorNoKeywordAll(IllegalArgumentException illegalArgumentException){
        ResponseEntity<String> responseEntity = new ResponseEntity<>(illegalArgumentException.getMessage(),HttpStatus.INTERNAL_SERVER_ERROR);
        return responseEntity;
    }
    @ExceptionHandler(NoKeyWordException.class)
    public ResponseEntity<String> noRecode(NoKeyWordException noKeyWordException){
        ResponseEntity<String> responseEntity = new ResponseEntity<>(noKeyWordException.getMessage(),HttpStatus.INTERNAL_SERVER_ERROR);
        return responseEntity;
    }
    @ExceptionHandler(WrongUserNamePasswordException.class)
    public ResponseEntity<String> wrongPassword(WrongUserNamePasswordException wrongUserNamePasswordException){
        return new ResponseEntity<>(wrongUserNamePasswordException.getMessage(),HttpStatus.INTERNAL_SERVER_ERROR);
    }
//    @ExceptionHandler(NoCountTimeResultError.class)
//    public ResponseEntity<String> noRecord(NoCountTimeResultError noCountTimeResultError){
//        ResponseEntity<String> responseEntity = new ResponseEntity<>("レコードがありません。",HttpStatus.INTERNAL_SERVER_ERROR);
//    }

}
