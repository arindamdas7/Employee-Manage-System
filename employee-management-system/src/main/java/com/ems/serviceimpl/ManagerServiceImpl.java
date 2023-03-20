package com.ems.serviceimpl;

import org.modelmapper.ModelMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.ems.dao.ManagerDAO;
import com.ems.daoimpl.ManagerDAOImpl;
import com.ems.entity.Manager;
import com.ems.exception.GlobalException;
import com.ems.model.ManagerDTO;
import com.ems.service.ManagerService;

public class ManagerServiceImpl implements ManagerService
{
	private static final Logger log = LoggerFactory.getLogger(EmployeeServiceImpl.class);
	
	//accessing the Data Access Layer(DAO) to call the methods
	ManagerDAO managerDAO = new ManagerDAOImpl();

	@Override
	public void saveManager(Manager mgr) 
	{
		log.info("New Department Details Added." + mgr.toString());    //log will add this line in logger when new employee added
		managerDAO.saveManager(mgr);
	}
  
	@Override
	public ManagerDTO getManagerById(int mgrId) 
	{
		Manager mgr = managerDAO.getManagerById(mgrId);
		if(mgr!=null) 
		{
			log.info("Manager with id: "+ mgrId + " was retrieved ");    //log will add this in logger when accessing any employee
			return new ModelMapper().map(mgr, ManagerDTO.class);
		}
		else
		{
			throw new GlobalException("Department Details Not Found!!!");
		}
	}

	@Override
	public ManagerDTO updateManagerById(int mgrId, Manager mgr1) 
	{
		Manager mgr = managerDAO.updateManagerById(mgrId, mgr1);
		if(mgr!=null)
		{
			log.info("Manager with id: "+ mgrId +"was updated successfully" + mgr.toString());
			return new ModelMapper().map(mgr, ManagerDTO.class);
		}
		else 
		{
			throw new GlobalException("Manager ID: " + mgrId + " not found!!!");
		}
	}
  
	@Override
	public void assignEmpToMgr(int empId, int mgrId)
	{
		log.info("Assign Employee "+ empId +" to the Manager " +mgrId);
		managerDAO.assignEmpToMgr(empId, mgrId);
	}

	@Override
	public boolean login(String userName, String password)
	{
		return managerDAO.login(userName, password);
	}

	@Override
	public void deleteManagerById(int mgrId)
	{
		log.info("Delete Manager info successfully!!");
		managerDAO.deleteManagerById(mgrId);
	
	}
	
}
