package com.jmr.producer.producer_practica.producer_practica_strings.controllers;

import com.jmr.practica.entities_practica.libreria_custom_maven_practica.models.entities.Stock;
import com.jmr.producer.producer_practica.producer_practica_strings.exceptions.StockNotFound;
import com.jmr.producer.producer_practica.producer_practica_strings.services.StockService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

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
        return "TEST FROM STOCK/TEST";
    }

    @GetMapping("/all")
    public List<Stock> getAll()
    {
        return stockService.all();
    }

    @GetMapping("/{id}")
    public Stock getById(@PathVariable long id) throws StockNotFound
    {
        return stockService.findById(id);
    }

    @GetMapping("brandModel/{idBrandModel}")
    public List<Stock> getStockByBrandModel(@PathVariable long idBrandModel) throws StockNotFound
    {
       return stockService.findByBrandModel(idBrandModel);
    }

    @GetMapping("brand/{idBrand}")
    public List<Stock> getStockByBrand(@PathVariable long idBrand) throws StockNotFound
    {
        return stockService.findByBrand(idBrand);
    }

    @PostMapping("/")
    public ResponseEntity<Stock> createStock(@RequestBody Stock stock){
        stockService.createStock(stock);
        return ResponseEntity.status(HttpStatus.CREATED).build();
    }
}
