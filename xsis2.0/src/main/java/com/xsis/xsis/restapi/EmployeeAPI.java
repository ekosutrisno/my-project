package com.xsis.xsis.restapi;

import java.util.List;
import java.util.Optional;

import com.xsis.xsis.dto.EmployeeDto;
import com.xsis.xsis.models.entity.EmployeeEntity;
import com.xsis.xsis.services.IEmployeeService;

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
 * EmployeeAPI
 */
@RestController
@RequestMapping(path = "/api/employee", produces = "application/json")
@CrossOrigin(origins = "*")
public class EmployeeAPI {
  @Autowired
  private IEmployeeService employeeService;

  @GetMapping
  public List<EmployeeEntity> getAll() {
    return employeeService.getAll();
  }

  @GetMapping("/erotrue")
  public List<EmployeeEntity> getEmployeeByEro() {
    return employeeService.getRoAndTroByEro();
  }

  @GetMapping("/erotrue/{bioId}")
  public List<EmployeeEntity> getEmployeeByEroId(@PathVariable("bioId") Long id) {
    return employeeService.getTruId(id);
  }

  @GetMapping("/{id}")
  public ResponseEntity<?> getEmployeeById(@PathVariable("id") Long id) {
    Optional<EmployeeEntity> optReg = employeeService.getById(id);
    if (optReg.isPresent()) {
      return new ResponseEntity<>(optReg.get(), HttpStatus.OK);
    }

    return new ResponseEntity<>(null, HttpStatus.NOT_FOUND);
  }

  @GetMapping("/empl/{biodataid}")
  public ResponseEntity<?> getEmployeeByBio(@PathVariable("biodataid") Long id) {
    return new ResponseEntity<>(employeeService.getRoAndTroByBiodataId(id), HttpStatus.OK);
  }

  @PostMapping
  public EmployeeDto simpanEmployee(@RequestBody EmployeeDto employeeDto) {

    EmployeeEntity employeeDetail = new EmployeeEntity();
    employeeDetail.setBiodataId(employeeDto.getBiodataId());
    employeeDetail.setIdle(false);
    employeeDetail.setEro(false);
    employeeDetail.setUserClient(false);
    employeeDetail.setEroEmail(employeeDto.getEroEmail());

    employeeService.save(employeeDetail);
    return employeeDto;
  }

  @PutMapping
  public EmployeeDto updateEmployee(@RequestBody EmployeeDto employeeDto) {

    EmployeeEntity employeeDetail = new EmployeeEntity();
    employeeDetail.setId(employeeDto.getId());
    employeeDetail.setBiodataId(employeeDto.getBiodataId());
    employeeDetail.setIdle(false);
    employeeDetail.setEro(false);
    employeeDetail.setUserClient(false);
    employeeDetail.setEroEmail(employeeDto.getEroEmail());

    employeeService.update(employeeDetail);
    return employeeDto;
  }

  @DeleteMapping("/{id}")
  public EmployeeEntity deleteEmployee(@PathVariable(value = "id") Long id) {
    return employeeService.delete(id);
  }

}