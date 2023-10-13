package com.example.prabhash.vehicelserver.entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
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
    @NotBlank
    private String vehicleBrand;

    private String vehicleCategory;

    private String fuelType;

    private String hybrid;

    private String fuelUsage;
    @NotBlank
    private String vehicleFontImg;
    @NotBlank
    private String vehicleRearImg;
    @NotBlank
    private String vehicleSideImg;

    private String vehicleFontInteriorImg;

    private String vehicleRearInteriorImg;

    private String transmissionType;
    @NotBlank
    private String driverName;
    @NotBlank
    private String conNumber;
    @NotBlank
    private String driverlicenseImg;

    private String remarks;

    //others
}
