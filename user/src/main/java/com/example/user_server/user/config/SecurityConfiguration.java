package com.example.user_server.user.config;

import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;
import org.springframework.web.cors.CorsConfiguration;
import org.springframework.web.cors.CorsConfigurationSource;
import org.springframework.web.cors.UrlBasedCorsConfigurationSource;

@Configuration
@EnableWebSecurity
@RequiredArgsConstructor
public class SecurityConfiguration {
    @Autowired
    private JWTAuthFilter jwtAuthFilter;
    @Autowired
    private AuthenticationProvider authenticationProvider;


    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
        http
                .csrf().disable()
                .authorizeRequests()
                .requestMatchers("/api/v1/auth/getAuth").permitAll()
                .requestMatchers("/**").hasAnyAuthority("user", "userAdmin", "packageDetailsAdmin", "paymentsAdmin","A_HOTEL")
                .anyRequest().authenticated()
                .and()
                .sessionManagement()
                .sessionCreationPolicy(SessionCreationPolicy.STATELESS)
                .and()
                .authenticationProvider(authenticationProvider)
                .addFilterBefore(jwtAuthFilter, UsernamePasswordAuthenticationFilter.class);

        return http.build();
    }
    @Bean
    public CorsConfigurationSource corsConfigurationSource() {
        CorsConfiguration configuration = new CorsConfiguration();
        configuration.addAllowedOrigin("*");
        configuration.addAllowedMethod("*");
        configuration.addAllowedHeader("*");

        UrlBasedCorsConfigurationSource source = new UrlBasedCorsConfigurationSource();
        source.registerCorsConfiguration("/**", configuration);

        return source;
}
}
//nrmal user
//eyJhbGciOiJIUzI1NiJ9.eyJ1c2VyUm9sZSI6IlVTRVIiLCJzdWIiOiJ1MjAwMSIsImlhdCI6MTY5ODE1MjEzNywiZXhwIjo0ODUxNzUyMTM3fQ.IXDk26PL3wg-U0_5aIc8QNyViB9N6AR01MVoSXjj3QQ

//admin controller user
//eyJhbGciOiJIUzI1NiJ9.eyJ1c2VyUm9sZSI6IkFEX1VTRVIiLCJzdWIiOiJhZG1pblVzZXIyMDAxIiwiaWF0IjoxNjk4MTUyNDMwLCJleHAiOjQ4NTE3NTI0MzB9.xw17OLiV8dS54uviHl8jtR1KrTn6difopKvdM1hYndk