package com.example.tensecondsserver.Exception;

public class NoKeyWordException extends RuntimeException {
    private static final long serialVersionUID = 1L;
    public NoKeyWordException(String str){
        super(str);
    }
}
