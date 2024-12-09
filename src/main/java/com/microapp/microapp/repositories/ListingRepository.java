package com.microapp.microapp.repositories;

import com.microapp.microapp.enitites.ListingEntity;
import com.microapp.microapp.enitites.UserEntity;
import org.springframework.data.domain.Page;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.awt.print.Pageable;

@Repository
public interface ListingRepository extends JpaRepository<ListingEntity, Integer> {

}
