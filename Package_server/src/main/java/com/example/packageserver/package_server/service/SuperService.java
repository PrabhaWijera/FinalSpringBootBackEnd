package com.example.packageserver.package_server.service;

import com.example.packageserver.package_server.dto.Package_dto;
import com.example.packageserver.package_server.dto.Super_dto;
import com.example.packageserver.package_server.res.ResponseController;

public interface SuperService <T extends Super_dto,ID>{
    ResponseController search(String id);

    ResponseController save(T t);

    ResponseController update(T t);

    ResponseController delete(String id);

    ResponseController getAll();
    ResponseController createResponse(int statusCode,Object data,String message);
}
