package com.smartemail.writer.smartemailapp;



import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.web.cors.CorsConfiguration;
import org.springframework.web.cors.CorsConfigurationSource;
import org.springframework.web.cors.UrlBasedCorsConfigurationSource;

import java.util.Arrays;

@Configuration
@EnableWebSecurity
public class SecurityConfig {

    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
        http
                // Apply the CORS configuration below
                .cors(cors -> cors.configurationSource(corsConfigurationSource()))

                // Disable CSRF protection, which is not needed for a stateless REST API
                .csrf(csrf -> csrf.disable())

                // Define the authorization rules for your endpoints
                .authorizeHttpRequests(auth -> auth
                        // 1. Allow all preflight OPTIONS requests (the fix for your 403 error)
                        .requestMatchers(HttpMethod.OPTIONS, "/**").permitAll()

                        // 2. Allow the specific POST request to your email generation endpoint
                        .requestMatchers(HttpMethod.POST, "/api/email/generate").permitAll()

                        // 3. (Optional but good practice) Require authentication for any other request
                        .anyRequest().authenticated()
                );

        return http.build();
    }

    @Bean
    public CorsConfigurationSource corsConfigurationSource() {
        CorsConfiguration configuration = new CorsConfiguration();

        // Set your specific Vercel frontend URL
        configuration.setAllowedOrigins(Arrays.asList("https://smart-email-frontend.vercel.app"));

        // Define the allowed HTTP methods
        configuration.setAllowedMethods(Arrays.asList("GET", "POST", "PUT", "DELETE", "OPTIONS"));

        // Allow all headers in the request
        configuration.setAllowedHeaders(Arrays.asList("*"));

        // Allow credentials (like cookies) to be sent
        configuration.setAllowCredentials(true);

        UrlBasedCorsConfigurationSource source = new UrlBasedCorsConfigurationSource();

        // Apply this CORS configuration to all paths in your application
        source.registerCorsConfiguration("/**", configuration);

        return source;
    }
}