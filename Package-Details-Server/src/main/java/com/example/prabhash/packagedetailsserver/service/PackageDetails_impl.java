package com.example.prabhash.packagedetailsserver.service;

import com.example.prabhash.packagedetailsserver.dto.PackageDetails_dto;
import com.example.prabhash.packagedetailsserver.entity.PackageDetail_entity;
import com.example.prabhash.packagedetailsserver.repo.PackageDetails_Repo;
import com.example.prabhash.packagedetailsserver.res.ResponseController;
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
public class PackageDetails_impl implements PackageDetailsService {

    @Autowired
    private PackageDetails_Repo packageDetails_repo;



    @Autowired
    private ModelMapper modelMapper;




    @Override
    public ResponseController search(String id) {
        Optional<PackageDetail_entity> packageDetailEntity=packageDetails_repo.findById(id);
        if (packageDetailEntity.isPresent()){
            return createResponse(HttpStatus.FOUND.value(), modelMapper.map(packageDetailEntity.get(),PackageDetails_dto.class),"Sucess");
        }
        return createResponse(HttpStatus.NOT_EXTENDED.value(), null,"No foound PackageDetaisl");
    }

    @Override
    public ResponseController save(PackageDetails_dto packageDetailsDto) {
        if (search(packageDetailsDto.getPackageDetailsID()).getData()==null){
            packageDetails_repo.save(modelMapper.map(packageDetailsDto,PackageDetail_entity.class));
            return createResponse(HttpStatus.OK.value(), null,"Sucess");
        }
        throw new RuntimeException("No save packageDetails");
    }

    @Override
    public ResponseController update(PackageDetails_dto packageDetailsDto) {
        if (search(packageDetailsDto.getPackageDetailsID()).getData()!=null){
            packageDetails_repo.save(modelMapper.map(packageDetailsDto,PackageDetail_entity.class));
            return createResponse(HttpStatus.OK.value(), null,"success");
        }
        throw new RuntimeException("packagedetails no update");
    }

    @Override
    public ResponseController delete(String id) {
        if (search(id).getData()!=null){
            packageDetails_repo.deleteById(id);
           return createResponse(HttpStatus.OK.value(), null,"Delete success");
        }
        throw new RuntimeException("NOT delete by id packagedetails");
    }

    @Override
    public ResponseController getAll() {
        List<PackageDetail_entity>packageDetailEntities=packageDetails_repo.findAll();
        if (packageDetailEntities.isEmpty()){
            ArrayList<PackageDetails_dto>packageDetailsDtos=new ArrayList<>();
            packageDetailEntities.forEach(packageDetailEntity -> {
                packageDetailsDtos.add(modelMapper.map(packageDetailEntity,PackageDetails_dto.class));
            });
            return createResponse(HttpStatus.OK.value(), null,"Sucess get All packagedetails");
        }
        throw new RuntimeException("no get allpackagedetails");
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
