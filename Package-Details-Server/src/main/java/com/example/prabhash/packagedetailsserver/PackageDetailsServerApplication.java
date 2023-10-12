package com.example.prabhash.packagedetailsserver;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class PackageDetailsServerApplication {

    public static void main(String[] args) {
        SpringApplication.run(PackageDetailsServerApplication.class, args);
        System.out.println("PACKAGE-DETAILS-SERVER IS RUNNING!!!");
    }

}
