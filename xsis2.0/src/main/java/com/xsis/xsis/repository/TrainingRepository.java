package com.xsis.xsis.repository;

import java.util.List;

import com.xsis.xsis.dto.TraiDto;
import com.xsis.xsis.model.Training;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

/**
 * TrainingRepository
 */
public interface TrainingRepository extends JpaRepository<Training, Long>{

    @Query(nativeQuery = true)
    List<TraiDto> getTrainingBiodata(Long biodataId);
    
}