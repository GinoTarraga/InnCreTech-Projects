package com.taskManager.taskManager.manager;

import com.taskManager.taskManager.dtos.EmployeeDTO;
import com.taskManager.taskManager.entity.Employee;
import com.taskManager.taskManager.repository.EmployeeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

@Component
public class EmployeeManager {

   @Autowired
   private EmployeeRepository employeeRepository;

    @Transactional
    public EmployeeDTO saveEmployee(EmployeeDTO employeeDTO){

        Employee employee = new Employee();

        employee.setEmployeeFirstName(employeeDTO.getEmployeeFirstName());

        employee.setEmployeeLastName(employeeDTO.getEmployeeLastName());

        Employee employee1 = employeeRepository.save(employee);

        employeeDTO.setEmployeeId(employee1.getEmployeeId());

        employeeDTO.setEmployeeFirstName(employee1.getEmployeeFirstName());

        employeeDTO.setEmployeeLastName(employee1.getEmployeeLastName());

        return employeeDTO;
    }

    @Transactional
    public EmployeeDTO getEmployeeById(EmployeeDTO employeeDTO){

        Employee employee = employeeRepository.findById(employeeDTO.getEmployeeId());

        employeeDTO.setEmployeeFirstName(employee.getEmployeeFirstName());
        employeeDTO.setEmployeeLastName(employee.getEmployeeLastName());
        employeeDTO.setTask(employee.getTask());
       
        return employeeDTO;
    }

}
