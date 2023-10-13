package com.example.prabhash.hotelserver.service;

import com.example.prabhash.hotelserver.dto.SuperDto;
import com.example.prabhash.hotelserver.res.ResponseController;
import org.springframework.stereotype.Service;

@Service
public interface HotelService <T extends SuperDto,ID> {

    ResponseController search(String id);

    ResponseController save(T t);

    ResponseController  update(T t);

    ResponseController  delete(String id);

    ResponseController  getAll();
    ResponseController  createResponse(int statusCode, Object data, String message);
}
