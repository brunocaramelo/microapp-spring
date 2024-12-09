package com.microapp.microapp.services;

import com.microapp.microapp.enitites.CategoryEntity;
import com.microapp.microapp.enitites.UserEntity;
import com.microapp.microapp.repositories.CategoryRepository;
import com.microapp.microapp.repositories.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class CategoryService {

    private final CategoryRepository localRepository;

    public List<CategoryEntity> getAll(int page, int pageSize) {
        return localRepository.findAll(PageRequest.of(page, pageSize)).getContent();
    }

    public Optional<CategoryEntity> getById(int id) {
        return localRepository.findById(id);
    }

}
