package com.xsis.xsis.repository;

import java.util.List;

import com.xsis.xsis.models.entity.UndanganView;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

/**
 * ViewRepository
 */
@Repository
public interface ViewRepository extends JpaRepository<UndanganView, Long> {

    static final String SEARCH_DATA = "SELECT * FROM x_data_search WHERE LOWER(fullname) LIKE %:name%";

    @Query(value = SEARCH_DATA, nativeQuery = true)
    List<UndanganView> searchUndanganbyName(@Param("name") String name);
}