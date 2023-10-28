package com.example.prabhash.packagedetailsserver.entity;


import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Builder
@Entity
public class PackageDetail_entity {

    //---------------------------
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private String packageDetailsID;

    private String packageID;

    private String packageCategory;

    private int hotelID;

    private int vehicleID;

    private Date startDuration;

    private Date endDuration;



    private int noOfDays;

    private String travelArea;

    private int noOfAdults;

    private int noOfChildren;

    private int totalHeadCount;

    private boolean isPetsAllowed;

    private boolean isGuideNeeded;

    private String guideID;

    private String NameGuide;

    private double TotalPackageValue;

    private String userID;

    private double packagePaidValue;

    private String remark;
}
