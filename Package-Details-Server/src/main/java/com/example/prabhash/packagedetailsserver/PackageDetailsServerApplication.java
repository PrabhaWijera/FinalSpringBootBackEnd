package com.example.prabhash.packagedetailsserver;

import org.modelmapper.ModelMapper;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class PackageDetailsServerApplication {

    public static void main(String[] args) {
        SpringApplication.run(PackageDetailsServerApplication.class, args);
        System.out.println("PACKAGE-DETAILS-SERVER IS RUNNING!!!");
    }

    @Bean
    public ModelMapper modelMapper(){
        return new ModelMapper();
    }
}
