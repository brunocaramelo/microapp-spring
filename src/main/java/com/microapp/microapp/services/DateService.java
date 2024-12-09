package com.microapp.microapp.services;

import com.microapp.microapp.enitites.CategoryEntity;
import com.microapp.microapp.enitites.DateEntity;
import com.microapp.microapp.repositories.CategoryRepository;
import com.microapp.microapp.repositories.DateRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class DateService {

    private final DateRepository localRepository;

    public List<DateEntity> getAll(int page, int pageSize) {

        return localRepository.findAll(PageRequest.of(page, pageSize)).getContent();
    }

    public Optional<DateEntity> getById(int id) {
        return localRepository.findById(id);
    }

}
