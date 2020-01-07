package com.xsis.xsis.services.implementation;

import com.xsis.xsis.model.EducationLevel;
import com.xsis.xsis.repository.EducationLevelRepository;
import com.xsis.xsis.services.EducationLevelServices;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * EducationLevelServicesImpl
 */
@Service
public class EducationLevelServicesImpl implements EducationLevelServices {

    @Autowired
    private EducationLevelRepository educationLevelRepository;

    @Override
    public Iterable<EducationLevel> getEducationLevel() {
        return educationLevelRepository.findAll();
    }


    

    
}