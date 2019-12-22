package com.xsis.xsis.restapi;

import java.util.List;
import java.util.Optional;

import com.xsis.xsis.dto.ReligionDto;
import com.xsis.xsis.models.entity.ReligionEntity;
import com.xsis.xsis.services.IReligionService;

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
 * ReligionAPI
 */
@RestController
@RequestMapping("api/religion")
@CrossOrigin(origins = "*")
public class ReligionAPI {

    @Autowired
    private IReligionService religionService;

    @GetMapping
    public List<ReligionEntity> getAll() {
        return religionService.getAll();
    }

    @GetMapping("/{id}")
    public ResponseEntity<?> biodataById(@PathVariable("id") Long id) {
        Optional<ReligionEntity> optReg = religionService.getById(id);
        if (optReg.isPresent()) {
            return new ResponseEntity<>(optReg.get(), HttpStatus.OK);
        }

        return new ResponseEntity<>(null, HttpStatus.NOT_FOUND);
    }

    @PostMapping
    public ReligionDto simpanReligion(@RequestBody ReligionDto religionDto) {

        ReligionEntity religionMapDetail = new ReligionEntity();
        religionMapDetail.setName(religionDto.getName());
        religionMapDetail.setDescription(religionDto.getDescription());

        religionService.save(religionMapDetail);
        return religionDto;
    }

    @PutMapping
    public ReligionDto updateReligion(@RequestBody ReligionDto religionDto) {

        ReligionEntity religionMapDetail = new ReligionEntity();
        religionMapDetail.setId(religionDto.getId());
        religionMapDetail.setName(religionDto.getName());
        religionMapDetail.setDescription(religionDto.getDescription());

        religionService.update(religionMapDetail);
        return religionDto;
    }

    @DeleteMapping("/{id}")
    public ReligionEntity deleteReligion(@PathVariable(value = "id") Long id) {
        return religionService.delete(id);
    }

}