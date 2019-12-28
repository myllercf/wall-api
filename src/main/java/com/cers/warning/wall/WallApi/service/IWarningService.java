package com.cers.warning.wall.WallApi.service;

import java.util.List;

import com.cers.warning.wall.WallApi.persistence.WarningEntity;

public interface IWarningService {
	
	public List<WarningEntity> listWarning();

}
