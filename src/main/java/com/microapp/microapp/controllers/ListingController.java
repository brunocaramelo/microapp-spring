package com.microapp.microapp.controllers;

import com.microapp.microapp.enitites.CategoryEntity;
import com.microapp.microapp.enitites.ListingEntity;
import com.microapp.microapp.services.CategoryService;
import com.microapp.microapp.services.ListingService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/listings")
public class ListingController {

    private final ListingService localService;

    @GetMapping("/")
    public List<ListingEntity> getAll( @RequestParam(value = "page", required = false, defaultValue = "0") int page,
                                       @RequestParam(value = "pageSize", required = false, defaultValue = "50") int pageSize
    ) {

        return localService.getAll(page, pageSize);
    }

    @GetMapping("/{id}")
    public ResponseEntity<ListingEntity> getUserById(@PathVariable int id) {
        return localService.getById(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }
}
