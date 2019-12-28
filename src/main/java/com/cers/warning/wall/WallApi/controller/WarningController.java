package com.cers.warning.wall.WallApi.controller;

import java.util.List;

import org.jboss.logging.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.cers.warning.wall.WallApi.WarningDTO;
import com.cers.warning.wall.WallApi.converter.WarningConverter;
import com.cers.warning.wall.WallApi.persistence.WarningEntity;
import com.cers.warning.wall.WallApi.service.IWarningService;

@RestController
@RequestMapping("/aviso")
public class WarningController {
	
	private static final Logger logger = Logger.getLogger(WarningController.class.getName());
	
	@Autowired
	private IWarningService warningService;
	
	@Autowired
	private WarningConverter converter;
	
	@RequestMapping(method = RequestMethod.GET)
	public ResponseEntity<List<WarningDTO>> listWarning(){
		logger.info("[WarningController.listWarning] Rest call to list warning.");
		List<WarningEntity> list = warningService.listWarning();
		return new ResponseEntity<>(
				converter.convertToDTO(list), HttpStatus.OK);
	}

}
