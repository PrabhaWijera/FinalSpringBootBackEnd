package com.example.user_server.user.fiegn;


import com.example.user_server.user.dto.Guide_dto;
import com.example.user_server.user.res.ResponseController;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

@FeignClient("GUIDE-SERVICE")
public interface GuideAuthfiegnInterface {



    @PostMapping(path = "Gsave",consumes = MediaType.APPLICATION_JSON_VALUE,produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseController save(@RequestBody Guide_dto guideDto);


    @GetMapping(path = "Gget",params = "guideID",produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseController get(@RequestParam("guideID") String guideID);


    @PutMapping(path = "Gput",consumes = MediaType.APPLICATION_JSON_VALUE,produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseController update(@RequestBody Guide_dto guideDto);


    @DeleteMapping(path = "Gdelete",params = "guideID",produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseController delete( @RequestParam("guideID") String guideID);

    @GetMapping(path = "H_search",params = "H_ID",produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseController search( @RequestParam("H_ID") String H_ID);



}
