package com.example.bus_backend.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.web.SecurityFilterChain;



@Configuration
public class SecurityConfig {

    @Bean
    public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {

        http
            .csrf(csrf -> csrf.disable()) // disable CSRF for POST requests
            .authorizeHttpRequests(auth -> auth
                .requestMatchers("/api/passengers/register").permitAll()
                .requestMatchers("/api/passengers/login").permitAll()
                .anyRequest().permitAll()  // allows all other APIs
            )
            .httpBasic(Customizer.withDefaults());

        return http.build();
    }
}
