package com.ems.dao;

import com.ems.entity.Manager;

public interface ManagerDAO 
{
	void saveManager(Manager mgr);
	Manager getManagerById(int mgrId);
	Manager updateManagerById(int mgrId, Manager mgr1);
	void deleteManagerById(int mgrId);
	void assignEmpToMgr(int empId, int mgrId);
	boolean login(String userName, String password);
	
}
