package com.cers.warning.wall.WallApi.service;

import java.util.List;

import org.jboss.logging.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cers.warning.wall.WallApi.persistence.WarningEntity;
import com.cers.warning.wall.WallApi.persistence.WarningRepository;

@Service
public class WarningService implements IWarningService{
	
	private static final Logger logger = Logger.getLogger(WarningService.class.getName());
	
	@Autowired
	private WarningRepository warningRepository;

	@Override
	public List<WarningEntity> listWarning() {
		logger.info("[WarningService.listWarning] Get list of warning.");
		return warningRepository.findAll();
	}

}
