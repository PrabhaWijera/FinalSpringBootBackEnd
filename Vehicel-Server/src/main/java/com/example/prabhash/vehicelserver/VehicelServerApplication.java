package com.example.prabhash.vehicelserver;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;

@SpringBootApplication
@EnableFeignClients
public class VehicelServerApplication {

    public static void main(String[] args) {
        SpringApplication.run(VehicelServerApplication.class, args);
    }

}
