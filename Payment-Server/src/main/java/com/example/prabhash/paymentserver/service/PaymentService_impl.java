package com.example.prabhash.paymentserver.service;

import com.example.prabhash.paymentserver.dto.Payment_dto;
import com.example.prabhash.paymentserver.entity.Payment_entity;
import com.example.prabhash.paymentserver.repo.PaymentRepo;
import com.example.prabhash.paymentserver.res.ResponsController;
import org.bouncycastle.asn1.cms.OtherRecipientInfo;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.ui.Model;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class PaymentService_impl implements PaymentService{

    @Autowired
    private PaymentRepo paymentRepo;

    @Autowired
    private ModelMapper modelMapper;

    @Override
    public ResponsController search(String id) {
        Optional<Payment_entity>paymentEntity=paymentRepo.findById(id);
        if (paymentEntity.isPresent()){
            return createResponse(HttpStatus.FOUND.value(), modelMapper.map(paymentEntity.get(),Payment_dto.class),"Sucess");
        }
        return createResponse(HttpStatus.NOT_EXTENDED.value(), null,"No serch found Payment");
    }

    @Override
    public ResponsController save(Payment_dto paymentDto) {
        if (search(paymentDto.getPayID()).getData()==null){
            paymentRepo.save(modelMapper.map(paymentDto,Payment_entity.class));
            return createResponse(HttpStatus.FOUND.value(),null,"save payment");
        }
        throw new RuntimeException(" no save payment");
    }

    @Override
    public ResponsController update(Payment_dto paymentDto) {
        if (search(paymentDto.getPayID()).getData()!=null){
            paymentRepo.save(modelMapper.map(paymentDto,Payment_entity.class));
            return createResponse(HttpStatus.FOUND.value(),null,"update payment");
        }
        throw new RuntimeException(" no update payment");
    }

    @Override
    public ResponsController delete(String id) {
        if (search(id).getData()!=null){
            paymentRepo.deleteById(id);
            return  createResponse(HttpStatus.OK.value(), null,"delete payment ok");
        }
        throw new RuntimeException("No delete payment");
    }

    @Override
    public ResponsController getAll() {
         List<Payment_entity> paymentEntityList=paymentRepo.findAll();
         if (!paymentEntityList.isEmpty()){
             ArrayList<Payment_dto> paymentDtos=new ArrayList<>();
             paymentEntityList.forEach(paymentEntity -> {
                 paymentDtos.add(modelMapper.map(paymentEntity,Payment_dto.class));
             });
             return createResponse(HttpStatus.OK.value(), null,"found all ok");
         }
         throw new RuntimeException("not work get all payment");

    }

    @Override
    public ResponsController createResponse(int statusCode, Object data, String message) {
        ResponsController  responseController1=new ResponsController ();
        responseController1.setStatusCode(statusCode);
        responseController1.setData(data);
        responseController1.setMessage(message);
        return responseController1;
    }
}
