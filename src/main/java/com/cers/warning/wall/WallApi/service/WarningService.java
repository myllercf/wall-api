package com.cers.warning.wall.WallApi.service;

import java.util.Date;
import java.util.Optional;

import org.jboss.logging.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import com.cers.warning.wall.WallApi.exception.BusinessException;
import com.cers.warning.wall.WallApi.exception.EntityNotFoundException;
import com.cers.warning.wall.WallApi.exception.MissingInformationException;
import com.cers.warning.wall.WallApi.persistence.WarningEntity;
import com.cers.warning.wall.WallApi.persistence.WarningRepository;
import com.cers.warning.wall.WallApi.util.Util;

@Service
public class WarningService implements IWarningService{

	private static final Logger logger = Logger.getLogger(WarningService.class.getName());

	@Autowired
	private WarningRepository warningRepository;

	@Override
	public Page<WarningEntity> getAllWarningPaged(Integer pageNumber, Integer pageSize, String sortBy) {
		logger.infof("[WarningService.getAllWarningPaged] Get all list of warning by page number: {}, page size: {}, sort: {}."
				, pageNumber, pageSize, sortBy);

		Pageable paging = PageRequest.of(pageNumber, pageSize, Sort.by(sortBy).ascending());
		Page<WarningEntity> pagedResult = warningRepository.findAll(paging);

		return pagedResult;
	}

	@Override
	public WarningEntity getWarning(Long id) {
		logger.infof("[WarningService.getWarning] Get warning by id: {}.", id);

		WarningEntity warning = convertOptionalToEntity(
				warningRepository.findById(id));

		markVisualizedWarning(id, warning);
		return warning;
	}

	@Override
	public WarningEntity updateWarning(Long id, WarningEntity newWarning) {
		logger.infof("[WarningService.updateWarning] Update the Warning of id: {} with the object: {}.", id, newWarning);

		WarningEntity recovered = convertOptionalToEntity(
				warningRepository.findById(id));		
		newWarning.setId(recovered.getId());		
		return warningRepository.save(newWarning);
	}
	
	@Override
	public WarningEntity createWarning(WarningEntity warning) {
		logger.infof("[WarningService.createWarning] Create a new Warning with the object: {}.", warning);		
		validateNewWarning(warning);		
		return warningRepository.save(warning);
	}
	
	@Override
	public void deleteWarning(Long id) {
		logger.infof("[WarningService.deleteWarning] Delete a Warning by id: {}.", id);
		try {
			warningRepository.deleteById(id);
		}catch(Exception e){
			throw new BusinessException("Warning deletion failed.", e);
		}
	}

	private WarningEntity convertOptionalToEntity(Optional<WarningEntity> warningOptional) {
		logger.infof("[WarningService.convertOptionalToEntity] Convert an optional object: {} into entity."
				, warningOptional);

		if(!warningOptional.isPresent()) {
			throw new EntityNotFoundException("The Warning was not found.");
		}
		return warningOptional.get();
	}
	
	private void markVisualizedWarning(Long id, WarningEntity warning) {
		logger.infof("[WarningService.markVisualizedWarning] Marking Warning as viewed.", id);
		warning.setViewDate(new Date());
		this.updateWarning(id, warning);
	}
	
	private void validateNewWarning(WarningEntity warning) {
		logger.infof("[WarningService.validateNewWarning] Validate with new Warning has required informations .", warning);
		if(warning == null 
				|| Util.stringIsNullOrEmpty(warning.getTitle())
				|| warning.getDescription().isEmpty()) {
			throw new MissingInformationException("Some information are required.");
		}
	}

}
