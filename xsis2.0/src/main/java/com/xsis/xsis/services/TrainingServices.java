package com.xsis.xsis.services;

import java.util.List;

import com.xsis.xsis.dto.TraiDto;

/**
 * TrainingServices
 */
public interface TrainingServices {

    List<TraiDto> getTrainingBiodata(Long biodataId);
    
}