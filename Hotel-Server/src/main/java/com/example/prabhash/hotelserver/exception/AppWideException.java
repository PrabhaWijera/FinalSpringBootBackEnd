package com.example.prabhash.hotelserver.exception;


import com.example.prabhash.hotelserver.res.ResponseController;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
@CrossOrigin
public class AppWideException{

@ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
    @ExceptionHandler({RuntimeException.class})
    public ResponseController handleException(RuntimeException e){
    return new ResponseController(500,e.getLocalizedMessage(),null);
}

}
