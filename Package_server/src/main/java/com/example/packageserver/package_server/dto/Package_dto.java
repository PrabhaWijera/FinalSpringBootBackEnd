package com.example.packageserver.package_server.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import java.io.Serializable;

@AllArgsConstructor
@NoArgsConstructor
@Data
@ToString
public class Package_dto implements Serializable,Super_dto{



    private String package_id;

    private String hotel_id;

    private String vehical_id;


}
