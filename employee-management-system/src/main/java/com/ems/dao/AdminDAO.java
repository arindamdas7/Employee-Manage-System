package com.ems.dao;

import com.ems.entity.Admin;

public interface AdminDAO
{
	void saveAdmin(Admin admin);
	Admin getAdminById(int admId);
	Admin updateAdminById(int admId, Admin adm);
	void deleteAdminById(int admId);
	boolean login(String userName, String password);
}
