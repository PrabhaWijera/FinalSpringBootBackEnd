package com.example.user_server.user.service.custom;

import com.example.user_server.user.config.JwtService;
import com.example.user_server.user.entity.UserEntity;
import com.example.user_server.user.repo.User_repo;
import com.example.user_server.user.res.ResponseController;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class AuthService {
    @Autowired
    private ResponseController response;
    @Autowired
    private User_repo userRepo;
    @Autowired
    private PasswordEncoder passwordEncoder;
    @Autowired
    private JwtService jwtService;

    public ResponseController register(UserEntity userDetails) {
        System.out.println(userDetails);
        String password = passwordEncoder.encode(userDetails.getPassword());
        userDetails.setUser_password(password);
        userRepo.save(userDetails);
        response.setStateCode(HttpStatus.OK.value());
        response.setMessage("User successfully registered and JWT Successfully generated!");
        response.setData("JWT : "+jwtService.generateToken(userDetails));
        return response;
    }


}
