package com.microapp.microapp.services;

import com.microapp.microapp.enitites.CategoryEntity;
import com.microapp.microapp.enitites.VenueEntity;
import com.microapp.microapp.repositories.CategoryRepository;
import com.microapp.microapp.repositories.VenueRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class VenueService {

    private final VenueRepository localRepository;

    public List<VenueEntity> getAll(int page, int pageSize) {
        return localRepository.findAll(PageRequest.of(page, pageSize)).getContent();
    }

    public Optional<VenueEntity> getById(int id) {
        return localRepository.findById(id);
    }

}
