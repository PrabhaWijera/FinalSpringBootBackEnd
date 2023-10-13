package com.example.prabhash.paymentserver.advisor;

import com.example.prabhash.paymentserver.res.ResponsController;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@Component
@RestControllerAdvice
public class Advisor {

    @Autowired
    private ResponsController responseController;


    @ExceptionHandler({Exception.class})
    public ResponsController handleException(Exception e){
        responseController.setStatusCode(HttpStatus.INTERNAL_SERVER_ERROR.value());
        responseController.setMessage("Server thre an Exception "+e.getLocalizedMessage());
        System.out.println(responseController.getMessage().toString());
        System.out.println(responseController.getData().toString());
        System.out.println(responseController.getStatusCode());
        responseController.setData(null);
        return responseController;
    }
}
