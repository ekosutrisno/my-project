package com.xsis.xsis.services;

import java.util.List;

import com.xsis.xsis.dto.KeahDto;

/**
 * KeahlianService
 */
public interface KeahlianService {

    List<KeahDto> getKeahlianBiodata(Long biodataId);
    
}