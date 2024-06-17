package com.example.consumidor.controlador;

import com.example.consumidor.service.ConsumidorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


@RestController
@RequestMapping("/serviceA")
public class ConsumidorController {

    @Autowired
    private ConsumidorService consumidorService;
    @GetMapping("/clientes")
    public String obtenerClientes() {
        return consumidorService.f();
    }
}
