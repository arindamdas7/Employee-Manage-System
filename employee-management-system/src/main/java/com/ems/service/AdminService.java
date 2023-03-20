package com.ems.service;

import com.ems.entity.Admin;
import com.ems.model.AdminDTO;

public interface AdminService 
{
	void saveAdmin(Admin admin);
	AdminDTO getAdminById(int admId);
	AdminDTO updateAdminById(int admId, Admin adm);
	void deleteAdminById(int admId);
	boolean login(String userName, String password);
}
