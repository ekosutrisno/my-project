package com.xsis.xsis.services.implementation;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Optional;

import com.xsis.xsis.models.entity.EmployeeEntity;
import com.xsis.xsis.repository.EmpRepoBackup;
import com.xsis.xsis.services.IEmployeeService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * EmployeeService
 */
@Service
public class EmployeeService implements IEmployeeService {
    @Autowired
    private EmpRepoBackup employeeRepository;

    public List<EmployeeEntity> getAll() {
        List<EmployeeEntity> employee = new ArrayList<>();
        for (EmployeeEntity employees : employeeRepository.findAll()) {
            if (!employees.getIsDelete()) {
                employee.add(employees);
            }
        }
        return employee;
    }

    @Override
    public List<EmployeeEntity> getRoAndTroByBiodataId(Long id) {
        return employeeRepository.getRoAndTroByBiodataId(id);
    }

    @Override
    public List<EmployeeEntity> getRoAndTroByEro() {
        return employeeRepository.getRoAndTroByEro();
    }

    @Override
    public List<EmployeeEntity> getTruId(Long id) {
        return employeeRepository.getTruId(id);
    }

    @Override
    public EmployeeEntity save(EmployeeEntity employeeEntity) {
        employeeEntity.setCreatedBy(1L);
        employeeEntity.setCreatedOn(new Date());
        return employeeRepository.save(employeeEntity);
    }

    @Override
    public Optional<EmployeeEntity> getById(Long id) {
        return employeeRepository.findById(id);
    }

    @Override
    public EmployeeEntity update(EmployeeEntity employeeEntity) {
        EmployeeEntity employeeDetail = employeeRepository.findById(employeeEntity.getId()).get();

        employeeDetail.setId(employeeEntity.getId());
        employeeDetail.setBiodataId(employeeEntity.getBiodataId());
        employeeDetail.setIdle(false);
        employeeDetail.setEro(false);
        employeeDetail.setUserClient(false);
        employeeDetail.setEroEmail(employeeEntity.getEroEmail());

        employeeDetail.setModifiedBy(1L);
        employeeDetail.setModifiedOn(new Date());
        return employeeRepository.save(employeeDetail);
    }

    @Override
    public EmployeeEntity delete(Long id) {
        EmployeeEntity employee = employeeRepository.findById(id).get();
        employee.setIsDelete(true);
        employee.setDeletedBy(1L);
        employee.setDeleteddOn(new Date());
        return employeeRepository.save(employee);
    }
}