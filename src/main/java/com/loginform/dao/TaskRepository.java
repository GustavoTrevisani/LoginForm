package com.loginform.dao;


import org.springframework.data.repository.CrudRepository;

import com.loginform.tasks.TaskList;

public interface TaskRepository extends CrudRepository<TaskList, Long> {
	
	

}
