package com.example.task_management.configs;

import com.example.task_management.security.JwtAuthenticationFilter;
import com.example.task_management.security.JwtEntryPoint;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

@Configuration
public class SecurityConfig {
    @Autowired
    private JwtEntryPoint jwtEntryPoint;
    @Autowired
    private JwtAuthenticationFilter jwtAuthenticationFilter;
    @Autowired
    private SecurityProperties securityProperties;

    @Bean
    SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
        http
                .csrf((csrf) -> csrf.disable())
                .headers(headers -> headers.frameOptions(frame-> frame.sameOrigin()))
                .exceptionHandling(ex -> ex.authenticationEntryPoint(jwtEntryPoint))
                .authorizeHttpRequests((authorize) ->
                        //white list for public access
                authorize.requestMatchers(securityProperties.getWhiteList().toArray(new String[0])).permitAll()
                .anyRequest().authenticated())
                .sessionManagement(session -> session
                        .sessionCreationPolicy(SessionCreationPolicy.STATELESS))
                .addFilterBefore(jwtAuthenticationFilter, UsernamePasswordAuthenticationFilter.class)
                .httpBasic(httpBasic -> {});

        return http.build();
    }

}
