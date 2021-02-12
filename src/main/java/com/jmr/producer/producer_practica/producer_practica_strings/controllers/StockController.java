package com.jmr.producer.producer_practica.producer_practica_strings.controllers;

import com.jmr.producer.producer_practica.producer_practica_strings.models.Stock;
import com.jmr.producer.producer_practica.producer_practica_strings.services.StockService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/stock")
public class StockController {

    private final StockService stockService;

    public StockController(StockService stockService) {
        this.stockService = stockService;
    }

    @GetMapping("/test")
    public String test()
    {
        return "TEST";
    }

    @GetMapping("/all")
    public List<Stock> getAll()
    {
        return stockService.all();
    }
}
