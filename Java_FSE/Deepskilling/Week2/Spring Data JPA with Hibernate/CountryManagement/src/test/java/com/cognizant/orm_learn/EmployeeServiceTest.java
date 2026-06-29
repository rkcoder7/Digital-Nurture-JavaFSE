package com.cognizant.orm_learn;

import static org.mockito.Mockito.*;
import static org.junit.jupiter.api.Assertions.*;

import java.math.BigDecimal;
import java.util.ArrayList;

import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import com.cognizant.orm_learn.DTOs.EmployeeDTO;
import com.cognizant.orm_learn.DTOs.EmployeeSkillDTO;
import com.cognizant.orm_learn.model.Department;
import com.cognizant.orm_learn.model.Employee;
import com.cognizant.orm_learn.repository.EmployeeRepository; // Assuming your service calls this
import com.cognizant.orm_learn.service.EmployeeService;

@ExtendWith(MockitoExtension.class)
public class EmployeeServiceTest {

    @Mock
    private EmployeeRepository employeeRepository;  //Fake Repo object created

    @InjectMocks
    private EmployeeService employeeService;  // real instance of service but injected with fake repo 
    @Order(1)
    @Test
    public void testAddNewEmployeeToDb() {
        // Setup
        Department dp = new Department(); 
        dp.setId(2);
        Employee newComer = Employee.builder().name("Mohan Sarady").salary(new BigDecimal("102000.00")).department(dp).build();
        
        // Stubbing
        when(employeeRepository.save(any(Employee.class))).thenReturn(newComer);
        
        // Act
        employeeService.saveEmployee(newComer);
        
        // Assert
        verify(employeeRepository, times(1)).save(newComer);
    }

   
    @Order(1)
    @Test
    public void testUpdateEmployeeSalary() {
        Employee mockEmployee = Employee.builder().id(41).salary(new BigDecimal("102000.00")).build();
        BigDecimal updatedSalary = new BigDecimal("130000.00");
        
        when(employeeRepository.findById(41)).thenReturn(java.util.Optional.of(mockEmployee));
        
        employeeService.updateEmployeeSalary(41, updatedSalary);
        
        assertEquals(updatedSalary, mockEmployee.getSalary());
    }
    @Order(2)
    @Test
    public void testUpdateEmployeeDOB() {
        Employee mockEmployee = Employee.builder().id(41).build();
        java.sql.Date newDob = java.sql.Date.valueOf("2005-11-24");
        
        when(employeeRepository.findById(41)).thenReturn(java.util.Optional.of(mockEmployee));
        
        employeeService.updateEmployeeDOB(41, newDob);
        
        assertEquals(newDob, mockEmployee.getDateOfBirth());
    }

}