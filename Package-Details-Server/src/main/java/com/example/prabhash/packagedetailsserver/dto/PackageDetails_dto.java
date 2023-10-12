package com.example.prabhash.packagedetailsserver.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
@AllArgsConstructor
@NoArgsConstructor
@Data
@Builder
public class PackageDetails_dto implements Serializable {


    private String PackageDetailsID;


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
