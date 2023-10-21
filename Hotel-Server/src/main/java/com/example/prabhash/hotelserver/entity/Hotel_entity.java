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

    private String hotelName;
    private String hotelCategory;
    private String location;
    private String locationCoordinate;

    private String hotelEmail;


    private String contactNumber01;

    private String getContactNumber02;

    private boolean petsStatus;
    //Pets allowed or not

    private String FullBoarddoublehotelFee;
    private String HalfBoardDoublehotelFee;
    private String FullBoardTriplehotelFee;
    private String HalfBoardTriplehotelFee;

    private String CancellationCriteria;

    private String remark;

    //other
    private String package_id;
}
