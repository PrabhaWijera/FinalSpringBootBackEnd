package com.example.prabhash.hotelserver.service;

import com.example.prabhash.hotelserver.dto.SuperDto;
import com.example.prabhash.hotelserver.res.ResponseController;

public class HotelService_impl implements HotelService{





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
        responseController1.setStateCode(statusCode);
        responseController1.setData(data);
        responseController1.setMessage(message);
        return responseController1;
    }
}
