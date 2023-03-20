package com.ems;

import javax.swing.JOptionPane;

import com.ems.entity.Admin;
import com.ems.exception.GlobalException;
import com.ems.model.AdminDTO;
import com.ems.service.AdminService;
import com.ems.serviceimpl.AdminServiceImpl;

public class AdminCRUD 
{

	static AdminService adminService = new AdminServiceImpl();
	
	public static void saveAdmin()
	{
		Admin admin = new Admin();
		String name = JOptionPane.showInputDialog("Enter admin name:","Type here..");
		String email = JOptionPane.showInputDialog("Enter email:","Type here..");
		String user = JOptionPane.showInputDialog("Enter user_name:","Type here..");
		String pass = JOptionPane.showInputDialog("Enter password:","Type here..");
		
		admin.setAdminName(name);
		admin.setAdminEmail(email);
		admin.setUserName(user);
		admin.setPassword(pass);
		admin.setRole("admin");
		
		adminService.saveAdmin(admin);
		System.out.println("New admin details has been added!");
		
	}
	
	public static void getAdmin() throws GlobalException
	{
		int id = Integer.parseInt(JOptionPane.showInputDialog("Enter ID to search Details: ", "Enter ID Here..."));
		AdminDTO adm1 = adminService.getAdminById(id);
		
		System.out.println("=======================================");
		System.out.println("Employee Name: " + adm1.getAdminName());
		System.out.println("Employee Address: " + adm1.getAdminName());
		System.out.println("=======================================");
	}
	
	public static void updateAdmin() throws GlobalException
	{
		
		int id = Integer.parseInt(JOptionPane.showInputDialog("Enter ID to Update Details: ", "Enter ID Here..."));
		Admin adm2 = new Admin();
		
		String name = JOptionPane.showInputDialog("Enter admin name:","Type here..");
		String email = JOptionPane.showInputDialog("Enter email:","Type here..");
		String user = JOptionPane.showInputDialog("Enter user_name:","Type here..");
		String pass = JOptionPane.showInputDialog("Enter password:","Type here..");
		
		adm2.setAdminName(name);
		adm2.setAdminEmail(email);
		adm2.setUserName(user);
		adm2.setPassword(pass);
		adm2.setRole("admin");
		
		adminService.saveAdmin(adm2);
		System.out.println("Admin details has been updated successfully!");
		
	}
	
	public static void deleteAdmin()
	{
		int id = Integer.parseInt(JOptionPane.showInputDialog("Enter Admin ID to Delete", "Tpe ID Here"));
		adminService.deleteAdminById(id);
	}
	
	
	public static void login()
	{
		
		adminService.login(JOptionPane.showInputDialog("Enter user_name:","Type here.."), 
				JOptionPane.showInputDialog("Enter password:","Type here.."));
	}
	
	public static void afterLoginAdmin()
    {
		do 
		{
    	System.out.println("===========================================================");
      	System.out.println("A) To check the Admin details using Id\nB) To update Admin details\n"
      			+ "C) To delete an Admin\n\nD) To check the Employee details using Id\n"
      			+ "E) To check the Employee details using Email\n"
      			+ "F) To update Employee details\nG) To delete an Employee\n\n"
      			+ "H) To check the Manager details using Id\nI) Assign Employee to Manager\n"
      			+ "J) To update Manager details\n"
      			+ "K) To delete an Manager\n\nL) Save new Department\n"
      			+ "M) To check Department details using ID\n"
      			+ "N) Assign Employee to Department\nO) To update Department details\n"
      			+ "P) Assign Manager to department\n"
      			+ "Q) To delete Department details\n\n"
      			+ "R) Exit");
      	System.out.println("===========================================================");
      	String choice = JOptionPane.showInputDialog("Enter choice: ","Type here...");
    	switch(choice)
    	{
    		case "A":
    			AdminCRUD.getAdmin();
    			break;
    		
    		case "B":
    			AdminCRUD.updateAdmin();
    			break;
    	
    		case "C":
    			AdminCRUD.deleteAdmin();
    			break;
    		
    		case "D":
    			EmployeeCRUD.getEmployee();
    			break;
    		
    		case "E":
    			EmployeeCRUD.getEmployeeByEmail();
    			break;
    		
    		case "F":
    			EmployeeCRUD.updateEmployee();
    			break;
    		
    		case "G":
    			EmployeeCRUD.deleteEmployee();
    			break;
    		
    		case "H":
    			ManagerCRUD.getManager();
    			break;
    			
    		case "I":
    			ManagerCRUD.assignEmpToMgr();
    			break;
    		
    		case "J":
    			ManagerCRUD.updateManager();
    			break;
    		
    		case "K":
    			ManagerCRUD.deleteEmployee();
    			break;
    		
    		case "L":
    			DepartmentCRUD.saveDepartment();
    			break;
    		
    		case "M":
    			DepartmentCRUD.getDepartment();
    			break;
    		
    		case "N":
    			DepartmentCRUD.assignEmpToDept();
    			break;
    		
    		case "O":
    			DepartmentCRUD.updateDepartment();
    			break;
    			
    		case "P":
    			DepartmentCRUD.assignMgrToDept();
    			break;
    		
    		case "Q":
    			DepartmentCRUD.deleteEmployee();
    			break;
    		
    		case "R":
    			App.mainAdmin();
    			break;
    			
    		default:
				System.out.println("Wrong Input!!");
    		
    		}
		}while(true);
    }
}

