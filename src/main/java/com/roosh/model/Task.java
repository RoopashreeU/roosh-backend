package com.roosh.model;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonSubTypes.Type;

@Entity
@Table(name="task")
public class Task {
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	int id;
	String name;
	String description;
	
	@Column(name="effort_in_mins")
	int effortInMins;
	
	@Column(name="start_date")
	@Type(Date.class)
	Date startDate;
	
	@Column(name="end_date")
	@Type(Date.class)
	Date endDate;
	
	@Column(name="status")
	@Enumerated(EnumType.STRING)
	TaskStatus status;
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public int getEffortInMins() {
		return effortInMins;
	}
	public void setEffortInMins(int effortInMins) {
		this.effortInMins = effortInMins;
	}
	public Date getStartDate() {
		return startDate;
	}
	public void setStartDate(Date startDate) {
		this.startDate = startDate;
	}
	public Date getEndDate() {
		return endDate;
	}
	public void setEndDate(Date endDate) {
		this.endDate = endDate;
	}
	public TaskStatus getStatus() {
		return status;
	}
	public void setStatus(TaskStatus status) {
		this.status = status;
	}
}
