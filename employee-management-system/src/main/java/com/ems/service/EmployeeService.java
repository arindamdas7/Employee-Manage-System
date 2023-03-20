package com.ems.service;

import com.ems.entity.Employee;
import com.ems.model.EmployeeDTO;

public interface EmployeeService 
{
	void saveEmployee(Employee employee);
	EmployeeDTO getEmployeeById(int id);
	EmployeeDTO getEmployeeByEmail(String email);
	EmployeeDTO updateEmployeeById(int id, Employee empl);
	void deleteEmployeeById(int id);
	boolean login(String userName, String password);
	
	
}
