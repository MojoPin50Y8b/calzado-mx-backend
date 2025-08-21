package com.example.calzado_api.repository;

import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import com.example.calzado_api.model.Brand;

public interface BrandRepository extends JpaRepository<Brand, Long> {
    List<Brand> findByNameContainingIgnoreCase(String name);
}
