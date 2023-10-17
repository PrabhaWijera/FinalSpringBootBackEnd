package com.example.packageserver.package_server.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import java.io.Serializable;
import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@Data
@ToString
public class Package_dto implements Serializable,Super_dto{



    private String package_id;

    private String  vehical_list;

    private String hotel_list;

    private String user_list;

    private String guideID;

    private String packageCategory;
}
