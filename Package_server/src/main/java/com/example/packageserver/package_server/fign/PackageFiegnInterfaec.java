package com.example.packageserver.package_server.fign;


import com.example.packageserver.package_server.res.ResponseController;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.List;

@FeignClient("USER-SERVER")
//step-1 -> annotated the fiegn and tag in which services we need-and all letters are Capitals(eureka eke display wela thiyena name eka gnn)
//step-2 -> get we need connect methods user api we need methods and past in here
//step3- package packagefigninterface eke ape method abstract widiyt set krnn
//step4- ekata ara gttu method reference ekata infac eka sset krnn
public interface PackageFiegnInterfaec {


    @GetMapping("user/getusergetCheckUser")
     public String getCheckUser() ;




}
