package com.xsis.xsis.services;

import java.util.List;
import java.util.Optional;

import com.xsis.xsis.models.entity.EmployeeEntity;

/**
 * IEmployeeService
 */
public interface IEmployeeService {

    List<EmployeeEntity> getAll();

    EmployeeEntity save(EmployeeEntity employeeEntity);

    Optional<EmployeeEntity> getById(Long id);

    EmployeeEntity update(EmployeeEntity employeeEntity);

    EmployeeEntity delete(Long id);
}