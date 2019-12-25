package com.xsis.xsis.repository;

import java.util.List;

import com.xsis.xsis.models.entity.EmployeeEntity;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

/**
 * EmployeeRepository
 */
@Repository
public interface EmployeeRepository extends JpaRepository<EmployeeEntity, Long> {

  @Query(value = "select * from x_employee where biodata_id = ?1", nativeQuery = true)
  List<EmployeeEntity> getRoAndTroByBiodataId(Long id);

  @Query(value = "select * from x_employee where is_ero = true", nativeQuery = true)
  List<EmployeeEntity> getRoAndTroByEro();

}