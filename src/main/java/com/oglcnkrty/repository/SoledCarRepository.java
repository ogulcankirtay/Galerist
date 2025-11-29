package com.oglcnkrty.repository;

import com.oglcnkrty.model.SoledCar;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SoledCarRepository extends JpaRepository<SoledCar, Long> {
}
