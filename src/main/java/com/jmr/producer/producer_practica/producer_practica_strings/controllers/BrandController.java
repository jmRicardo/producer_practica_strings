package com.jmr.producer.producer_practica.producer_practica_strings.controllers;

import com.jmr.producer.producer_practica.producer_practica_strings.models.Brand;
import com.jmr.producer.producer_practica.producer_practica_strings.services.BrandService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Slf4j
@RestController
@RequestMapping("/brand")
public class BrandController {

    private final BrandService brandService;

    @Value("${configuracion.texto}")
    private String texto;

    public BrandController(BrandService brandService) {
        this.brandService = brandService;
    }

    @GetMapping("/all")
    public List<Brand> getAll()
    {
        return brandService.all();
    }

    @GetMapping("/get-config")
    public ResponseEntity<?> obtenerConfig(){

        log.info(texto);

        Map<String, String> json = new HashMap<>();
        json.put("texto", texto);

        return new ResponseEntity<>(json, HttpStatus.OK);
    }



}
