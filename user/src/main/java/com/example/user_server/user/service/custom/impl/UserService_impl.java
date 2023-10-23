package com.example.user_server.user.service.custom.impl;

import com.example.user_server.user.config.JwtService;
import com.example.user_server.user.dto.User_dto;
import com.example.user_server.user.entity.UserEntity;
import com.example.user_server.user.repo.User_repo;
import com.example.user_server.user.res.ResponseController;
import com.example.user_server.user.service.custom.UserService;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.loadbalancer.Response;
import org.springframework.http.HttpStatus;


import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.util.*;

@Service
@Transactional
@RequiredArgsConstructor
@Slf4j
public class UserService_impl implements UserService {

    @Autowired
    private User_repo userRepo;


    @Autowired
    private ModelMapper modelMapper;


    @Autowired
    private ResponseController responseController;


    @Autowired
    private PasswordEncoder passwordEncoder;

    @Autowired
    private JwtService jwtService;



    @Override
    public ResponseController search(String id) {
        Optional<UserEntity> userEntity=userRepo.findById(id);
        if (userEntity.isPresent()){
            return createResponse(HttpStatus.FOUND.value(), modelMapper.map(userEntity.get(), User_dto.class),"Successful ");

        }
        return createResponse(HttpStatus.NOT_EXTENDED.value(), null,"Error");
    }


    @Override
    @Transactional
    public ResponseController save(User_dto userDto) {
        if (search(userDto.getUserId()).getData() == null) {
            userDto.setUserPassword(passwordEncoder.encode(userDto.getUserPassword()));

            userRepo.save(modelMapper.map(userDto, UserEntity.class));
            HashMap<String,Object> userRoles= new HashMap<>();
            userRoles.put("userRole",userDto.getUserRole());
            return createandSendResponed(HttpStatus.CREATED.value(), "User Successfully saved and JWT successfully generated!", jwtService.generateToken(userRoles,modelMapper.map(userDto, UserEntity.class)));

        }
        return createandSendResponed(HttpStatus.CONFLICT.value(), "User already exists!", null);
    }

    @Override
    public ResponseController update(User_dto userDto) {
         if (search(userDto.getUserId()).getData() !=null){
             userRepo.save(modelMapper.map(userDto,UserEntity.class));
             return createResponse(HttpStatus.OK.value(), null,"Update OK!");
         }
         throw new RuntimeException("No found");
    }

    @Override
    public ResponseController delete(String id) {
        if (search(id).getData()!=null){
            userRepo.deleteById(id);
            return createResponse(HttpStatus.OK.value(), null,"Delete ok!");
        }
        throw new RuntimeException("Not found");
    }

    @Override
    public ResponseController getAll() {
        List<UserEntity>userEntityList=userRepo.findAll();
        if (!userEntityList.isEmpty()){
            ArrayList<User_dto> userDto=new ArrayList<>();
            userEntityList.forEach(userEntity -> {
                userDto.add(modelMapper.map(userEntity, User_dto.class));
            });
            return createResponse(HttpStatus.FOUND.value(), userDto,"Success");
        }
        throw new RuntimeException("No found at all");
    }

    @Override
    public ResponseController createResponse(int statusCode, Object data, String message) {
        ResponseController responseController1=new ResponseController();
        responseController1.setStateCode(statusCode);
        responseController1.setData(data);
        responseController1.setMessage(message);
        return responseController1;
    }


    @Override
    public String handleUpload(MultipartFile imgfile) {
        return null;
    }

    @Override
    public ResponseController getUserByUserName(String username, String password) {
        Optional<UserEntity> user = userRepo.findByUserName(username);
        if (user.isPresent()){
            String hashPass=user.get().getPassword();
            if (passwordValidaor(password,hashPass)){
                User_dto userDto = modelMapper.map(user.get(), User_dto.class);
                userDto.setAuthenticated(true);
                return createandSendResponed(200,"user suck",userDto);
            }
        }
        return createandSendResponed(403,"user not suck",null);
    }

    @Override
    public Boolean passwordValidaor(String password, String hanshedPassword) {
      return passwordEncoder.matches(password,hanshedPassword);
    }

    @Override
    public ResponseController createandSendResponed(int statuscode, String message, Object data) {
       responseController.setStateCode(statuscode);
       responseController.setMessage(message);
       responseController.setData(data);
       return responseController;
    }

/*public ResponseEntity<ResponseController>createAndResponse(int statusCode,String message,Object data){
        responseController.setMessage(message);
        responseController.setData(data);
        return new ResponseEntity<>(responseController, HttpStatusCode.valueOf(statusCode));
}
    */
}
