package com.xsis.xsis.services.implementation;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Optional;

import javax.transaction.Transactional;

import com.xsis.xsis.models.entity.AddressEntity;
import com.xsis.xsis.models.entity.BiodataEntity;
import com.xsis.xsis.repository.BiodataRepository;
import com.xsis.xsis.services.IBiodataService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * BiodataService
 */
@Service
@Transactional
public class BiodataService implements IBiodataService {

    @Autowired
    private BiodataRepository biodataRepository;

    @Override
    public List<BiodataEntity> getAll() {
        List<BiodataEntity> biodata = new ArrayList<>();
        for (BiodataEntity biodatas : biodataRepository.findAll()) {
            if (!biodatas.getIsDelete()) {
                biodata.add(biodatas);
            }
        }
        return biodata;
    }

    @Override
    public List<BiodataEntity> getBiodataByReligion(Long id) {
        return biodataRepository.getBiodataByReligion(id);
    }

    @Override
    public List<BiodataEntity> getBiodataByMarital(Long id) {
        return biodataRepository.getBiodataByMarital(id);
    }

    @Override
    public List<BiodataEntity> getBiodataByIdentity(Long id) {
        return biodataRepository.getBiodataByIdentity(id);
    }

    @Override
    public List<AddressEntity> getAddressByBiodata(Long id) {
        return biodataRepository.getAddressByBiodata(id);
    }

    @Override
    public BiodataEntity save(BiodataEntity biodataEntity) {
        biodataEntity.setCreatedBy(1L);
        biodataEntity.setCreatedOn(new Date());
        return biodataRepository.save(biodataEntity);
    }

    @Override
    public Optional<BiodataEntity> getById(Long id) {
        return biodataRepository.findById(id);
    }

    @Override
    public BiodataEntity update(BiodataEntity biodata) {

        BiodataEntity biodataDetail = new BiodataEntity();

        biodataDetail.setId(biodata.getId());
        biodataDetail.setFullName(biodata.getFullName());
        biodataDetail.setNickName(biodata.getNickName());
        biodataDetail.setPob(biodata.getPob());
        biodataDetail.setDob(biodata.getDob());
        biodataDetail.setGender(biodata.getGender());
        biodataDetail.setHight(biodata.getHight());
        biodataDetail.setWeight(biodata.getWeight());
        biodataDetail.setNationality(biodata.getNationality());
        biodataDetail.setEthnic(biodata.getEthnic());
        biodataDetail.setHobby(biodata.getHobby());
        biodataDetail.setIdentityType(biodata.getIdentityType());
        biodataDetail.setEmail(biodata.getEmail());
        biodataDetail.setIdentityNo(biodata.getIdentityNo());
        biodataDetail.setPhoneNumber1(biodata.getPhoneNumber1());
        biodataDetail.setPhoneNumber2(biodata.getPhoneNumber2());
        biodataDetail.setParentPhoneNumber(biodata.getParentPhoneNumber());
        biodataDetail.setChildSequence(biodata.getChildSequence());
        biodataDetail.setHowManyBrothers(biodata.getHowManyBrothers());
        biodataDetail.setMaritalStatus(biodata.getMaritalStatus());
        biodataDetail.setAddrbookId(biodata.getAddrbookId());
        biodataDetail.setToken(biodata.getToken());
        biodataDetail.setExpiredToken(biodata.getExpiredToken());
        biodataDetail.setMarriageYear(biodata.getMarriageYear());
        biodataDetail.setCompanyId(biodata.getCompanyId());
        biodataDetail.setIsProcess(biodata.getIsProcess());
        biodataDetail.setIsComplete(biodata.getIsComplete());
        biodataDetail.setReligion(biodata.getReligion());

        biodataDetail.setModifiedBy(1L);
        biodataDetail.setModifiedOn(new Date());
        biodataDetail.setCreatedBy(1L);
        biodataDetail.setCreatedOn(new Date());
        return biodataRepository.save(biodataDetail);
    }

    @Override
    public BiodataEntity delete(Long id) {
        BiodataEntity biodata = biodataRepository.findById(id).get();
        biodata.setIsDelete(true);
        biodata.setDeletedBy(1L);
        biodata.setDeleteddOn(new Date());
        return biodataRepository.save(biodata);
    }
}