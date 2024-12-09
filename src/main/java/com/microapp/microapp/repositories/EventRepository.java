package com.microapp.microapp.repositories;

import com.microapp.microapp.enitites.EventEntity;
import com.microapp.microapp.enitites.UserEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface EventRepository extends JpaRepository<EventEntity, Integer> {

}
