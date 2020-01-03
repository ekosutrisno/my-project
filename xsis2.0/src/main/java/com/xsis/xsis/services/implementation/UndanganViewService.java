package com.xsis.xsis.services.implementation;

import java.util.ArrayList;
import java.util.List;

import com.xsis.xsis.models.entity.UndanganView;
import com.xsis.xsis.repository.ViewRepository;
import com.xsis.xsis.services.IViewService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * UndanganViewService
 */
@Service
public class UndanganViewService implements IViewService {

    @Autowired
    private ViewRepository viewsRepo;

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
        return viewsRepo.searchUndanganbyName(name);
    }

}