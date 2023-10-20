package com.example.user_server.user.endpointother;

import com.example.user_server.user.dto.Guide_dto;
import com.example.user_server.user.fiegn.GuideAuthfiegnInterface;
import com.example.user_server.user.res.ResponseController;
import jakarta.persistence.Access;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

@CrossOrigin
@RestController
@RequestMapping("api/v1/guide")
public class GuideController {

    @Autowired
    private GuideAuthfiegnInterface guideAuthfiegnInterface;

    @PostMapping(path = "/saveGuide",consumes = MediaType.APPLICATION_JSON_VALUE,produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseController saveGuide(@RequestBody Guide_dto guideDto){
        return guideAuthfiegnInterface.saveGuide(guideDto);
    }



}
