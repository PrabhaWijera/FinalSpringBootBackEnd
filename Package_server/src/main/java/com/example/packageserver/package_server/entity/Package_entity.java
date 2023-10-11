package com.example.packageserver.package_server.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


@Entity
@AllArgsConstructor
@NoArgsConstructor
@Data
public class Package_entity {

    @Id
    private String package_id;

    private String hotel_id;

    private String vehical_id;
}
