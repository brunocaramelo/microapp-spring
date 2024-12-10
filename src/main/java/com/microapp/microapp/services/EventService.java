package com.microapp.microapp.services;

import com.microapp.microapp.enitites.DateEntity;
import com.microapp.microapp.enitites.EventEntity;
import com.microapp.microapp.enitites.ListingEntity;
import com.microapp.microapp.repositories.DateRepository;
import com.microapp.microapp.repositories.EventRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.PageRequest;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class EventService {

    private final EventRepository localRepository;

    public List<EventEntity> getAll(int page, int pageSize) {

        return localRepository.findAll(PageRequest.of(page, pageSize)).getContent();
    }

    public List<EventEntity> findAvailable(LocalDate contextDate,
                                           Optional<Integer> categoryId,
                                           Optional<String> city,
                                           int page,
                                           int pageSize
    ) {
        LocalDateTime startOfDay = contextDate.atStartOfDay();
        LocalDateTime endOfDay = contextDate.atStartOfDay().withHour(23).withMinute(59).withSecond(59);

        return localRepository.findAvailable(startOfDay,
                                             endOfDay,
                                             categoryId,
                                             city,
                                             PageRequest.of(page, pageSize));
    }


    public Optional<EventEntity> getById(int id) {

        return localRepository.findById(id);
    }

}
