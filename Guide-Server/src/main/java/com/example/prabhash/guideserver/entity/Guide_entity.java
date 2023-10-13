package com.example.prabhash.guideserver.entity;


import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.validation.constraints.NotBlank;
import lombok.*;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Builder
@Entity
public class Guide_entity {

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private String guideID;
    @NotBlank
    private String guideName;
    @NotBlank
    private String guideAddress;
    @NotBlank
    private String guideAge;
    @NotBlank
    private String guideGender;
    @NotBlank
    private String guidePICImage;
    @NotBlank
    private String guideNICFrontIMG;
    @NotBlank
    private String guideNICRearIMG;
    @NotBlank
    private String guideIDscannedFrontIMG;
    @NotBlank
    private String guideIDscannedRearIMG;

    private String guideExperience;

    private int manDayValue;


    private String remark;
}
