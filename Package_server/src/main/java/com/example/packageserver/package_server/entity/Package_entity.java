package com.example.packageserver.package_server.entity;

import jakarta.persistence.ElementCollection;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;


@Entity
@AllArgsConstructor
@NoArgsConstructor
@Data
public class Package_entity {

    @Id
    private String package_id;

    private String packageCategory;


    @ElementCollection
    private List<String> hotel_list;

    @ElementCollection//we cant use many to one
    private List<String> Vehical_id;

    @ElementCollection
    private List<String> user_list;

    @ElementCollection
    private List<String> guideID;

    private String packageDetails;



}
