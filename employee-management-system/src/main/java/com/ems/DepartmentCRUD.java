package com.ems;

import java.util.Scanner;

import javax.swing.JOptionPane;

import com.ems.entity.Department;
import com.ems.exception.GlobalException;
import com.ems.model.DepartmentDTO;
import com.ems.service.DepartmentService;
import com.ems.serviceimpl.DepartmentServiceImpl;

public class DepartmentCRUD 
{
	static Scanner sc = new Scanner(System.in);
	static DepartmentService deptService = new DepartmentServiceImpl();
	
	public static void saveDepartment()
	{
		Department dept = new Department();
		
		String deptName = JOptionPane.showInputDialog("Enter Department name:","Type here..");
		String location = JOptionPane.showInputDialog("Enter location:","Type here..");
		
		dept.setDeptName(deptName);
		dept.setTotalEmp(0);
		dept.setLocation(location);
		
		deptService.saveDepartment(dept);
		System.out.println("Department details saved!!");
	}
	
	public static void getDepartment() throws GlobalException 
	{
		int id = Integer.parseInt(JOptionPane.showInputDialog("Enter ID to search Details: ", "Enter ID Here..."));
		DepartmentDTO dept1 = deptService.getDepartmentById(id);
		
		System.out.println("======================================");
		System.out.println("Department Name: " + dept1.getDeptName());
		System.out.println("Total Employee: " + dept1.getTotalEmp());
		System.out.println("Location: " + dept1.getLocation());
		System.out.println("======================================");
		
	}
	
	public static void updateDepartment() throws GlobalException
	{
		int deptId = Integer.parseInt(JOptionPane.showInputDialog("Enter ID to Update Details: ", "Enter ID Here..."));
		Department dept2 = new Department();
		

		String deptName = JOptionPane.showInputDialog("Enter Department name:","Type here..");
		String location = JOptionPane.showInputDialog("Enter Department location:","Type here..");
		
		dept2.setDeptName(deptName);
		dept2.setTotalEmp(0);
		dept2.setLocation(location);
		
		deptService.saveDepartment(dept2);
		System.out.println("Department details updated successfully!!");
		
	}
	
	public static void assignEmpToDept()
	{
		int deptId = Integer.parseInt(JOptionPane.showInputDialog("Enter Department ID: ","Type Here"));
		int empId = Integer.parseInt(JOptionPane.showInputDialog("Enter Employee ID: ","Type Here"));
		
		deptService.assignEmpToDept(empId, deptId);
		JOptionPane.showMessageDialog(null, "Employee Has been Assigned Succesfully with A Department");
	}
	
	public static void assignMgrToDept()
	{
		int deptId = Integer.parseInt(JOptionPane.showInputDialog("Enter Department ID: ","Type Here"));
		int mgrId = Integer.parseInt(JOptionPane.showInputDialog("Enter Manager ID: ","Type Here"));
		
		deptService.assignMgrToDept(mgrId, deptId);
		JOptionPane.showMessageDialog(null, "Manager Has been Assigned Succesfully with A Department");
	}
	
	public static void deleteEmployee()
	{
		int id = Integer.parseInt(JOptionPane.showInputDialog("Enter Department ID to Delete", "Tpe ID Here"));
		deptService.deleteDepartmentById(id);
	}
}
