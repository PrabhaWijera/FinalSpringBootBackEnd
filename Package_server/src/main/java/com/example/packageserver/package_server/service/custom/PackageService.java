package com.example.packageserver.package_server.service.custom;

import com.example.packageserver.package_server.dto.Package_dto;
import com.example.packageserver.package_server.service.SuperService;

import java.util.List;

public interface PackageService extends SuperService<Package_dto,String> {
    List<Integer> getAllID();
}
