package com.example.user_server.user.endpointother;

import com.example.user_server.user.dto.Guide_dto;
import com.example.user_server.user.fiegn.GuideAuthfiegnInterface;
import com.example.user_server.user.fiegn.HotelAuthfiegnInterface;
import com.example.user_server.user.res.ResponseController;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

@CrossOrigin
@RestController
@RequestMapping("")
public class Guide_api {

    @Autowired
    private GuideAuthfiegnInterface  guideAuthfiegnInterface;



   @PostMapping(path = "Gsave",consumes = MediaType.APPLICATION_JSON_VALUE,produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseController save( @RequestBody Guide_dto guideDto){
       System.out.println("Guide save"+guideDto.toString());
       return guideAuthfiegnInterface.save(guideDto);

   }

   @GetMapping(path = "Gget",params = "guideID",produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseController get(@RequestParam("guideID") String guideID){
       System.out.println("Guide search"+guideID);
     return guideAuthfiegnInterface.search(guideID);
   }

   @PutMapping(path = "Gput",consumes = MediaType.APPLICATION_JSON_VALUE,produces = MediaType.APPLICATION_JSON_VALUE)
   public ResponseController update(  @RequestBody Guide_dto guideDto){
       System.out.println("update guide"+guideDto.toString());
       return guideAuthfiegnInterface.save(guideDto);
   }

   @DeleteMapping(path = "Gdelete",params = "guideID",produces = MediaType.APPLICATION_JSON_VALUE)
   public ResponseController delete(   @RequestParam("guideID") String guideID){
       System.out.println("Guide delete ok"+guideID);
       return guideAuthfiegnInterface.delete(guideID);
   }






}
