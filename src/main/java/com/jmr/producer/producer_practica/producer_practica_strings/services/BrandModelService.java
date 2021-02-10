package com.jmr.producer.producer_practica.producer_practica_strings.services;

import com.jmr.producer.producer_practica.producer_practica_strings.models.BrandModel;
import com.jmr.producer.producer_practica.producer_practica_strings.repositories.BrandModelRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BrandModelService {

    private final BrandModelRepository brandModelRepository;

    public BrandModelService(BrandModelRepository brandModelRepository) {
        this.brandModelRepository = brandModelRepository;
    }

    public List<BrandModel> all()
    {
        return brandModelRepository.findAll();
    }
}
