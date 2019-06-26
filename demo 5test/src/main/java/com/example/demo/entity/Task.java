package com.example.demo.entity;


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
    private long taskId;

    private String taskName;

    private String employeeName;

    private long employeeId;

    public long getTaskId(){ return taskId; }

    public String getTaskName(){ return taskName; }

    public void setTaskName(String taskName){ this.taskName = taskName; }

   public String getEmployeeName() { return employeeName; }

   public void setEmployeeName(String employeeName){ this.employeeName = employeeName; }

   public long getEmployeeId(){ return employeeId; }

   public void setEmployeeId(Long employeeId) {this.employeeId = employeeId; }


}
