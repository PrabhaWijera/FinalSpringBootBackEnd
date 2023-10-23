package com.example.prabhash.guideserver.service;

import com.example.prabhash.guideserver.dto.Guide_dto;
import com.example.prabhash.guideserver.entity.Guide_entity;
import com.example.prabhash.guideserver.res.Response;
import org.springframework.http.ResponseEntity;

import java.util.Optional;

public interface GuideService<T extends Guide_dto,ID> {
    ResponseEntity<Response> search(String id);

    ResponseEntity <Response>save(T t);

    ResponseEntity <Response> update(T t);

    ResponseEntity<Response> findByGuideName(String guideName);

    ResponseEntity <Response> delete(String id);

    ResponseEntity <Response>getAll();
    ResponseEntity<Response> createAndSendResponse(int statusCode, String msg, Object data);

}
