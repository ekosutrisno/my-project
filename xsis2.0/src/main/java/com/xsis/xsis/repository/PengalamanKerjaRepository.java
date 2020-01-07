package com.xsis.xsis.repository;

import java.util.List;

import com.xsis.xsis.dto.PeKerDto;
import com.xsis.xsis.model.PengalamanKerja;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

/**
 * PengalamanKerjaRepository
 */
public interface PengalamanKerjaRepository extends JpaRepository<PengalamanKerja, Long> {

    @Query(nativeQuery = true)
    List<PeKerDto> getPengalamanKerjaBiodata(Long biodataId);

}