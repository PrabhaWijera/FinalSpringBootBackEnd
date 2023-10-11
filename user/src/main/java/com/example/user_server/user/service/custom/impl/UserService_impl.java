package com.example.user_server.user.service.custom.impl;

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
import org.springframework.http.HttpStatus;


import org.springframework.stereotype.Service;

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
        // Check if the user with the specified user_id already exists
        UserEntity existingUser = (UserEntity) search(userDto.getUser_id()).getData();

        if (existingUser == null) {
            // Additional validation logic can be added here

            // Map the User_dto to UserEntity and save it
            UserEntity newUser = modelMapper.map(userDto, UserEntity.class);
            userRepo.save(newUser);

            return createResponse(HttpStatus.OK.value(), newUser, "User saved successfully");
        } else {
            // User with the same user_id already exists
            throw new RuntimeException("User with this ID already exists");
        }
    }

    @Override
    public ResponseController update(User_dto userDto) {
         if (search(userDto.getUser_id()).getData() !=null){
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



}
