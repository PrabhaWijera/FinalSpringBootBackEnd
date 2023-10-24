package com.example.prabhash.paymentserver.service;

import com.example.prabhash.paymentserver.dto.Payment_dto;
import com.example.prabhash.paymentserver.entity.Payment_entity;
import com.example.prabhash.paymentserver.repo.PaymentRepo;
import com.example.prabhash.paymentserver.res.Response;
import com.example.prabhash.paymentserver.service.custom.PaymentService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
@Transactional
public class PaymentService_impl implements PaymentService {

    @Autowired
    private PaymentRepo paymentRepo;
    @Autowired
    private Response response;
    @Autowired
    private ModelMapper modelMapper;

    @Override
    public ResponseEntity<Response> search(String id) {
        Optional<Payment_entity> paymentEntity=paymentRepo.findById(id);
        if (paymentEntity.isPresent()){
            return createAndSendResponse(HttpStatus.FOUND.value(), "sucsss",modelMapper.map(paymentEntity.get(),Payment_dto.class));
        }
        return createAndSendResponse(HttpStatus.NOT_EXTENDED.value(), "error found vehicle",null);
    }

    @Override
    public ResponseEntity<Response> save(Payment_dto paymentDto) {
        if (search(paymentDto.getPayID()).getBody().getData()==null){
            paymentRepo.save(modelMapper.map(paymentDto,Payment_entity.class));
            return createAndSendResponse(HttpStatus.OK.value(),"save ok pa",null);
        }
        throw new RuntimeException("pay save not ok");
    }

    @Override
    public ResponseEntity<Response> update(Payment_dto paymentDto) {
        if (search(paymentDto.getPayID()).getBody().getData()!=null){
            paymentRepo.save(modelMapper.map(paymentDto,Payment_entity.class));
            return createAndSendResponse(HttpStatus.FOUND.value(),"update payment",null);
        }
        throw new RuntimeException(" no update payment");
    }

    @Override
    public ResponseEntity<Response> delete(String id) {
        if (search(id).getBody().getData()!=null){
            paymentRepo.deleteById(id);
            return  createAndSendResponse(HttpStatus.OK.value(), "delete payment ok",null);
        }
        throw new RuntimeException("No delete payment");
    }

    @Override
    public ResponseEntity<Response> getAll() {
         List<Payment_entity> paymentEntityList=paymentRepo.findAll();
         if (!paymentEntityList.isEmpty()){
             ArrayList<Payment_dto> paymentDtos=new ArrayList<>();
             paymentEntityList.forEach(paymentEntity -> {
                 paymentDtos.add(modelMapper.map(paymentEntity,Payment_dto.class));
             });
             return createAndSendResponse(HttpStatus.OK.value(), "found all ok",null);
         }
         throw new RuntimeException("not work get all payment");

    }

    @Override
    public ResponseEntity<Response> createAndSendResponse(int statusCode, String msg, Object data) {
        response.setStatusCode(statusCode);
        response.setMessage(msg);
        response.setData(data);
        System.out.println("Status Code : " + statusCode);
        System.out.println("Sent : " + HttpStatus.valueOf(statusCode));

        return new ResponseEntity<>(response, HttpStatusCode.valueOf(statusCode));

    }


}
