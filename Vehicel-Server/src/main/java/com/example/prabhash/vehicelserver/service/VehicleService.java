package com.example.prabhash.vehicelserver.service;

import com.example.prabhash.vehicelserver.dto.SuperDto;
import com.example.prabhash.vehicelserver.dto.Vehicle_dto;
import com.example.prabhash.vehicelserver.res.ResponseController;

public interface VehicleService  <T extends Vehicle_dto,ID>{
    ResponseController search(String id);

    ResponseController save(T t);

    ResponseController  update(T t);

    ResponseController  delete(String id);

    ResponseController  getAll();
    ResponseController  createResponse(int statusCode, Object data, String message);
}
