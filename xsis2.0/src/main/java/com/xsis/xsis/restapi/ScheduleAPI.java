package com.xsis.xsis.restapi;

import java.util.List;
import java.util.Optional;

import com.xsis.xsis.dto.ScheduleDto;
import com.xsis.xsis.models.entity.ScheduleTypeEntity;
import com.xsis.xsis.services.IScheduleTypeService;

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
 * ScheduleAPI
 */
@RestController
@CrossOrigin(origins = "*")
@RequestMapping("/api/schedule")
public class ScheduleAPI {
    @Autowired
    private IScheduleTypeService scheduleTypeService;

    @GetMapping
    public List<ScheduleTypeEntity> getAll() {
        return scheduleTypeService.getAll();
    }

    @GetMapping("/{id}")
    public ResponseEntity<?> biodataById(@PathVariable("id") Long id) {
        Optional<ScheduleTypeEntity> optReg = scheduleTypeService.getById(id);
        if (optReg.isPresent()) {
            return new ResponseEntity<>(optReg.get(), HttpStatus.OK);
        }

        return new ResponseEntity<>(null, HttpStatus.NOT_FOUND);
    }

    @PostMapping
    public ScheduleDto simpanReligion(@RequestBody ScheduleDto scheduleDto) {

        ScheduleTypeEntity scheduleDetail = new ScheduleTypeEntity();

        scheduleDetail.setName(scheduleDto.getName());
        scheduleDetail.setDescription(scheduleDto.getDescription());

        scheduleTypeService.save(scheduleDetail);
        return scheduleDto;
    }

    @PutMapping
    public ScheduleDto updateReligion(@RequestBody ScheduleDto scheduleDto) {

        ScheduleTypeEntity scheduleMapDetail = new ScheduleTypeEntity();
        scheduleMapDetail.setId(scheduleDto.getId());
        scheduleMapDetail.setName(scheduleDto.getName());
        scheduleMapDetail.setDescription(scheduleDto.getDescription());

        scheduleTypeService.update(scheduleMapDetail);
        return scheduleDto;
    }

    @DeleteMapping("/{id}")
    public ScheduleTypeEntity deleteReligion(@PathVariable(value = "id") Long id) {
        return scheduleTypeService.delete(id);
    }

}