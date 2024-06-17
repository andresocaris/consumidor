package com.example.consumidor.service;

import io.github.resilience4j.circuitbreaker.annotation.CircuitBreaker;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.client.ResourceAccessException;
import org.springframework.web.client.RestTemplate;

@Service
public class ConsumidorService {
    @Autowired
    private RestTemplate restTemplate;
    @CircuitBreaker(name="books", fallbackMethod = "getBooksFallBack")
    public String f() {
        // URL del servicio "listar-clientes" registrado en Eureka
        String url = "http://mi-aplication/test-consumidor";
        return restTemplate.getForObject(url, String.class);
    }
    public String getBooksFallBack(Throwable e){
        return "esto es para recuperarme";
    }
}
