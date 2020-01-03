package com.xsis.xsis.repository.vacancy_pendidikan_resourceproject;

import java.util.List;
import java.util.Optional;

import com.xsis.xsis.model.vacancy_pendidikan_resourceproject.Education;
import com.xsis.xsis.dto.vacancy_pendidikan_resourceproject.EduDto;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

/**
 * PendidikanRepository
 */
public interface EducationRepository extends JpaRepository<Education, Long> {
    
    @Query(nativeQuery = true)
    List<EduDto> getEduName(Long biodataId);

    @Query(nativeQuery = true)
    List<EduDto> getLastEducation(Long biodataId);

    @Query(nativeQuery = true)
    Optional<EduDto> getEduNameDetail(Long biodataId, Long id);
}