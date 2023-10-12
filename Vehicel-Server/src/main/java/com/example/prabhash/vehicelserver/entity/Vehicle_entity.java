package com.example.prabhash.vehicelserver.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Table
@Entity
@Builder
public class Vehicle_entity {

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private String vehicleID;

    private String vehicleBrand;

    private String vehicleCategory;

    private String fuelType;

    private String hybrid;

    private String fuelUsage;

    private String vehicleFontImg;

    private String vehicleRearImg;

    private String vehicleSideImg;

    private String vehicleFontInteriorImg;

    private String vehicleRearInteriorImg;

    private String transmissionType;

    private String driverName;

    private String conNumber;

    private String driverlicenseImg;

    private String remarks;

    //others
}
