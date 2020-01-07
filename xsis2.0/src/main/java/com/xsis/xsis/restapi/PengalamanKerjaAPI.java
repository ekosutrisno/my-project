package com.xsis.xsis.restapi;

import com.xsis.xsis.services.PengalamanKerjaServices;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * PengalamanKerjaAPI
 */
@RestController
@RequestMapping(path = "/api/pengalaman-kerja", produces = "application/json")
@CrossOrigin(origins = "*")
public class PengalamanKerjaAPI {

    @Autowired
    private PengalamanKerjaServices pengalamanKerjaServices;

    @GetMapping("/biodata/{biodata_id}")
    public ResponseEntity<?> findPengalamanKerjaBiodata(@PathVariable("biodata_id") Long biodataId) {
        return new ResponseEntity<>(pengalamanKerjaServices.getPengalamanKerjaBiodata(biodataId), HttpStatus.OK);
    }

}