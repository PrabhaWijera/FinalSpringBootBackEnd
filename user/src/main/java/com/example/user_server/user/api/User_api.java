package com.example.user_server.user.api;


import com.example.user_server.user.dto.User_dto;

import com.example.user_server.user.res.ResponseController;
import com.example.user_server.user.service.custom.UserService;
import jakarta.annotation.PostConstruct;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.Base64;

@CrossOrigin
@RestController
@RequestMapping("/user_server")
public class User_api {

    User_api(){
        System.out.println("User_api_working_on");
    }


    @Autowired
    private UserService userService;

    // load balancing -telu

    @Autowired
    Environment environment;


//---------------------



//this goes to package
    @GetMapping( "/check")
    public String getCheck_USER(){
        System.out.println(environment.getProperty("local.sever.port"));
        return "User API RUNNING !!!!";
    }




    @PostMapping(value = "/save", consumes = MediaType.MULTIPART_FORM_DATA_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseController save(
            @RequestPart("userDto") User_dto userDto,
            @RequestPart("profilePicture") MultipartFile profilePicture

    ) throws IOException {
        // Handle userDto and profilePicture here
        System.out.println("User save working");

        System.out.println(userDto.getUserName());
        System.out.println(ResponseController.class);
        if (profilePicture != null) {
            // Convert the profilePicture to a Base64-encoded string
            String base64ProfilePicture = Base64.getEncoder().encodeToString(profilePicture.getBytes());

            // Set the Base64-encoded profile picture in the userDto
            userDto.setUserNic_Photo(base64ProfilePicture);
        }

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
