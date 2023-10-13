package com.example.prabhash.packagedetailsserver.service;

import com.example.prabhash.packagedetailsserver.dto.PackageDetails_dto;
import com.example.prabhash.packagedetailsserver.res.ResponseController;

public interface PackageDetailsService <T extends PackageDetails_dto,ID>{

    ResponseController search(String id);

    ResponseController save(T t);

    ResponseController  update(T t);

    ResponseController  delete(String id);

    ResponseController  getAll();
    ResponseController  createResponse(int statusCode, Object data, String message);
}
