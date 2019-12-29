package com.cers.warning.wall.WallApi.dto;

import java.util.List;

public class WarningPageableDTO {
	
	private int page;
	private int size;
	private String sort;
	private String order;
	private int total;
	private List<WarningDTO> warnings;
	
	public int getPage() {
		return page;
	}
	public void setPage(int page) {
		this.page = page;
	}
	public int getSize() {
		return size;
	}
	public void setSize(int size) {
		this.size = size;
	}
	public String getSort() {
		return sort;
	}
	public void setSort(String sort) {
		this.sort = sort;
	}
	public String getOrder() {
		return order;
	}
	public void setOrder(String order) {
		this.order = order;
	}
	public int getTotal() {
		return total;
	}
	public void setTotal(int total) {
		this.total = total;
	}
	public List<WarningDTO> getWarnings() {
		return warnings;
	}
	public void setWarnings(List<WarningDTO> warnings) {
		this.warnings = warnings;
	}

}
