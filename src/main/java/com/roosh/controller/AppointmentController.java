package com.roosh.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.github.fge.jsonpatch.JsonPatch;
import com.roosh.dao.AppointmentRepository;
import com.roosh.model.Appointment;

@RestController
public class AppointmentController {

	@Autowired
	AppointmentRepository repo;
	
	@Autowired
	ObjectMapper mapper;
	
	@PutMapping("/get_appointment")
	public ResponseEntity<String> getAppointment(@RequestBody Appointment apmt){
		try {
			System.out.println("Start Time = " + apmt.getStartTime());
			System.out.println("End Time = " + apmt.getEndTime());
			if(repo.checkAvailablity(apmt.getStartDate(), apmt.getEndDate(), apmt.getStartTime(), apmt.getEndTime()).isEmpty()) {
				repo.save(apmt);
			}else {
				throw new Exception();
			}
			
		} catch (Exception e) {
			e.printStackTrace();
			return new ResponseEntity<String>(HttpStatus.CONFLICT);
		}
		return new ResponseEntity<String>(HttpStatus.ACCEPTED);
	}
	
	@DeleteMapping("/delete_appointment/{id}")
	public ResponseEntity<String> deleteAppointment(@PathVariable Integer id){
		repo.deleteById(id);
		return new ResponseEntity<String>(HttpStatus.ACCEPTED);
	}
	
	@PatchMapping(path = "/edit_appointment/{id}", consumes="application/json-patch+json")
	public ResponseEntity<String> editAppointment(@PathVariable Integer id, @RequestBody JsonPatch patch){
		try {
			//Yet to validate the patch value. check for availability
			Appointment apmt = repo.findById(id).orElseThrow(Exception::new);
			JsonNode node = patch.apply(mapper.convertValue(apmt, JsonNode.class));
			apmt = mapper.treeToValue(node, Appointment.class);
			repo.save(apmt);
		} catch (Exception e) {
			e.printStackTrace();
			return new ResponseEntity<String>(HttpStatus.NOT_FOUND);
		}
		return new ResponseEntity<String>(HttpStatus.ACCEPTED);
	}
}
