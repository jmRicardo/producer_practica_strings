package com.jmr.producer.producer_practica.producer_practica_strings.services;

import com.jmr.producer.producer_practica.producer_practica_strings.models.Brand;
import com.jmr.producer.producer_practica.producer_practica_strings.repositories.BrandRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BrandService {

    private final BrandRepository brandRepository;

    public BrandService(BrandRepository brandRepository) {
        this.brandRepository = brandRepository;
    }

    public List<Brand> all()
    {
        return brandRepository.findAll();
    }
}
