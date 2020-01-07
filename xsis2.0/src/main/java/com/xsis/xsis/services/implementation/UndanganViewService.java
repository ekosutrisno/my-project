package com.xsis.xsis.services.implementation;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import com.xsis.xsis.models.entity.UndanganView;
import com.xsis.xsis.repository.PagingViewDetail;
import com.xsis.xsis.repository.ViewRepository;
import com.xsis.xsis.services.IViewService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

/**
 * UndanganViewService
 */
@Service
public class UndanganViewService implements IViewService {

    @Autowired
    private ViewRepository viewsRepo;

    @Autowired
    private PagingViewDetail viewPaging;

    @Override
    public List<UndanganView> getAll() {
        List<UndanganView> view = new ArrayList<>();
        for (UndanganView views : viewsRepo.findAll()) {
            view.add(views);
        }
        return view;
    }

    @Override
    public List<UndanganView> searchDataByName(String name) {
        return viewsRepo.findByFullNameContainingIgnoreCase(name);
    }

    @Override
    public Optional<UndanganView> getById(Long id) {
        return viewsRepo.findById(id);
    }

    @Override
    public Page<UndanganView> getPagingView(Pageable pageable, String key) {
        return viewPaging.findViewByPaging(pageable, key);
    }

}