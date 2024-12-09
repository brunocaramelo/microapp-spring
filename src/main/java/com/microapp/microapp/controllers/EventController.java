package com.microapp.microapp.controllers;

import com.microapp.microapp.enitites.CategoryEntity;
import com.microapp.microapp.enitites.EventEntity;
import com.microapp.microapp.services.CategoryService;
import com.microapp.microapp.services.EventService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/events")
public class EventController {

    private final EventService localService;

    @GetMapping("/")
    public List<EventEntity> getAllUsers(@RequestParam(value = "page", required = false, defaultValue = "0") int page,
                                         @RequestParam(value = "pageSize", required = false, defaultValue = "50") int pageSize
    ) {
        return localService.getAll(page, pageSize);
    }

    @GetMapping("/{id}")
    public ResponseEntity<EventEntity> getUserById(@PathVariable int id) {
        return localService.getById(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }
}
