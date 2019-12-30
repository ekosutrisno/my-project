package com.xsis.xsis.repository;

import com.xsis.xsis.models.entity.UndanganEntity;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * UndanganRepository
 */
@Repository
public interface UndanganRepository extends JpaRepository<UndanganEntity, Long> {

}