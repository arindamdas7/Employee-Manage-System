package com.ems.serviceimpl;

import org.modelmapper.ModelMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.ems.dao.AdminDAO;
import com.ems.daoimpl.AdminDAOImpl;
import com.ems.entity.Admin;
import com.ems.exception.GlobalException;
import com.ems.model.AdminDTO;
import com.ems.service.AdminService;

public class AdminServiceImpl implements AdminService
{
	
	private static final Logger log = LoggerFactory.getLogger(EmployeeServiceImpl.class);
	AdminDAO adminDAO = new AdminDAOImpl();
	
	@Override
	public void saveAdmin(Admin admin)
	{

	    log.info("New Admin Details Added." + admin.toString()); 
		adminDAO.saveAdmin(admin);
		
	}
	

	@Override
	public boolean login(String userName, String password)
	{
		return adminDAO.login(userName, password);
	}


	@Override
	public AdminDTO getAdminById(int admId)
	{
		Admin admin = adminDAO.getAdminById(admId);
	    if(admin!=null) 
	    {
	    	log.info("Admin with id: "+ admId + " was retrieved");    //log will add this in logger when accessing any employee
	    	return new ModelMapper().map(admin, AdminDTO.class);
	    }
	    else
	    {
	    	throw new GlobalException("Admin Details Not Found!!!");
	    }
	}


	@Override
	public AdminDTO updateAdminById(int admId, Admin adm)
	{
		Admin admin = adminDAO.updateAdminById(admId, adm);
	    if(admin!=null)
	    {
	    	log.info("Admin with id "+ admId +" was updated successfully "+adm.toString());
	    	return new ModelMapper().map(admin, AdminDTO.class);
	    }
	    else 
	    {
	    	throw new GlobalException("Admin ID: " + admId + " not found!!!");
	    }
	}


	@Override
	public void deleteAdminById(int admId)
	{
		log.info("Delete Admin info successfully!!");
		adminDAO.deleteAdminById(admId);
		
	}

}
