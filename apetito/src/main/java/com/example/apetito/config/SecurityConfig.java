package com.example.apetito.config;


import com.example.apetito.service.ClientService;
import com.example.apetito.service.DeliveryCompanyAccountService;
import com.example.apetito.service.RestaurantAccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configurers.AbstractHttpConfigurer;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;
import org.springframework.web.cors.CorsConfiguration;
import org.springframework.web.cors.CorsConfigurationSource;
import org.springframework.web.cors.UrlBasedCorsConfigurationSource;

import java.util.Arrays;

import static org.springframework.http.HttpMethod.*;

@Configuration
@EnableWebSecurity
public class SecurityConfig {
    private static final String[] WHITE_LIST_URL = {"/auth/**",
            "/api/restaurants/**",
            "/api/products/**",
            "/api/createOrder",
            "/orders/deliveryCompanies/**",
            "/order/my"};

    @Autowired
    private ClientService userService;

    @Autowired
    private DeliveryCompanyAccountService deliveryService;

    @Autowired
    private JwtAuthenticationFilter jwtAuthFilter;

    @Autowired
    private RestaurantAccountService adminService;

    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
        http
                .csrf(AbstractHttpConfigurer::disable)
                .cors(cors -> cors.configurationSource(corsConfigurationSource()))
                .authorizeHttpRequests(matcherRegistry -> {
                    matcherRegistry.requestMatchers(WHITE_LIST_URL)
                            .permitAll()
                            .requestMatchers(GET,"/api/client/orders/all").hasAuthority("CLIENT")

                            .anyRequest()
                            .authenticated();
                })
                .sessionManagement(session -> session.sessionCreationPolicy(SessionCreationPolicy.STATELESS))
                .addFilterBefore(jwtAuthFilter, UsernamePasswordAuthenticationFilter.class);

//todo

        return http.build();
    }


    @Bean
    public AuthenticationManager authenticationManager(HttpSecurity http) throws Exception {

        AuthenticationManagerBuilder authenticationManagerBuilder = http.getSharedObject(AuthenticationManagerBuilder.class);
/*
        authenticationManagerBuilder
                .userDetailsService(adminService)
                .passwordEncoder(passwordEncoder());

        authenticationManagerBuilder
                .userDetailsService(deliveryService)
                .passwordEncoder(passwordEncoder());

 */



        authenticationManagerBuilder
                .userDetailsService(userService)
                .passwordEncoder(passwordEncoder());


        return authenticationManagerBuilder.build();
    }
/*
    @Bean
    public AuthenticationManager authenticationManager(HttpSecurity http) throws Exception {

        AuthenticationManagerBuilder authenticationManagerBuilder = http.getSharedObject(AuthenticationManagerBuilder.class);

        authenticationManagerBuilder
                .userDetailsService(adminService)
                .passwordEncoder(passwordEncoder());

        authenticationManagerBuilder
                .userDetailsService(userService)
                .passwordEncoder(passwordEncoder());

        authenticationManagerBuilder
                .userDetailsService(deliveryService)
                .passwordEncoder(passwordEncoder());
        return authenticationManagerBuilder.build();
    }

 */

    @Bean
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }

    @Bean
    public CorsConfigurationSource corsConfigurationSource() {
        CorsConfiguration configuration = new CorsConfiguration();
        configuration.setAllowedOrigins(Arrays.asList("http://localhost:3000")); // Dopuszczone domeny
        configuration.setAllowedMethods(Arrays.asList("GET", "POST", "PUT", "PATCH", "DELETE", "OPTIONS")); // Dopuszczone metody
        configuration.setAllowedHeaders(Arrays.asList("authorization", "content-type", "x-auth-token")); // Dopuszczone nagłówki
        configuration.setExposedHeaders(Arrays.asList("x-auth-token")); // Nagłówki, które klient może odczytać
        configuration.setAllowCredentials(true); // Jeśli chcesz zezwjalać na cookies
        UrlBasedCorsConfigurationSource source = new UrlBasedCorsConfigurationSource();
        source.registerCorsConfiguration("/**", configuration); // Stosuje konfigurację dla wszystkich ścieżek
        return source;
    }

    /*
    @Bean
    public CorsConfigurationSource corsConfigurationSource() {
        CorsConfiguration configuration = new CorsConfiguration();
        configuration.setAllowedOrigins(Arrays.asList("*")); // Zezwala na wszystkie domeny
        configuration.setAllowedMethods(Arrays.asList("GET", "POST", "PUT", "PATCH", "DELETE", "OPTIONS")); // Dopuszczone metody
        configuration.setAllowedHeaders(Arrays.asList("*")); // Zezwala na wszystkie nagłówki
        configuration.setExposedHeaders(Arrays.asList("x-auth-token")); // Nagłówki, które klient może odczytać
        configuration.setAllowCredentials(true); // Uwaga: 'true' może nie działać z 'AllowedOrigins' ustawionym na '*'
        UrlBasedCorsConfigurationSource source = new UrlBasedCorsConfigurationSource();
        source.registerCorsConfiguration("/**", configuration); // Stosuje konfigurację dla wszystkich ścieżek
        return source;
    }
     */


}
