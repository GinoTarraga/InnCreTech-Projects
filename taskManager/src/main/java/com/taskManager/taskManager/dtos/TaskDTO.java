package com.taskManager.taskManager.dtos;

import com.taskManager.taskManager.entity.Employee;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import java.util.List;

@JsonIgnoreProperties(ignoreUnknown = true)
public class TaskDTO {

    private long taskId;

    private String taskName;

    private String taskDescription;

    private boolean isCompleted;

    private List <EmployeeDTO> employees;

    public long getTaskId() {
        return taskId;
    }

    public void setTaskId(long taskId) {
        this.taskId = taskId;
    }

    public String getTaskName() {
        return taskName;
    }

    public void setTaskName(String taskName) {
        this.taskName = taskName;
    }

    public String getTaskDescription() {
        return taskDescription;
    }

    public void setTaskDescription(String taskDescription) {
        this.taskDescription = taskDescription;
    }

    public boolean getIsCompleted() { return isCompleted; }

    public void setIsCompleted(boolean isCompleted){ this.isCompleted = isCompleted; }

    public List<EmployeeDTO> getEmployees() {
        return employees;
    }

    public void setEmployees(List<EmployeeDTO> employees) {
        this.employees = employees;
    }
}
