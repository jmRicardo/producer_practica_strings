package com.jmr.producer.producer_practica.producer_practica_strings.models;

import com.fasterxml.jackson.annotation.JsonBackReference;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import javax.persistence.*;

@ToString
@Entity
@AllArgsConstructor
@NoArgsConstructor
@Data
@Table(name = "brand_model")
public class BrandModel {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_brand_model")
    private long id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JsonBackReference(value="brandmodel-brand")
    @JoinColumn(name = "id_brand")
    private Brand brand;

    private String model;
    private int strings;
    private String type;

}
