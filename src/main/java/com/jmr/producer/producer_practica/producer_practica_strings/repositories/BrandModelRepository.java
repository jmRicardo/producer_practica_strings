package com.jmr.producer.producer_practica.producer_practica_strings.repositories;

import com.jmr.producer.producer_practica.producer_practica_strings.models.BrandModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface BrandModelRepository extends JpaRepository<BrandModel,Long> {
}
