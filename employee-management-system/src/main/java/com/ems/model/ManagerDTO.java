package com.ems.model;

import java.util.List;

import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class ManagerDTO 
{
	
	private String mgrName;
	private String mgrAddress;
	private double mgrSalary;
	private String mgrContact;
	private String mgrEmail;
	private int mgrTotalEmp;
	
	private List<EmployeeDTO> employee;
	
}
