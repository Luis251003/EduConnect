package com.luis.springboot.EduConnect.exceptions;

public class UnauthorizedAccessException extends RuntimeException{
    public UnauthorizedAccessException(String message){
        super((message));
    }
}
