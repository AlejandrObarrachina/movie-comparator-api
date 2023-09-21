package com.moviesapi.moviesapi.config;

import com.moviesapi.moviesapi.model.Results;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.RestTemplate;

@Configuration
public class MoviesConfig {
    @Bean
    public RestTemplate restTemplate(){
       return new RestTemplate();
    }
}
