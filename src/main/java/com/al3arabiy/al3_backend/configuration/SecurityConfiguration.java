package com.al3arabiy.al3_backend.configuration;

import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
@RequiredArgsConstructor @EnableWebSecurity
public class SecurityConfiguration {

    private final String[] permissibleRequests = {
            "/login/**",
            "/registration/**",
            "/images/**",
            "/mp3/**",
            "/js/**",
            "/error/**",
    };

    @Bean
    public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {

        http.authorizeHttpRequests(
                request -> request
                        .requestMatchers(permissibleRequests).permitAll()
                        .anyRequest().authenticated()
        );

        http.sessionManagement(
                sessionManagement -> sessionManagement
                        .sessionCreationPolicy(SessionCreationPolicy.STATELESS)
        );

        http.headers(
                httpSecurityHeadersConfigurer ->
                        httpSecurityHeadersConfigurer.frameOptions(Customizer.withDefaults()).disable()
        );


        return http.build();
    }
}
