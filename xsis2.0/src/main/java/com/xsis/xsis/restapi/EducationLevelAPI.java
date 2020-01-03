package com.xsis.xsis.restapi.vacancy_pendidikan_resourceproject;

import com.xsis.xsis.model.vacancy_pendidikan_resourceproject.EducationLevel;
import com.xsis.xsis.services.vacancy_pendidikan_resourceproject.EducationLevelServices;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * EducationLevelAPI
 */
@RestController
@RequestMapping(path = "/api/education-level", produces = "application/json")
@CrossOrigin(origins = "*")
public class EducationLevelAPI {

    @Autowired
    private EducationLevelServices educationLevelServices;

    @GetMapping
    public Iterable<EducationLevel> findAllEducationLevel() {
        return educationLevelServices.getEducationLevel();
    }
    
}