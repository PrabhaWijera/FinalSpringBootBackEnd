package com.example.prabhash.packagedetailsserver.service;

import com.example.prabhash.packagedetailsserver.dto.PackageDetails_dto;
import com.example.prabhash.packagedetailsserver.entity.PackageDetail_entity;
import com.example.prabhash.packagedetailsserver.repo.PackageDetails_Repo;
import com.example.prabhash.packagedetailsserver.res.Response;
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
public class PackageDetails_impl implements PackageDetailsService {

    @Autowired
    private PackageDetails_Repo packageDetails_repo;

    @Autowired
    private Response response;

    @Autowired
    private ModelMapper modelMapper;




    @Override
    public ResponseEntity<Response> search(String id) {
        Optional<PackageDetail_entity> packageDetailEntity=packageDetails_repo.findById(id);
        if (packageDetailEntity.isPresent()){
            return createAndSendResponse(HttpStatus.FOUND.value(),"Sucess", modelMapper.map(packageDetailEntity.get(),PackageDetails_dto.class));
        }
        return createAndSendResponse(HttpStatus.NOT_EXTENDED.value(), null,"No foound PackageDetaisl");
    }

    @Override
    public ResponseEntity<Response> save(PackageDetails_dto packageDetailsDto) {
        if (search(String.valueOf(packageDetailsDto.getPackageID())).getBody().getData()==null){
            packageDetails_repo.save(modelMapper.map(packageDetailsDto,PackageDetail_entity.class));
            return createAndSendResponse(HttpStatus.OK.value(), "Sucess",null);
        }
        throw new RuntimeException("No save packageDetails");
    }

    @Override
    public ResponseEntity<Response> update(PackageDetails_dto packageDetailsDto) {
        if (search(String.valueOf(packageDetailsDto.getPackageID())).getBody().getData()!=null){
            packageDetails_repo.save(modelMapper.map(packageDetailsDto,PackageDetail_entity.class));
            return createAndSendResponse(HttpStatus.OK.value(),"success",null);
        }
        throw new RuntimeException("packagedetails no update");
    }

    @Override
    public ResponseEntity<Response> delete(String id) {
        if (search(id).getBody().getData()!=null){
            packageDetails_repo.deleteById(id);
           return createAndSendResponse(HttpStatus.OK.value(), "Delete success",null);
        }
        throw new RuntimeException("NOT delete by id packagedetails");
    }

    @Override
    public ResponseEntity<Response> getAll() {
        List<PackageDetail_entity>packageDetailEntities=packageDetails_repo.findAll();
        if (packageDetailEntities.isEmpty()){
            ArrayList<PackageDetails_dto>packageDetailsDtos=new ArrayList<>();
            packageDetailEntities.forEach(packageDetailEntity -> {
                packageDetailsDtos.add(modelMapper.map(packageDetailEntity,PackageDetails_dto.class));
            });
            return createAndSendResponse(HttpStatus.OK.value(), "Sucess get All packagedetails",null);
        }
        throw new RuntimeException("no get allpackagedetails");
    }

    @Override
    public ResponseEntity<Response> createAndSendResponse(int statusCode, String msg, Object data) {
        return null;
    }


}
