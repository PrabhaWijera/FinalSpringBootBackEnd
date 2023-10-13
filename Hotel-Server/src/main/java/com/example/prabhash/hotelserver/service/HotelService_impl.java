package com.example.prabhash.hotelserver.service;

import com.example.prabhash.hotelserver.dto.Hotel_dto;
import com.example.prabhash.hotelserver.dto.SuperDto;
import com.example.prabhash.hotelserver.entity.Hotel_entity;
import com.example.prabhash.hotelserver.repo.Hotel_repo;
import com.example.prabhash.hotelserver.res.ResponseController;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
@Service
@Transactional
public class HotelService_impl implements HotelService{

    @Autowired
    private Hotel_repo hotelRepo;

    @Autowired
    private ModelMapper modelMapper;


    @Override
    public ResponseController search(String id) {
        Optional<Hotel_entity> hotelEntity=hotelRepo.findById(id);
            if (hotelEntity.isPresent()){
                return createResponse(HttpStatus.FOUND.value(), modelMapper.map(hotelEntity.get(),Hotel_dto.class),"Sucess");

            }
            return createResponse(HttpStatus.NOT_EXTENDED.value(), null,"error");

    }

    @Override
    public ResponseController save(Hotel_dto hotelDto) {
    if (search(hotelDto.getHotelID()).getData()==null){
        hotelRepo.save(modelMapper.map(hotelDto,Hotel_entity.class));
   return createResponse(HttpStatus.OK.value(), null,"Sucess");

    }
    throw new RuntimeException("Hotel not exits!!!");
    }

    @Override
    public ResponseController update(Hotel_dto hotelDto) {
        if (search(hotelDto.getHotelID()).getData() !=null){
            hotelRepo.save(modelMapper.map(hotelDto,Hotel_entity.class));
            return createResponse(HttpStatus.OK.value(), null,"Success");
        }
        throw new RuntimeException("No found hotel update");
    }

    @Override
    public ResponseController delete(String id) {
        if (search(id).getData()!=null){
            hotelRepo.deleteById(id);
            return createResponse(HttpStatus.OK.value(), null
            ,"Delete ok hotel");
        }
        throw new RuntimeException("Not found delete hotel ");
    }

    @Override
    public ResponseController getAll() {
        List<Hotel_entity>hotelEntities=hotelRepo.findAll();
        if (!hotelEntities.isEmpty()){
            ArrayList<Hotel_dto>hotelDtos=new ArrayList<>();
             hotelEntities.forEach(hotelEntity -> {
                 hotelDtos.add(modelMapper.map(hotelEntities,Hotel_dto.class));
             });
             return createResponse(HttpStatus.FOUND.value(), hotelDtos,"Sucess get al  hotels");
        }
        throw new RuntimeException("No found ALL hotels");
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
