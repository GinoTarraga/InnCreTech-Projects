package com.example.demo.controller;

import com.example.demo.dtos.EmployeeDTO;
import com.example.demo.dtos.TaskDTO;
import com.example.demo.entity.Employee;
import com.example.demo.service.EmployeeService;
import jdk.nashorn.internal.ir.ObjectNode;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

@RestController
@RequestMapping("/api/rest/employee")
public class EmployeeController {

	@Autowired
	private EmployeeService employeeService;

	@RequestMapping(value="/addEmployee",method = RequestMethod.POST)
	public EmployeeDTO addEmployee(@RequestBody EmployeeDTO employeeDTO){
		return employeeService.saveEmployee(employeeDTO);
	}

}
