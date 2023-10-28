package com.example.prabhash.paymentserver.dto;

import lombok.*;

import java.io.Serializable;
@AllArgsConstructor
@NoArgsConstructor
@Data
@Builder
@ToString
public class Payment_dto implements Serializable, SuperDto {

    private String payID;
    private String userID;
    private String packageDetailsID;
    private String paymentDate;
    private double paymentAmount;
    private String paymentImageLocation;

}
