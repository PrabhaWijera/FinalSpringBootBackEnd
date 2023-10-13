package com.example.prabhash.guideserver.service;

import com.example.prabhash.guideserver.dto.Guide_dto;
import com.example.prabhash.guideserver.entity.Guide_entity;
import com.example.prabhash.guideserver.repo.GuideRepo;
import com.example.prabhash.guideserver.res.ResponseController;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.net.http.HttpClient;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
@Transactional
public class GuideService_impl implements GuideService{


    @Autowired
    private GuideRepo guideRepo;

    @Autowired
    private ModelMapper modelMapper;

    @Autowired
    private ResponseController responseController;

    @Override
    public ResponseController search(String id) {
        Optional<Guide_entity>guideEntity=guideRepo.findById(id);
        if (guideEntity.isPresent()){
            return createResponse(HttpStatus.FOUND.value(), modelMapper.map(guideEntity.get(),Guide_dto.class),"Sucess");
        }
        return createResponse(HttpStatus.NOT_EXTENDED.value(), null,"Error");
    }

    @Override
    public ResponseController save(Guide_dto guideDto) {
        if (search(guideDto.getGuideID()).getData()==null){
            guideRepo.save(modelMapper.map(guideDto,Guide_entity.class));
            return createResponse(HttpStatus.OK.value(), null,"Success");
        }
        throw new RuntimeException("no save guide");
    }

    @Override
    public ResponseController update(Guide_dto guideDto) {
        if (search(guideDto.getGuideID()).getData()!=null){
            guideRepo.save(modelMapper.map(guideDto,Guide_entity.class));
            return createResponse(HttpStatus.OK.value(), null,"Success");
        }
        throw new RuntimeException("No update found guide");
    }

    @Override
    public ResponseController delete(String id) {
        if (search(id).getData()!=null){
            guideRepo.deleteById(id);
            return createResponse(HttpStatus.OK.value(),null,"Sucess delete guide");
        }
        throw new RuntimeException("no delete in guide");
    }

    @Override
    public ResponseController getAll() {
        List<Guide_entity>guideEntities=guideRepo.findAll();
        if (guideEntities.isEmpty()){
            ArrayList<Guide_dto>arrayList=new ArrayList<>();
            guideEntities.forEach(guideEntity -> {
                arrayList.add(modelMapper.map(guideEntity,Guide_dto.class));
            });
            return createResponse(HttpStatus.OK.value(), null,"Findall Success");
        }
        throw new RuntimeException("Find guide all error");
    }

    @Override
    public ResponseController createResponse(int statusCode, Object data, String message) {
        ResponseController  responseController1=new ResponseController ();
        responseController1.setStatus_code(statusCode);
        responseController1.setData(data);
        responseController1.setMessage(message);
        return responseController1;
    }
}
