package com.xsis.xsis.services.implementation;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Optional;

import com.xsis.xsis.models.entity.AddressEntity;
import com.xsis.xsis.repository.AddressRepository;
import com.xsis.xsis.services.IAddressService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * AddressService
 */
@Service
public class AddressService implements IAddressService {

    @Autowired
    private AddressRepository addressRepository;

    @Override
    public List<AddressEntity> getAll() {
        List<AddressEntity> addres = new ArrayList<>();
        for (AddressEntity address : addressRepository.findAll()) {
            if (!address.getIsDelete()) {
                addres.add(address);
            }
        }
        return addres;
    }

    @Override
    public List<AddressEntity> getAddressByBiodata(Long id) {
        return addressRepository.getAddressByBiodata(id);
    }

    @Override
    public AddressEntity save(AddressEntity addressEntity) {

        addressEntity.setCreatedBy(1L);
        addressEntity.setCreatedOn(new Date());
        return addressRepository.save(addressEntity);
    }

    @Override
    public Optional<AddressEntity> getById(Long id) {
        return addressRepository.findById(id);
    }

    @Override
    public AddressEntity update(AddressEntity addressEntity) {
        AddressEntity addressDetail = addressRepository.findById(addressEntity.getId()).get();

        addressDetail.setBiodataId(addressEntity.getBiodataId());
        addressDetail.setAddress1(addressEntity.getAddress1());
        addressDetail.setAddress2(addressEntity.getAddress2());
        addressDetail.setPostalCode1(addressEntity.getPostalCode1());
        addressDetail.setPostalCode2(addressEntity.getPostalCode2());
        addressDetail.setRt1(addressEntity.getRt1());
        addressDetail.setRt2(addressEntity.getRt2());
        addressDetail.setRw1(addressEntity.getRw1());
        addressDetail.setRw2(addressEntity.getRw2());
        addressDetail.setKelurahan1(addressEntity.getKelurahan1());
        addressDetail.setKelurahan2(addressEntity.getKelurahan2());
        addressDetail.setKecamatan1(addressEntity.getKecamatan1());
        addressDetail.setKecamatan2(addressEntity.getKecamatan2());
        addressDetail.setRegion1(addressEntity.getRegion1());
        addressDetail.setRegion2(addressEntity.getRegion2());

        addressDetail.setModifiedBy(1L);
        addressDetail.setModifiedOn(new Date());
        return addressRepository.save(addressDetail);
    }

    @Override
    public AddressEntity delete(Long id) {
        AddressEntity religion = addressRepository.findById(id).get();
        religion.setIsDelete(true);
        religion.setDeletedBy(1L);
        religion.setDeleteddOn(new Date());
        return addressRepository.save(religion);
    }

}