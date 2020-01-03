package com.xsis.xsis.repository.vacancy_pendidikan_resourceproject;

import com.xsis.xsis.model.vacancy_pendidikan_resourceproject.EducationLevel;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

/**
 * EducationLevelRepository
 */
public interface EducationLevelRepository extends JpaRepository<EducationLevel, Long> {

    @Query(value = "select * from x_education_level order by description", nativeQuery = true)
    Iterable<EducationLevel> getEducationLevel();

}