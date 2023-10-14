package com.example.user_server.user.fiegn;

import com.example.user_server.user.dto.Payment_dto;
import com.example.user_server.user.res.ResponseController;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

@FeignClient("PAYMENT-SERVICE")
public interface PayemtAuthfiegnInterface {



    @GetMapping(path = "PGet",params = "PayID",produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseController search(@RequestParam("PayID") String PayID);

    @PostMapping(path = "PSave",consumes = MediaType.APPLICATION_JSON_VALUE,produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseController save(@RequestBody Payment_dto paymentDto);


    @PutMapping(path = "Pput",produces = MediaType.APPLICATION_JSON_VALUE,consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseController update(@RequestBody Payment_dto paymentDto);

    @DeleteMapping(path = "Pdelet",params = "PayID",produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseController delete(@RequestParam("PayID") String PayID);



}
