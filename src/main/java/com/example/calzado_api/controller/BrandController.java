package com.example.calzado_api.controller;

import java.util.List;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import com.example.calzado_api.model.Brand;
import com.example.calzado_api.service.BrandService;

@RestController
@RequestMapping("/api/brands")
public class BrandController {

    private final BrandService brandService;

    public BrandController(BrandService brandService) {
        this.brandService = brandService;
    }

    @GetMapping
    public List<Brand> list() {
        return brandService.findAll();
    }

    @GetMapping("/{id}")
    public Brand get(@PathVariable Long id) {
        return brandService.findById(id);
    }

    @PostMapping
    public ResponseEntity<Brand> create(@Validated @RequestBody Brand brand) {
        return ResponseEntity.ok(brandService.create(brand));
    }

    @PutMapping("/{id}")
    public ResponseEntity<Brand> update(@PathVariable Long id, @Validated @RequestBody Brand brand) {
        return ResponseEntity.ok(brandService.update(id, brand));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id) {
        brandService.delete(id);
        return ResponseEntity.noContent().build();
    }

    @GetMapping("/search")
    public List<Brand> search(@RequestParam("q") String q) {
        return brandService.searchByName(q);
    }
}