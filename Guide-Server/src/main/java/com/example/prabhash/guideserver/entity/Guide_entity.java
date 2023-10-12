package com.example.prabhash.guideserver.entity;


import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Builder
@Entity
public class Guide_entity {

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private String guideID;

    private String guideName;

    private String guideAddress;

    private String guideAge;

    private String guideGender;

    private String guidePICImage;

    private String guideNICFrontIMG;

    private String guideNICRearIMG;

    private String guideIDscannedFrontIMG;
    private String guideIDscannedRearIMG;

    private String guideExperience;

    private int manDayValue;


    private String remark;
}
