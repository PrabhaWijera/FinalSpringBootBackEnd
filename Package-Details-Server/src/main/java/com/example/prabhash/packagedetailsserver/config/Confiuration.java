package com.example.prabhash.packagedetailsserver.config;

import org.modelmapper.ModelMapper;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class Confiuration {

    @Bean
    public ModelMapper modelMapper(){
        return new ModelMapper();
    }
}
