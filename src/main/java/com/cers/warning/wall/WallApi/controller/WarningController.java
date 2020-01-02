package com.cers.warning.wall.WallApi.controller;

import java.util.List;

import javax.validation.Valid;

import org.jboss.logging.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
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
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.cers.warning.wall.WallApi.converter.WarningConverter;
import com.cers.warning.wall.WallApi.dto.WarningDTO;
import com.cers.warning.wall.WallApi.dto.WarningPageableDTO;
import com.cers.warning.wall.WallApi.persistence.WarningEntity;
import com.cers.warning.wall.WallApi.service.IWarningService;

@CrossOrigin(origins = "*")
@RestController
@RequestMapping("/aviso")
public class WarningController {
	
	private static final Logger logger = Logger.getLogger(WarningController.class.getName());
	
	@Autowired
	private IWarningService warningService;
	
	@Autowired
	private WarningConverter converter;
	
	@RequestMapping(method = RequestMethod.GET)
	public ResponseEntity<List<WarningPageableDTO>> getAllWarningPaged(
			@RequestParam(defaultValue = "0") Integer pageNumber, 
            @RequestParam(defaultValue = "10") Integer pageSize,
            @RequestParam(defaultValue = "id") String sortBy){
		logger.info("[WarningController.getAllWarningPaged] Rest call to list warning.");
		
		Page<WarningEntity> list = warningService.getAllWarningPaged(pageNumber, pageSize, sortBy);
		return new ResponseEntity<>(
				converter.convertToPageableDTO(list), HttpStatus.OK);
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<WarningDTO> getWarning(
			@PathVariable(value = "id") Long id){
		logger.infof("[WarningController.getWarning] Rest call to get warning by id: {}.", id);
		
		WarningEntity entity = warningService.getWarning(id);
		return new ResponseEntity<>(
				converter.convertToDTO(entity), HttpStatus.OK);
	}
	
	@PutMapping("/{id}")
	public ResponseEntity<WarningDTO> updateWarning(
			@PathVariable(value = "id") Long id
			, @Valid @RequestBody WarningDTO dto){
		logger.infof("[WarningController.updateWarning] Rest call to update warning by id: {}.", id);
		
		WarningEntity entity = warningService.updateWarning(
				id, converter.convertToEntity(dto));
		
		return new ResponseEntity<>(
				converter.convertToDTO(entity), HttpStatus.OK);
	}
	
	@PostMapping
	public ResponseEntity<WarningDTO> createWarning(
			@Valid @RequestBody WarningDTO dto) {
		logger.infof("[Controller.createWarning] - Rest call to create warning with the object: {}.", dto);
		
		WarningEntity entity = warningService.createWarning(
				converter.convertToEntity(dto));
		
		return new ResponseEntity<>(
				converter.convertToDTO(entity), HttpStatus.CREATED);
	}
	
	@DeleteMapping("/{id}")
	public ResponseEntity<String> deleteWarning(
			@PathVariable(value = "id") Long id){
		logger.infof("[Controller.deleteWarning] - Rest call to delete warning by id: {}.", id);
		warningService.deleteWarning(id);
		return new ResponseEntity<>("Warning deleted.", HttpStatus.NO_CONTENT);
	}
	
}
