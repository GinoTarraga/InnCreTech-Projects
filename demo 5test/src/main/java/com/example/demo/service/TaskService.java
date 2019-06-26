package com.example.demo.service;

import com.example.demo.dtos.EmployeeDTO;
import com.example.demo.dtos.TaskDTO;
import org.springframework.http.ResponseEntity;

public interface TaskService {

    TaskDTO saveTask(TaskDTO taskDTO);

    TaskDTO assignTask(TaskDTO taskDTO);
}
