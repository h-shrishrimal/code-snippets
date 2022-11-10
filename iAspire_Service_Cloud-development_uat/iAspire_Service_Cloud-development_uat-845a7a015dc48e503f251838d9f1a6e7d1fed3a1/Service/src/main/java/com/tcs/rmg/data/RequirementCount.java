package com.tcs.rmg.data;

public class RequirementCount {
	
	
	Integer totalOpenPositions;
	Integer openPositionsInBusinessUnit;
	Integer appliedPositions;
	Integer pendingApprovals;
	Integer recentOpenRequirements;
	//Integer recentOpenRequirements;
	Integer totalOpenDigitalPosition;
	
	
	public RequirementCount() {
        //default Constructor
	}

	public RequirementCount(Integer totalOpenPositions, Integer openPositionsInBusinessUnit, Integer appliedPositions, Integer pendingApprovals, Integer recentOpenRequirements, Integer totalOpenDigitalPosition) {
		this.totalOpenPositions = totalOpenPositions;
		this.openPositionsInBusinessUnit = openPositionsInBusinessUnit;
		this.appliedPositions = appliedPositions;
		this.pendingApprovals = pendingApprovals;
		this.recentOpenRequirements = recentOpenRequirements;
		this.totalOpenDigitalPosition = totalOpenDigitalPosition;
	}

	public Integer getTotalOpenPositions() {
		return totalOpenPositions;
	}

	public void setTotalOpenPositions(Integer totalOpenPositions) {
		this.totalOpenPositions = totalOpenPositions;
	}

	public Integer getOpenPositionsInBusinessUnit() {
		return openPositionsInBusinessUnit;
	}

	public void setOpenPositionsInBusinessUnit(Integer openPositionsInBusinessUnit) {
		this.openPositionsInBusinessUnit = openPositionsInBusinessUnit;
	}

	public Integer getAppliedPositions() {
		return appliedPositions;
	}

	public void setAppliedPositions(Integer appliedPositions) {
		this.appliedPositions = appliedPositions;
	}

	public Integer getPendingApprovals() {
		return pendingApprovals;
	}

	public void setPendingApprovals(Integer pendingApprovals) {
		this.pendingApprovals = pendingApprovals;
	}

	public Integer getRecentOpenRequirements() {
		return recentOpenRequirements;
	}

	public void setRecentOpenRequirements(Integer recentOpenRequirements) {
		this.recentOpenRequirements = recentOpenRequirements;
	}

	public Integer getTotalOpenDigitalPosition() {
		return totalOpenDigitalPosition;
	}

	public void setTotalOpenDigitalPosition(Integer totalOpenDigitalPosition) {
		this.totalOpenDigitalPosition = totalOpenDigitalPosition;
	}
	
	
}
