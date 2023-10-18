package com.example.prabhash.paymentserver.dto;

import lombok.*;

import java.io.Serializable;
@AllArgsConstructor
@NoArgsConstructor
@Data
@Builder
@ToString
public class Payment_dto implements Serializable {

    private String payID;

    private int DailyIncome;
    private int AnnualIncome;
    private int MonthlyIncome;
    private int WeeklyIncome;

}
