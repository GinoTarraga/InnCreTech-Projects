package com.example.demo.entity;

import com.example.demo.dtos.TaskDTO;
import com.fasterxml.jackson.annotation.JsonProperty;
import org.hibernate.annotations.DynamicInsert;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;


@Entity
@Table(name="employee")
@DynamicInsert
public class Employee {
	@Id
	@GeneratedValue(strategy= GenerationType.IDENTITY)
	@Column(name = "employee_Id")
	private long employeeId;

	@Column(name = "employee_Name")
	private String employeeName;

	@Column(name = "task_id")
	private long taskId;

	@Column(name = "task_Name")
	private String taskName;

	@Column(name = "mark_completed")
	@JsonProperty
	private boolean isCompleted; //

	public long getEmployeeId() {
		return employeeId;
	}

	public String getEmployeeName() {
		return employeeName;
	}

	public void setEmployeeName(String employeeName) {
		this.employeeName = employeeName;
	}

	//Task getters & Setters
	public String getTaskName() { return taskName; }

	public void  setTaskName(String taskName) {this.taskName = taskName; }

	public long getTaskId() {return taskId; }

	public void setTaskId(long taskId) {this.taskId = taskId;}

	//isCompleted getters & Setters
	public boolean getIsCompleted() { return isCompleted; }

	public void setIsCompleted(boolean isCompleted){ this.isCompleted = isCompleted; }
}
