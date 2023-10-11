package com.example.packageserver.package_server.advisor;

import com.example.packageserver.package_server.res.ResponseController;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@Component
@RestControllerAdvice
public class Advisor {

    @Autowired
    private ResponseController responseController;


    @ExceptionHandler({Exception.class})
    public ResponseController handleException(Exception exception){
        responseController.setStatus_code(HttpStatus.INTERNAL_SERVER_ERROR.value());
        responseController.setMessage("Sever threw an Exception"+exception.getLocalizedMessage());
        System.out.println(responseController.getMessage().toString());
        System.out.println(responseController.getData().toString());
        System.out.println(responseController.getStatus_code());
        responseController.setData(null);
        return responseController;
    }






}
