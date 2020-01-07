package com.xsis.xsis.repository;

import java.util.List;

import com.xsis.xsis.models.entity.BiodataView;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

/**
 * BiodataViewRepository
 */
@Repository
public interface BiodataViewRepository extends JpaRepository<BiodataView, Long> {
  static final String SEARCH_DATA = "SELECT * FROM x_data_vacancy WHERE LOWER(fullname) LIKE %:name%";

  @Query(value = SEARCH_DATA, nativeQuery = true)
  List<BiodataView> findByFullNameContainingIgnoreCase(@Param("name") String fullname);

}