package com.microapp.microapp.services;

import com.microapp.microapp.enitites.UserEntity;
import com.microapp.microapp.repositories.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class UserService {

    private final UserRepository userRepository;

    public List<UserEntity> getAll(int page, int pageSize) {
        return userRepository.findAll(PageRequest.of(page, pageSize)).getContent();
    }

    public Optional<UserEntity> getById(int id) {
        return userRepository.findById(id);
    }

}
