package com.example.prabhash.hotelserver.entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Builder
@Data
@Entity
@Table
public class Hotel_entity {


    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private String hotelID;

    @NotBlank
    private String hotelName;
    private String hotelCategory;
    private String location;
    private String locationCoordinate;

    @NotBlank
    private String hotelEmail;

    @NotBlank
    private String contactNumber01;

    @NotBlank
    private String getContactNumber02;
    private String petsStatus;
    //Pets allowed or not

    @NotBlank
    private String hotelFee;

    private String criteria;

    private String remark;
}
