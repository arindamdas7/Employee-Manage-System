package com.ems;


import java.util.Scanner;

import javax.swing.JOptionPane;

import com.ems.service.AdminService;
import com.ems.serviceimpl.AdminServiceImpl;
import com.ems.service.EmployeeService;
import com.ems.service.ManagerService;
import com.ems.serviceimpl.EmployeeServiceImpl;
import com.ems.serviceimpl.ManagerServiceImpl;


public class App 
{
	static AdminService adminService = new AdminServiceImpl();
	static EmployeeService empService = new EmployeeServiceImpl();
	static ManagerService mgrService = new ManagerServiceImpl();
	static Scanner sc = new Scanner(System.in);
	
    public static void main( String[] args )
    {
    	mainMenu();
    }
    
    public static void mainMenu()
    {
    	
    	int ch;
    	do 
    	{
    		System.out.println("=============================================");
    		System.out.println(" ---Welcome to Employee Management System---");
    		System.out.println("=============================================");
    		System.out.println("1) Admin\n2) Employee\n3) Manager\n4) Exit");
    		System.out.println("=============================================");
    		ch = Integer.parseInt(JOptionPane.showInputDialog("Enter choice: ","Type here"));
    		switch(ch)
    		{
    			case 1:
    				mainAdmin();
    				break;
    			case 2:
    				mainUser();
    				break;
    			case 3:
    				mainManager();
    				break;
    			case 4:
    				System.exit(0);
    				break;
    			default:
    				System.out.println("Wrong Input!!");	
    		}
    	}while(ch!=3);
    }
    
    
    //main menu for user/employee
    public static void mainUser()
    {
    	do 
    	{
    		System.out.println("===============================");
    		System.out.println("---------Employee Menu---------");
    		System.out.println("===============================");
    		System.out.println("A) Log In\n"
    				+ "B) Exit");
    		System.out.println("===============================");
    		String choice = JOptionPane.showInputDialog("Enter choice: ","Type here...");
    		switch(choice)
    		{

    			case "A":
    				boolean status=empService.login(JOptionPane.showInputDialog
    					("Enter user_name:","Type here.."), 
    					JOptionPane.showInputDialog("Enter password:","Type here.."));
    				if(status==true)
    				{
    					EmployeeCRUD.afterLoginAdmin();
    				}
    				else
    				{
    					JOptionPane.showMessageDialog(null, "Wrong Credentials");
    				}
    				break;
    	
    			case "B":
    				mainMenu();
    				break;
    			default:
    				System.out.println("Wrong Input!!");
 
    		}
    	}while(true);
    }
    
    //main menu for admin
    public static void mainAdmin()
    {
    	do 
    	{
    		System.out.println("============================");
    		System.out.println("---------Admin Menu---------");
    		System.out.println("============================");
    		System.out.println("A) LogIn\nB) Exit");
    		System.out.println("============================");
    		String choice = JOptionPane.showInputDialog("Enter choice: ","Type here...");
    		switch(choice)
    		{
    		
    			case "A":
    				boolean status=adminService.login(JOptionPane.showInputDialog
    					("Enter user_name:","Type here.."), 
    					JOptionPane.showInputDialog("Enter password:","Type here.."));
    				if(status==true)
    				{
    					AdminCRUD.afterLoginAdmin();
    				}
    				else
    				{
    					JOptionPane.showMessageDialog(null, "Wrong Credentials");
    				}
    				break;
    	
    			case "B":
    				mainMenu();
    				break;
    			default:
    				System.out.println("Wrong Input!!");
    				
    		
    		}
    	}while(true);
    }
    
    //main menu for manager
    public static void mainManager()
    {
    	do 
    	{
    		System.out.println("==============================");
    		System.out.println("---------Manager Menu---------");
    		System.out.println("==============================");
    		System.out.println("A) LogIn\nB) Exit");
    		System.out.println("==============================");
    		String choice = JOptionPane.showInputDialog("Enter choice: ","Type here...");
    		switch(choice)
    		{
    		
    			case "A":
    				boolean status=mgrService.login(JOptionPane.showInputDialog
    					("Enter user_name:","Type here.."), 
    					JOptionPane.showInputDialog("Enter password:","Type here.."));
    				if(status==true)
    				{
    					ManagerCRUD.afterLoginAdmin();
    				}
    				else
    				{
    					JOptionPane.showMessageDialog(null, "Wrong Credentials");
    				}
    				break;
    	
    			case "B":
    				mainMenu();
    				break;
    		
    		}
    	}while(true);
    }
    
}
