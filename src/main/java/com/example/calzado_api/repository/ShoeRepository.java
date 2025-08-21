package com.example.calzado_api.repository;

import com.example.calzado_api.model.Shoe;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ShoeRepository extends JpaRepository<Shoe, Long> {
    List<Shoe> findByBrandId(Long brandId);

    List<Shoe> findByModelNameContainingIgnoreCase(String q);

    List<Shoe> findByBrandIdAndModelNameContainingIgnoreCase(Long brandId, String q);
}
