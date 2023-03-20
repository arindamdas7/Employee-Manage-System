package com.ems.servicetest;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

import java.time.LocalDate;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.MethodOrderer;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;

import com.ems.config.HibernateUtil;
import com.ems.entity.Employee;
import com.ems.exception.GlobalException;
import com.ems.model.EmployeeDTO;
import com.ems.service.EmployeeService;
import com.ems.serviceimpl.EmployeeServiceImpl;

@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
class EmployeeServiceTest 
{

	EmployeeService empService = new EmployeeServiceImpl();
	
	private static SessionFactory sessionFactory;
	private Session session;
	
	@BeforeAll
	static void setUpBeforeClass() throws Exception 
	{
		sessionFactory= HibernateUtil.getSessionFactory();
	}

	@AfterAll
	static void tearDownAfterClass() throws Exception 
	{
		if(sessionFactory!=null)
			sessionFactory.close();
		System.out.println("Session Factory Closed!");
	}

	@BeforeEach
	void setUp() throws Exception 
	{
		session = sessionFactory.openSession();
	}

	@AfterEach
	void tearDown() throws Exception 
	{
		if(session!=null)
			session.close();
		System.out.println("Session Closed!");
	}
	
	@Test
	@DisplayName("Testing save employee")
	@Order(1)
	void testSaveEmployee()
	{
		Transaction tx=session.beginTransaction();
		Employee emp = Employee.builder().empName("Arijit").empAddress("Kolkata").salary(25000).
				contact("9876543210").designation("Developer").email("arijit@gmail.com").
				DOJ(LocalDate.parse("2023-05-23")).build();
		empService.saveEmployee(emp);
		tx.commit();
		assertEquals("Arijit", emp.getEmpName());
		
	}
	
	@Test
	@DisplayName("Testing getting employee using id")
	@Order(2)
	void testGetEmpById()
	{
		EmployeeDTO eDTO=empService.getEmployeeById(10);
		assertThat(eDTO.getEmpName()).isEqualTo("Arijit");
	}

	@Test
	@Order(3)
	void testUpdateEmployee()
	{
		Employee emp = new Employee();
		emp.setEmpName("Arijit Das");
		emp.setEmpAddress("Midnapore");
		emp.setContact("9876543211");
		emp.setDesignation("Java Developer");
		emp.setEmail("arijitdas@gmail.com");
		emp.setDOJ(LocalDate.parse("2023-05-23"));
		emp.setPassword("arijit123");
		emp.setUserName("arijit");
		emp.setRole("employee");
		
		EmployeeDTO eDTO=empService.updateEmployeeById(10, emp);
		assertEquals("Arijit Das", eDTO.getEmpName());
	}
	
	@Test
	@Order(4)
	void testDeleteEmployee()
	{
		empService.deleteEmployeeById(10);
		//assertNull(empService.getEmployeeUsingId(7));
		assertThrows(GlobalException.class, ()-> empService.getEmployeeById(10));
	}
}
