package com.xsis.xsis.services;

import java.util.List;
import java.util.Optional;

import com.xsis.xsis.model.Education;
import com.xsis.xsis.dto.EduDto;

import org.springframework.data.repository.query.Param;

/**
 * PendidikanServices
 */
public interface EducationServices {

    // Post Data Pendidikan Pelamar
    Education saveEducation(Education education);

    // Get List Data Pendidikan Pelamar
    Iterable<Education> findAllEducation();

    // Get Data Pendidikan Pelamar
    Optional<Education> getEducationById(@Param("id") Long id);

    // Education Join Education Level
    List<EduDto> getEduName(Long biodataId);

    // Education Join Education Level Detail
    Optional<EduDto> getEduNameDetail(Long biodataId, Long id);
}