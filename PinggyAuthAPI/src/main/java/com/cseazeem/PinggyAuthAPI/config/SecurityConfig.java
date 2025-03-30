package com.cseazeem.PinggyAuthAPI.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
public class SecurityConfig {

    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
        http
                .cors().and()  // Enable CORS
                .csrf().disable()  // Disable CSRF for testing (enable it for production)
                .authorizeHttpRequests(auth -> auth
                        .requestMatchers("/post", "/list").authenticated()  // Secure main endpoints
                        .requestMatchers("/**").permitAll()  // Allow all other requests
                )
                .sessionManagement(session -> session.sessionCreationPolicy(SessionCreationPolicy.STATELESS)) // No sessions
                .httpBasic(); // Enable basic authentication

        return http.build();
    }
}
