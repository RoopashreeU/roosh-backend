package com.roosh.model;

import java.sql.Date;
import java.sql.Time;
import java.util.List;

import javax.persistence.CollectionTable;
import javax.persistence.Column;
import javax.persistence.ElementCollection;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonFormat;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
@Table(name="Appointment")
public class Appointment {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	int id;
	String name;
	String purpose;
	
	@Column(name="start_date")
	@JsonFormat(shape=JsonFormat.Shape.STRING, pattern="yyyy-MM-dd")
	Date startDate;
	
	@Column(name="end_date")
	@JsonFormat(shape=JsonFormat.Shape.STRING, pattern="yyyy-MM-dd")
	Date endDate;
	
	@Column(name="start_time")
	@JsonFormat(shape=JsonFormat.Shape.STRING, pattern="hh:mm:ss")
	Time startTime;
	
	@Column(name="end_time")
	@JsonFormat(shape=JsonFormat.Shape.STRING, pattern="hh:mm:ss")
	Time endTime;
	
	@ElementCollection
	@CollectionTable(name="appointment_people", joinColumns=@JoinColumn(name="appointment_id"))
	@Column(name="people")
	List<String> people;
	
	//File agenda;
	//File otherDocs;
}
