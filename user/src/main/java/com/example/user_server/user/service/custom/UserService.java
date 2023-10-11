package com.example.user_server.user.service.custom;

import com.example.user_server.user.dto.User_dto;
import com.example.user_server.user.entity.UserEntity;
import com.example.user_server.user.service.SuperService;
import org.springframework.stereotype.Service;


public interface UserService extends SuperService<User_dto,String> {



}
