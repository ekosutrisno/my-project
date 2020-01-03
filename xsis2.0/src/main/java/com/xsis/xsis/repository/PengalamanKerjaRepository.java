package com.xsis.xsis.repository.vacancy_pendidikan_resourceproject;

import java.util.List;

import com.xsis.xsis.dto.vacancy_pendidikan_resourceproject.PeKerDto;
import com.xsis.xsis.model.vacancy_pendidikan_resourceproject.PengalamanKerja;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

/**
 * PengalamanKerjaRepository
 */
public interface PengalamanKerjaRepository extends JpaRepository<PengalamanKerja, Long>{

    @Query(nativeQuery = true)
    List<PeKerDto> getPengalamanKerjaBiodata(Long biodataId);
    
}