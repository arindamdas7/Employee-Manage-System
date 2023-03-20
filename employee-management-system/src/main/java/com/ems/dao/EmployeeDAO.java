package com.ems.dao;

import com.ems.entity.Employee;

public interface EmployeeDAO 
{
	
	void saveEmployee(Employee employee);
	Employee getEmployeeById(int id);
	Employee getEmployeeByEmail(String email);
	Employee updateEmployeeById(int id, Employee empl);
	void deleteEmployeeById(int id);
	boolean login(String userName, String password);
	
}
