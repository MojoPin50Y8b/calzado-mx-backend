package com.example.calzado_api.controller;

import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import com.example.calzado_api.model.Shoe;
import com.example.calzado_api.service.ShoeService;

@RestController
@RequestMapping("/api/shoes")
public class ShoeController {

    private final ShoeService shoeService;

    public ShoeController(ShoeService shoeService) {
        this.shoeService = shoeService;
    }

    /** Nuevo: delega en service.list(brandId, q) para filtrar combinado. */
    @GetMapping
    public List<Shoe> list(
            @RequestParam(value = "brandId", required = false) Long brandId,
            @RequestParam(value = "q", required = false) String q) {
        return shoeService.list(brandId, q);
    }

    @GetMapping("/{id}")
    public Shoe get(@PathVariable Long id) {
        return shoeService.findById(id);
    }

    @PostMapping
    public ResponseEntity<Shoe> create(@Validated @RequestBody Shoe shoe,
            @RequestParam("brandId") Long brandId) {
        return ResponseEntity.ok(shoeService.create(shoe, brandId));
    }

    @PutMapping("/{id}")
    public ResponseEntity<Shoe> update(@PathVariable Long id,
            @Validated @RequestBody Shoe shoe,
            @RequestParam(value = "brandId", required = false) Long brandId) {
        return ResponseEntity.ok(shoeService.update(id, shoe, brandId));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id) {
        shoeService.delete(id);
        return ResponseEntity.noContent().build();
    }
}
