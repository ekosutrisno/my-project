package com.xsis.xsis.repository;

import com.xsis.xsis.models.entity.ReligionEntity;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * ReligionRepository
 */
@Repository
public interface ReligionRepository extends JpaRepository<ReligionEntity, Long> {

}