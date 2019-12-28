package com.xsis.xsis.restapi;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import com.xsis.xsis.model.Biodata;
import com.xsis.xsis.services.BiodataServices;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * BiodataAPI
 */
@RestController
@RequestMapping(path = "/api/biodata", produces = "application/json")
@CrossOrigin(origins = "*")
public class BiodataAPI {

    @Autowired
    private BiodataServices biodataServices;

    @GetMapping
    public Iterable<Biodata> findAllBiodata() {
        List<Biodata> biodata = new ArrayList<>();
        for (Biodata biodatas : biodataServices.getBiodata())
        {
            if (!biodatas.getIsDelete())
            {
                biodata.add(biodatas);
            }
        }
        return biodata;
    }

    @GetMapping("/{id}")
    public ResponseEntity<?> biodataById(@PathVariable("id") Long id) {
        Optional<Biodata> optBiodata = biodataServices.getBiodataById(id);
        if (optBiodata.isPresent()) {
            return new ResponseEntity<>(optBiodata.get(), HttpStatus.OK);
        }
        return new ResponseEntity<>(null, HttpStatus.NOT_FOUND);
    }

    
}