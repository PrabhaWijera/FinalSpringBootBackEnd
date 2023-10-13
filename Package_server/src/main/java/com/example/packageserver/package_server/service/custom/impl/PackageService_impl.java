package com.example.packageserver.package_server.service.custom.impl;

import com.example.packageserver.package_server.dto.Package_dto;
import com.example.packageserver.package_server.entity.Package_entity;
import com.example.packageserver.package_server.fign.PackageFiegnInterfaec;
import com.example.packageserver.package_server.repo.Package_repo;
import com.example.packageserver.package_server.res.ResponseController;
import com.example.packageserver.package_server.service.custom.PackageService;
import jakarta.transaction.Transactional;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Optional;


@Service
@Transactional
public class PackageService_impl implements PackageService {

    @Autowired
    private Package_repo packageRepo;

    @Autowired
    private ModelMapper modelMapper;

    @Autowired
    private ResponseController  responseController;


    //Rest templet for communication other servers
    //Fientclient , Service Discovery we use

    @Autowired
    private PackageFiegnInterfaec packageFiegnInterfaec;






    //-------------------------------------------------------



    @Override
    public ResponseController  search(String id) {
        Optional<Package_entity>packageEntity=packageRepo.findById(id);
        if (packageEntity.isPresent()){
            return createResponse(HttpStatus.FOUND.value(), modelMapper.map(packageEntity.get(),Package_dto.class),"success");
        }
        return createResponse(HttpStatus.NOT_EXTENDED.value(),null,"eorr");
    }

    @Override
    public ResponseController save(Package_dto packageDto) {
        if (search(packageDto.getPackage_id()).getData()==null){
            packageRepo.save(modelMapper.map(packageDto,Package_entity.class));
            return createResponse(HttpStatus.OK.value(),null,"Save OK");
        }
        throw new RuntimeException("Package not exits");
    }

    @Override
    public ResponseController  update(Package_dto packageDto) {
        if (search(packageDto.getPackage_id()).getData() !=null){
            packageRepo.save(modelMapper.map(packageDto,Package_entity.class));
            return createResponse(HttpStatus.OK.value(), null,"Update OK!");
        }
        throw new RuntimeException("No found!");

    }

    @Override
    public ResponseController  delete(String id) {
        if (search(id).getData()!=null){
        packageRepo.deleteById(id);
        return createResponse(HttpStatus.OK.value(),null,"Delete OK");
        }
        throw new RuntimeException("Not found!");
    }

    @Override
    public ResponseController  getAll() {
        List<Package_entity>packageEntities=packageRepo.findAll();
        if (!packageEntities.isEmpty()){
            ArrayList<Package_dto> packageDtos=new ArrayList<>();
            packageEntities.forEach(packageEntity -> {
                packageDtos.add(modelMapper.map(packageEntity,Package_dto.class));
            });
            return createResponse(HttpStatus.FOUND.value(), packageDtos,"Success");
        }
        throw new RuntimeException("No found all");
    }

    @Override
    public ResponseController  createResponse(int statusCode, Object data, String message) {
        ResponseController  responseController1=new ResponseController ();
        responseController1.setStatus_code(statusCode);
        responseController1.setData(data);
        responseController1.setMessage(message);
        return responseController1;
    }




    // testing
    public ResponseEntity<String> createVehicles(@RequestBody String id) {
        // You should pass the id to your Feign client to retrieve vehicle data
        List<String> vehicles = Collections.singletonList(packageFiegnInterfaec.getAllVehicles(id).getBody());

        Package_entity packageEntity=new Package_entity();
        packageEntity.setVehical_id(Collections.singletonList("V0124445"));
        // Here you can add logic to process the 'vehicles' data
        packageRepo.save(packageEntity);

        // If creation is successful, return a success response
        return new ResponseEntity<>("Success", HttpStatus.CREATED);
    }
}
