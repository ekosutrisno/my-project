package com.xsis.xsis.services;

import java.util.List;
import java.util.Optional;

import com.xsis.xsis.models.entity.ScheduleTypeEntity;

/**
 * IScheduleTypeService
 */
public interface IScheduleTypeService {
    List<ScheduleTypeEntity> getAll();

    ScheduleTypeEntity save(ScheduleTypeEntity scheduleTypeEntity);

    Optional<ScheduleTypeEntity> getById(Long id);

    ScheduleTypeEntity update(ScheduleTypeEntity scheduleTypeEntity);

    ScheduleTypeEntity delete(Long id);

}