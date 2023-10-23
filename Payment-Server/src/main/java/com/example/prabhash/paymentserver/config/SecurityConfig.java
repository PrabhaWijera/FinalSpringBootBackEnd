package com.example.prabhash.paymentserver.config;

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
                .requestMatchers("/**").hasAnyAuthority("hotelAdmin","packageAdmin")
                .anyRequest().permitAll()

                .and()
                .csrf().disable();
        return http.build();

    }
}
//eyJhbGciOiJIUzI1NiJ9.eyJ1c2VyUm9sZSI6IkFfUEFZTUVOVCIsInN1YiI6InBheW1lbnRhZG1pbiIsImlhdCI6MTY5ODA2NzU5NywiZXhwIjo0ODUxNjY3NTk3fQ.M49VkVWi2Wwwfw5QEGq9r8ppviJRnrPoHh0b2Uwcep8

//eyJhbGciOiJIUzI1NiJ9.eyJ1c2VyUm9sZSI6IkFfUEFZTUVOVCIsInN1YiI6IlBheW1lbnRBZG1pbiIsImlhdCI6MTY5ODA2ODIwNCwiZXhwIjo0ODUxNjY4MjA0fQ._pKMG_OfKY2OJ7Cp4SOSTp7GLZ4smKGHiT2ckwJnr00