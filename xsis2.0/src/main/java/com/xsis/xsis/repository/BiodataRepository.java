package com.xsis.xsis.repository;

import com.xsis.xsis.model.Biodata;

import org.springframework.data.jpa.repository.JpaRepository;

/**
 * BiodataRepository
 */
public interface BiodataRepository extends JpaRepository <Biodata, Long> {

    
}