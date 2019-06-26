package com.example.demo.entity;

import com.example.demo.dtos.TaskDTO;
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
	private long employeeId;

	private String employeeName;

	private String taskName;

	public long getEmployeeId() {
		return employeeId;
	}

	public String getEmployeeName() {
		return employeeName;
	}

	public void setEmployeeName(String employeeName) {
		this.employeeName = employeeName;
	}

	public String getTaskName() { return taskName; }

	public void  setTaskName(String taskName) {this.taskName = taskName; }

}
