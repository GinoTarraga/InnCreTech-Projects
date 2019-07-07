package com.taskManager.taskManager.servicelmpl;

import com.taskManager.taskManager.dtos.EmployeeDTO;
import com.taskManager.taskManager.dtos.TaskDTO;
import com.taskManager.taskManager.manager.EmployeeManager;
import com.taskManager.taskManager.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class Employeelmpl implements EmployeeService {

    @Autowired
    private EmployeeManager employeeManager;

    @Override
    public EmployeeDTO saveEmployee(EmployeeDTO employeeDTO){ return employeeManager.saveEmployee(employeeDTO); }

    @Override
    public EmployeeDTO getEmployeeById(EmployeeDTO employeeDTO){ return employeeManager.getEmployeeById(employeeDTO); }


}
