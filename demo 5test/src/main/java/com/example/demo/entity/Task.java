package com.example.demo.entity;


import com.fasterxml.jackson.annotation.JsonProperty;
import org.hibernate.annotations.DynamicInsert;
import org.hibernate.annotations.DynamicUpdate;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Set;

@Entity
@Table(name = "task")
@DynamicInsert
@DynamicUpdate
public class Task implements Serializable {

private static final long serialVersionUID =1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY) //Auto generates uses a global number generater for every entity
    @Column(name = "task_Id")
    private long taskId;

    @Column(name = "task_Name")
    private String taskName;

    @Column(name = "employee_Name")
    private String employeeName;

    @Column(name = "employee_Id")
    private long employeeId;


    @Column(name = "marked_Completed")
    @JsonProperty
    private boolean isCompleted;

    public long getTaskId(){ return taskId; }

    public String getTaskName(){ return taskName; }

    public void setTaskName(String taskName){ this.taskName = taskName; }

    //Employee getters & Setters
    public String getEmployeeName() { return employeeName; }

    public void setEmployeeName(String employeeName){ this.employeeName = employeeName; }

    public long getEmployeeId(){ return employeeId; }

    public void setEmployeeId(Long employeeId) {this.employeeId = employeeId; }

    //isCompleted getters & Setters
    public boolean getIsCompleted() { return isCompleted; }

    public void setIsCompleted(boolean isCompleted){ this.isCompleted = isCompleted; }


}
