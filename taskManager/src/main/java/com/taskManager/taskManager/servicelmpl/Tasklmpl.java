package com.taskManager.taskManager.servicelmpl;

import com.taskManager.taskManager.dtos.TaskDTO;
import com.taskManager.taskManager.entity.Task;
import com.taskManager.taskManager.manager.TaskManager;
import com.taskManager.taskManager.service.TaskService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class Tasklmpl implements  TaskService{

    @Autowired
    private TaskManager taskManager;

    @Override
    public TaskDTO saveTask(TaskDTO taskDTO) {
        return taskManager.saveTask(taskDTO);
    }

    @Override
    public TaskDTO assignTask(TaskDTO taskDTO) { return taskManager.assignTask(taskDTO); }

    @Override
    public TaskDTO isCompleted(TaskDTO taskDTO) { return taskManager.isCompleted(taskDTO); }

}
