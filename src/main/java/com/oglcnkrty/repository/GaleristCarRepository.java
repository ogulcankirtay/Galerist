package com.oglcnkrty.repository;

import com.oglcnkrty.model.GaleristCar;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface GaleristCarRepository extends JpaRepository<GaleristCar, Long> {
}
