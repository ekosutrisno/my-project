package com.xsis.xsis.restapi;

import com.xsis.xsis.services.BiodataAttachmentServices;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * BiodataAttachmentAPI
 */
@RestController
@RequestMapping(path = "/api/biodata-attachment", produces = "application/json")
@CrossOrigin(origins = "*")
public class BiodataAttachmentAPI {

    @Autowired
    private BiodataAttachmentServices biodataAttachmentServices;

    @GetMapping("/profile/{biodata_id}")
    public ResponseEntity<?> findBiodataAttachment(@PathVariable("biodata_id") Long biodataId) {
        return new ResponseEntity<>(biodataAttachmentServices.getBiodataAttachment(biodataId), HttpStatus.OK);
    }

}