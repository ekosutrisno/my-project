package com.xsis.xsis.restapi;

import java.util.List;

import com.xsis.xsis.dto.PengalamanKerjaDto;
import com.xsis.xsis.model.entity.PengalamanKerja;
import com.xsis.xsis.services.PengalamanKerjaService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/pengalaman-kerja")
public class PengalamanKerjaAPI {
    @Autowired
    private PengalamanKerjaService pengalamanKerjaService;

    @GetMapping
    public List<PengalamanKerja> getId() {
        return pengalamanKerjaService.getAll();
    }

    @GetMapping("/{id}")
    public PengalamanKerja getPengalamanId(@PathVariable(value = "id") Long id) {
        return pengalamanKerjaService.getById(id);
    }

    @PostMapping
    public PengalamanKerjaDto simpan(@RequestBody PengalamanKerjaDto kerjaDto) {
        PengalamanKerja pengalaman = new PengalamanKerja();
        pengalaman.setModifiedBy(1L);
        pengalaman.setBiodataId(kerjaDto.getBiodataId());
        pengalaman.setCompanyName(kerjaDto.getCompanyName());
        pengalaman.setCity(kerjaDto.getCity());
        pengalaman.setCountry(kerjaDto.getCountry());
        pengalaman.setJoinYear(kerjaDto.getJoinYear());
        pengalaman.setJoinMonth(kerjaDto.getJoinMonth());
        pengalaman.setResignYear(kerjaDto.getResignYear());
        pengalaman.setResignMonth(kerjaDto.getResignMonth());
        pengalaman.setLastPosition(kerjaDto.getLastPosition());
        pengalaman.setIncome(kerjaDto.getIncome());
        pengalaman.setIsItRelated(kerjaDto.isIsItRelated());
        pengalaman.setAboutJob(kerjaDto.getAboutJob());
        pengalaman.setExitReason(kerjaDto.getExitReason());
        pengalaman.setAboutJob(kerjaDto.getAboutJob());
        pengalaman.setNotes(kerjaDto.getNotes());
        pengalamanKerjaService.save(pengalaman);
        return kerjaDto;
    }

    // @PutMapping
    // public PengalamanKerja editCategory(@RequestBody epk categoryDto) {
    // PengalamanKerja category = new CategoryEntity();
    // category.setId(categoryDto.getId());
    // category.setName(categoryDto.getName());
    // pengalamanKerjaService.update(category);
    // return categoryDto;
    // }

    // @DeleteMapping("/{id}")
    // public CategoryEntity deleteCategory(@PathVariable(value = "id") Integer id)
    // {
    // return pengalamanKerjaService.delete(id);
    // }

}