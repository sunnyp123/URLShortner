package com.example.url.URLShortner;




import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
public class CorsConfig implements WebMvcConfigurer {

    @Override
    public void addCorsMappings(CorsRegistry registry) {
        // Apply CORS policy for all /api/** endpoints
        registry.addMapping("/api/**")
                .allowedOrigins("http://localhost:3000")  // Allow requests from localhost:3000
                .allowedMethods("GET", "POST", "PUT", "DELETE")  // Allow these HTTP methods
                .allowCredentials(true)  // Allow sending credentials (cookies, authorization headers, etc.)
                .maxAge(3600);  // Cache CORS preflight request for 1 hour
    }
}
