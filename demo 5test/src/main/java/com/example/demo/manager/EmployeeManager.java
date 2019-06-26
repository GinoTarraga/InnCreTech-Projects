package com.example.demo.manager;

import com.example.demo.dtos.EmployeeDTO;
import com.example.demo.dtos.TaskDTO;
import com.example.demo.entity.Employee;
import com.example.demo.entity.Task;
import com.example.demo.repository.EmployeeRepository;
import net.bytebuddy.asm.Advice;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;

@Component
public class EmployeeManager {

	@Autowired
	private EmployeeRepository employeeRepository;

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

}
