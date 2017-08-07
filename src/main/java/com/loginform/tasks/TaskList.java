package com.loginform.tasks;



import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class TaskList {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;
	
	private String task;
	private String beginDate;
	private String endDate;
	
	
	public TaskList() {
		
	}
	
	public TaskList(String task, String beginDate, String endDate) {
		this.task = task;
		this.beginDate = beginDate;
		this.endDate = endDate;
	}
	
	public String getBeginDate() {
		return beginDate;
	}

	public void setBeginDate(String beginDate) {
		this.beginDate = beginDate;
	}

	public String getEndDate() {
		return endDate;
	}

	public void setEndDate(String endDate) {
		this.endDate = endDate;
	}

	
	public String getTask() {
		return task;
	}

	public void setTask(String task) {
		this.task = task;
	}

	

}
