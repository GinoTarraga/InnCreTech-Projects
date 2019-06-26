package com.example.demo.controller;

import com.example.demo.dtos.EmployeeDTO;
import com.example.demo.dtos.TaskDTO;
import com.example.demo.service.TaskService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/rest/task")
public class TaskController {

    @Autowired
    private TaskService taskService;

    @RequestMapping(value = "/addTask", method = RequestMethod.POST)
    public TaskDTO addTask(@RequestBody TaskDTO taskDTO){

        return taskService.saveTask(taskDTO);
    }

    @PutMapping(value = "/assignTask")
    public TaskDTO assignTask(@RequestBody TaskDTO taskDTO){
        return taskService.assignTask(taskDTO);
    }
}
