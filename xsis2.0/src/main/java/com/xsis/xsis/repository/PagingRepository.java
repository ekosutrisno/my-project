package com.xsis.xsis.repository;

// import java.util.List;

import com.xsis.xsis.models.entity.RencanaEntity;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

/**
 * PagingRepository
 */
@Repository
public interface PagingRepository extends PagingAndSortingRepository<RencanaEntity, Long> {

    static final String PAGE_RENCANA = "SELECT * FROM x_rencana_jadwal WHERE isdelete = 'false'";

    @Query(value = PAGE_RENCANA, nativeQuery = true)
    Page<RencanaEntity> findByPaging(Pageable pageable, String key);

}