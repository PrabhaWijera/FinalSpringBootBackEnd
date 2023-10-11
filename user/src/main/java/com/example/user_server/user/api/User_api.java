package com.example.user_server.user.api;


import com.example.user_server.user.dto.User_dto;

import com.example.user_server.user.res.ResponseController;
import com.example.user_server.user.service.custom.UserService;
import jakarta.annotation.PostConstruct;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@CrossOrigin
@RestController
@RequestMapping("/user_server")
public class User_api {

    User_api(){
        System.out.println("User_api_working_on");
    }


    @Autowired
    private UserService userService;





    @GetMapping( "/check")
    public String getCheck_USER(){
        return "User API RUNNING !!!!";
    }

    @PostMapping(path = "/Usave",consumes = MediaType.APPLICATION_JSON_VALUE,produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseController save(@RequestBody User_dto userDto){
        System.out.println("User save working");
        return userService.save(userDto);
    }

    @PutMapping(path = "/Uput",consumes = MediaType.APPLICATION_JSON_VALUE,produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseController update(@RequestBody User_dto userDto){
        System.out.println("User Api Update");
        return userService.update(userDto);
    }

    @DeleteMapping(path = "/Udelete",params = "userID",produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseController delete(@RequestParam ("userID") String userId){
        return userService.search(userId);
    }

    @GetMapping(path = "/Usearch",params = "UserID",produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseController search(@RequestParam ("UserID") String userID){
        return userService.search(userID);
    }

}
