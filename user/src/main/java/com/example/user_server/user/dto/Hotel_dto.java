package com.example.user_server.user.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;


@AllArgsConstructor
@NoArgsConstructor
@Builder
@Data
public class Hotel_dto implements Serializable,SuperDto {


    private String hotelID;
    private String hotelName;
    private String hotelCategory;
    private String location;
    private String locationCoordinate;
    private String hotelEmail;
    private String contactNumber01;
    private String getContactNumber02;
    private String petsStatus;
    //Pets allowed or not
    private String hotelFee;

    private String criteria;

    private String remark;


}
