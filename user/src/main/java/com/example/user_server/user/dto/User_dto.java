package com.example.user_server.user.dto;


import com.example.user_server.user.entity.Role;
import lombok.*;

import java.io.Serializable;

@AllArgsConstructor
@NoArgsConstructor
@Data
@ToString
@Builder
public class User_dto implements Serializable ,SuperDto {

    private String user_id;

    private String userName;

    private String user_nic;

    private String user_password;

    private String gender;

    private String age;

    private String email;

    private String contactNumber;

    private String remark;

    private String userNic_Photo;

    private Role role;//string d dnne

    private boolean isAuthenticated;


/*
    private String userNic_Photo;*/
}
