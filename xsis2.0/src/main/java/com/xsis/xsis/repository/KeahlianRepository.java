package com.xsis.xsis.repository.vacancy_pendidikan_resourceproject;

import java.util.List;

import com.xsis.xsis.dto.vacancy_pendidikan_resourceproject.KeahDto;
import com.xsis.xsis.model.vacancy_pendidikan_resourceproject.Keahlian;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

/**
 * KeahlianRepository
 */
public interface KeahlianRepository extends JpaRepository<Keahlian, Long> {

    @Query(nativeQuery = true)
    List<KeahDto> getKeahlianBiodata(Long biodataId);
    
}