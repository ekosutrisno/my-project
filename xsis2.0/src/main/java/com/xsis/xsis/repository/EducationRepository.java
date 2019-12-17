package com.xsis.xsis.repository;

import java.util.List;
import java.util.Optional;

import com.xsis.xsis.model.Education;
import com.xsis.xsis.dto.EduDto;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

/**
 * PendidikanRepository
 */
public interface EducationRepository extends JpaRepository<Education, Long> {
    
    @Query(nativeQuery = true)
    List<EduDto> getEduName(Long biodataId);

    @Query(nativeQuery = true)
    Optional<EduDto> getEduNameDetail(Long biodataId, Long id);
}