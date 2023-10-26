package com.example.packageserver.package_server.service.custom.impl;

import com.example.packageserver.package_server.dto.Package_dto;
import com.example.packageserver.package_server.entity.Package_entity;
import com.example.packageserver.package_server.fign.PackageFiegnInterfaec;
import com.example.packageserver.package_server.repo.Package_repo;
import com.example.packageserver.package_server.res.Response;
import com.example.packageserver.package_server.service.custom.PackageService;
import jakarta.transaction.Transactional;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
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
    private Response response;



    //Rest templet for communication other servers
    //Fientclient , Service Discovery we use

    @Autowired
    private PackageFiegnInterfaec packageFiegnInterfaec;






    //-------------------------------------------------------



    @Override
    public ResponseEntity<Response>  search(String id) {
        Optional<Package_entity>packageEntity=packageRepo.findById(id);
        if (packageEntity.isPresent()){
            return createAndSendResponse(HttpStatus.FOUND.value() ,"success",modelMapper.map(packageEntity.get(),Package_dto.class));
        }
        return createAndSendResponse(HttpStatus.NOT_EXTENDED.value(),null,"eorr");
    }

    @Override
    public ResponseEntity<Response> save(Package_dto packageDto) {
        if (search(packageDto.getPackage_id()).getBody().getData()==null){
            packageRepo.save(modelMapper.map(packageDto,Package_entity.class));
            return createAndSendResponse(HttpStatus.OK.value(),null,"Save OK");
        }
        throw new RuntimeException("Package not exits");
    }

    @Override
    public ResponseEntity<Response>  update(Package_dto packageDto) {
        if (search(packageDto.getPackage_id()).getBody().getData() !=null){
            packageRepo.save(modelMapper.map(packageDto,Package_entity.class));
            return createAndSendResponse(HttpStatus.OK.value(), null,"Update OK!");
        }
        throw new RuntimeException("No found!");

    }

    @Override
    public ResponseEntity<Response>  delete(String id) {
        if (search(id).getBody().getData()!=null){
        packageRepo.deleteById(id);
        return createAndSendResponse(HttpStatus.OK.value(),null,"Delete OK");
        }
        throw new RuntimeException("Not found!");
    }

    @Override
    public ResponseEntity<Response>  getAll() {
        List<Package_entity>packageEntities=packageRepo.findAll();
        if (!packageEntities.isEmpty()){
            ArrayList<Package_dto> packageDtos=new ArrayList<>();
            packageEntities.forEach(packageEntity -> {
                packageDtos.add(modelMapper.map(packageEntity,Package_dto.class));
            });
            return createAndSendResponse(HttpStatus.FOUND.value(),"Success", packageDtos);
        }
        throw new RuntimeException("No found all");
    }

    @Override
    public ResponseEntity<Response> createAndSendResponse(int statusCode, String msg, Object data) {
        response.setStatusCode(statusCode);
        response.setMessage(msg);
        response.setData(data);
        System.out.println("Status Code : " + statusCode);
        System.out.println("Sent : " + HttpStatus.valueOf(statusCode));

        return new ResponseEntity<>(response, HttpStatusCode.valueOf(statusCode));

    }






    // testing
    public ResponseEntity<String> createVehicles(@RequestBody String id) {
        // You should pass the id to your Feign client to retrieve vehicle data
        List<String> vehicles = Collections.singletonList(packageFiegnInterfaec.getAllVehicles(id).getBody());

        Package_entity packageEntity=new Package_entity();
        packageEntity.setVehical_Category(Collections.singletonList("V0124445"));
        // Here you can add logic to process the 'vehicles' data
        packageRepo.save(packageEntity);

        // If creation is successful, return a success response
        return new ResponseEntity<>("Success", HttpStatus.CREATED);
    }
}
