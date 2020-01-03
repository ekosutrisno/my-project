package com.xsis.xsis.restapi;

import java.util.List;
import java.util.Optional;

import com.xsis.xsis.dto.UndanganDetailDto;
import com.xsis.xsis.models.entity.UndanganDetailEntity;
import com.xsis.xsis.services.IUndanganDetailService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;

/**
 * UndanganDetailAPI
 */
@RestController
@RequestMapping(path = "api/detail-undangan", produces = "application/json")
@CrossOrigin(origins = "*")
public class UndanganDetailAPI {

    @Autowired
    private IUndanganDetailService undanganDetailService;

    @GetMapping
    public Page<UndanganDetailEntity> findByPaging(Pageable pageable,
            @RequestParam(name = "key", defaultValue = "") String key) {
        return undanganDetailService.findByPaging(pageable, key);
    }

    @GetMapping("/{id}")
    public ResponseEntity<?> detailUndanganById(@PathVariable("id") Long id) {
        Optional<UndanganDetailEntity> optUnd = undanganDetailService.getById(id);
        if (optUnd.isPresent()) {
            return new ResponseEntity<>(optUnd.get(), HttpStatus.OK);
        }
        return new ResponseEntity<>(null, HttpStatus.NOT_FOUND);
    }

    @GetMapping("/search")
    public List<UndanganDetailEntity> cariDetailUndangan(@RequestParam(name = "name") String name) {
        return undanganDetailService.searchDataByName(name);
    }

    @PostMapping
    public UndanganDetailDto SimpanDetailUndangan(@RequestBody UndanganDetailDto undanganDetailDto) {

        UndanganDetailEntity unDetail = new UndanganDetailEntity();
        unDetail.setBiodataId(undanganDetailDto.getBiodataId());
        unDetail.setUndanganId(undanganDetailDto.getUndanganId());
        unDetail.setNotes(undanganDetailDto.getNotes());

        undanganDetailService.save(unDetail);
        return undanganDetailDto;
    }

    @PutMapping
    public UndanganDetailDto updateUndangan(@RequestBody UndanganDetailDto undanganDetailDto) {
        UndanganDetailEntity unDetail = new UndanganDetailEntity();
        unDetail.setId(undanganDetailDto.getId());
        unDetail.setBiodataId(undanganDetailDto.getBiodataId());
        unDetail.setUndanganId(undanganDetailDto.getUndanganId());
        unDetail.setNotes(undanganDetailDto.getNotes());

        undanganDetailService.update(unDetail);
        return undanganDetailDto;
    }

    @DeleteMapping("/{id}")
    public UndanganDetailEntity deleteDetailUndangan(@PathVariable(value = "id") Long id) {
        return undanganDetailService.delete(id);
    }

}