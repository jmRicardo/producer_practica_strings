package com.jmr.producer.producer_practica.producer_practica_strings.repositories;

import com.jmr.practica.entities_practica.libreria_custom_maven_practica.models.entities.Stock;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface StockRepository extends JpaRepository<Stock,Long> {

    @Query(value = "SELECT * FROM string_set WHERE id_brand_model = ?1", nativeQuery = true)
    List<Stock> findByBrandModel(long idBrandModel);

    @Query(value = "select ss.id_brand_model,ss.id_set,ss.stock\n" +
            "from string_set ss\n" +
            "inner join brand_model bm\n" +
            "inner join brand b\n" +
            "where ss.id_brand_model = bm.id_brand_model and b.id_brand = bm.id_brand and bm.id_brand = 3;\n", nativeQuery = true)
    List<Stock> findByBrand(long idBrand);
}
