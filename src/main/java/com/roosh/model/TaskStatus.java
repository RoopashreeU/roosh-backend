package com.roosh.model;

public enum TaskStatus {
	CREATED("CREATED"),
	INPROGRESS("INPROGRESS"),
	PENDING("PENDING"),
	COMPLETED("COMPLETED"),
	NEED_REVIEW("NEED_REVIEW"),
	DELETED("DELETED"),
	CANCELLED("CANCELLED");
	
	private String status;
	
	private TaskStatus(String status) {
		this.setStatus(status);
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}
	
}
