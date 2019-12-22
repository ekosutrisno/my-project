package com.xsis.xsis.restapi;

import java.util.List;
import java.util.Optional;

import com.xsis.xsis.dto.AddressDto;
import com.xsis.xsis.models.entity.AddressEntity;
import com.xsis.xsis.services.IAddressService;

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
 * AddressAPI
 */
@RestController
@RequestMapping("api/address")
@CrossOrigin(origins = "*")
public class AddressAPI {
    @Autowired
    private IAddressService addressService;

    @Autowired
    ModelMapper modelMapper;

    @GetMapping
    public List<AddressEntity> getAll() {
        return addressService.getAll();
    }

    @GetMapping("/bio/{biodataid}")
    public ResponseEntity<?> biodataByBio(@PathVariable("biodataid") Long id) {
        return new ResponseEntity<>(addressService.getAddressByBiodata(id), HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<?> addressById(@PathVariable("id") Long id) {
        Optional<AddressEntity> optAdd = addressService.getById(id);
        if (optAdd.isPresent()) {
            return new ResponseEntity<>(optAdd.get(), HttpStatus.OK);
        }

        return new ResponseEntity<>(null, HttpStatus.NOT_FOUND);
    }

    @PostMapping
    public AddressDto simpanAddress(@RequestBody AddressDto addressDto) {

        AddressEntity addressMapDetail = modelMapper.map(addressDto, AddressEntity.class);

        addressMapDetail.setBiodataId(addressDto.getBiodataId());
        addressMapDetail.setAddress1(addressDto.getAddress1());
        addressMapDetail.setAddress2(addressDto.getAddress2());
        addressMapDetail.setPostalCode1(addressDto.getPostalCode1());
        addressMapDetail.setPostalCode2(addressDto.getPostalCode2());
        addressMapDetail.setRt1(addressDto.getRt1());
        addressMapDetail.setRt2(addressDto.getRt2());
        addressMapDetail.setRw1(addressDto.getRw1());
        addressMapDetail.setRw2(addressDto.getRw2());
        addressMapDetail.setKelurahan1(addressDto.getKelurahan1());
        addressMapDetail.setKelurahan2(addressDto.getKelurahan2());
        addressMapDetail.setKecamatan1(addressDto.getKecamatan1());
        addressMapDetail.setKecamatan2(addressDto.getKecamatan2());
        addressMapDetail.setRegion1(addressDto.getRegion1());
        addressMapDetail.setRegion2(addressDto.getRegion2());

        addressService.save(addressMapDetail);
        return addressDto;
    }

    @PutMapping
    public AddressDto updateAddress(@RequestBody AddressDto addressDto) {

        AddressEntity addressMapDetail = modelMapper.map(addressDto, AddressEntity.class);

        addressMapDetail.setId(addressDto.getId());
        addressMapDetail.setBiodataId(addressDto.getBiodataId());
        addressMapDetail.setAddress1(addressDto.getAddress1());
        addressMapDetail.setAddress2(addressDto.getAddress2());
        addressMapDetail.setPostalCode1(addressDto.getPostalCode1());
        addressMapDetail.setPostalCode2(addressDto.getPostalCode2());
        addressMapDetail.setRt1(addressDto.getRt1());
        addressMapDetail.setRt2(addressDto.getRt2());
        addressMapDetail.setRw1(addressDto.getRw1());
        addressMapDetail.setRw2(addressDto.getRw2());
        addressMapDetail.setKelurahan1(addressDto.getKelurahan1());
        addressMapDetail.setKelurahan2(addressDto.getKelurahan2());
        addressMapDetail.setKecamatan1(addressDto.getKecamatan1());
        addressMapDetail.setKecamatan2(addressDto.getKecamatan2());
        addressMapDetail.setRegion1(addressDto.getRegion1());
        addressMapDetail.setRegion2(addressDto.getRegion2());

        addressService.update(addressMapDetail);
        return addressDto;
    }

    @DeleteMapping("/{id}")
    public AddressEntity deleteAddress(@PathVariable(value = "id") Long id) {
        return addressService.delete(id);
    }

}