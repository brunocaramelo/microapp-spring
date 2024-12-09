package com.microapp.microapp.services;

import com.microapp.microapp.enitites.CategoryEntity;
import com.microapp.microapp.enitites.SaleEntity;
import com.microapp.microapp.repositories.CategoryRepository;
import com.microapp.microapp.repositories.SaleRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class SalesService {

    private final SaleRepository localRepository;

    public List<SaleEntity> getAll(int page, int pageSize) {
        return localRepository.findAll(PageRequest.of(page, pageSize)).getContent();
    }

    public Optional<SaleEntity> getById(int id) {
        return localRepository.findById(id);
    }

}
