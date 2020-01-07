package com.xsis.xsis.restapi;

import java.util.List;
import java.util.Optional;

import com.xsis.xsis.dto.UndanganDto;
import com.xsis.xsis.models.entity.UndanganDetailEntity;
import com.xsis.xsis.models.entity.UndanganEntity;
import com.xsis.xsis.services.IUndanganDetailService;
import com.xsis.xsis.services.IUndanganService;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
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
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 * UndanganAPI
 */
@RestController
@RequestMapping(path = "/api/undangan", produces = "application/json")
@CrossOrigin(origins = "*")
public class UndanganAPI {

    @Autowired
    private IUndanganService undanganService;

    @Autowired
    private IUndanganDetailService unDetail;

    @Autowired
    private ModelMapper modelaMapper;

    @GetMapping
    public Page<UndanganEntity> findByPaging(Pageable pageable,
            @RequestParam(name = "key", defaultValue = "") String key) {
        return undanganService.findByPaging(pageable, key);
    }

    @GetMapping("/{id}")
    public ResponseEntity<?> undanganById(@PathVariable("id") Long id) {
        Optional<UndanganEntity> optReg = undanganService.getById(id);
        if (optReg.isPresent()) {
            return new ResponseEntity<>(optReg.get(), HttpStatus.OK);
        }
        return new ResponseEntity<>(null, HttpStatus.NOT_FOUND);
    }

    @GetMapping("/search")
    public List<UndanganEntity> getSearchDataByName(@RequestParam(name = "name") String name) {
        return undanganService.searchDataByName(name);
    }

    @PostMapping
    public UndanganDto simpanUndangan(@RequestBody UndanganDto undanganDto) {

        UndanganEntity undanganDetail = modelaMapper.map(undanganDto, UndanganEntity.class);
        UndanganDetailEntity undet = modelaMapper.map(undanganDto, UndanganDetailEntity.class);

        undanganDetail.setInvitationCode(undanganDto.getInvitationCode());
        undanganDetail.setInvitationDate(undanganDto.getInvitationDate());
        undanganDetail.setScheduleTypeId(undanganDto.getScheduleTypeId());
        undanganDetail.setTime(undanganDto.getTime());
        undanganDetail.setOtherRoTro(undanganDto.getOtherRoTro());
        undanganDetail.setLocation(undanganDto.getLocation());
        undanganDetail.setRo(undanganDto.getRo());
        undanganDetail.setTro(undanganDto.getTro());
        undanganDetail.setStatus(undanganDto.getStatus());

        undet.setBiodataId(undanganDto.getBiodataId());
        undet.setUndanganId(undanganDetail);
        undet.setNotes(undanganDto.getNotes());

        undanganService.save(undanganDetail);
        unDetail.save(undet);
        return undanganDto;
    }

    @PutMapping
    public UndanganDto UpdateUndangan(@RequestBody UndanganDto undanganDto) {

        UndanganEntity undanganDetail = modelaMapper.map(undanganDto, UndanganEntity.class);
        UndanganDetailEntity undet = modelaMapper.map(undanganDto, UndanganDetailEntity.class);

        undanganDetail.setId(undanganDto.getId());
        undanganDetail.setInvitationCode(undanganDto.getInvitationCode());
        undanganDetail.setInvitationDate(undanganDto.getInvitationDate());
        undanganDetail.setScheduleTypeId(undanganDto.getScheduleTypeId());
        undanganDetail.setTime(undanganDto.getTime());
        undanganDetail.setOtherRoTro(undanganDto.getOtherRoTro());
        undanganDetail.setLocation(undanganDto.getLocation());
        undanganDetail.setRo(undanganDto.getRo());
        undanganDetail.setTro(undanganDto.getTro());
        undanganDetail.setStatus(undanganDto.getStatus());

        undet.setId(undanganDto.getDetId());
        undet.setBiodataId(undanganDto.getBiodataId());
        undet.setUndanganId(undanganDetail);
        undet.setNotes(undanganDto.getNotes());

        undanganService.update(undanganDetail);
        unDetail.update(undet);
        return undanganDto;
    }

    @DeleteMapping("/{id}")
    public UndanganEntity deleteUndangan(@PathVariable(value = "id") Long id) {
        return undanganService.delete(id);
    }

    @GetMapping("/desc")
    public List<UndanganEntity> getUndanganDescending() {
        return undanganService.getDescendings();
    }
}