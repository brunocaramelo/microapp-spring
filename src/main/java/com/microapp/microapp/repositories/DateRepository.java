package com.microapp.microapp.repositories;

import com.microapp.microapp.enitites.DateEntity;
import com.microapp.microapp.enitites.UserEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface DateRepository extends JpaRepository<DateEntity, Integer> {

}
