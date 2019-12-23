package com.xsis.xsis.services.implementation;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Optional;

import com.xsis.xsis.models.entity.ScheduleTypeEntity;
import com.xsis.xsis.repository.ScheduleTypeRepository;
import com.xsis.xsis.services.IScheduleTypeService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * ScheduleTypeService
 */
@Service
public class ScheduleTypeService implements IScheduleTypeService {

    @Autowired
    private ScheduleTypeRepository scheduleTypeRepository;

    public List<ScheduleTypeEntity> getAll() {
        List<ScheduleTypeEntity> schedule = new ArrayList<>();
        for (ScheduleTypeEntity schedules : scheduleTypeRepository.findAll()) {
            if (!schedules.getIsDelete()) {
                schedule.add(schedules);
            }
        }
        return schedule;
    }

    @Override
    public ScheduleTypeEntity save(ScheduleTypeEntity scheduleTypeEntity) {
        scheduleTypeEntity.setCreatedBy(1L);
        scheduleTypeEntity.setCreatedOn(new Date());
        return scheduleTypeRepository.save(scheduleTypeEntity);
    }

    @Override
    public Optional<ScheduleTypeEntity> getById(Long id) {
        return scheduleTypeRepository.findById(id);
    }

    @Override
    public ScheduleTypeEntity update(ScheduleTypeEntity scheduleTypeEntity) {
        ScheduleTypeEntity scheduleDetail = scheduleTypeRepository.findById(scheduleTypeEntity.getId()).get();

        scheduleDetail.setId(scheduleTypeEntity.getId());
        scheduleDetail.setName(scheduleTypeEntity.getName());
        scheduleDetail.setDescription(scheduleTypeEntity.getDescription());

        scheduleDetail.setModifiedBy(1L);
        scheduleDetail.setModifiedOn(new Date());
        return scheduleTypeRepository.save(scheduleDetail);
    }

    @Override
    public ScheduleTypeEntity delete(Long id) {
        ScheduleTypeEntity schedule = scheduleTypeRepository.findById(id).get();
        schedule.setIsDelete(true);
        schedule.setDeletedBy(1L);
        schedule.setDeleteddOn(new Date());
        return scheduleTypeRepository.save(schedule);
    }

}