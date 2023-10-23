package com.example.prabhash.hotelserver.config;

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
                .requestMatchers("/**").hasAnyAuthority("A_HOTEL","A_PACKAGE")
                .anyRequest().permitAll()

                .and()
                .csrf().disable();
        return http.build();

    }
}
//eyJhbGciOiJIUzI1NiJ9.eyJ1c2VyUm9sZSI6IkFfSE9URUwiLCJzdWIiOiJob3RlbGFkbWluIiwiaWF0IjoxNjk4MDY3MzYzLCJleHAiOjQ4NTE2NjczNjN9.tKHjcgdzWsQ6gXu4rBD33wZxFFPZQNmc9WvYcM89scU

//eyJhbGciOiJIUzI1NiJ9.eyJ1c2VyUm9sZSI6IkFfSE9URUwiLCJzdWIiOiJob3RlbEFkbWluIiwiaWF0IjoxNjk4MDY4MjgzLCJleHAiOjQ4NTE2NjgyODN9.gvI62fX0TSVJyO6JDlISC2yFHoZdGLF6lC2RGyD2exw