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
@Table(name = "string_set")
public class Stock {


    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_set")
    private long id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JsonBackReference(value="stock-brandmodel")
    @JoinColumn(name = "id_brand_model")
    private BrandModel brandModel;

    private int stock;

}
