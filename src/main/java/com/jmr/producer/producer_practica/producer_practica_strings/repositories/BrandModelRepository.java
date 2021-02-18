package com.jmr.producer.producer_practica.producer_practica_strings.repositories;

import com.jmr.practica.entities_practica.libreria_custom_maven_practica.models.entities.BrandModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface BrandModelRepository extends JpaRepository<BrandModel,Long> {
}
