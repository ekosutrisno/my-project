package com.xsis.xsis.services;

import java.util.List;

import com.xsis.xsis.model.entity.PengalamanKerja;

/**
 * PengalamanKerjaService
 */
public interface PengalamanKerjaService {

    List<PengalamanKerja> getAll();

    PengalamanKerja getById(Long id);

    PengalamanKerja save(PengalamanKerja pengalamanKerja);

    PengalamanKerja update(PengalamanKerja pengalamanKerja);

    PengalamanKerja delete(Long id);

}