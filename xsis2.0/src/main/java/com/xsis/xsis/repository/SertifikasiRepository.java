package com.xsis.xsis.repository;

import java.util.List;

import com.xsis.xsis.dto.SertDto;
import com.xsis.xsis.model.Sertifikasi;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

/**
 * SertifikasiRepository
 */
public interface SertifikasiRepository extends JpaRepository<Sertifikasi, Long>{

    @Query(nativeQuery = true)
    List<SertDto> getSertifikasiBiodata(Long biodataId);
    
}