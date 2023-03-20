package com.ems.serviceimpl;

import org.modelmapper.ModelMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.ems.dao.DepartmentDAO;
import com.ems.daoimpl.DepartmentDAOImpl;
import com.ems.entity.Department;
import com.ems.exception.GlobalException;
import com.ems.model.DepartmentDTO;
import com.ems.service.DepartmentService;

public class DepartmentServiceImpl implements DepartmentService
{
	private static final Logger log = LoggerFactory.getLogger(EmployeeServiceImpl.class);
	
		//accessing the Data Access Layer(DAO) to call the methods
	DepartmentDAO departmentDAO = new DepartmentDAOImpl();
	
	@Override
	public void saveDepartment(Department dept) 
	{
		log.info("New Department Details Added." + dept.toString());    //log will add this line in logger when new employee added
		departmentDAO.saveDepartment(dept);
	}
	  
	@Override
	public DepartmentDTO getDepartmentById(int deptId) 
	{
		Department dept = departmentDAO.getDepartmentById(deptId);
	    if(dept!=null) 
	    {
	    	log.info("Department with id: "+ deptId + " was retrieved");    //log will add this in logger when accessing any employee
	    	return new ModelMapper().map(dept, DepartmentDTO.class);
	    }
	    else
	    {
	    	throw new GlobalException("Department Details Not Found!!!");
	    }
	}

	@Override
	public DepartmentDTO updateDepartment(int deptId, Department department) 
	{
	    Department dept = departmentDAO.updateDepartment(deptId, department);
	    if(dept!=null)
	    {
	    	log.info("Department with id: "+ deptId +" was updated successfully" +department.toString());
	    	return new ModelMapper().map(dept, DepartmentDTO.class);
	    }
	    else 
	    {
	    	throw new GlobalException("Department ID: " + deptId + " not found!!!");
	    }
	}
	  
	@Override
	public void assignEmpToDept(int empId, int deptId)
	{
		log.info("Assign Employee "+ empId +" to the Department " +deptId);
		departmentDAO.assignEmpToDept(empId, deptId);
	}

	@Override
	public void assignMgrToDept(int mgrId, int deptId)
	{
		log.info("Assign Manager "+ mgrId +" to the Department " +deptId);
		departmentDAO.assignMgrToDept(mgrId, deptId);
		
	}

	@Override
	public void deleteDepartmentById(int id) 
	{
		log.info("Delete Department info successfully!!");
		departmentDAO.deleteDepartmentById(id);
		
	}

}
