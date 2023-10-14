package com.example.user_server.user.fiegn;

import com.example.user_server.user.dto.Hotel_dto;
import com.example.user_server.user.res.ResponseController;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

@FeignClient("HOTEL-SERVICE")
public interface HotelAuthfiegnInterface {



    @PostMapping(path = "h_save",consumes = MediaType.APPLICATION_JSON_VALUE,produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseController save(  @RequestBody Hotel_dto hotelDto);

    @PutMapping(path = "h_put",consumes = MediaType.APPLICATION_JSON_VALUE,produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseController update(  @RequestBody Hotel_dto hotelDto);


    @DeleteMapping(path = "H_ID",params = "H_ID",produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseController delete(  @RequestParam("H_ID") String H_ID);


    @GetMapping(path = "H_search",params = "H_ID",produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseController search(  @RequestParam("H_ID") String H_ID);



}
