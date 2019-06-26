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


}
