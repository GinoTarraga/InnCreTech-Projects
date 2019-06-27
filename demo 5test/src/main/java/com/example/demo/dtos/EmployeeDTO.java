package com.example.demo.dtos;

import com.example.demo.entity.Task;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import java.time.format.TextStyle;
import java.util.List;

@JsonIgnoreProperties(ignoreUnknown = true)
public class EmployeeDTO {

	private long employeeId;

	private String employeeName;

	private String taskName;

	private long taskId;

	private boolean isCompleted;

	public long getEmployeeId() {
		return employeeId;
	}

	public void setEmployeeId(long employeeId) {
		this.employeeId = employeeId;
	}

	public String getEmployeeName() {
		return employeeName;
	}

	public void setEmployeeName(String employeeName) {
		this.employeeName = employeeName;
	}

	public String getTaskName() { return taskName;}

	public void setTaskName(String taskName) { this.taskName = taskName; }

	public long getTaskId() {return taskId; }

	public void setTaskId(long taskId) {this.taskId = taskId;}

	//isCompleted getters & Setters
	public boolean getIsCompleted() { return isCompleted; }

	public void setIsCompleted(boolean isCompleted){ this.isCompleted = isCompleted; }


}
