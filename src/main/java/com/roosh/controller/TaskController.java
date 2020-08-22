package com.roosh.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.github.fge.jsonpatch.JsonPatch;
import com.roosh.dao.TaskRepository;
import com.roosh.model.Task;

@RestController
public class TaskController {
	
	@Autowired
	TaskRepository respository;
	
	@Autowired
	ObjectMapper mapper;
	
	
	@PutMapping("/add_task")
	public @ResponseBody ResponseEntity<Task> addTask(@RequestBody Task task) {
		System.out.println("Task start date : " + task.getStartDate());
		System.out.println("Task status : " + task.getStatus().toString());
		respository.save(task);
		return new ResponseEntity<Task>(HttpStatus.ACCEPTED);
	}
	
	@DeleteMapping("/delete_task/{id}")
	public @ResponseBody ResponseEntity<Task> deleteTask(@PathVariable Integer id) {
		respository.deleteById(id);
		return new ResponseEntity<Task>(HttpStatus.ACCEPTED);
	}
	
	@PatchMapping(path = "/edit_task/{id}", consumes="application/json-patch+json")
	public @ResponseBody ResponseEntity<Task> editTask(@PathVariable int id, @RequestBody JsonPatch patch){
		try {
			Task task = respository.findById(id).orElseThrow(Exception::new);
			JsonNode node = patch.apply(mapper.convertValue(task, JsonNode.class));
			task = mapper.treeToValue(node, Task.class);
			respository.save(task);
		} catch (Exception e) {
			e.printStackTrace();
			return new ResponseEntity<Task>(HttpStatus.NOT_FOUND);
		}
		return new ResponseEntity<Task>(HttpStatus.ACCEPTED);
	}
}
