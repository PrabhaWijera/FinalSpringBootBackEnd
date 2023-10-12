package com.example.prabhash.packagedetailsserver.entity;


import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Builder
@Entity
public class PackageDetail_entity {


    @Id
    private String PackageDetailsID;



    private String UserID;

    private String GuideID;

    private String HotelID;

    private String VehicleID;

    private String PackID;

    //---------------------------



    private String travelTimeDuration;

    private String travelArea;

    private int NoAdult;

    private int NoChild;

    private int totalHeadCount;

    private String packageCategory;

    private String petAllowed;

    private String needGuide;

    private double packageValue;

    private  double paidValue;

    private String remark;


}
