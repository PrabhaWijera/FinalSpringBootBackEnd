package com.example.user_server.user.api;


import com.example.user_server.user.entity.UserEntity;
import com.example.user_server.user.res.ResponseController;
import com.example.user_server.user.service.custom.AuthService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.core.env.Environment;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;

@RestController
@RequestMapping("api/v1/auth")
@CrossOrigin

public class AuthController {

    @Autowired
    private ResponseController response;
    @Autowired
    private AuthService authService;

    //load balancer
    @Autowired
    Environment environment;


    private RestTemplate restTemplate;




    @PostMapping(path = "/register",produces = MediaType.APPLICATION_JSON_VALUE,consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseController register(@RequestBody UserEntity userDetails){

        authService.register(userDetails);
        System.out.println(environment.getProperty("local.sever.port"));
        return response;
    }

}
