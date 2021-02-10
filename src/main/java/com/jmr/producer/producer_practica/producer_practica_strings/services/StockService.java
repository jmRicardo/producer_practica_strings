package com.jmr.producer.producer_practica.producer_practica_strings.services;

import com.jmr.producer.producer_practica.producer_practica_strings.models.Stock;
import com.jmr.producer.producer_practica.producer_practica_strings.repositories.StockRepository;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class StockService {

    private final StockRepository stockRepository;

    public StockService(StockRepository stockRepository) {
        this.stockRepository = stockRepository;
    }

    public List<Stock> all()
    {
        return this.stockRepository.findAll();
    }
}
