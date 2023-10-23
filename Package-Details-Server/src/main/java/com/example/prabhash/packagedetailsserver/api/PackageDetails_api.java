package com.example.prabhash.packagedetailsserver.api;


import com.example.prabhash.packagedetailsserver.dto.PackageDetails_dto;
import com.example.prabhash.packagedetailsserver.res.Response;
import com.example.prabhash.packagedetailsserver.service.PackageDetailsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@CrossOrigin(origins = "http://localhost:8080")
@RequestMapping("packageDetals")
@RestController
public class PackageDetails_api {

    @Autowired
    private PackageDetailsService packageDetailsService;


    @GetMapping("check")
    public String getCheck(){
        return "Checked OK packageDetails";
    }

    @PostMapping(path = "save",consumes = MediaType.APPLICATION_JSON_VALUE,produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Response> save(@RequestBody PackageDetails_dto packageDetailsDto){
        return packageDetailsService.save(packageDetailsDto);
    }

    @PutMapping(path = "put",consumes = MediaType.APPLICATION_JSON_VALUE,produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Response> update(@RequestBody PackageDetails_dto packageDetailsDto){
        return packageDetailsService.update(packageDetailsDto);
    }


    @DeleteMapping(path = "delete",params = "PkID",produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Response> delete(@RequestParam("PkID") String PkID){
        return packageDetailsService.delete(PkID);
    }

    @GetMapping(path = "get",params = "PkID",produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Response> search(@RequestParam("PkID")String PkID){
        return packageDetailsService.search(PkID);
    }

}
