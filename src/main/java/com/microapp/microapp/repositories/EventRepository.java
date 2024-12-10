package com.microapp.microapp.repositories;

import com.microapp.microapp.enitites.EventEntity;
import com.microapp.microapp.enitites.ListingEntity;
import com.microapp.microapp.enitites.UserEntity;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

@Repository
public interface EventRepository extends JpaRepository<EventEntity, Integer> {

    @Query("SELECT e FROM EventEntity e " +
            " JOIN e.venue v " +
            " JOIN e.category c " +
            " WHERE e.eventStartTime BETWEEN :startOfDate AND :endOfDay " +
            " AND (:categoryId IS NULL OR c.id = :categoryId%) " +
            " AND (:city IS NULL OR v.city = :city%)")
    List<EventEntity> findAvailable(@Param("startOfDate") LocalDateTime startOfDay ,
                                    @Param("endOfDay") LocalDateTime endOfDay ,
                                   @Param("categoryId") Optional<Integer> categoryId,
                                   @Param("city") Optional<String> city,
                                   Pageable pageable);
}
