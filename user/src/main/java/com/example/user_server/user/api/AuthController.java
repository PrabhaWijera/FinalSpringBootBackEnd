package com.example.user_server.user.api;


import com.example.user_server.user.dto.Guide_dto;
import com.example.user_server.user.dto.User_dto;
import com.example.user_server.user.entity.UserEntity;
import com.example.user_server.user.fiegn.GuideAuthfiegnInterface;
import com.example.user_server.user.res.ResponseController;
import com.example.user_server.user.service.custom.AuthService;
import com.example.user_server.user.service.custom.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.core.env.Environment;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.multipart.MultipartFile;

@RestController
@RequestMapping("api/v1/auth")
@CrossOrigin(origins = "http://localhost:63342")

public class AuthController {

    @Autowired
    private ResponseController response;
    @Autowired
    private AuthService authService;

    //load balancer
    @Autowired
    Environment environment;
    private RestTemplate restTemplate;

    @Autowired
    private UserService userService;

    // fiegn
    @Autowired
    GuideAuthfiegnInterface guideAuthfiegnInterface;






    @PostMapping(path = "/register",produces = MediaType.APPLICATION_JSON_VALUE,consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseController register(@RequestBody UserEntity userDetails){

        authService.register(userDetails);
        System.out.println(environment.getProperty("local.sever.port"));

        return response;
    }

    @PostMapping(path = "/uploadImg",params = "user_id")
    public ResponseController uploadImage(@RequestParam("imgaeFile")MultipartFile multipartFile,@RequestParam("user_id") String user_id){
        ResponseController user= userService.search(user_id);

        User_dto userDto=(User_dto) user.getData();
        if (userDto !=null){
         /*   userDto.(userService.handleUpload(multipartFile));*/
           return userService.update(userDto);
        }
        throw new RuntimeException("User not found!!!");

    }

}
