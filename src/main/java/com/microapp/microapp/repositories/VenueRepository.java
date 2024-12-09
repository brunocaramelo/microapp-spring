package com.microapp.microapp.repositories;

import com.microapp.microapp.enitites.UserEntity;
import com.microapp.microapp.enitites.VenueEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface VenueRepository extends JpaRepository<VenueEntity, Integer> {

}
