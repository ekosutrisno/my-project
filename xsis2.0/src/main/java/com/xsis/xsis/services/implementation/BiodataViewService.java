package com.xsis.xsis.services.implementation;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import com.xsis.xsis.models.entity.BiodataView;
import com.xsis.xsis.repository.BiodataViewRepository;
import com.xsis.xsis.repository.PagingBiodataView;
import com.xsis.xsis.services.IBiodataViewService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

/**
 * BiodataViewService
 */
@Service
public class BiodataViewService implements IBiodataViewService {

  @Autowired
  private BiodataViewRepository bioView;

  @Autowired
  private PagingBiodataView pagView;

  @Override
  public List<BiodataView> getAll() {
    List<BiodataView> view = new ArrayList<>();
    for (BiodataView views : bioView.findAll()) {
      view.add(views);
    }
    return view;
  }

  @Override
  public Optional<BiodataView> getById(Long id) {
    return bioView.findById(id);
  }

  @Override
  public Page<BiodataView> getPagingView(Pageable pageable, String key) {
    return pagView.findViewByPaging(pageable, key);
  }

  @Override
  public List<BiodataView> searchDataByName(String name) {
    return bioView.findByFullNameContainingIgnoreCase(name);
  }

}