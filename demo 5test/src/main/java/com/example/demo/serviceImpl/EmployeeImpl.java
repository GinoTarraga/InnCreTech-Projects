package com.example.demo.serviceImpl;

import com.example.demo.dtos.EmployeeDTO;
import com.example.demo.dtos.TaskDTO;
import com.example.demo.manager.EmployeeManager;
import com.example.demo.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
public class EmployeeImpl implements EmployeeService {
	@Autowired
	private EmployeeManager employeeManager;

	@Override
	public EmployeeDTO saveEmployee(EmployeeDTO employeeDTO) {
		return employeeManager.saveEmployee(employeeDTO);
	}

	@Override
	public EmployeeDTO isCompleted(EmployeeDTO employeeDTO) { return employeeManager.isCompleted(employeeDTO); }

}
