package com.ems.service;

import com.ems.entity.Department;
import com.ems.model.DepartmentDTO;

public interface DepartmentService 
{
	void saveDepartment(Department dept);
	DepartmentDTO getDepartmentById(int deptId);
	DepartmentDTO updateDepartment(int deptId, Department department);
	void assignEmpToDept(int empId, int deptId);
	void assignMgrToDept(int mgrId, int deptId);
	void deleteDepartmentById(int id);
}
