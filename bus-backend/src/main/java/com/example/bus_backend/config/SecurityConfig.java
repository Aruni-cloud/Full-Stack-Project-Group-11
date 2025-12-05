package com.example.bus_backend.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;

@Configuration
@EnableWebSecurity
public class SecurityConfig {

    @Bean
    public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
        http
            .csrf(csrf -> csrf.disable())  // disable CSRF for API testing
            .authorizeHttpRequests(auth -> auth
                .requestMatchers("/api/passengers/**").permitAll()   // allow passenger APIs
                .requestMatchers("/api/bookings/**").permitAll()     // allow booking APIs
                .requestMatchers("/api/complaints/**").permitAll()   // allow complaint APIs
                .requestMatchers("/api/feedback/**").permitAll()
                .requestMatchers("/api/payments/**").permitAll() 
                .requestMatchers("/api/routes/**").permitAll()
                .requestMatchers("/api/schedules/**").permitAll()
                
                .anyRequest().authenticated()                        // everything else requires login
            )
            .httpBasic(basic -> basic.disable());

        return http.build();
    }
}
