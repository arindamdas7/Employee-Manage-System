package com.ems.serviceimpl;

import org.modelmapper.ModelMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.ems.dao.EmployeeDAO;
import com.ems.daoimpl.EmployeeDAOImpl;
import com.ems.entity.Employee;
import com.ems.exception.GlobalException;
import com.ems.model.EmployeeDTO;
import com.ems.service.EmployeeService;

public class EmployeeServiceImpl implements EmployeeService
{
	private static final Logger log = LoggerFactory.getLogger(EmployeeServiceImpl.class);
	
	//accessing the Data Access Layer(DAO) to call the methods
	EmployeeDAO employeeDAO = new EmployeeDAOImpl();
	
	@Override
	public void saveEmployee(Employee employee) 
	{
		log.info("New Employee Details Added." + employee.toString());    //log will add this line in logger when new employee added
	    employeeDAO.saveEmployee(employee);
	}
	  
	@Override
	public EmployeeDTO getEmployeeById(int id) 
	{
	    Employee employee = employeeDAO.getEmployeeById(id);
	    if(employee!=null) 
	    {
	    	log.info("Employee with id: "+ id + " was retrieved ");    //log will add this in logger when accessing any employee
	    	return new ModelMapper().map(employee, EmployeeDTO.class);
	    }
	    else 
	    {
	    	throw new GlobalException("Employee Details Not Found!!!");
	    }
	}

	@Override
	public EmployeeDTO updateEmployeeById(int id, Employee employee) 
	{
		Employee emp = employeeDAO.updateEmployeeById(id, employee);
	    if(emp!=null) 
	    {
	    	log.info("Employee with id: "+ id+ "was updated successfully" +employee.toString());
	    	return new ModelMapper().map(emp, EmployeeDTO.class);
	    }
	    else 
	    {
	    	throw new GlobalException("Employee ID: " + id + " not found!!!");
	    }
	}

	@Override
	public void deleteEmployeeById(int id)
	{
		log.info("Delete Employee details successfully");
		employeeDAO.deleteEmployeeById(id);
	}

	@Override
	public EmployeeDTO getEmployeeByEmail(String email) 
	{
		log.info("Employee with email: "+ email +" was retrived");
		Employee emp = employeeDAO.getEmployeeByEmail(email);
	    if(emp!=null)
	    {
	    	return new ModelMapper().map(emp, EmployeeDTO.class);
	    }
	    else
	    {
	    	throw new GlobalException("Employee Details with email: " + email + " Not Found!!!");
	    }
	}

	@Override
	public boolean login(String userName, String password)
	{
		return employeeDAO.login(userName, password);
	}
}
