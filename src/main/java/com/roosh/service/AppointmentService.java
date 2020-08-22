package com.roosh.service;

import java.sql.Date;
import java.sql.Time;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.roosh.dao.AppointmentRepository;

@Service
public class AppointmentService {
	
	@Autowired
	AppointmentRepository appRepo;
	
	public boolean checkAvalability(Date startDate, Date endDate, Time startTime, Time endTime) {
		return true;
	}
	
}
