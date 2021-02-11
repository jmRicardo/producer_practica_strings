package com.jmr.producer.producer_practica.producer_practica_strings;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

@SpringBootApplication
@EnableEurekaClient
public class ProducerPracticaStringsApplication {

    public static void main(String[] args) {
        SpringApplication.run(ProducerPracticaStringsApplication.class, args);
    }

}
