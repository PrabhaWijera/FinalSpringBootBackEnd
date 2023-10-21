package com.example.prabhash.vehicelserver.service;

import com.example.prabhash.vehicelserver.dto.SuperDto;
import com.example.prabhash.vehicelserver.dto.Vehicle_dto;
import com.example.prabhash.vehicelserver.entity.Vehicle_entity;
import com.example.prabhash.vehicelserver.repo.Vehicle_repo;
import com.example.prabhash.vehicelserver.res.ResponseController;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.ui.Model;
import org.springframework.web.client.RestTemplate;

import java.net.http.HttpClient;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;


@Service
@Transactional
public class VehicleService_impl implements VehicleService{

    @Autowired
    private Vehicle_repo vehicleRepo;

    @Autowired
    private ModelMapper modelMapper;



    @Override
    public ResponseController search(String id) {
        Optional<Vehicle_entity> vehicleEntity=vehicleRepo.findById(id);
        if (vehicleEntity.isPresent()){
            return createResponse(HttpStatus.FOUND.value(), modelMapper.map(vehicleEntity.get(),Vehicle_dto.class),"sucsss");
        }
        return createResponse(HttpStatus.NOT_EXTENDED.value(), null,"error found vehicle");
    }

    @Override
    public ResponseController save(Vehicle_dto vehicleDto) {
        if (search(vehicleDto.getVehicleID()).getData()==null){
               vehicleRepo.save(modelMapper.map(vehicleDto,Vehicle_entity.class));
            return createResponse(HttpStatus.OK.value(),null,"save ok vehicle");
        }
        throw new RuntimeException("Vehicale save not ok");
    }

/*    @Override
    public ResponseController update(Vehicle_dto vehicleDto) {
       if (search(vehicleDto.getVehicleID()).getData() !=null){
           vehicleRepo.save(modelMapper.map(vehicleDto,Vehicle_entity.class));
           return createResponse(HttpStatus.OK.value(),null,"Success");
       }
       throw new RuntimeException("vehcle not update");
    }*/
/*    @Override
    public ResponseController update(Vehicle_dto vehicleDto) {
    if (search(vehicleDto.getVehicleID()).getData() ==null){
        Optional<Vehicle_entity>vehicleEntity=vehicleRepo.findById(vehicleDto.getVehicleID());
        if (vehicleEntity.isPresent()){
            vehicleRepo.save(modelMapper.map(vehicleDto,Vehicle_entity.class));
            return createResponse(HttpStatus.OK.value(),null,"Success");
        }else {
            return createResponse(HttpStatus.OK.value(),null,"no hell no   ");
        }
    }
    throw new RuntimeException("vehcle not update");
}*/
/*@Override
public ResponseController update(Vehicle_dto vehicleDto) {
    ResponseController searchResult = search(vehicleDto.getVehicleID());
    if (searchResult.getData() == null) {
        Optional<Vehicle_entity> vehicleEntity = vehicleRepo.findById(vehicleDto.getVehicleID());
        if (vehicleEntity.isPresent()) {
            vehicleRepo.save(modelMapper.map(vehicleDto, Vehicle_entity.class));
            return createResponse(HttpStatus.OK.value(), null, "Success");
        } else {
            return createResponse(HttpStatus.NOT_FOUND.value(), null, "Vehicle not found");
        }
    }
    throw new RuntimeException("Vehicle not updated");
}*/
    @Override
    public ResponseController update(Vehicle_dto vehicleDto) {
    Optional<Vehicle_entity> vehicleEntity = vehicleRepo.findById(vehicleDto.getVehicleID());
    if (vehicleEntity.isPresent()) {
        // If the vehicle exists, update it
        vehicleRepo.save(modelMapper.map(vehicleDto, Vehicle_entity.class));
        return createResponse(HttpStatus.OK.value(), null, "Success");
    } else {
        // If the vehicle doesn't exist, create a new entry
        vehicleRepo.save(modelMapper.map(vehicleDto, Vehicle_entity.class));
        return createResponse(HttpStatus.OK.value(), null, "Success");
    }
}
    @Override
    public ResponseController delete(String id) {
        if(search(id).getData()!=null){
            vehicleRepo.deleteById(id);
            return createResponse(HttpStatus.OK.value(),null,"Sucess delete vehi");
        }
        throw new RuntimeException("Not found!!!!");
    }

    @Override
    public ResponseController getAll() {
        List<Vehicle_entity>vehicleEntities=vehicleRepo.findAll();
        if (!vehicleEntities.isEmpty()){
            ArrayList<Vehicle_dto>vehicleDtos=new ArrayList<>();
            vehicleEntities.forEach(vehicleEntity -> {
                vehicleDtos.add(modelMapper.map(vehicleEntity,Vehicle_dto.class));
            });
            return createResponse(HttpStatus.FOUND.value(),vehicleDtos,"Sucess");
        }
        throw new RuntimeException("No found all");
    }

    @Override
    public ResponseController createResponse(int statusCode, Object data, String message) {
        ResponseController  responseController1=new ResponseController ();
        responseController1.setStatusCode(statusCode);
        responseController1.setData(data);
        responseController1.setMessage(message);
        return responseController1;
    }
}
