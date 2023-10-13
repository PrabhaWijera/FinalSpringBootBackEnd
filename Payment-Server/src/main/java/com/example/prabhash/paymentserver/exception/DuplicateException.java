package com.example.prabhash.paymentserver.exception;

public class DuplicateException extends RuntimeException{

    public DuplicateException (String message){
        super(message);
    }
}
