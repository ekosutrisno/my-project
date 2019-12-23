package com.xsis.xsis.repository;

import com.xsis.xsis.models.entity.RencanaEntity;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * RencanaRepository
 */
@Repository
public interface RencanaRepository extends JpaRepository<RencanaEntity, Long> {

}