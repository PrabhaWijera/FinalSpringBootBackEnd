package com.example.prabhash.guideserver.service;

import com.example.prabhash.guideserver.dto.Guide_dto;
import com.example.prabhash.guideserver.entity.Guide_entity;
import com.example.prabhash.guideserver.repo.GuideRepo;
import com.example.prabhash.guideserver.res.Response;
import com.example.prabhash.guideserver.service.custom.GuideService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
@Transactional
public class GuideService_impl implements GuideService {


    @Autowired
    private GuideRepo guideRepo;

    @Autowired
    private ModelMapper modelMapper;

    @Autowired
    private Response response;

    @Override
    public ResponseEntity<Response> search(String id) {
        Optional<Guide_entity>guideEntity=guideRepo.findById(id);
        if (guideEntity.isPresent()){
            return createAndSendResponse(HttpStatus.FOUND.value(),"Success service",modelMapper.map(guideEntity.get(),Guide_dto.class));
        }
        return createAndSendResponse(HttpStatus.NOT_EXTENDED.value(), "Error",null);
    }

    @Override
    public ResponseEntity<Response> save(Guide_dto guideDto) {
        if (search(guideDto.getGuideID()).getBody().getData()==null){
            guideRepo.save(modelMapper.map(guideDto,Guide_entity.class));
            return createAndSendResponse(HttpStatus.OK.value(),"Success", null);
        }
        throw new RuntimeException(" no save guide");
    }

    @Override
    public ResponseEntity<Response> update(Guide_dto guideDto) {
        Optional<Guide_entity> existingGuide = guideRepo.findById(guideDto.getGuideID());

        if (existingGuide.isPresent()) {
            // The vehicle with the given ID exists, so update it
            Guide_entity updatedEntity = modelMapper.map(guideDto, Guide_entity.class);
            updatedEntity.setGuideID(guideDto.getGuideID()); // Set the ID to ensure an update
            guideRepo.save(updatedEntity);
            return createAndSendResponse(HttpStatus.OK.value(), "Vehicle updated successfully",null);
        } else {
            // The vehicle with the given ID does not exist, so create a new entry
            Guide_entity newEntity = modelMapper.map(guideDto, Guide_entity.class);
            guideRepo.save(newEntity);
            return createAndSendResponse(HttpStatus.OK.value(), "Vehicle created successfully",null );
        }
    }
    @Override
    public ResponseEntity<Response> findByGuideName(String guideName) {
        Optional<Guide_entity> guideEntity = guideRepo.findByGuideName(guideName);
        if (guideEntity.isPresent()) {
            return createAndSendResponse(HttpStatus.OK.value(), "Hotel Successfully retrieved!", modelMapper.map(guideEntity.get(), Guide_dto.class));

        }
        return createAndSendResponse(HttpStatus.NOT_FOUND.value(), "Hotel Not Found!", null);
    }


    @Override
    public ResponseEntity<Response> delete(String id) {
        if (search(id).getBody().getData()!=null){
            guideRepo.deleteById(id);
            return createAndSendResponse(HttpStatus.OK.value(),"Sucess delete guide",null);
        }
        throw new RuntimeException("no delete in guide");
    }

    @Override
    public ResponseEntity<Response> getAll() {
        List<Guide_entity>guideEntities=guideRepo.findAll();
        if (!guideEntities.isEmpty()){
            ArrayList<Guide_dto>guideDtos=new ArrayList<>();
            guideEntities.forEach(guideEntity -> {
                guideDtos.add(modelMapper.map(guideEntity,Guide_dto.class));
            });
            return createAndSendResponse(HttpStatus.FOUND.value(),"Sucess",guideDtos);
        }
        return createAndSendResponse(HttpStatus.NOT_FOUND.value(),"No success",null);
    }

    @Override
    public ResponseEntity<Response> createAndSendResponse(int statusCode, String msg, Object data) {
        response.setStatusCode(statusCode);
        response.setMessage(msg);
        response.setData(data);
        System.out.println("Status Code : " + statusCode);
        System.out.println("Sent : " + HttpStatus.valueOf(statusCode));

        return new ResponseEntity<Response>(response, HttpStatusCode.valueOf(statusCode));

    }

}
