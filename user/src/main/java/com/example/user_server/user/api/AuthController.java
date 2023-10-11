package com.example.user_server.user.api;


import com.example.user_server.user.entity.UserEntity;
import com.example.user_server.user.res.ResponseController;
import com.example.user_server.user.service.custom.AuthService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("api/v1/auth")
@CrossOrigin

public class AuthController {

    @Autowired
    private ResponseController response;
    @Autowired
    private AuthService authService;
    @PostMapping(path = "/register",produces = MediaType.APPLICATION_JSON_VALUE,consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseController register(@RequestBody UserEntity userDetails){
        authService.register(userDetails);
        return response;
    }

}
