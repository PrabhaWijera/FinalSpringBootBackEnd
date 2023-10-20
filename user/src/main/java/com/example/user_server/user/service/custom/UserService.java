package com.example.user_server.user.service.custom;

import com.example.user_server.user.dto.User_dto;
import com.example.user_server.user.entity.UserEntity;
import com.example.user_server.user.res.ResponseController;
import com.example.user_server.user.service.SuperService;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;


public interface UserService extends SuperService<User_dto,String> {

   String handleUpload(MultipartFile imgfile);

   ResponseController getUserByUserName(String username,String password);

   Boolean passwordValidaor(String password,String hanshedPassword);

}
