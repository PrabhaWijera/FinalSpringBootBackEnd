package com.example.prabhash.paymentserver.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Data

public class Payment_entity {

    @Id
    private String payID;

    private int DailyIncome;
    private int AnnualIncome;
    private int MonthlyIncome;
    private int WeeklyIncome;

}
