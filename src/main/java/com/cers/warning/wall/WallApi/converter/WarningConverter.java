package com.cers.warning.wall.WallApi.converter;

import java.util.ArrayList;
import java.util.List;

import org.jboss.logging.Logger;
import org.springframework.stereotype.Component;

import com.cers.warning.wall.WallApi.WarningDTO;
import com.cers.warning.wall.WallApi.persistence.WarningEntity;

@Component
public class WarningConverter {
	
	private static final Logger logger = Logger.getLogger(WarningConverter.class.getName());
	
	public WarningDTO convertToDTO(WarningEntity entity) {
		logger.infof("[WarningConverter.convertToDTO] Convert entity object to dto. {}", entity);
		WarningDTO dto = new WarningDTO();
		dto.setId(entity.getId());
		dto.setTitle(entity.getTitle());
		dto.setDescription(entity.getDescription());
		dto.setPublishDate(entity.getPublishDate());
		dto.setViewDate(entity.getViewDate());
		return dto;
	}
	
	public List<WarningDTO> convertToDTO(List<WarningEntity> entityList){
		logger.infof("[WarningConverter.convertToDTO] Convert a list of entity object to dto. {}", entityList);
		List<WarningDTO> dtoList = new ArrayList<>();
		
		for(WarningEntity entity: entityList) {
			dtoList.add(this.convertToDTO(entity));
		}
		return dtoList;
	}

}
