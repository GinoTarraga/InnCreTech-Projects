package com.taskManager.taskManager.repository;

import com.taskManager.taskManager.entity.Employee;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface EmployeeRepository extends JpaRepository <Employee, Long> {
    Employee findById(long employeeId);

    Employee findByEmployeeLastName(String employeeLastName);

}
