package com.jmr.producer.producer_practica.producer_practica_strings;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

@EnableEurekaClient
@SpringBootApplication
@EntityScan({"com.jmr.practica.entities_practica.libreria_custom_maven_practica.models.entities"})
public class ProducerPracticaStringsApplication {

    public static void main(String[] args) {
        SpringApplication.run(ProducerPracticaStringsApplication.class, args);
    }

}
