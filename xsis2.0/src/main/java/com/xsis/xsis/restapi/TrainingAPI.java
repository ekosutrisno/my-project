package com.xsis.xsis.restapi;

import com.xsis.xsis.services.TrainingServices;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * TrainingAPI
 */
@RestController
@RequestMapping(path = "/api/training", produces = "application/json")
@CrossOrigin(origins = "*")
public class TrainingAPI {

    @Autowired
    private TrainingServices trainingServices;

    @GetMapping("/biodata/{biodata_id}")
    public ResponseEntity<?> findTrainingBiodata(@PathVariable("biodata_id") Long biodataId) {
        return new ResponseEntity<>(trainingServices.getTrainingBiodata(biodataId), HttpStatus.OK);
    }

    
}