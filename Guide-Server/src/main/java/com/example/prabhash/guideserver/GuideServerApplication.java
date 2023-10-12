package com.example.prabhash.guideserver;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.cloud.openfeign.FeignClient;

@SpringBootApplication
@EnableFeignClients
public class GuideServerApplication {

    public static void main(String[] args) {
        SpringApplication.run(GuideServerApplication.class, args);
    }

}
