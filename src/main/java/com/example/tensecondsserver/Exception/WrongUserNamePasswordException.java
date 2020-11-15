package com.example.tensecondsserver.Exception;

public class WrongUserNamePasswordException extends RuntimeException {
    private static final long serialVersionUID = 1L;
    public WrongUserNamePasswordException(String msg){
        super(msg);
    }
}
