package com.jmr.producer.producer_practica.producer_practica_strings.controllers;

import com.jmr.producer.producer_practica.producer_practica_strings.models.BrandModel;
import com.jmr.producer.producer_practica.producer_practica_strings.services.BrandModelService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("api/bmodel")
@Slf4j
public class BrandModelController {

    private final BrandModelService brandModelService;

    public BrandModelController(BrandModelService brandModelService) {
        this.brandModelService = brandModelService;
    }

    @GetMapping("/all")
    public ResponseEntity<List<BrandModel>> getAll(){
        return ResponseEntity.ok(brandModelService.all());
    }
}
