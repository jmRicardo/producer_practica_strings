package com.jmr.producer.producer_practica.producer_practica_strings.services;

import com.jmr.practica.entities_practica.libreria_custom_maven_practica.models.entities.Stock;
import com.jmr.producer.producer_practica.producer_practica_strings.exceptions.StockNotFound;
import com.jmr.producer.producer_practica.producer_practica_strings.repositories.StockRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;

import java.util.Collections;
import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;
import static org.mockito.MockitoAnnotations.*;

class StockServiceTest {

    private static final long ID_STOCK = 1;

    @Mock
    StockRepository stockRepository;

    @InjectMocks
    StockService stockService;

    @BeforeEach
    void setUp() {
        openMocks(this);
    }

    @Test
    void createStock()
    {
        Stock stock = mock(Stock.class);

        stockService.createStock(stock);

        verify(stockRepository,times(1)).save(stock);
    }

    @Test
    void findByIdNotFound()
    {
        when(stockRepository.findById(ID_STOCK)).thenReturn(Optional.empty());
        assertThrows(StockNotFound.class, () -> stockService.findById(ID_STOCK));
    }

    @Test
    void findById()
    {
        Stock stock = mock(Stock.class);

        when(stockRepository.findById(ID_STOCK)).thenReturn(Optional.ofNullable(stock));

        Stock data = stockService.findById(ID_STOCK);

        verify(stockRepository,times(1)).findById(ID_STOCK);

        assertEquals(stock,data);
    }

    @Test
    void all()
    {
        List<Stock> stock = Collections.emptyList();

        when(stockRepository.findAll()).thenReturn(stock);

        List<Stock> listResult = stockService.all();

        assertEquals(stock, listResult);

        verify(stockRepository, times(1)).findAll();
    }


    @Test
    void findByBrandModel() {
    }

    @Test
    void findByBrand() {
    }
}