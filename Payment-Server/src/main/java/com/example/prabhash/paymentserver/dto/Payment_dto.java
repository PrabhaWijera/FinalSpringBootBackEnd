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
    private String DIncome;
    private String AIncome;
    private String MIncome;
    private String WIncome;

    private String packageId;

}
