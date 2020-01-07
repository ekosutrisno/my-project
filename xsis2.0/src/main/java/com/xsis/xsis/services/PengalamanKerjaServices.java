package com.xsis.xsis.services;

import java.util.List;

import com.xsis.xsis.dto.PeKerDto;

/**
 * PengalamanKerjaServices
 */
public interface PengalamanKerjaServices {

    List<PeKerDto> getPengalamanKerjaBiodata(Long biodataId);
    
}