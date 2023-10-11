package com.example.user_server.user.service;

import com.example.user_server.user.dto.SuperDto;
import com.example.user_server.user.res.ResponseController;
import org.springframework.stereotype.Service;



public interface SuperService <T extends SuperDto,ID> {
    ResponseController search(String id);

    ResponseController save(T t);

    ResponseController update(T t);

    ResponseController delete(String id);

    ResponseController getAll();
    ResponseController createResponse(int statusCode,Object data,String message);
}
