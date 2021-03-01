package com.jmr.producer.producer_practica.producer_practica_strings.services;

import com.jmr.practica.entities_practica.libreria_custom_maven_practica.models.entities.Stock;
import com.jmr.producer.producer_practica.producer_practica_strings.exceptions.StockNotFound;
import com.jmr.producer.producer_practica.producer_practica_strings.repositories.StockRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;
import static org.mockito.MockitoAnnotations.*;

class StockServiceTest {

    private static final long ID_STOCK = 1;

    private static final long ID_BRAND_MODEL = 1;

    @Mock
    StockRepository stockRepository;

    @InjectMocks
    StockService stockService;

    @Mock
    List<Stock> stockList;

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

    @Nested
    @DisplayName("Test para todos los find del service")
    class findTests
    {
        @Test
        void findByBrandModelNotFound()
        {
            when(stockRepository.findById(ID_BRAND_MODEL)).thenReturn(Optional.empty());

            assertThrows(StockNotFound.class, () -> stockService.findByBrandModel(ID_BRAND_MODEL));
        }

        @Test
        void findByBrandModel() {

            when(stockRepository.findByBrandModel(ID_BRAND_MODEL)).thenReturn(stockList);

            List<Stock> data = stockService.findByBrandModel(ID_BRAND_MODEL);

            verify(stockRepository,times(1)).findByBrandModel(ID_BRAND_MODEL);

            assertEquals(stockList,data);
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
        void findByBrand() {
        }
    }

    @Test
    void all()
    {
        when(stockRepository.findAll()).thenReturn(stockList);

        List<Stock> listResult = stockService.all();

        assertEquals(stockList, listResult);

        verify(stockRepository, times(1)).findAll();
    }

}