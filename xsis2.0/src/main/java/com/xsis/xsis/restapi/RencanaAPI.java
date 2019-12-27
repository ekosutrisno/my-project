package com.xsis.xsis.restapi;

import java.util.List;
import java.util.Optional;

import com.xsis.xsis.dto.RencanaDto;
import com.xsis.xsis.models.entity.RencanaEntity;
import com.xsis.xsis.services.IRencanaService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
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
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 * RencanaAPI
 */
@RestController
@CrossOrigin(origins = "*")
@RequestMapping(path = "/api/rencana", produces = "application/json")
public class RencanaAPI {

	@Autowired
	private IRencanaService rencanaService;

	@GetMapping
	public List<RencanaEntity> getAll() {
		return rencanaService.getAll();
	}

	@GetMapping("/asc")
	public List<RencanaEntity> getAllAscending() {
		return rencanaService.getAscending();
	}

	@GetMapping("/desc")
	public List<RencanaEntity> getAllDescending() {
		return rencanaService.getDescending();
	}

	@GetMapping("/search")
	public List<RencanaEntity> getSearch(@RequestParam(name = "tgl_mulai") String tgl_mulai,
			@RequestParam(name = "tgl_sampai") String tgl_sampai) {
		return rencanaService.searchData(tgl_mulai, tgl_sampai);
	}

	@GetMapping("/paging")
	public Page<RencanaEntity> findByPaging(Pageable pageable,
			@RequestParam(name = "key", defaultValue = "") String key) {
		return rencanaService.findByPaging(pageable, key);
	}

	@GetMapping("/{id}")
	public ResponseEntity<?> biodataById(@PathVariable("id") Long id) {
		Optional<RencanaEntity> optReg = rencanaService.getById(id);
		if (optReg.isPresent()) {
			return new ResponseEntity<>(optReg.get(), HttpStatus.OK);
		}
		return new ResponseEntity<>(null, HttpStatus.NOT_FOUND);
	}

	@PostMapping
	public RencanaDto simpanRencana(@RequestBody RencanaDto rencanaDto) {

		RencanaEntity rencanaDetail = new RencanaEntity();

		rencanaDetail.setScheduleCode(rencanaDto.getScheduleCode());
		rencanaDetail.setScheduleDate(rencanaDto.getScheduleDate());
		rencanaDetail.setTime(rencanaDto.getTime());
		rencanaDetail.setTime(rencanaDto.getTime());
		rencanaDetail.setRo(rencanaDto.getRo());
		rencanaDetail.setTro(rencanaDto.getTro());
		rencanaDetail.setScheduleTypeId(rencanaDto.getScheduleTypeId());
		rencanaDetail.setLocation(rencanaDto.getLocation());
		rencanaDetail.setOtherRoTro(rencanaDto.getOtherRoTro());
		rencanaDetail.setNotes(rencanaDto.getNotes());
		rencanaDetail.setSentDate(rencanaDto.getSentDate());
		rencanaDetail.setAutomaticMail(false);

		rencanaService.save(rencanaDetail);
		return rencanaDto;
	}

	@PutMapping
	public RencanaDto updateRencana(@RequestBody RencanaDto rencanaDto) {

		RencanaEntity rencanaDetail = new RencanaEntity();
		rencanaDetail.setId(rencanaDto.getId());
		rencanaDetail.setScheduleCode(rencanaDto.getScheduleCode());
		rencanaDetail.setScheduleDate(rencanaDto.getScheduleDate());
		rencanaDetail.setTime(rencanaDto.getTime());
		rencanaDetail.setTime(rencanaDto.getTime());
		rencanaDetail.setRo(rencanaDto.getRo());
		rencanaDetail.setTro(rencanaDto.getTro());
		rencanaDetail.setScheduleTypeId(rencanaDto.getScheduleTypeId());
		rencanaDetail.setLocation(rencanaDto.getLocation());
		rencanaDetail.setOtherRoTro(rencanaDto.getOtherRoTro());
		rencanaDetail.setNotes(rencanaDto.getNotes());
		rencanaDetail.setSentDate(rencanaDto.getSentDate());

		rencanaDetail.setAutomaticMail(false);

		rencanaService.update(rencanaDetail);
		return rencanaDto;
	}

	@DeleteMapping("/{id}")
	public RencanaEntity deleteRencana(@PathVariable(value = "id") Long id) {
		return rencanaService.delete(id);
	}
}