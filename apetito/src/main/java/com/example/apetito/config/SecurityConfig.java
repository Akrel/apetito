package com.example.apetito.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
@EnableWebSecurity
public class SecurityConfig {

    @Bean
    public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
        http
                .authorizeRequests(authorizeRequests -> authorizeRequests
                        .anyRequest().permitAll())
                .csrf(csrf -> csrf.disable()) // Zakładając, że również CSRF jest dostosowany
        // Dalsza konfiguracja, która może zastąpić przestarzałą metodę headers()
        ;

        // Możliwe jest bezpośrednie wykorzystanie nowych metod konfiguracji dla konkretnych nagłówków
        // lub innych mechanizmów bezpieczeństwa w zależności od Twoich potrzeb i zaleceń Spring Security.

        return http.build();
    }
}
