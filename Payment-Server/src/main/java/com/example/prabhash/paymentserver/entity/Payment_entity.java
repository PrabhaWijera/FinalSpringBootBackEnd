package com.example.prabhash.paymentserver.entity;

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
public class Payment_entity {

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private String payID;
    private String DIncome;
    private String AIncome;
    private String MIncome;
    private String WIncome;

    private String packageId;

}
