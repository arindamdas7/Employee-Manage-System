package com.ems;

import java.util.Scanner;

import javax.swing.JOptionPane;

import com.ems.entity.Manager;
import com.ems.exception.GlobalException;
import com.ems.model.ManagerDTO;
import com.ems.service.ManagerService;
import com.ems.serviceimpl.ManagerServiceImpl;

public class ManagerCRUD
{
	static Scanner sc = new Scanner(System.in);
	static ManagerService mgrService = new ManagerServiceImpl();
	
	public static void saveManager()
	{
		Manager mgr = new Manager();
		
		String name = JOptionPane.showInputDialog("Enter Manager name:","Type here..");
		String add = JOptionPane.showInputDialog("Enter Manager address:","Type here..");
		Double sal = Double.parseDouble(JOptionPane.showInputDialog("Enter Manager Salary:","Type here.."));
		String cont = JOptionPane.showInputDialog("Enter Manager phone no.:","Type here..");
		String email = JOptionPane.showInputDialog("Enter Manager email:","Type here..");
		String user = JOptionPane.showInputDialog("Enter Manager user-name:","Type here..");
		String pass = JOptionPane.showInputDialog("Enter Manager password:","Type here..");
		
		mgr.setMgrName(name);
		mgr.setMgrAddress(add);
		mgr.setMgrSalary(sal);
		mgr.setMgrContact(cont);
		mgr.setMgrEmail(email);
		mgr.setUserName(user);
		mgr.setPassword(pass);
		mgr.setRole("manager");
		
		mgrService.saveManager(mgr);
		System.out.println("Manager details saved!!");
		
	}
	
	public static void getManager() throws GlobalException 
	{
		int id = Integer.parseInt(JOptionPane.showInputDialog("Enter ID to search Details: ", "Enter ID Here..."));
		ManagerDTO mgr1 = mgrService.getManagerById(id);
		
		System.out.println("=====================================");
		System.out.println("Manager Name: " + mgr1.getMgrName());
		System.out.println("Manager Address: " + mgr1.getMgrAddress());
		System.out.println("Manager Salary: " + mgr1.getMgrSalary());
		System.out.println("Manager Contact: " + mgr1.getMgrContact());
		System.out.println("Manager Email: " + mgr1.getMgrEmail());
		System.out.println("=====================================");
		
	}
	
	public static void updateManager() throws GlobalException
	{
		
		int id = Integer.parseInt(JOptionPane.showInputDialog("Enter ID to Update Details: ", "Enter ID Here..."));
		
		Manager mgr2 = new Manager();
		
		String name = JOptionPane.showInputDialog("Enter Manager name:","Type here..");
		String add = JOptionPane.showInputDialog("Enter Manager address:","Type here..");
		Double sal = Double.parseDouble(JOptionPane.showInputDialog("Enter Manager Salary:","Type here.."));
		String cont = JOptionPane.showInputDialog("Enter Manager phone no.:","Type here..");
		String email = JOptionPane.showInputDialog("Enter Manager email:","Type here..");
		String user = JOptionPane.showInputDialog("Enter Manager user-name:","Type here..");
		String pass = JOptionPane.showInputDialog("Enter Manager password:","Type here..");
		
		mgr2.setMgrName(name);
		mgr2.setMgrAddress(add);
		mgr2.setMgrSalary(sal);
		mgr2.setMgrContact(cont);
		mgr2.setMgrEmail(email);
		mgr2.setUserName(user);
		mgr2.setPassword(pass);
		mgr2.setRole("manager");
		
		mgrService.saveManager(mgr2);
		System.out.println("Manager details updated successfully!!");
	}
	
	public static void assignEmpToMgr()
	{
		int mgrId = Integer.parseInt(JOptionPane.showInputDialog("Enter Manager ID: ","Type Here"));
		int empId = Integer.parseInt(JOptionPane.showInputDialog("Enter Employee ID: ","Type Here"));
		
		mgrService.assignEmpToMgr(empId, mgrId);
		JOptionPane.showMessageDialog(null, "Employee Has been Assigned Succesfully with A Manager");
	}
	
	public static void deleteEmployee()
	{
		int id = Integer.parseInt(JOptionPane.showInputDialog("Enter Manager ID to Delete", "Tpe ID Here"));
		mgrService.deleteManagerById(id);
	}
	public static void login()
	{

		mgrService.login(JOptionPane.showInputDialog("Enter user_name:","Type here.."), 
				JOptionPane.showInputDialog("Enter password:","Type here.."));
	}
	
	public static void afterLoginAdmin()
    {
		do 
		{
			System.out.println("==========================================");
			System.out.println("D) Save New Manager\nE) Read The Manager Details\n"
					+ "F) Update Manager Details\n"
					+ "G) Assign Employee to Manager\n"
					+ "H) Exit");
			System.out.println("==========================================");
			String choice = JOptionPane.showInputDialog("Enter choice: ","Type here...");
			switch(choice)
			{
				case "E":
					ManagerCRUD.getManager();
					break;
    		
				case "F":
					ManagerCRUD.updateManager();
					break;
    	
				case "G":
					ManagerCRUD.assignEmpToMgr();
					break;
    		
				case "H":
					App.mainManager();
					break;
					
				default:
    				System.out.println("Wrong Input!!");
    		
			}
		}while(true);
    }
	
}
