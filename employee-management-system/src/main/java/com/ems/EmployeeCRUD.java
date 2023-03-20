package com.ems;

import java.time.LocalDate;
import java.util.Scanner;

import javax.swing.JOptionPane;

import com.ems.entity.Employee;
import com.ems.exception.GlobalException;
import com.ems.model.EmployeeDTO;
import com.ems.service.EmployeeService;
import com.ems.serviceimpl.EmployeeServiceImpl;

public class EmployeeCRUD 
{

	static Scanner sc = new Scanner(System.in);
	static EmployeeService empService = new EmployeeServiceImpl();
	
	public static void saveEmployee()
	{
		Employee emp = new Employee();

		String name = JOptionPane.showInputDialog("Enter Employee name:","Type here..");
		String add = JOptionPane.showInputDialog("Enter Employee address:","Type here..");
		Double sal = Double.parseDouble(JOptionPane.showInputDialog("Enter Employee Salary:","Type here.."));
		String cont = JOptionPane.showInputDialog("Enter Employee phone no.:","Type here..");
		String email = JOptionPane.showInputDialog("Enter Employee email:","Type here..");
		String des = JOptionPane.showInputDialog("Enter Employee designation:","Type here..");
		LocalDate date = LocalDate.parse(JOptionPane.showInputDialog("Enter Employee D.O.J:","Type here.."));
		String user = JOptionPane.showInputDialog("Enter Employee user-name:","Type here..");
		String pass = JOptionPane.showInputDialog("Enter Employee password:","Type here..");
		
		emp.setEmpName(name);
		emp.setEmpAddress(add);
		emp.setSalary(sal);
		emp.setContact(cont);
		emp.setEmail(email);
		emp.setDesignation(des);
		emp.setDOJ(date);
		emp.setUserName(user);
		emp.setPassword(pass);
		emp.setRole("employee");
		
		empService.saveEmployee(emp);
		System.out.println("Employee details saved!!");

	}
	
	public static void getEmployee() throws GlobalException 
	{
		int id = Integer.parseInt(JOptionPane.showInputDialog("Enter ID to search Details: ", "Enter ID Here..."));
		EmployeeDTO emp1 = empService.getEmployeeById(id);
		
		System.out.println("==========================================");
		System.out.println("Employee Name: " + emp1.getEmpName());
		System.out.println("Employee Address: " + emp1.getEmpAddress());
		System.out.println("Employee Salary: " + emp1.getSalary());
		System.out.println("Employee Contact: " + emp1.getContact());
		System.out.println("Employee Email: " + emp1.getEmail());
		System.out.println("Employee Designation: " + emp1.getDesignation());
		System.out.println("Employee D.O.J: " + emp1.getDOJ());
		System.out.println("==========================================");
		
	}
	
	public static void updateEmployee() throws GlobalException
	{
		
		int id = Integer.parseInt(JOptionPane.showInputDialog("Enter ID to Update Details: ", "Enter ID Here..."));
		Employee emp2 = new Employee();
		
		String name = JOptionPane.showInputDialog("Enter Name: ", "Type Here");
		String add = JOptionPane.showInputDialog("Enter Address: ", "Type Here");
		Double sal = Double.parseDouble(JOptionPane.showInputDialog("Enter Salary: ", "Type Here"));
		String cont = JOptionPane.showInputDialog("Enter Phone Number: ", "Type Here");
		String email = JOptionPane.showInputDialog("Enter Email: ", "Type Here");
		String des = JOptionPane.showInputDialog("Enter Designation: ", "Type Here");
		LocalDate date = LocalDate.parse(JOptionPane.showInputDialog("Enter Date: ", "yyyy-mm-dd"));
		String user = JOptionPane.showInputDialog("Enter User-Name: ", "Type Here");
		String pass = JOptionPane.showInputDialog("Enter Password: ", "Type Here");
		
		emp2.setEmpName(name);
		emp2.setEmpAddress(add);
		emp2.setSalary(sal);
		emp2.setContact(cont);
		emp2.setEmail(email);
		emp2.setDesignation(des);
		emp2.setDOJ(date);
		emp2.setUserName(user);
		emp2.setPassword(pass);
		emp2.setRole("employee");
		
		empService.updateEmployeeById(id, emp2);
		System.out.println("\nDetails Updated Successfully...\n");
	}
	
	public static void deleteEmployee()
	{
		int id = Integer.parseInt(JOptionPane.showInputDialog("Enter Employee ID to Delete", "Tpe ID Here"));
		empService.deleteEmployeeById(id);
	}
	
	public static void getEmployeeByEmail()
	{
		String email = JOptionPane.showInputDialog("Enter email to search","Type here..");
		EmployeeDTO emps=empService.getEmployeeByEmail(email);

		
		System.out.println("Employee Name: " + emps.getEmpName());
		System.out.println("Employee Address: " + emps.getEmpAddress());
		System.out.println("Employee Salary: " + emps.getSalary());
		System.out.println("Employee Contact: " + emps.getContact());
		System.out.println("Employee Email: " + emps.getEmail());
		System.out.println("Employee Designation: " + emps.getDesignation());
		System.out.println("Employee D.O.J: " + emps.getDOJ());
		
	}
	
	public static void login()
	{
		
		empService.login(JOptionPane.showInputDialog("Enter user_name:","Type here.."), 
				JOptionPane.showInputDialog("Enter password:","Type here.."));
		
	}
	
	public static void afterLoginAdmin()
    {
		do
		{
			System.out.println("======================================================");
			System.out.println("P) Save New Employee\nQ) Read Employee Details Using ID\n"
					+ "R) Read Employee Details Using Email\n"
					+ "S) Update Own Details\n"
					+ "T) Exit");
			System.out.println("======================================================");
			String choice = JOptionPane.showInputDialog("Enter choice: ","Type here...");
			switch(choice)
			{
				case "Q":
					EmployeeCRUD.getEmployee();
					break;
    		
				case "R":
					EmployeeCRUD.getEmployeeByEmail();
					break;
    	
				case "S":
					EmployeeCRUD.updateEmployee();
					break;
    		
				case "T":
					App.mainUser();
					break;
					
				default:
    				System.out.println("Wrong Input!!");
  
			}
		}while(true);
    }
}
