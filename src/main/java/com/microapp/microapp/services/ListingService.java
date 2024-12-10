package com.microapp.microapp.services;

import com.microapp.microapp.enitites.CategoryEntity;
import com.microapp.microapp.enitites.ListingEntity;
import com.microapp.microapp.repositories.CategoryRepository;
import com.microapp.microapp.repositories.ListingRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class ListingService {

    private final ListingRepository localRepository;

    public List<ListingEntity> getAll(int page, int pageSize) {
        return localRepository.findAll(PageRequest.of(page, pageSize)).getContent();
    }

    public Optional<ListingEntity> getById(int id) {
        return localRepository.findById(id);
    }

}
