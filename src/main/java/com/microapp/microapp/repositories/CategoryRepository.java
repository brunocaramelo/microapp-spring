package com.microapp.microapp.repositories;

import com.microapp.microapp.enitites.CategoryEntity;
import com.microapp.microapp.enitites.UserEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CategoryRepository extends JpaRepository<CategoryEntity, Integer> {

}
