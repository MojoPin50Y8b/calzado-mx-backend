package com.example.calzado_api.service;

import java.util.List;
import org.springframework.stereotype.Service;
import com.example.calzado_api.exception.ResourceNotFoundException;
import com.example.calzado_api.model.Brand;
import com.example.calzado_api.repository.BrandRepository;

@Service
public class BrandService {
    private final BrandRepository brandRepository;

    public BrandService(BrandRepository brandRepository) {
        this.brandRepository = brandRepository;
    }

    public List<Brand> findAll() {
        return brandRepository.findAll();
    }

    public Brand findById(Long id) {
        return brandRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Marca no encontrada: id=" + id));
    }

    public Brand create(Brand brand) {
        return brandRepository.save(brand);
    }

    public Brand update(Long id, Brand payload) {
        Brand b = findById(id);
        b.setName(payload.getName());
        b.setActive(payload.getActive());
        return brandRepository.save(b);
    }

    public void delete(Long id) {
        brandRepository.delete(findById(id));
    }

    public List<Brand> searchByName(String q) {
        return brandRepository.findByNameContainingIgnoreCase(q);
    }
}
