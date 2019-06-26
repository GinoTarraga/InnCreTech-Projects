package com.example.demo.service;

import com.example.demo.dtos.EmployeeDTO;
import com.example.demo.dtos.TaskDTO;
import com.example.demo.entity.Task;

public interface EmployeeService {

	EmployeeDTO saveEmployee(EmployeeDTO employeeDTO);

}
