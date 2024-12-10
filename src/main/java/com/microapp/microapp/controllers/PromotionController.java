package com.microapp.microapp.controllers;

import com.microapp.microapp.enitites.CategoryEntity;
import com.microapp.microapp.enitites.EventEntity;
import com.microapp.microapp.enitites.ListingEntity;
import com.microapp.microapp.repositories.EventRepository;
import com.microapp.microapp.services.CategoryService;
import com.microapp.microapp.services.EventService;
import com.microapp.microapp.services.ListingService;
import lombok.RequiredArgsConstructor;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/promotions")
public class PromotionController {

    private final EventService localService;

    @GetMapping("/available")
    public List<EventEntity> findAvailable(@RequestParam LocalDate contextDate,
                                                  @RequestParam(required = false) Integer categoryId,
                                                  @RequestParam(required = false) String city,
                                                  @RequestParam(value = "page", required = false, defaultValue = "0") int page,
                                                  @RequestParam(value = "pageSize", required = false, defaultValue = "50") int pageSize
    ) {
        return localService.findAvailable(contextDate,
                                         Optional.ofNullable(categoryId),
                                         Optional.ofNullable(city),
                                         page,
                                         pageSize);

    }
}
