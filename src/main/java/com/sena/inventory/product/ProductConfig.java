package com.sena.inventory.product;


import com.sena.inventory.brand.Brand;
import com.sena.inventory.brand.BrandRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.List;


@Configuration
public class ProductConfig {

    @Bean
    CommandLineRunner commandLineRunner (ProductRepository productRepository, BrandRepository brandRepository){
        return args -> {
            Brand logitech = new Brand("logitech");
            Brand lenovo = new Brand("lenovo");
            Brand hp = new Brand("hp");
            brandRepository.saveAll(List.of(logitech, lenovo, hp));
            Product Teclado = new Product("Teclado", 50000.00,20000.00,new Brand(1,""),true, 30 );
            Product Mouse = new Product("mouse", 50000.00,20000.00,new Brand(2,"") ,true, 30);
            Product Pantalla = new Product("pantalla", 500000.00,300000.00,new Brand(3,""),true, 30 );
            productRepository.saveAll(List.of(Teclado, Mouse, Pantalla));
        };
    }
}
