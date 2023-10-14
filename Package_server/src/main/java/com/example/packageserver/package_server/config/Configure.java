package com.example.packageserver.package_server.config;

import org.modelmapper.ModelMapper;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;


@Configuration
public class Configure {

    @Bean
    public ModelMapper modelMapper(){
        return new ModelMapper();
    }
}
