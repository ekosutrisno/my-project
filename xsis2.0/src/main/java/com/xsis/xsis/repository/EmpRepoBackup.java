package com.xsis.xsis.repository;

import java.util.List;

import com.xsis.xsis.models.entity.EmployeeEntity;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

/**
 * EmpRepoBackup
 */
@Repository
public interface EmpRepoBackup extends JpaRepository<EmployeeEntity, Long> {

  @Query(value = "SELECT * FROM x_employee WHERE biodata_id = ?1", nativeQuery = true)
  List<EmployeeEntity> getRoAndTroByBiodataId(Long id);

  @Query(value = "SELECT * FROM x_employee WHERE is_ero = true ORDER BY x_employee.id ASC", nativeQuery = true)
  List<EmployeeEntity> getRoAndTroByEro();

  @Query(value = "SELECT * FROM x_employee WHERE is_ero = true AND biodata_id = ?1", nativeQuery = true)
  List<EmployeeEntity> getTruId(Long id);

}