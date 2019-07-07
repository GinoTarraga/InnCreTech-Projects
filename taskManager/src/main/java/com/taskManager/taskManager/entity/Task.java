package com.taskManager.taskManager.entity;

import org.hibernate.annotations.DynamicInsert;
import org.hibernate.annotations.DynamicUpdate;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "task")
@DynamicInsert
@DynamicUpdate
public class Task {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "task_Id")
    private long taskId;

    @Column(name = "task_Name")
    private String taskName;

    @Column(name = "task_Description")
    private String taskDescription;

    @Column(name = "task_Completed")
    private boolean isCompleted;

    /*
          targetEntity - the entity class that is targeted by the association
          mappedBy - is used to define the reference side. Making the relation bidirectional
          - Owning side would be the Many to one in employee entity (usually the side that owns a foreign key)
          - Fetches entity fields eagerly. All of the employees are fetched from the DB when task is fetched.
          - Lazy only fetches entity fields when you want to access them.
          -
          - One task can have many employees
     */

    @OneToMany(targetEntity = Employee.class, mappedBy = "task", fetch = FetchType.EAGER)
    private List<Employee> employees;

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

    public boolean getComplete() { return isCompleted; }

    public void setCompleted(boolean isCompleted){ this.isCompleted = isCompleted; }

    public List<Employee> getEmployees() {
        return employees;
    }

    public void setEmployees(List<Employee> employees) {
        this.employees = employees;
    }
}