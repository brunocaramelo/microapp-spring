package com.microapp.microapp.controllers;

import com.microapp.microapp.enitites.CategoryEntity;
import com.microapp.microapp.enitites.SaleEntity;
import com.microapp.microapp.services.CategoryService;
import com.microapp.microapp.services.SalesService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/sales")
public class SalesController {

    private final SalesService localService;

    @GetMapping("/")
    public List<SaleEntity> getAllUsers(@RequestParam(value = "page", required = false, defaultValue = "0") int page,
                                        @RequestParam(value = "pageSize", required = false, defaultValue = "50") int pageSize) {
        return localService.getAll(page, pageSize);
    }

    @GetMapping("/{id}")
    public ResponseEntity<SaleEntity> getUserById(@PathVariable int id) {
        return localService.getById(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }
}
