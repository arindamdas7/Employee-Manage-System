package com.ems.entity;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.OneToMany;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Entity
@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
@ToString
@Builder
public class Manager extends User
{
	
	@Column(length=30, nullable = false)
	private String mgrName;
	@Column(length=30, nullable = false)
	private String mgrAddress;
	@Column(length=20, nullable = false)
	private double mgrSalary;
	@Column(length=10, nullable = false)
	private String mgrContact;
	@Column(length=50, nullable = false, unique = true)
	private String mgrEmail;
	@Column(name="mgr_total_employees", length=10)
	private int mgrTotalEmp;
	
	@OneToMany
	private List<Employee> employee;
	
}
