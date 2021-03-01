package com.jmr.producer.producer_practica.producer_practica_strings.controllers;

import com.jmr.producer.producer_practica.producer_practica_strings.services.StockService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.web.servlet.MockMvc;

import static org.hamcrest.Matchers.containsString;
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

    @Test
    void testShouldReturnMessageFromService() throws Exception {
        this.mockMvc.perform(get("/stock/test")).andDo(print()).andExpect(status().isOk())
                .andExpect(content().string(containsString("TEST FROM STOCK/TEST")));
    }

    @Test
    void getAll() {
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