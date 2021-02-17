package com.jmr.producer.producer_practica.producer_practica_strings.services;

import com.jmr.producer.producer_practica.producer_practica_strings.exceptions.StockNotFound;
import com.jmr.producer.producer_practica.producer_practica_strings.models.Stock;
import com.jmr.producer.producer_practica.producer_practica_strings.repositories.StockRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

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

    public void createStock(Stock stock) {
        stockRepository.save(stock);
    }

    public Stock findById(long id) {
        Optional<Stock> stockOptional = this.stockRepository.findById(id);
        if (stockOptional.isPresent())
        {
            return stockOptional.get();
        }
        throw new StockNotFound("El stock con el id: " + id + " no existe!");
    }

    public List<Stock> findByBrandModel(long idBrandModel)
    {
        List<Stock> byBrandModel = stockRepository.findByBrandModel(idBrandModel);
        if (!byBrandModel.isEmpty())
        {
            return byBrandModel;
        }
        throw new StockNotFound("No se encontro stock del modelo con el ID: " + idBrandModel + " !");
    }

    public List<Stock> findByBrand(long idBrand)
    {
        List<Stock> byBrand = stockRepository.findByBrand(idBrand);
        if (!byBrand.isEmpty())
        {
            return byBrand;
        }
        throw new StockNotFound("No se encontro stock de la marca con el ID: " + idBrand + " !");
    }


}
