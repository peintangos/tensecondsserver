package com.example.tensecondsserver.Exception;

public class NoCountTimeResultError extends RuntimeException{
    private static final long serialVersionUID = 1L;
    public NoCountTimeResultError(String str){
        super(str);
    }
}
