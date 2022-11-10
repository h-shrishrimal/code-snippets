package com.tcs.rmg.data;

import java.util.List;

public class TotalRequirementDataResponse {
	
	private List<?> totalReqData;
	private Integer totalPages;
	private long totalCount;
	
	public List<?> getTotalReqData() {
		return totalReqData;
	}
	public void setTotalReqData(List<?> totalReqData) {
		this.totalReqData = totalReqData;
	}
	public Integer getTotalPages() {
		return totalPages;
	}
	public void setTotalPages(Integer totalPages) {
		this.totalPages = totalPages;
	}
	public long getTotalCount() {
		return totalCount;
	}
	public void setTotalCount(long totalCount) {
		this.totalCount = totalCount;
	}
	
	
}
