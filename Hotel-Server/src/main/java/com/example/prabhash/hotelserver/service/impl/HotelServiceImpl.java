package com.example.prabhash.hotelserver.service.impl;

import com.example.prabhash.hotelserver.dto.Hotel_dto;
import com.example.prabhash.hotelserver.entity.Hotel_entity;
import com.example.prabhash.hotelserver.fiegn.PackageInterface;
import com.example.prabhash.hotelserver.repo.Hotel_repo;
import com.example.prabhash.hotelserver.res.Response;
import com.example.prabhash.hotelserver.service.custom.HotelService;
import jakarta.transaction.Transactional;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
@Transactional
public class HotelServiceImpl implements HotelService {
    @Autowired
    private ModelMapper mapper;
    @Autowired
    private Hotel_repo hotelRepo;
    @Autowired
    private Response response;

    @Autowired
    private PackageInterface packageInterface;


    @Override
    public ResponseEntity<Response> add(Hotel_dto hotelDTO) {
        if (search(hotelDTO.getHotelId()).getBody().getData() == null) {
            hotelRepo.save(mapper.map(hotelDTO, Hotel_entity.class));
            Hotel_dto dto = (Hotel_dto) findByHotelName(hotelDTO.getHotelName()).getBody().getData();
            packageInterface.saveHotelID(hotelDTO.getPackageId(), dto.getHotelId());
            return createAndSendResponse(HttpStatus.CREATED.value(), "Hotel Successfully saved!", true);

        }
        return createAndSendResponse(HttpStatus.CONFLICT.value(), "Hotel Already Exists!", false);
    }

    @Override
    public ResponseEntity<Response> update(Hotel_dto hotelDTO) {
        if (search(hotelDTO.getHotelId()).getBody().getData() == null) {
            return createAndSendResponse(HttpStatus.NOT_FOUND.value(), "Hotel Not Found!", null);

        }
        Optional<Hotel_entity> hotelDto = hotelRepo.findById(hotelDTO.getHotelId());
        if (hotelDto.isPresent()) {
            packageInterface.updateHotelPackageId(hotelDto.get().getPackageId(), hotelDTO.getPackageId(), hotelDTO.getHotelId());
            hotelRepo.save(mapper.map(hotelDTO, Hotel_entity.class));


        }
        return createAndSendResponse(HttpStatus.OK.value(), "Hotel Successfully updated!", null);


    }

    @Override
    public ResponseEntity<Response> search(String s) {
        Optional<Hotel_entity> hotel = hotelRepo.findById(s);
        if (hotel.isPresent()) {
            return createAndSendResponse(HttpStatus.OK.value(), "Hotel Successfully retrieved!", mapper.map(hotel.get(), Hotel_dto.class));

        }
        return createAndSendResponse(HttpStatus.NOT_FOUND.value(), "Hotel Not Found!", null);
    }

    @Override
    public ResponseEntity<Response> delete(String s) {
        if (search(s).getBody().getData() == null) {
            return createAndSendResponse(HttpStatus.NOT_FOUND.value(), "Hotel Not Found!", null);

        }
        hotelRepo.deleteById(s);
        return createAndSendResponse(HttpStatus.OK.value(), "Hotel Successfully deleted!", null);


    }

    @Override
    public ResponseEntity<Response> getAll() {
        List<Hotel_entity> hotels = hotelRepo.findAll();
        if (!hotels.isEmpty()) {
            List<Hotel_dto> hotelDTOS = new ArrayList<>();
            hotels.forEach((hotel) -> {
                hotelDTOS.add(mapper.map(hotel, Hotel_dto.class));

            });
            return createAndSendResponse(HttpStatus.OK.value(), "Hotels Successfully retrieved!", hotelDTOS);

        }
        return createAndSendResponse(HttpStatus.NOT_FOUND.value(), "Hotels Not Found!", null);

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

    @Override
    public ResponseEntity<Response> deleteAllHotels(List<String> hotelIDList) {
        System.out.println("HotelServiceIMPL : " + hotelIDList);
        hotelIDList.forEach((hID) -> {
            hotelRepo.deleteById(hID);

        });
        return createAndSendResponse(HttpStatus.OK.value(), "Hotels Successfully deleted!", null);
    }

    @Override
    public ResponseEntity<Response> findByHotelName(String hotelName) {
        Optional<Hotel_entity> hotel = hotelRepo.findByHotelName(hotelName);
        if (hotel.isPresent()) {
            return createAndSendResponse(HttpStatus.OK.value(), "Hotel Successfully retrieved!", mapper.map(hotel.get(), Hotel_dto.class));

        }
        return createAndSendResponse(HttpStatus.NOT_FOUND.value(), "Hotel Not Found!", null);
    }
}
