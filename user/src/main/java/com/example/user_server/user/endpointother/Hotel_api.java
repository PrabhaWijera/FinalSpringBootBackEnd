package com.example.user_server.user.endpointother;


import com.example.user_server.user.dto.Hotel_dto;
import com.example.user_server.user.fiegn.HotelAuthfiegnInterface;
import com.example.user_server.user.res.ResponseController;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.awt.*;

@CrossOrigin
@RequestMapping("api/v1/hotel_api")
@RestController
public class Hotel_api {

    Hotel_api(){
        System.out.println("Hotel api class Run in user !!");
    }


    @Autowired
   private HotelAuthfiegnInterface hotelAuthfiegnInterface;


    @PostMapping(path = "h_save",consumes = MediaType.APPLICATION_JSON_VALUE,produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseController save(@RequestBody Hotel_dto hotelDto){
        System.out.println("Hotel save working");
        return hotelAuthfiegnInterface.save(hotelDto);
    }

    @PutMapping(path = "h_put",consumes = MediaType.APPLICATION_JSON_VALUE,produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseController update(@RequestBody Hotel_dto hotelDto){
        System.out.println("Hotel update working");
        return hotelAuthfiegnInterface.update(hotelDto);
    }

    @DeleteMapping(path = "H_ID",params = "H_ID",produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseController delete(@RequestParam("H_ID") String H_ID){
        return hotelAuthfiegnInterface.delete(H_ID);
    }

    @GetMapping(path = "H_search",params = "H_ID",produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseController search(@RequestParam("H_ID") String H_ID){
        return hotelAuthfiegnInterface.search(H_ID);
    }


}
