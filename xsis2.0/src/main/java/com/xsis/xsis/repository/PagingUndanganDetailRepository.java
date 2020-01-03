package com.xsis.xsis.repository;

import com.xsis.xsis.models.entity.UndanganDetailEntity;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.PagingAndSortingRepository;

/**
 * PagingUndanganDetail
 */
public interface PagingUndanganDetailRepository extends PagingAndSortingRepository<UndanganDetailEntity, Long> {

    static final String QUERY_DATA = "SELECT * FROM x_undangan_detail WHERE isdelete='false'";

    @Query(value = QUERY_DATA, nativeQuery = true)
    Page<UndanganDetailEntity> findByPaging(Pageable pageable, String key);

}