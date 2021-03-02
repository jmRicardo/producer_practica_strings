package com.jmr.producer.producer_practica.producer_practica_strings.controllers;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.jmr.practica.entities_practica.libreria_custom_maven_practica.models.entities.Stock;
import com.jmr.producer.producer_practica.producer_practica_strings.services.StockService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;

import java.util.ArrayList;
import java.util.List;

import static org.hamcrest.Matchers.containsString;
import static org.mockito.Mockito.when;
import static org.mockito.MockitoAnnotations.openMocks;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@WebMvcTest(StockController.class)
class StockControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private StockService service;

    @Mock
    List<Stock> stockList;

    @BeforeEach
    void setUp() {
        openMocks(this);
        stockList = new ArrayList<>();
    }



    @Test
    void testShouldReturnMessageFromService() throws Exception {
        this.mockMvc.perform(get("/stock/test"))
                .andDo(print())
                .andExpect(status().isOk())
                .andExpect(content().string(containsString("TEST FROM STOCK/TEST")));
    }

    @Test
    void getAll() throws Exception {

        stockList.add(new Stock());
        String stockListJSON = "";

        try {
            stockListJSON =  new ObjectMapper().writeValueAsString(stockList);
        } catch (JsonProcessingException e) {
            e.printStackTrace();
        }

        when(service.all()).thenReturn(stockList);

        mockMvc.perform(get("/stock/all")).andExpect(status().isOk())
                .andExpect(content().contentType(MediaType.APPLICATION_JSON))
                .andExpect(content().string(stockListJSON));
    }

    @Test
    void getById() {
    }

    @Test
    void getStockByBrandModel() {
    }

    @Test
    void getStockByBrand() {
    }

    @Test
    void createStock() {
    }
}