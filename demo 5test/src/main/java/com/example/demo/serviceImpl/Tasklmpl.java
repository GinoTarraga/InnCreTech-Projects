package com.example.demo.serviceImpl;

import com.example.demo.dtos.EmployeeDTO;
import com.example.demo.dtos.TaskDTO;
import com.example.demo.entity.Employee;
import com.example.demo.entity.Task;
import com.example.demo.manager.EmployeeManager;
import com.example.demo.manager.TaskManager;
import com.example.demo.service.TaskService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class Tasklmpl implements TaskService {

    @Autowired
    private TaskManager taskManager;

    @Override
    public TaskDTO saveTask(TaskDTO taskDTO) {
        return taskManager.saveTask(taskDTO);
    }

    @Override
    public TaskDTO assignTask(TaskDTO taskDTO){
        return taskManager.assignTask(taskDTO);
    }

    @Override
    public List<TaskDTO> completedTaskList(TaskDTO taskDTO) {
        return taskManager.completedTaskList(taskDTO);
    }


}
