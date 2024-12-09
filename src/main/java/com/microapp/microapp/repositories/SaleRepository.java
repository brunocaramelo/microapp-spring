package com.microapp.microapp.repositories;

import com.microapp.microapp.enitites.ListingEntity;
import com.microapp.microapp.enitites.SaleEntity;
import com.microapp.microapp.enitites.UserEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SaleRepository extends JpaRepository<SaleEntity, Integer> {

}
