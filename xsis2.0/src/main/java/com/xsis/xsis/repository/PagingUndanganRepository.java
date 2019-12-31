package com.xsis.xsis.repository;

import com.xsis.xsis.models.entity.UndanganEntity;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.PagingAndSortingRepository;

/**
 * PagingUndanganRepository
 */
public interface PagingUndanganRepository extends PagingAndSortingRepository<UndanganEntity, Long> {

    static final String PAGE_UNDANGAN = "SELECT * FROM x_undangan WHERE isdelete = 'false'";

    @Query(value = PAGE_UNDANGAN, nativeQuery = true)
    Page<UndanganEntity> finduUndanganByPaging(Pageable pageable, String key);

}