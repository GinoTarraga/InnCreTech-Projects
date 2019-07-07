package com.taskManager.taskManager.manager;

import com.taskManager.taskManager.dtos.EmployeeDTO;
import com.taskManager.taskManager.entity.Employee;
import com.taskManager.taskManager.entity.Task;
import com.taskManager.taskManager.dtos.TaskDTO;

import com.taskManager.taskManager.repository.EmployeeRepository;
import com.taskManager.taskManager.repository.TaskRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import java.lang.Object;
import java.util.AbstractCollection;

import java.util.Objects;

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

        task.setTaskDescription(taskDTO.getTaskDescription());

        //TaskRepository saves a task which is then saved to task1 object
        Task task1 = taskRepository.save(task);

        //taskId auto generates in task entity then sets into taskDTO
        taskDTO.setTaskId(task1.getTaskId());

        //set taskName in taskDTO which is gotten from task1 entity
        taskDTO.setTaskName(task1.getTaskName());

        taskDTO.setTaskDescription(task1.getTaskDescription());

        return taskDTO;
    }

    //Or if task in task DB has been set to completed as there are no Re-assigning of task if not completed
    @Transactional
    public TaskDTO assignTask(TaskDTO taskDTO){

        Task task = new Task();

        try {
            task = taskRepository.findById(taskDTO.getTaskId());
        }catch (Exception e){
            //if an employee id is entered and it does not exist in the database
        }

        int count = 0;

        //Count will always be less then the # of employees inputted
        while(count < taskDTO.getEmployees().size()){

            EmployeeDTO employeeDTO = taskDTO.getEmployees().get(count);

            Employee employee = employeeRepository.findById(employeeDTO.getEmployeeId());

            //if employee's task is completed or has never been assigned a task
            if (Objects.isNull(employee.getTask())) {

                task.getEmployees().add(employee);

                taskRepository.save(task);

                employee.setTask(task);

                employeeRepository.save(employee);

            }else
                if ((employee.getTask().getComplete() == true)) {

                    task.getEmployees().add(employee);

                    taskRepository.save(task);

                    employee.setTask(task);

                    employeeRepository.save(employee);
                } else {
                    //cannot assign task to employee because they current have a uncompleted task
                    // as employee is many 2 one and cant have multiple task
                }
                count++;
        }
        return  taskDTO;
    }

    @Transactional
    public TaskDTO isCompleted(TaskDTO taskDTO){

        Task task = taskRepository.findById(taskDTO.getTaskId());

        task.setCompleted(taskDTO.getIsCompleted());

        taskRepository.save(task);

        return taskDTO;
    }

}
