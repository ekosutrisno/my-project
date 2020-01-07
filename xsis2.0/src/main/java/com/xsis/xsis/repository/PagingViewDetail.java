package com.xsis.xsis.repository;

import com.xsis.xsis.models.entity.UndanganView;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

/**
 * PagingViewDetail
 */
@Repository
public interface PagingViewDetail extends PagingAndSortingRepository<UndanganView, Long> {
  static final String PAGE_VIEW_UNDANGAN = "SELECT * FROM x_data_search";

  @Query(value = PAGE_VIEW_UNDANGAN, nativeQuery = true)
  Page<UndanganView> findViewByPaging(Pageable pageable, String key);

}