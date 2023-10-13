package com.example.prabhash.vehicelserver.api;


import com.example.prabhash.vehicelserver.dto.Vehicle_dto;
import com.example.prabhash.vehicelserver.res.ResponseController;
import com.example.prabhash.vehicelserver.service.VehicleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

@CrossOrigin
@RestController
@RequestMapping("/vehicle_server")
public class Vehicle_api {

    @Autowired
    private VehicleService vehicleService;


    @GetMapping("/check")
    public String getCheck_vehicle(){
        return "Vehicle API run";
    }


    @PostMapping(path = "vSave",consumes = MediaType.APPLICATION_JSON_VALUE,produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseController save(@RequestBody Vehicle_dto vehicleDto){
        System.out.println("vehicle save working");
       return vehicleService.save(vehicleDto);
    }

    @PutMapping(value = "V_put",consumes = MediaType.APPLICATION_JSON_VALUE,produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseController update(@RequestBody Vehicle_dto vehicleDto){
        System.out.println("VehicleDto update working");
        return vehicleService.update(vehicleDto);
    }


    @DeleteMapping(path = "V_delete",params ="V_ID",produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseController delete(@RequestParam("V_ID") String vehicleID){
        return vehicleService.delete(vehicleID);
    }

    @GetMapping(path = "V_search",params = "Vehicle_ID",produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseController search(@RequestParam("Vehicle_ID") String Vehicle_ID){
        return vehicleService.search(Vehicle_ID);
    }










}
