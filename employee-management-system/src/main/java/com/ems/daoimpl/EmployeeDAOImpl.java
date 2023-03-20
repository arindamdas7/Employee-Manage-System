package com.ems.daoimpl;

import javax.swing.JOptionPane;

import org.hibernate.HibernateException;
import org.hibernate.query.Query;
import org.hibernate.Session;

import com.ems.config.HibernateUtil;
import com.ems.dao.EmployeeDAO;
import com.ems.entity.Employee;

public class EmployeeDAOImpl implements EmployeeDAO
{
	
	@Override
	public void saveEmployee(Employee employee) 
	{
		try(Session session=HibernateUtil.getSession())
		{
			session.beginTransaction();
			session.save(employee);
			session.getTransaction().commit();
			session.clear();
		}
		catch (HibernateException e) 
		{
			System.out.println(e.getMessage());
		}
		catch(Exception e)
		{
			System.out.println(e.getMessage());
		}
	}

	@Override
	public Employee getEmployeeById(int id) 
	{
		try(Session session = HibernateUtil.getSession()) 
		{
			Employee employee = session.get(Employee.class, id);
			return employee;
		}
		catch(HibernateException e) 
		{
			System.out.println(e.getMessage());
		}
		catch(Exception e) 
		{
			System.out.println(e.getMessage());
		}
    
		return null;
	}

	@Override
	public Employee updateEmployeeById(int id, Employee empl)
	{
		try(Session session = HibernateUtil.getSession()) 
		{
			session.beginTransaction();
			Employee emp = session.get(Employee.class, id);
      
			//updating existing details with the new one
			emp.setEmpName(empl.getEmpName());
			emp.setEmpAddress(empl.getEmpAddress());
			emp.setSalary(empl.getSalary());
			emp.setContact(empl.getContact());
			emp.setEmail(empl.getEmail());
			emp.setDesignation(empl.getDesignation());
			emp.setDOJ(empl.getDOJ());
			emp.setUserName(empl.getUserName());
			emp.setPassword(empl.getPassword());
      
			session.saveOrUpdate(emp);
			session.getTransaction().commit();
      
			return emp;
			
		}
		catch(HibernateException e) 
		{
			System.out.println(e.getMessage());
		}
		catch(Exception e)
		{
			System.out.println(e.getMessage());
		}
		return null;
	}

	@Override
	public void deleteEmployeeById(int id) 
	{
		try(Session session = HibernateUtil.getSession()) 
		{
			Employee employee = session.load(Employee.class, id);
			
			session.beginTransaction();
			int input = JOptionPane.showConfirmDialog(null, "Do You Wnt to Delete", "Are You Sure?", JOptionPane.YES_NO_OPTION);
			if(input==0)
			{
				System.out.println("\n INPUT VAL = " + input + " \n");
				session.delete(employee);
				System.out.println("\nRecord Deleted from ID: "+id);
        
			}
			else 
			{
				System.out.println("\n INPUT VAL = " + input + " \n");
				JOptionPane.showMessageDialog(null, "User wants to Retain It.");
				System.out.println("\nUser Denied to Deleted from ID: "+id);
			}
			session.getTransaction().commit();
		}
		catch(HibernateException e)
		{
			System.out.println(e.getMessage());
		}
	}

	@Override
	public Employee getEmployeeByEmail(String mail)
	{
		try(Session session = HibernateUtil.getSession()) 
		{
			//Employee employee = session.get(Employee.class, mail);  //this is only work for id
			String query = "from Employee e where e.email =: m";
			Query q = session.createQuery(query);
			q.setParameter("m", mail);
      
			Employee emp = (Employee) q.uniqueResult();
      
			return emp;
		}
		catch(HibernateException e)
		{
			System.out.println(e.getMessage());
		}
		catch(Exception e) 
		{
			System.out.println(e.getMessage());
		}
    
		return null;
	}
  
	@Override
	public boolean login(String userName, String password) 
	{
		try(Session session=HibernateUtil.getSession())
		{
			int id = Integer.parseInt(JOptionPane.showInputDialog("Enter Id: ","Type here.."));
			Employee emp=session.get(Employee.class, id);
			if(emp.getUserName().equals(userName) && emp.getPassword().equals(password) 
					&& emp.getRole().equals("employee"))
			{
				JOptionPane.showMessageDialog(null, "Log In successfull!!");
				return true;
			}
			else
			{
				JOptionPane.showMessageDialog(null, "Wrong Credentials!!");
				return false;
			}
		}
	}
  
}
