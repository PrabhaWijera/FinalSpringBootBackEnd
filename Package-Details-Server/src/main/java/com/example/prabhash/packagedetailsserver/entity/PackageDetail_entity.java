package com.example.prabhash.packagedetailsserver.entity;


import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
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

    //---------------------------
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private String packageID;

    private String packageCategory;
    private String travelDuration;
    private String travelArea;
    private String remark;
    private int noOfAdults;
    private int noOfChildren;
    private int totalHeadCount;
    private boolean isPetsAllowed;
    private boolean isGuideNeeded;
    private double packageValue;
    private double packagePaidValue;

    private int hotelID;
    private int vehicleID;
    private int userID;
    private int guideID;

}
