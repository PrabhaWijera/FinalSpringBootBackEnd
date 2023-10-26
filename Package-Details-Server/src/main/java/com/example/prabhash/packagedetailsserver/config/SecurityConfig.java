package com.example.prabhash.packagedetailsserver.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
@EnableWebSecurity
public class SecurityConfig {

    @Autowired
    private JWTAuthFilter jwtAuthFilter;


    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
        http
                .addFilterBefore(jwtAuthFilter, org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter.class)
                .authorizeRequests()
                .requestMatchers("/**").hasAnyAuthority("hotelAdmin","packageAdmin","packageDetailsAdmin")
                .anyRequest().permitAll()

                .and()
                .csrf().disable();
        return http.build();

    }
}
//eyJhbGciOiJIUzI1NiJ9.eyJ1c2VyUm9sZSI6IlBBQ0tBR0VfREVUQUlMUyIsInN1YiI6IjIwMDEiLCJpYXQiOjE2OTgzMDY0NTIsImV4cCI6NDg1MTkwNjQ1Mn0.dlmkG9suHiRelGPgbJRx08W4SpE1BV_r2CWzfXvduag