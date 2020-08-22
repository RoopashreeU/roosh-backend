package com.roosh.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.roosh.model.Task;

@Repository
public interface TaskRepository extends JpaRepository<Task, Integer>{
	
}
