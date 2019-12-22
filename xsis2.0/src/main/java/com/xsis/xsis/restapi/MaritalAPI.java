package com.xsis.xsis.restapi;

import java.util.List;
import java.util.Optional;

import com.xsis.xsis.dto.MaritalDto;
import com.xsis.xsis.models.entity.MaritalStatusEntity;
import com.xsis.xsis.services.IMaritalService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * MaritalAPI
 */
@RestController
@RequestMapping("api/marital")
@CrossOrigin(origins = "*")
public class MaritalAPI {

    @Autowired
    private IMaritalService maritalService;

    @GetMapping
    public List<MaritalStatusEntity> getAll() {
        return maritalService.getAll();
    }

    @GetMapping("/{id}")
    public ResponseEntity<?> maritalById(@PathVariable("id") Long id) {
        Optional<MaritalStatusEntity> optMartial = maritalService.getById(id);
        if (optMartial.isPresent()) {
            return new ResponseEntity<>(optMartial.get(), HttpStatus.OK);
        }

        return new ResponseEntity<>(null, HttpStatus.NOT_FOUND);
    }

    @PostMapping
    public MaritalDto simpanMarital(@RequestBody MaritalDto maritalDto) {

        MaritalStatusEntity maritalMapDetail = new MaritalStatusEntity();
        maritalMapDetail.setName(maritalDto.getName());
        maritalMapDetail.setDescription(maritalDto.getDescription());

        maritalService.save(maritalMapDetail);
        return maritalDto;
    }

    @PutMapping
    public MaritalDto updateMarital(@RequestBody MaritalDto maritalDto) {

        MaritalStatusEntity maritalMapDetail = new MaritalStatusEntity();
        maritalMapDetail.setId(maritalDto.getId());
        maritalMapDetail.setName(maritalDto.getName());
        maritalMapDetail.setDescription(maritalDto.getDescription());

        maritalService.save(maritalMapDetail);
        return maritalDto;
    }

    @DeleteMapping("/{id}")
    public MaritalStatusEntity deleteMarital(@PathVariable(value = "id") Long id) {
        return maritalService.delete(id);
    }

}