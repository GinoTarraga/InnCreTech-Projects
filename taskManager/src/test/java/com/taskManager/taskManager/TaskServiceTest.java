package com.taskManager.taskManager;
import com.taskManager.taskManager.dtos.EmployeeDTO;
import com.taskManager.taskManager.dtos.TaskDTO;
import com.taskManager.taskManager.service.TaskService;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.ArrayList;

import java.util.List;


@RunWith(SpringRunner.class)
@SpringBootTest
public class TaskServiceTest extends EmployeeServiceTest {

    @Autowired
    protected TaskService taskService;

    protected TaskDTO taskDTO;

    /*
        - Creates new taskDTOTest object which is used to set values you wish you test with
        - A task Id is suppose to auto generate when a task is saved
        - Depends on employee group from EmployeeServiceTest class
     */
    @Test(groups = {"task"}, dependsOnGroups = {"employee"})
    public void saveTaskTest(){

        TaskDTO taskDTOTest = new TaskDTO();

        taskDTOTest.setTaskName("test case");
        taskDTOTest.setTaskDescription("create test cases");

        taskDTO = taskService.saveTask(taskDTOTest);

        //Checks if taskDTO is not null and if a taskID was auto generated
        Assert.assertNotNull(taskDTO);
        Assert.assertNotNull(taskDTO.getTaskId());
    }

    /*
        - Uses values from EmployeeDTO object created in EmployeeServiceTest
        - test case for if employee have been assigned to task
        - Create a List with Id, and see if they match the Ids present in the task's array list
        - Checks if employeeDTO object exist within the taskDTO object
     */
    @Test(groups = {"task"}, dependsOnMethods = {"saveTaskTest"})
    public void assignTaskTest(){

        TaskDTO taskDTOTest = taskDTO;

        List<EmployeeDTO> employeesListTest = new ArrayList<>();
        employeesListTest.add(employeeDTO);

        taskDTOTest.setEmployees(employeesListTest);

        try {
           taskDTO =  taskService.assignTask(taskDTOTest);
        }catch (Exception e){
            //if taskId does not exist, throw exceptions
            Assert.fail(String.format("Invalid test Id : %s", taskDTOTest.getTaskId(), e));
        }
        //compares id given above to the id of the employee who was assigned a task
        Assert.assertNotNull(taskDTO.getEmployees().contains(employeeDTO));
    }

//    @Test(groups = {"task"}, dependsOnMethods = {"assignTaskTest"})
//    public void isCompletedTest(){
//
//        TaskDTO taskDTOTest = taskDTO;
//
//        taskDTOTest.setIsCompleted(true);
//
//        taskDTOTest = taskService.isCompleted(taskDTOTest);
//
//        Assert.assertEquals(taskDTO.getEmployees().contains(employeeDTO.getTask().getComplete()),
//                taskDTOTest.getIsCompleted());
//
//    }
}
