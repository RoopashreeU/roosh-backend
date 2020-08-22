package com.roosh.dao;

import java.sql.Date;
import java.sql.Time;
import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.roosh.model.Appointment;

@Repository
public interface AppointmentRepository extends JpaRepository<Appointment, Integer>{
	@Query(value="Select * from Appointment where ((start_date<=?1 and end_date>=?1) or (start_date<=?2 and end_date>=?2)) and ((start_time<=?3 and end_time>=?3) or (start_time<=?4 and end_time>=?4))", nativeQuery=true)
	public Optional<List<Appointment>> checkAvailablity(Date startdate, Date enddate, Time starttime, Time endtime);
}
