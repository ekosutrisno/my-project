package com.xsis.xsis.repository;

import com.xsis.xsis.models.entity.BiodataEntity;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

/**
 * PagingPelamarRepository
 */
@Repository
public interface PagingPelamarRepository extends PagingAndSortingRepository<BiodataEntity, Long> {
    static final String PAGE_BIODATA = "SELECT * FROM x_biodata WHERE isdelete = 'false'";

    @Query(value = PAGE_BIODATA, nativeQuery = true)
    Page<BiodataEntity> findByPaging(Pageable pageable, String key);
}