package com.xsis.xsis.repository;

import com.xsis.xsis.models.entity.MaritalStatusEntity;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * MaritalRepository
 */
@Repository
public interface MaritalRepository extends JpaRepository<MaritalStatusEntity, Long> {

}