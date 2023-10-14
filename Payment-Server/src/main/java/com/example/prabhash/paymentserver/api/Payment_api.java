package com.example.prabhash.paymentserver.api;


import com.example.prabhash.paymentserver.dto.Payment_dto;
import com.example.prabhash.paymentserver.res.ResponsController;
import com.example.prabhash.paymentserver.service.PaymentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import javax.print.attribute.standard.Media;

@RestController
@RequestMapping("/Payment")
@CrossOrigin(origins = "http://localhost:8080")
public class Payment_api {

    @Autowired
    private PaymentService paymentService;


    @GetMapping(path = "PGet",params = "PayID",produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponsController get(@RequestParam("PayID") String PayID){
        System.out.println("payment search");
        return paymentService.search(PayID);
    }

    @PostMapping(path = "PSave",consumes = MediaType.APPLICATION_JSON_VALUE,produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponsController save(@RequestBody Payment_dto paymentDto){
        System.out.println("save payment");
        return paymentService.save(paymentDto);
    }

    @PutMapping(path = "Pput",produces = MediaType.APPLICATION_JSON_VALUE,consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponsController update(@RequestBody Payment_dto paymentDto){
        System.out.println("put payment");
        return paymentService.save(paymentDto);
    }

    @DeleteMapping(path = "Pdelet",params = "PayID",produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponsController delete(@RequestParam("PayID") String PayID){
        System.out.println("PayID delete ok");
        return paymentService.delete(PayID);
    }



}
