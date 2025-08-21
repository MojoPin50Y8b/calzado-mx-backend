package com.example.calzado_api.service;

import java.util.List;
import org.springframework.stereotype.Service;
import com.example.calzado_api.exception.ResourceNotFoundException;
import com.example.calzado_api.model.Brand;
import com.example.calzado_api.model.Shoe;
import com.example.calzado_api.repository.BrandRepository;
import com.example.calzado_api.repository.ShoeRepository;

@Service
public class ShoeService {
    private final ShoeRepository shoeRepository;
    private final BrandRepository brandRepository;

    public ShoeService(ShoeRepository shoeRepository, BrandRepository brandRepository) {
        this.shoeRepository = shoeRepository;
        this.brandRepository = brandRepository;
    }

    public List<Shoe> findAll() {
        return shoeRepository.findAll();
    }

    public Shoe findById(Long id) {
        return shoeRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Calzado no encontrado: id=" + id));
    }

    public Shoe create(Shoe shoe, Long brandId) {
        Brand brand = brandRepository.findById(brandId)
                .orElseThrow(() -> new ResourceNotFoundException("Marca no encontrada: id=" + brandId));
        shoe.setBrand(brand);
        return shoeRepository.save(shoe);
    }

    public Shoe update(Long id, Shoe payload, Long brandId) {
        Shoe s = findById(id);
        if (brandId != null) {
            Brand brand = brandRepository.findById(brandId)
                    .orElseThrow(() -> new ResourceNotFoundException("Marca no encontrada: id=" + brandId));
            s.setBrand(brand);
        }
        s.setModelName(payload.getModelName());
        s.setPrice(payload.getPrice());
        s.setColor(payload.getColor());
        s.setSize(payload.getSize());
        s.setStock(payload.getStock());
        s.setImageUrl(payload.getImageUrl());
        s.setDescription(payload.getDescription());
        return shoeRepository.save(s);
    }

    public void delete(Long id) {
        shoeRepository.delete(findById(id));
    }

    public List<Shoe> searchByModel(String q) {
        return shoeRepository.findByModelNameContainingIgnoreCase(q);
    }

    public List<Shoe> findByBrand(Long brandId) {
        return shoeRepository.findByBrandId(brandId);
    }
}