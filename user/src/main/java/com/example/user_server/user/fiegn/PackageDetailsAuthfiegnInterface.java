package com.example.user_server.user.fiegn;

import com.example.user_server.user.dto.PackageDetails_dto;
import com.example.user_server.user.res.ResponseController;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

@FeignClient("PACKAGE-DETAILS-SERVICE")
public interface PackageDetailsAuthfiegnInterface {



    @PostMapping(path = "save",consumes = MediaType.APPLICATION_JSON_VALUE,produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseController save(@RequestBody PackageDetails_dto packageDetailsDto);

    @PutMapping(path = "put",consumes = MediaType.APPLICATION_JSON_VALUE,produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseController update(@RequestBody PackageDetails_dto packageDetailsDto);


    @DeleteMapping(path = "delete",params = "PkID",produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseController delete(@RequestParam("PkID") String PkID);

    @GetMapping(path = "get",params = "PkID",produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseController search(@RequestParam("PkID")String PkID);

}
