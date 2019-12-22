package com.xsis.xsis.restapi;

import java.util.List;
import java.util.Optional;

import com.xsis.xsis.dto.IdentitasDto;
import com.xsis.xsis.models.entity.IdentitasTypeEntity;
import com.xsis.xsis.services.IIdentitasService;

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
 * IdentitasAPI
 */
@RestController
@RequestMapping("api/identitas")
@CrossOrigin(origins = "*")
public class IdentitasAPI {

    @Autowired
    private IIdentitasService identitasService;

    @GetMapping
    public List<IdentitasTypeEntity> getAll() {
        return identitasService.getAll();
    }

    @GetMapping("/{id}")
    public ResponseEntity<?> identitasById(@PathVariable("id") Long id) {
        Optional<IdentitasTypeEntity> optMartial = identitasService.getById(id);
        if (optMartial.isPresent()) {
            return new ResponseEntity<>(optMartial.get(), HttpStatus.OK);
        }

        return new ResponseEntity<>(null, HttpStatus.NOT_FOUND);
    }

    @PostMapping
    public IdentitasDto simpanidentitas(@RequestBody IdentitasDto identitasDto) {

        IdentitasTypeEntity identitasMapDetail = new IdentitasTypeEntity();
        identitasMapDetail.setName(identitasDto.getName());
        identitasMapDetail.setDescription(identitasDto.getDescription());

        identitasService.save(identitasMapDetail);
        return identitasDto;
    }

    @PutMapping
    public IdentitasDto updateidentitas(@RequestBody IdentitasDto identitasDto) {

        IdentitasTypeEntity identitasMapDetail = new IdentitasTypeEntity();
        identitasMapDetail.setId(identitasDto.getId());
        identitasMapDetail.setName(identitasDto.getName());
        identitasMapDetail.setDescription(identitasDto.getDescription());

        identitasService.save(identitasMapDetail);
        return identitasDto;
    }

    @DeleteMapping("/{id}")
    public IdentitasTypeEntity deleteidentitas(@PathVariable(value = "id") Long id) {
        return identitasService.delete(id);
    }
}