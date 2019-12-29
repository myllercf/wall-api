package com.cers.warning.wall.WallApi.converter;

import java.util.ArrayList;
import java.util.List;

import org.jboss.logging.Logger;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Component;

import com.cers.warning.wall.WallApi.dto.WarningDTO;
import com.cers.warning.wall.WallApi.dto.WarningPageableDTO;
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

	public List<WarningPageableDTO> convertToPageableDTO(Page<WarningEntity> pagedResult){
		logger.infof("[WarningConverter.convertToPageableDTO] Convert a list of paged entity object to paged dto. {}"
				, pagedResult);

		List<WarningPageableDTO> pagedDTOList = new ArrayList<>();

		if(pagedResult == null 
				|| pagedResult.getContent().isEmpty()) {
			return pagedDTOList;
		}

		WarningPageableDTO pagedDTO = new WarningPageableDTO();
		pagedDTO.setPage(pagedResult.getPageable().getPageNumber());
		pagedDTO.setSize(pagedResult.getPageable().getPageSize());
		//			pagedDTO.setSort(pagedResult.getSort().get);
		//			pagedDTO.setOrder(order);
		pagedDTO.setTotal(pagedResult.getTotalPages());
		pagedDTO.setWarnings(
				this.convertToDTO(pagedResult.getContent()));			
		pagedDTOList.add(pagedDTO);

		return pagedDTOList;
	}
	
	public WarningEntity convertToEntity(WarningDTO dto) {
		logger.infof("[WarningConverter.convertToDTO] Convert dto object to entity. {}", dto);		
		WarningEntity entity = new WarningEntity();
		entity.setTitle(dto.getTitle());
		entity.setDescription(dto.getDescription());
		entity.setPublishDate(dto.getPublishDate());
		entity.setViewDate(dto.getViewDate());
		return entity;
	}

}
