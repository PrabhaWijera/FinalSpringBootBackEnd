package com.example.prabhash.paymentserver.service;

import com.example.prabhash.paymentserver.dto.Payment_dto;
import com.example.prabhash.paymentserver.res.ResponsController;

public interface PaymentService <T extends Payment_dto,ID>{
    ResponsController search(String id);

    ResponsController save(T t);

    ResponsController  update(T t);

    ResponsController  delete(String id);

    ResponsController  getAll();
    ResponsController  createResponse(int statusCode, Object data, String message);
}
