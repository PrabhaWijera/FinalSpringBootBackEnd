package com.example.prabhash.packagedetailsserver.service;

import com.example.prabhash.packagedetailsserver.dto.PackageDetails_dto;
import com.example.prabhash.packagedetailsserver.res.Response;
import com.example.prabhash.packagedetailsserver.service.custom.SuperService;
import org.springframework.http.ResponseEntity;

import java.util.List;

public interface PackageDetailsService extends SuperService<PackageDetails_dto,String> {


    List<Integer> getAllID();
}
