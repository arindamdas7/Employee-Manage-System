package com.ems.entity;

import java.time.LocalDate;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.ManyToOne;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Employee extends User
{

	@Column(length=30, nullable = false)
	private String empName;
	@Column(length=30, nullable = false)
	private String empAddress;
	@Column(length=20, nullable = false)
	private double salary;
	@Column(length=10, nullable = false)
	private String contact;
	@Column(length=50, nullable = false, unique = true)
	private String email;
	@Column(length=30, nullable = false)
	private String designation;
	@Column(nullable = false)
	private LocalDate DOJ;
	
	@ManyToOne
	private Department dept;
	
	@ManyToOne
	private Manager mgr;
	
}
