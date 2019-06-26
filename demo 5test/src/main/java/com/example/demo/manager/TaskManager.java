package com.example.demo.manager;

import com.example.demo.dtos.EmployeeDTO;
import com.example.demo.entity.Employee;
import com.example.demo.entity.Task;
import com.example.demo.dtos.TaskDTO;
import com.example.demo.repository.EmployeeRepository;
import com.example.demo.repository.TaskRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import java.util.Objects;
import java.util.Optional;

@Component
public class TaskManager {

    @Autowired
    private TaskRepository taskRepository;

    @Autowired
    private EmployeeRepository employeeRepository;

    @Transactional
    public TaskDTO saveTask(TaskDTO taskDTO){

        Task task = new Task();

        //set taskName in task entity which is gotten from taskDTO
        task.setTaskName(taskDTO.getTaskName());

        //TaskRepository saves a task which is then saved to task1 object
        Task task1 = taskRepository.save(task);

        //taskId auto generates in task entity then sets into taskDTO
        taskDTO.setTaskId(task1.getTaskId());

        //set taskName in taskDTO which is gotten from task1 entity
        taskDTO.setTaskName(task1.getTaskName());

        return taskDTO;
    }

    //Must pass employeeId, employeeName and taskId since it will automatically assume taskId and employeId = 0
    public TaskDTO assignTask(TaskDTO taskDTO){

        Task task = taskRepository.findById(taskDTO.getTaskId());
        Employee employee = employeeRepository.findById(taskDTO.getEmployeeId());

//        if(!(Objects.nonNull(task) || !(Objects.nonNull(employee)))){
//            //throw exceptions
//        }

        if((Objects.nonNull(task))){

            task.setEmployeeId(taskDTO.getEmployeeId());

            if(taskDTO.getEmployeeName() != null) {
                task.setEmployeeName(taskDTO.getEmployeeName());
                employee.setTaskName(task.getTaskName());

                Task task1 = taskRepository.save(task);
                Employee employee1 = employeeRepository.save(employee);

                taskDTO.setEmployeeId(task1.getEmployeeId());
                taskDTO.setEmployeeName(task1.getEmployeeName());
                taskDTO.setTaskName(task1.getTaskName());
            }
        }

        return taskDTO;
    }
}
