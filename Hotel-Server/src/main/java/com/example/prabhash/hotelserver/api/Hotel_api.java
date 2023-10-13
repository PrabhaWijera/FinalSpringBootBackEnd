package com.example.prabhash.hotelserver.api;


import com.example.prabhash.hotelserver.dto.Hotel_dto;
import com.example.prabhash.hotelserver.res.ResponseController;
import com.example.prabhash.hotelserver.service.HotelService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.awt.*;

@CrossOrigin
@RequestMapping("/hotel_api")
@RestController
public class Hotel_api {

    Hotel_api(){
        System.out.println("Hotel api class Run!!");
    }

    @Autowired
    private HotelService hotelService;


    @PostMapping(path = "h_save",consumes = MediaType.APPLICATION_JSON_VALUE,produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseController save(@Valid @RequestBody Hotel_dto hotelDto){
        System.out.println("Hotel save working");
        return hotelService.save(hotelDto);
    }

    @PutMapping(path = "h_put",consumes = MediaType.APPLICATION_JSON_VALUE,produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseController update(@Valid @RequestBody Hotel_dto hotelDto){
        System.out.println("Hotel update working");
        return hotelService.update(hotelDto);
    }

    @DeleteMapping(path = "H_ID",params = "H_ID",produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseController delete(@Valid @RequestParam("H_ID") String H_ID){
        return hotelService.delete(H_ID);
    }

    @GetMapping(path = "H_search",params = "H_ID",produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseController search(@Valid @RequestParam("H_ID") String H_ID){
        return hotelService.search(H_ID);
    }


}
