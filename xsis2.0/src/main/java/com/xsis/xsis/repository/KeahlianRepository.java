package com.xsis.xsis.repository;

import java.util.List;

import com.xsis.xsis.dto.KeahDto;
import com.xsis.xsis.model.Keahlian;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

/**
 * KeahlianRepository
 */
public interface KeahlianRepository extends JpaRepository<Keahlian, Long> {

    @Query(nativeQuery = true)
    List<KeahDto> getKeahlianBiodata(Long biodataId);
    
}