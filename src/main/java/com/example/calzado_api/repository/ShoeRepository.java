package com.example.calzado_api.repository;

import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import com.example.calzado_api.model.Shoe;

public interface ShoeRepository extends JpaRepository<Shoe, Long> {
    List<Shoe> findByModelNameContainingIgnoreCase(String modelName);

    List<Shoe> findByBrandId(Long brandId);
}
