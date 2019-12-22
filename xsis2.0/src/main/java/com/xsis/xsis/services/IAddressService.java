package com.xsis.xsis.services;

import java.util.List;
import java.util.Optional;

import com.xsis.xsis.models.entity.AddressEntity;

/**
 * IAddressService
 */
public interface IAddressService {

    List<AddressEntity> getAll();

    List<AddressEntity> getAddressByBiodata(Long id);

    AddressEntity save(AddressEntity addressEntity);

    Optional<AddressEntity> getById(Long id);

    AddressEntity update(AddressEntity addressEntity);

    AddressEntity delete(Long id);
}