package com.example.calzado_api.config;

import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.example.calzado_api.model.Brand;
import com.example.calzado_api.repository.BrandRepository;

import java.util.List;

@Configuration
public class DataLoader {
    @Bean
    CommandLineRunner initBrands(BrandRepository brandRepository) {
        return args -> {
            if (brandRepository.count() == 0) {
                List<String> names = List.of("Jordan", "Converse", "Nike", "Adidas", "Umbro", "Pirma", "Charly");
                names.forEach(n -> {
                    Brand b = new Brand();
                    b.setName(n);
                    b.setActive(true);
                    brandRepository.save(b);
                });
            }
        };
    }
}