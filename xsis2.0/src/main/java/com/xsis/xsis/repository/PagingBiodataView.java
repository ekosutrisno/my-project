package com.xsis.xsis.repository;

import com.xsis.xsis.models.entity.BiodataView;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

/**
 * PagingBiodataView
 */
@Repository
public interface PagingBiodataView extends PagingAndSortingRepository<BiodataView, Long> {
  static final String PAGE_VIEW_UNDANGAN = "SELECT * FROM x_data_vacancy";

  @Query(value = PAGE_VIEW_UNDANGAN, nativeQuery = true)

  Page<BiodataView> findViewByPaging(Pageable pageable, String key);

}