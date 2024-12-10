package com.microapp.microapp.repositories;

import com.microapp.microapp.enitites.ListingEntity;
import com.microapp.microapp.enitites.UserEntity;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

@Repository
public interface ListingRepository extends JpaRepository<ListingEntity, Integer> {
}
