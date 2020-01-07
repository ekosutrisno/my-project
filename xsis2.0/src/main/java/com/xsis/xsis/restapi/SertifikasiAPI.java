package com.xsis.xsis.restapi;

import com.xsis.xsis.services.SertifikasiServices;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * SertifikasiAPI
 */
@RestController
@RequestMapping(path = "/api/sertifikasi", produces = "application/json")
@CrossOrigin(origins = "*")
public class SertifikasiAPI {

    @Autowired
    private SertifikasiServices sertifikasiServices;

    @GetMapping("/biodata/{biodata_id}")
    public ResponseEntity<?> findSertifikasiBiodata(@PathVariable("biodata_id") Long biodataId) {
        return new ResponseEntity<>(sertifikasiServices.getSertifikasiBiodata(biodataId), HttpStatus.OK);
    }
}