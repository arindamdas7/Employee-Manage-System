package com.ems.dao;

import com.ems.entity.Department;

public interface DepartmentDAO 
{
	
	void saveDepartment(Department dept);
	Department getDepartmentById(int deptId);
	Department updateDepartment(int deptId, Department department);
	void assignEmpToDept(int employeeId, int deptId);
	void assignMgrToDept(int mgrId, int deptId);
	void deleteDepartmentById(int id);
}
