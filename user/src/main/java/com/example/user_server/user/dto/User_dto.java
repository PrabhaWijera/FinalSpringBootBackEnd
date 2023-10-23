package com.example.user_server.user.dto;


import com.example.user_server.user.entity.GENDER;
import com.example.user_server.user.entity.Role;
import jakarta.persistence.*;
import lombok.*;

import java.io.Serializable;

@AllArgsConstructor
@NoArgsConstructor
@Data
@ToString
@Builder
public class User_dto implements Serializable ,SuperDto {

    private String userRole;

    private String userId;

    private String name;

    private String userName;

    private String userPassword;

    private String userNIC;

    private String userNICImageLocation;

    private int userAge;


    private GENDER gender;

    private String userEmail;

    private String userPhone;

    private String userAddress;

    private String remarks;

    private String userImageLocation;

    private boolean isAuthenticated;
}
