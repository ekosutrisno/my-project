package com.xsis.xsis.services;

import java.util.List;
import java.util.Optional;

import com.xsis.xsis.models.entity.EmployeeEntity;

/**
 * IEmployeeService
 */
public interface IEmployeeService {

    List<EmployeeEntity> getAll();

    // join tabel dengan x_biodata
    List<EmployeeEntity> getRoAndTroByBiodataId(Long id);

    // mengambil karyawan yang is_ero = true
    List<EmployeeEntity> getRoAndTroByEro();

    // mengambil karyawan yang is_ero = true berdasarkan id
    List<EmployeeEntity> getTruId(Long id);

    EmployeeEntity save(EmployeeEntity employeeEntity);

    Optional<EmployeeEntity> getById(Long id);

    EmployeeEntity update(EmployeeEntity employeeEntity);

    EmployeeEntity delete(Long id);
}