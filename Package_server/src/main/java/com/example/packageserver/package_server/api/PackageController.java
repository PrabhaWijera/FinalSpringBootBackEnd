package com.example.packageserver.package_server.api;

import com.example.packageserver.package_server.res.Response;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@CrossOrigin
@RestController
@RequestMapping("/package_serverController")
public class PackageController {

    @PostMapping(path = "/saveHotelID",produces = MediaType.APPLICATION_JSON_VALUE,params = {"packageID","hotelID"})
    public ResponseEntity<Response> saveHotelID(@RequestParam("packageID") String packageID, @RequestParam("hotelID") String hotelID){
        return null;
    }
    @PostMapping(path = "/saveVehicleID",produces = MediaType.APPLICATION_JSON_VALUE,params = {"packageID","vehicleID"})
    public ResponseEntity<Response> saveVehicleID(@RequestParam("packageID") String packageID, @RequestParam("vehicleID") String vehicleID){
        return null;
    }
    @DeleteMapping(path = "/deleteHotelID",produces = MediaType.APPLICATION_JSON_VALUE,params = {"packageID","hotelID"})
    public ResponseEntity<Response> deleteHotelID(@RequestParam("packageID") String packageID, @RequestParam("hotelID") String hotelID){
        return null;
    }
    @DeleteMapping(path = "/deleteVehicleID",produces = MediaType.APPLICATION_JSON_VALUE,params = {"packageID","vehicleID"})
    public ResponseEntity<Response> deleteVehicleID(@RequestParam("packageID") String packageID, @RequestParam("vehicleID") String vehicleID){
        return null;
    }
    @PutMapping(path = "/updateHotelPackageId",produces = MediaType.APPLICATION_JSON_VALUE,params = {"oldPackageId","newPackageId","hotelId"})
    public ResponseEntity<Response>updateHotelPackageId(@RequestParam("oldPackageId")String oldPackageId,@RequestParam("newPackageId")String newPackageId,@RequestParam("hotelId")String hotelId){
        return null;
    }

}
