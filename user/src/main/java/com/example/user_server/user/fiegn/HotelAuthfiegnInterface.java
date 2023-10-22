package com.example.user_server.user.fiegn;

import com.example.user_server.user.dto.Hotel_dto;
import com.example.user_server.user.res.ResponseController;
import jakarta.validation.Valid;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

@FeignClient("hotel-service")
public interface HotelAuthfiegnInterface {


    @PostMapping(path = "h_save",consumes = MediaType.APPLICATION_JSON_VALUE,produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseController save(  @RequestBody Hotel_dto hotelDto);



    @PutMapping(path = "h_put",consumes = MediaType.APPLICATION_JSON_VALUE,produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseController update(@Valid @RequestBody Hotel_dto hotelDto);


    @DeleteMapping(path = "H_Delete",params = "H_ID",produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseController delete(@Valid @RequestParam("H_ID") String H_ID);


    @GetMapping(path = "H_search",params = "H_ID",produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseController search(@Valid @RequestParam("H_ID") String H_ID);





}
