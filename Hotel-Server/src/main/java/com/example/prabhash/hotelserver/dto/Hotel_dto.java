package com.example.prabhash.hotelserver.dto;

import jakarta.validation.Valid;
import jakarta.validation.constraints.*;
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


    private String hotelId;

    private String packageId;

    private String hotelName;

    private String hotelCategory;

    private String stars;

    private String hotelLocation;

    private String hotelLocationWithCoordinates;
    private String hotelImageLocation;

    private String hotelContactEmail;

    private String hotelContact1;

    private String hotelContact2;
    private double fullBoardWithACLuxuryRoomDouble;
    private double halfBoardWithACLuxuryRoomDouble;
    private double fullBoardWithACLuxuryRoomTriple;
    private double halfBoardWithACLuxuryRoomTriple;
    private boolean isPetsAllowed;

    private double hotelFee;

    private String cancellationCriteria;
    private String remarks;


}
