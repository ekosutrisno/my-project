package com.xsis.xsis.restapi.vacancy_pendidikan_resourceproject;

import com.xsis.xsis.services.vacancy_pendidikan_resourceproject.KeahlianService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * KeahlianAPI
 */
@RestController
@RequestMapping(path = "/api/keahlian", produces = "application/json")
@CrossOrigin(origins = "*")
public class KeahlianAPI {

    @Autowired
    private KeahlianService keahlianService;

    @GetMapping("/biodata/{biodata_id}")
    public ResponseEntity<?> findKeahlianBiodata(@PathVariable("biodata_id") Long biodataId) {
        return new ResponseEntity<>(keahlianService.getKeahlianBiodata(biodataId), HttpStatus.OK);
    }

    
}