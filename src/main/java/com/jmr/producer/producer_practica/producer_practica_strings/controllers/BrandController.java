package com.jmr.producer.producer_practica.producer_practica_strings.controllers;

import com.jmr.practica.entities_practica.libreria_custom_maven_practica.models.entities.Brand;
import com.jmr.producer.producer_practica.producer_practica_strings.services.BrandService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@Slf4j
@RestController
@RequestMapping("/brand")
public class BrandController {

    private final BrandService brandService;

    public BrandController(BrandService brandService) {
        this.brandService = brandService;
    }

    @GetMapping("/all")
    public List<Brand> getAll()
    {
        return brandService.all();
    }





}
