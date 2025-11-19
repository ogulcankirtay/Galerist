package com.oglcnkrty.repository;

import com.oglcnkrty.model.Galerist;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface GaleristRepository extends JpaRepository<Galerist, Long> {
}
