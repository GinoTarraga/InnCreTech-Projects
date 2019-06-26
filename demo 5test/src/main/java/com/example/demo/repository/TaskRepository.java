package com.example.demo.repository;

import com.example.demo.entity.Task;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TaskRepository extends JpaRepository<Task, Long> {
    Task findById(long taskId);
    /*
        Task findByTaskName(String taskName);
        You can create functions to search by if it isn't already in the JpaRepository
        for example:
            - If you want to search by completed task
            - Task findByTaskCompleted(boolean taskCompleted);
            - boolean taskCompleted must exist in the task entity.
     */


}
