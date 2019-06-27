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

import java.util.ArrayList;
import java.util.List;
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

        //TaskRepository saves a task which is then saved to task1 object
        Task task1 = taskRepository.save(task);

        //taskId auto generates in task entity then sets into taskDTO
        taskDTO.setTaskId(task1.getTaskId());

        //set taskName in taskDTO which is gotten from task1 entity
        taskDTO.setTaskName(task1.getTaskName());

        return taskDTO;
    }

    /*
        - Must check if employee has a previous task assigned
        - can not be assigned a new task until previous task is completed
        - Or if they never had a previous task
     */
    //Must pass employeeId, employeeName and taskId since it will automatically assume taskId and employeId = 0
    @Transactional
    public TaskDTO assignTask(TaskDTO taskDTO){

        Task task = taskRepository.findById(taskDTO.getTaskId());
        Employee employee = employeeRepository.findById(taskDTO.getEmployeeId());

//        if(!(Objects.nonNull(task) || !(Objects.nonNull(employee)))){
//            //throw exceptions
//        }

        if((Objects.nonNull(task.getTaskId()))){

            //Checks if employee has never had a previous task
            //Or if their current task is completed
            //Or if task in task DB has also been set to completed as there are no Re-assigning of task

            // is taskId or employeeId = 0 then employee and task have never been assigned
            if((employee.getTaskId() != 0) || (task.getEmployeeId() != 0)) {

                if ((employee.getIsCompleted() == true || task.getIsCompleted() == true)) {

                    task.setEmployeeId(taskDTO.getEmployeeId());
                    task.setEmployeeName(taskDTO.getEmployeeName());
                    task.setIsCompleted(false);

                    employee.setTaskName(task.getTaskName());
                    employee.setTaskId(task.getTaskId());
                    employee.setIsCompleted(false);

                    employeeRepository.save(employee);
                    taskRepository.save(task);
                }else{
                    //throw exceptions because a new task can not be assignes without completing the previous one
                    // for now until a employee has a List of task
                    taskDTO.setTaskName("Employee has not completed previous task");
                    return taskDTO;
                }

            } else {

                task.setEmployeeId(taskDTO.getEmployeeId());
                task.setEmployeeName(taskDTO.getEmployeeName());
                task.setIsCompleted(false);

                employee.setTaskName(task.getTaskName());
                employee.setTaskId(task.getTaskId());
                employee.setIsCompleted(false);

                Task task1 = taskRepository.save(task);
                Employee employee1 = employeeRepository.save(employee);
            }

            //Task task1 = taskRepository.save(task);
                //Employee employee1 = employeeRepository.save(employee);

                //Dont think employeeId should be shown back to user.
                taskDTO.setEmployeeId(task.getEmployeeId());
                taskDTO.setEmployeeName(task.getEmployeeName());
                taskDTO.setTaskName(task.getTaskName());

        }

        return taskDTO;
    }

    // create a new array list
    // traverse task DB by task Id and checks every task completed status
    // adds only completed task into array list then returns array list
    @Transactional
    public List <TaskDTO> completedTaskList(TaskDTO taskDTO){

        List<TaskDTO> completedTask = new ArrayList<>();

        long countId = 1;

        Task task = taskRepository.findById(countId);

        while(Objects.nonNull(task)){

            if(task.getIsCompleted() == true){

                TaskDTO taskDTO2 = new TaskDTO();
                taskDTO2.setTaskName(task.getTaskName());
                taskDTO2.setIsCompleted(task.getIsCompleted());
                taskDTO2.setEmployeeName(task.getEmployeeName());

                completedTask.add(taskDTO2);
            }
            countId++;
            task = taskRepository.findById(countId);
        }

        return completedTask;
    }

}
