package com.xsis.xsis.repository.vacancy_pendidikan_resourceproject;

import java.util.List;

import com.xsis.xsis.dto.vacancy_pendidikan_resourceproject.TraiDto;
import com.xsis.xsis.model.vacancy_pendidikan_resourceproject.Training;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

/**
 * TrainingRepository
 */
public interface TrainingRepository extends JpaRepository<Training, Long>{

    @Query(nativeQuery = true)
    List<TraiDto> getTrainingBiodata(Long biodataId);
    
}