package com.example.user_server.user.advisor;

import com.example.user_server.user.res.ResponseController;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
@Component
public class Advisor {


    @Autowired
    private ResponseController responseController;

    @ExceptionHandler({Exception.class})
    public ResponseController handleException(Exception exception){
        responseController.setStateCode(HttpStatus.INTERNAL_SERVER_ERROR.value());
        responseController.setMessage("Sever threw an Exception"+exception.getLocalizedMessage());
        System.out.println(responseController.getMessage().toString());
        responseController.setData(null);
        return responseController;


    }
}
