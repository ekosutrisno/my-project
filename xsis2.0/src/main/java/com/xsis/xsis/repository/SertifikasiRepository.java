package com.xsis.xsis.repository.vacancy_pendidikan_resourceproject;

import java.util.List;

import com.xsis.xsis.dto.vacancy_pendidikan_resourceproject.SertDto;
import com.xsis.xsis.model.vacancy_pendidikan_resourceproject.Sertifikasi;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

/**
 * SertifikasiRepository
 */
public interface SertifikasiRepository extends JpaRepository<Sertifikasi, Long>{

    @Query(nativeQuery = true)
    List<SertDto> getSertifikasiBiodata(Long biodataId);
    
}