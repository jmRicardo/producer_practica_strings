package com.jmr.producer.producer_practica.producer_practica_strings.controllers;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Map;

@Slf4j
@RestController
@RequestMapping("/test")
public class TestController {

    @Value("${configuracion.texto}")
    private String texto;

    @GetMapping()
    public ResponseEntity<?> getEnviormentVariable(){

        log.info(texto);

        Map<String, String> json = new HashMap<>();
        json.put("texto", texto);

        return new ResponseEntity<>(json, HttpStatus.OK);
    }
}
