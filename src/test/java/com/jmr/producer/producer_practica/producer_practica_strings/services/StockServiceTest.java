package com.jmr.producer.producer_practica.producer_practica_strings.services;

import com.jmr.practica.entities_practica.libreria_custom_maven_practica.models.entities.Stock;
import com.jmr.producer.producer_practica.producer_practica_strings.repositories.StockRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;

import java.util.Collections;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.*;
import static org.mockito.MockitoAnnotations.*;

class StockServiceTest {

    @Mock
    StockRepository stockRepository;

    @InjectMocks
    StockService stockService;

    @BeforeEach
    void setUp() {
        openMocks(this);
    }


    @Test
    void all() {

        List<Stock> stock = Collections.emptyList();

        when(stockRepository.findAll()).thenReturn(stock);

        List<Stock> listResult = stockService.all();

        assertEquals(stock, listResult);

        verify(stockRepository, times(1)).findAll();
    }

    @Test
    void createStock() {
    }

    @Test
    void findById() {
    }

    @Test
    void findByBrandModel() {
    }

    @Test
    void findByBrand() {
    }
}