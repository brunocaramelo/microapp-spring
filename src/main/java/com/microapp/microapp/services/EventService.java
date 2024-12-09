package com.microapp.microapp.services;

import com.microapp.microapp.enitites.DateEntity;
import com.microapp.microapp.enitites.EventEntity;
import com.microapp.microapp.repositories.DateRepository;
import com.microapp.microapp.repositories.EventRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class EventService {

    private final EventRepository localRepository;

    public List<EventEntity> getAll(int page, int pageSize) {

        return localRepository.findAll(PageRequest.of(page, pageSize)).getContent();
    }

    public Optional<EventEntity> getById(int id) {
        return localRepository.findById(id);
    }

}
