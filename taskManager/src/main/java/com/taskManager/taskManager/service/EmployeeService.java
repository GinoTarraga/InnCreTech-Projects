package com.taskManager.taskManager.service;

import com.taskManager.taskManager.dtos.EmployeeDTO;
import org.springframework.stereotype.Service;

public interface EmployeeService {

    EmployeeDTO saveEmployee(EmployeeDTO employeeDTO);

    EmployeeDTO getEmployeeById(EmployeeDTO employeeDTO);

}
