package com.example.demo.dtos;

import com.example.demo.entity.Employee;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown = true)
public class TaskDTO {

    private long taskId;

    private String taskName;

    private String employeeName;

    private long employeeId;

    private boolean isCompleted;

    public long getTaskId(){ return taskId; }

    public void setTaskId(long taskId){ this.taskId = taskId; }

    public String getTaskName(){ return taskName; }

    public void setTaskName(String taskName){ this.taskName = taskName; }

    //Employee sets & gets
    public String getEmployeeName(){ return employeeName; }

    public void setEmployeeName(String employeeName){
        this.employeeName = employeeName;
    }

    public long getEmployeeId() { return employeeId; }

    public void setEmployeeId(long employeeId) { this.employeeId = employeeId; }

    //isCompleted getters & Setters
    public boolean getIsCompleted() { return isCompleted; }

    public void setIsCompleted(boolean isCompleted){ this.isCompleted = isCompleted; }

}
