package com.cers.warning.wall.WallApi.service;

import org.springframework.data.domain.Page;

import com.cers.warning.wall.WallApi.persistence.WarningEntity;

public interface IWarningService {
	
	public Page<WarningEntity> getAllWarningPaged(Integer pageNumber, Integer pageSize, String sortBy);

	public WarningEntity getWarning(Long id);
	
	public WarningEntity updateWarning(Long id, WarningEntity warning);

}
