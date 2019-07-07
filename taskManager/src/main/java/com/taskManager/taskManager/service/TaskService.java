package com.taskManager.taskManager.service;

import com.taskManager.taskManager.dtos.TaskDTO;
import org.springframework.http.ResponseEntity;

import java.util.List;
public interface TaskService {

    TaskDTO saveTask(TaskDTO taskDTO);

    TaskDTO assignTask(TaskDTO taskDTO);

    TaskDTO isCompleted(TaskDTO taskDTO);
}
