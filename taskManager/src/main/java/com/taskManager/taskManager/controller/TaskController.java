package com.taskManager.taskManager.controller;

import com.taskManager.taskManager.dtos.EmployeeDTO;
import com.taskManager.taskManager.dtos.TaskDTO;
import com.taskManager.taskManager.repository.TaskRepository;
import com.taskManager.taskManager.service.TaskService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/rest/task")
public class TaskController {

    @Autowired
    private TaskService taskService;

    @RequestMapping(value = "/addTask", method = RequestMethod.POST)
    public TaskDTO saveTask(@RequestBody TaskDTO taskDTO){
        return taskService.saveTask(taskDTO);
    }

    @RequestMapping(value = "/assignTask", method = RequestMethod.PUT)
    public TaskDTO assignTask(@RequestBody TaskDTO taskDTO){
        return taskService.assignTask(taskDTO);
    }

    @RequestMapping(value = "/taskCompleted", method = RequestMethod.PUT)
    public TaskDTO isCompleted(@RequestBody TaskDTO taskDTO){
        return taskService.isCompleted(taskDTO);
    }

}
