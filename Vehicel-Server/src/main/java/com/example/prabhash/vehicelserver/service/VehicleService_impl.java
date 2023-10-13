package com.example.prabhash.vehicelserver.service;

import com.example.prabhash.vehicelserver.dto.SuperDto;
import com.example.prabhash.vehicelserver.res.ResponseController;
import org.springframework.stereotype.Service;


@Service
public class VehicleService_impl implements VehicleService{



    @Override
    public ResponseController search(String id) {
        return null;
    }

    @Override
    public ResponseController save(SuperDto superDto) {
        return null;
    }

    @Override
    public ResponseController update(SuperDto superDto) {
        return null;
    }

    @Override
    public ResponseController delete(String id) {
        return null;
    }

    @Override
    public ResponseController getAll() {
        return null;
    }

    @Override
    public ResponseController createResponse(int statusCode, Object data, String message) {
        ResponseController  responseController1=new ResponseController ();
        responseController1.setStatusCode(statusCode);
        responseController1.setData(data);
        responseController1.setMessage(message);
        return responseController1;
    }
}
