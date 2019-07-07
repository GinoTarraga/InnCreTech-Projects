package com.taskManager.taskManager.dtos;

import com.taskManager.taskManager.entity.Task;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import java.time.format.TextStyle;
import java.util.List;

@JsonIgnoreProperties(ignoreUnknown = true)
public class EmployeeDTO {

    private long employeeId;

    private String employeeFirstName;

    private String employeeLastName;

    private Task task;

    public long getEmployeeId() {
        return employeeId;
    }

    public void setEmployeeId(long employeeId) {
        this.employeeId = employeeId;
    }

    public String getEmployeeFirstName() {
        return employeeFirstName;
    }

    public void setEmployeeFirstName(String employeeFirstName) {
        this.employeeFirstName = employeeFirstName;
    }

    public String getEmployeeLastName() {
        return employeeLastName;
    }

    public void setEmployeeLastName(String employeeLastName) {
        this.employeeLastName = employeeLastName;
    }

    public Task getTask() {
        return task;
    }

    public void setTask(Task task) {
        this.task = task;
    }
}
