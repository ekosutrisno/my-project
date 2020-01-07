package com.xsis.xsis.services.implementation;

import java.util.List;

import com.xsis.xsis.dto.TraiDto;
import com.xsis.xsis.repository.TrainingRepository;
import com.xsis.xsis.services.TrainingServices;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * TrainingServicesImpl
 */
@Service
public class TrainingServicesImpl implements TrainingServices {

    @Autowired
    private TrainingRepository trainingRepository;

    @Override
    public List<TraiDto> getTrainingBiodata(Long biodataId) {
        return trainingRepository.getTrainingBiodata(biodataId);
    }
}