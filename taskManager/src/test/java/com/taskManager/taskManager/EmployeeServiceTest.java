package com.taskManager.taskManager;

import com.taskManager.taskManager.dtos.EmployeeDTO;
import com.taskManager.taskManager.entity.Employee;
import com.taskManager.taskManager.repository.EmployeeRepository;
import com.taskManager.taskManager.service.EmployeeService;
import org.junit.Assert;

import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.context.testng.AbstractTestNGSpringContextTests;
import org.testng.annotations.Test;

@RunWith(SpringRunner.class)
@SpringBootTest
public class EmployeeServiceTest extends AbstractTestNGSpringContextTests{

    @Autowired
    protected EmployeeService employeeService;

    protected EmployeeDTO employeeDTO;

    /*
        - Test case for saveEmployee
        - Checks if a employeeId is generated
        - If a Id is not generated then test failed
     */
    @Test(groups = {"employee"})
    public void saveEmployeeTest(){

        EmployeeDTO testEmployeeDTO = new EmployeeDTO();

        testEmployeeDTO.setEmployeeFirstName("Test Employee");
        testEmployeeDTO.setEmployeeLastName("Test Employee");

        employeeDTO = employeeService.saveEmployee(testEmployeeDTO);

        Assert.assertNotNull(employeeDTO);
        Assert.assertNotNull(employeeDTO.getEmployeeId());
    }

    /*
        - Tests getEmployeeById method in service
        - Depends on the saveEmployeeTest method in order to run
        - Uses data from EmployeeDTO which was initialized in saveEmployee
        - Runs getEmployeeId method from service
        - and checks if the firstName from employeDTO is equal to the preset value from testEmployeeDTO
        - And if Object is not null
     */
    @Test(groups = {"employee"}, dependsOnMethods = {"saveEmployeeTest"})
    public void getEmployeeByIdTest(){

        EmployeeDTO testEmployeeDTO = new EmployeeDTO();
        testEmployeeDTO.setEmployeeFirstName("Test Employee");
        testEmployeeDTO.setEmployeeId(employeeDTO.getEmployeeId());


        try{
            employeeDTO = employeeService.getEmployeeById(testEmployeeDTO);
        }catch (Exception e){
            Assert.fail(String.format("No user exist by that Id : %s", employeeDTO.getEmployeeId(), e));
        }
        Assert.assertNotNull(employeeDTO.getEmployeeId());
        Assert.assertEquals(testEmployeeDTO.getEmployeeFirstName(), employeeDTO.getEmployeeFirstName());
    }

}
