package com.xsis.xsis.restapi;

import java.util.List;
import java.util.Optional;

import com.xsis.xsis.dto.BiodataDto;
import com.xsis.xsis.models.entity.AddressEntity;
import com.xsis.xsis.models.entity.BiodataEntity;
import com.xsis.xsis.services.IAddressService;
import com.xsis.xsis.services.IBiodataService;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * BiodataAPI
 */
@RestController
@RequestMapping("/api/biodata")
@CrossOrigin(origins = "*")
public class BiodataAPI {

    @Autowired
    private IBiodataService biodataService;

    @Autowired
    private IAddressService addressService;

    @Autowired
    ModelMapper modelMapper;

    @GetMapping
    public List<BiodataEntity> getAll() {
        return biodataService.getAll();
    }

    @GetMapping("/{id}")
    public ResponseEntity<?> biodataById(@PathVariable("id") Long id) {
        Optional<BiodataEntity> optBio = biodataService.getById(id);

        if (optBio.isPresent()) {
            return new ResponseEntity<>(optBio.get(), HttpStatus.OK);
        }

        return new ResponseEntity<>(null, HttpStatus.NOT_FOUND);
    }

    @PostMapping
    public BiodataDto simpanBiodata(@RequestBody BiodataDto biodataDto) {
        BiodataEntity biodataMapDetail = modelMapper.map(biodataDto, BiodataEntity.class);
        AddressEntity addressMapDetail = modelMapper.map(biodataDto, AddressEntity.class);

        biodataMapDetail.setFullName(biodataDto.getFullName());
        biodataMapDetail.setNickName(biodataDto.getNickName());
        biodataMapDetail.setPob(biodataDto.getPob());
        biodataMapDetail.setDob(biodataDto.getDob());
        biodataMapDetail.setGender(biodataDto.getGender());
        biodataMapDetail.setHight(biodataDto.getHight());
        biodataMapDetail.setWeight(biodataDto.getWeight());
        biodataMapDetail.setNationality(biodataDto.getNationality());
        biodataMapDetail.setEthnic(biodataDto.getEthnic());
        biodataMapDetail.setHobby(biodataDto.getHobby());
        biodataMapDetail.setIdentityType(biodataDto.getIdentityType());
        biodataMapDetail.setEmail(biodataDto.getEmail());
        biodataMapDetail.setIdentityNo(biodataDto.getIdentityNo());
        biodataMapDetail.setPhoneNumber1(biodataDto.getPhoneNumber1());
        biodataMapDetail.setPhoneNumber2(biodataDto.getPhoneNumber2());
        biodataMapDetail.setParentPhoneNumber(biodataDto.getParentPhoneNumber());
        biodataMapDetail.setChildSequence(biodataDto.getChildSequence());
        biodataMapDetail.setHowManyBrothers(biodataDto.getHowManyBrothers());
        biodataMapDetail.setMaritalStatus(biodataDto.getMaritalStatus());
        biodataMapDetail.setAddrbookId(biodataDto.getAddrbookId());
        biodataMapDetail.setToken(biodataDto.getToken());
        biodataMapDetail.setExpiredToken(biodataDto.getExpiredToken());
        biodataMapDetail.setMarriageYear(biodataDto.getMarriageYear());
        biodataMapDetail.setCompanyId(biodataDto.getCompanyId());
        biodataMapDetail.setIsProcess(biodataDto.getIsProcess());
        biodataMapDetail.setIsComplete(biodataDto.getIsComplete());
        biodataMapDetail.setReligion(biodataDto.getReligion());

        addressMapDetail.setAddress1(biodataDto.getAddress1());
        addressMapDetail.setAddress2(biodataDto.getAddress2());
        addressMapDetail.setPostalCode1(biodataDto.getPostalCode1());
        addressMapDetail.setPostalCode2(biodataDto.getPostalCode2());
        addressMapDetail.setRt1(biodataDto.getRt1());
        addressMapDetail.setRt2(biodataDto.getRt2());
        addressMapDetail.setRw1(biodataDto.getRw1());
        addressMapDetail.setRw2(biodataDto.getRw2());
        addressMapDetail.setKelurahan1(biodataDto.getKelurahan1());
        addressMapDetail.setKelurahan2(biodataDto.getKelurahan2());
        addressMapDetail.setKecamatan1(biodataDto.getKecamatan1());
        addressMapDetail.setKecamatan2(biodataDto.getKecamatan2());
        addressMapDetail.setRegion1(biodataDto.getRegion1());
        addressMapDetail.setRegion2(biodataDto.getRegion2());
        addressMapDetail.setBiodataId(biodataMapDetail);

        biodataService.save(biodataMapDetail);
        addressService.save(addressMapDetail);
        return biodataDto;
    }

    @PutMapping
    public BiodataDto updateBiodata(@RequestBody BiodataDto biodataDto) {

        BiodataEntity biodataMapDetail = modelMapper.map(biodataDto, BiodataEntity.class);
        AddressEntity addressMapDetail = modelMapper.map(biodataDto, AddressEntity.class);

        biodataMapDetail.setId(biodataDto.getId());
        biodataMapDetail.setFullName(biodataDto.getFullName());
        biodataMapDetail.setNickName(biodataDto.getNickName());
        biodataMapDetail.setPob(biodataDto.getPob());
        biodataMapDetail.setDob(biodataDto.getDob());
        biodataMapDetail.setGender(biodataDto.getGender());
        biodataMapDetail.setHight(biodataDto.getHight());
        biodataMapDetail.setWeight(biodataDto.getWeight());
        biodataMapDetail.setNationality(biodataDto.getNationality());
        biodataMapDetail.setEthnic(biodataDto.getEthnic());
        biodataMapDetail.setHobby(biodataDto.getHobby());
        biodataMapDetail.setIdentityType(biodataDto.getIdentityType());
        biodataMapDetail.setEmail(biodataDto.getEmail());
        biodataMapDetail.setIdentityNo(biodataDto.getIdentityNo());
        biodataMapDetail.setPhoneNumber1(biodataDto.getPhoneNumber1());
        biodataMapDetail.setPhoneNumber2(biodataDto.getPhoneNumber2());
        biodataMapDetail.setParentPhoneNumber(biodataDto.getParentPhoneNumber());
        biodataMapDetail.setChildSequence(biodataDto.getChildSequence());
        biodataMapDetail.setHowManyBrothers(biodataDto.getHowManyBrothers());
        biodataMapDetail.setMaritalStatus(biodataDto.getMaritalStatus());
        biodataMapDetail.setAddrbookId(biodataDto.getAddrbookId());
        biodataMapDetail.setToken(biodataDto.getToken());
        biodataMapDetail.setExpiredToken(biodataDto.getExpiredToken());
        biodataMapDetail.setMarriageYear(biodataDto.getMarriageYear());
        biodataMapDetail.setCompanyId(biodataDto.getCompanyId());
        biodataMapDetail.setIsProcess(biodataDto.getIsProcess());
        biodataMapDetail.setIsComplete(biodataDto.getIsComplete());
        biodataMapDetail.setReligion(biodataDto.getReligion());

        addressMapDetail.setAddress1(biodataDto.getAddress1());
        addressMapDetail.setAddress2(biodataDto.getAddress2());
        addressMapDetail.setPostalCode1(biodataDto.getPostalCode1());
        addressMapDetail.setPostalCode2(biodataDto.getPostalCode2());
        addressMapDetail.setRt1(biodataDto.getRt1());
        addressMapDetail.setRt2(biodataDto.getRt2());
        addressMapDetail.setRw1(biodataDto.getRw1());
        addressMapDetail.setRw2(biodataDto.getRw2());
        addressMapDetail.setKelurahan1(biodataDto.getKelurahan1());
        addressMapDetail.setKelurahan2(biodataDto.getKelurahan2());
        addressMapDetail.setKecamatan1(biodataDto.getKecamatan1());
        addressMapDetail.setKecamatan2(biodataDto.getKecamatan2());
        addressMapDetail.setRegion1(biodataDto.getRegion1());
        addressMapDetail.setRegion2(biodataDto.getRegion2());
        addressMapDetail.setBiodataId(biodataMapDetail);
        addressMapDetail.setId(biodataDto.getIdA());

        biodataService.update(biodataMapDetail);
        addressService.update(addressMapDetail);
        return biodataDto;
    }

    @DeleteMapping("/{id}")
    public BiodataEntity deleteBiodata(@PathVariable(value = "id") Long id) {
        return biodataService.delete(id);
    }

}