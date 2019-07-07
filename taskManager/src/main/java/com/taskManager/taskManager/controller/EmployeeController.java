package com.taskManager.taskManager.controller;

import com.taskManager.taskManager.dtos.EmployeeDTO;
import com.taskManager.taskManager.dtos.TaskDTO;
import com.taskManager.taskManager.entity.Employee;
import com.taskManager.taskManager.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/api/rest/employee")
public class EmployeeController {

    @Autowired
    private EmployeeService employeeService;

    @RequestMapping(value = "/addEmployee", method = RequestMethod.POST)
    public EmployeeDTO saveEmployee(@RequestBody EmployeeDTO employeeDTO){
        return employeeService.saveEmployee(employeeDTO);
    }

    @RequestMapping(value = "/getEmployeeById", method = RequestMethod.GET)
    public EmployeeDTO getEmployeeById(@RequestBody EmployeeDTO employeeDTO){
        return employeeService.getEmployeeById(employeeDTO);
    }


}
