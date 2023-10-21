package com.example.user_server.user.fiegn;

import com.example.user_server.user.dto.Vehicle_dto;
import com.example.user_server.user.res.ResponseController;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@FeignClient("vehicle-server")
public interface VehicleAuthFiegnInterface {





    @GetMapping("/check")
    public String getCheck_vehicle();


    @PostMapping(path = "vSave",consumes = MediaType.APPLICATION_JSON_VALUE,produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseController save(@Valid @RequestBody Vehicle_dto vehicleDto);
    @PutMapping(value = "V_put",consumes = MediaType.APPLICATION_JSON_VALUE,produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseController update(@Valid @RequestBody Vehicle_dto vehicleDto);
    @DeleteMapping(path = "V_delete",params ="V_ID",produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseController delete(@Valid @RequestParam("V_ID") String vehicleID);

    @GetMapping(path = "V_search",params = "Vehicle_ID",produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseController search(@Valid @RequestParam("Vehicle_ID") String Vehicle_ID);
    @PostMapping("/getvehi")
    public ResponseEntity<String> getAllVehicles(@Valid @RequestParam String id);




}
