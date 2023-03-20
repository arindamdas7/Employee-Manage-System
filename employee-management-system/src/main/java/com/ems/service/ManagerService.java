package com.ems.service;


import com.ems.entity.Manager;
import com.ems.model.ManagerDTO;

public interface ManagerService 
{
	void saveManager(Manager mgr);
	ManagerDTO getManagerById(int mgrId);
	ManagerDTO updateManagerById(int mgrId, Manager mgr1);
	void deleteManagerById(int mgrId);
	void assignEmpToMgr(int empId, int mgrId);
	boolean login(String userName, String password);
}
