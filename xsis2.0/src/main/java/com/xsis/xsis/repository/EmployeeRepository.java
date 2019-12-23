package com.xsis.xsis.repository;

import com.xsis.xsis.models.entity.EmployeeEntity;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * EmployeeRepository
 */
@Repository
public interface EmployeeRepository extends JpaRepository<EmployeeEntity, Long> {

}