package com.example.demo.manager;

import com.example.demo.dtos.EmployeeDTO;
import com.example.demo.dtos.TaskDTO;
import com.example.demo.entity.Employee;
import com.example.demo.entity.Task;
import com.example.demo.repository.EmployeeRepository;
import com.example.demo.repository.TaskRepository;
import net.bytebuddy.asm.Advice;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

@Component
public class EmployeeManager {

	@Autowired
	private EmployeeRepository employeeRepository;

	@Autowired
	private TaskRepository taskRepository;

	/*
	- Transactional means that any failure causes the whole operation to roll back to it's previous state and re-throw
	the original exception.
	- No employee will be able to be saved if one employee fails to be saved
	 */
	@Transactional
	public EmployeeDTO saveEmployee(EmployeeDTO employeeDTO){

		Employee employee = new Employee();

		employee.setEmployeeName(employeeDTO.getEmployeeName());

		Employee employee1 = employeeRepository.save(employee);

		employeeDTO.setEmployeeId(employee1.getEmployeeId());

		employeeDTO.setEmployeeName(employee1.getEmployeeName());

		return employeeDTO;
	}

	/*
        - Completed Task
        - Employee will enter their employee Id, task Id and isCompleted = 1;
        - Add task Id to employee DB as they could input an incorrect taskName
        - This method will set isCompleted to true on both employee and task DB
        - 0 = uncompleted task
        - Employee can only be assigned a task if they have no prior task or if their current task is completed
        - If task doesnt exist throw exceptions
     */

	@Transactional
	public EmployeeDTO isCompleted(EmployeeDTO employeeDTO){

		Employee employee = employeeRepository.findById(employeeDTO.getEmployeeId());

		Task task = taskRepository.findById(employeeDTO.getEmployeeId());

		if (!(Objects.nonNull(employee)) || !(Objects.nonNull(task))){
			//throw exceptions
		}
			//if employee doesn't have an assign task and tries to complete a task
			//Or if they try to complete a task which has already been completed
			if((employee.getTaskId() == 0) || employee.getIsCompleted() == true){
				//throw exceptions, but for now
				employeeDTO.setTaskName("No current task available or you have already completed that task");
				return employeeDTO;
			}else{
				// Set task to isCompleted (1).
				// Employee can only be assigned a new task if his current task is completed
				// A task can only be assigned to an employee if it is marked completed in task DB
				// Or if has not been previously assigned
				employee.setIsCompleted(employeeDTO.getIsCompleted());
				task.setIsCompleted(employeeDTO.getIsCompleted());
				employeeRepository.save(employee);
				taskRepository.save(task);
			}

		employeeDTO.setTaskName(employee.getTaskName());
		employeeDTO.setIsCompleted(employee.getIsCompleted());

		return employeeDTO;
	}
}
