package com.example.prabhash.guideserver.service;

import com.example.prabhash.guideserver.api.Guide_api;
import com.example.prabhash.guideserver.dto.Guide_dto;
import com.example.prabhash.guideserver.entity.Guide_entity;
import com.example.prabhash.guideserver.res.ResponseController;

public interface GuideService<T extends Guide_dto,ID> {
    ResponseController search(String id);

    ResponseController save(T t);

    ResponseController  update(T t);

    ResponseController  delete(String id);

    ResponseController  getAll();
    ResponseController  createResponse(int statusCode, Object data, String message);
}
