package com.xsis.xsis.restapi;

import java.util.List;
import java.util.Optional;

import com.xsis.xsis.models.entity.BiodataView;
import com.xsis.xsis.services.IBiodataViewService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 * ViewBiodataAPI
 */
@RestController
@CrossOrigin(origins = "*")
@RequestMapping(path = "api/view-biodata", produces = "application/json")
public class ViewBiodataAPI {

  @Autowired
  private IBiodataViewService viewService;

  @GetMapping
  public Page<BiodataView> findByPaging(Pageable pageable, @RequestParam(name = "key", defaultValue = "") String key) {
    return viewService.getPagingView(pageable, key);
  }

  @GetMapping("/{id}")
  public ResponseEntity<?> getViewById(@PathVariable("id") Long id) {
    Optional<BiodataView> optReg = viewService.getById(id);
    if (optReg.isPresent()) {
      return new ResponseEntity<>(optReg.get(), HttpStatus.OK);
    }
    return new ResponseEntity<>(null, HttpStatus.NOT_FOUND);
  }

  @GetMapping("/search")
  public List<BiodataView> cariDetailUndangan(@RequestParam(name = "name") String name) {
    return viewService.searchDataByName(name);
  }
}