package com.ems.daoimpl;

import java.util.ArrayList;
import java.util.List;

import javax.swing.JOptionPane;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import com.ems.config.HibernateUtil;
import com.ems.dao.DepartmentDAO;
import com.ems.entity.Department;
import com.ems.entity.Employee;
import com.ems.entity.Manager;

public class DepartmentDAOImpl implements DepartmentDAO
{
	
	@Override
	public void saveDepartment(Department dept) 
	{
		try(Session session=HibernateUtil.getSession())
		{
			session.beginTransaction();
			session.save(dept);
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
	public Department getDepartmentById(int deptId) 
	{
	    try(Session session = HibernateUtil.getSession()) 
	    {
	    	Department dept = session.get(Department.class, deptId);
	    	return dept;
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
	public Department updateDepartment(int deptId, Department dept)
	{
		try(Session session = HibernateUtil.getSession()) 
	    {
			session.beginTransaction();
			Department department = session.get(Department.class, deptId);
	      
			//updating existing details with the new one
			department.setDeptName(dept.getDeptName());
			department.setTotalEmp(dept.getTotalEmp());
			department.setLocation(dept.getLocation());
	      
	      
			session.saveOrUpdate(department);
			session.getTransaction().commit();
	      
			return department;
	      
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
	public void assignEmpToDept(int employeeId, int deptId) 
	{
		try(Session session = HibernateUtil.getSession()) 
	    {
	    	Employee emp = session.get(Employee.class, employeeId);
			Department dept = session.get(Department.class, deptId);
			
			List<Employee> employees = new ArrayList<>();
			employees.add(emp);
			
			dept.setEmployees(employees);
			emp.setDept(dept);
			
			dept.setTotalEmp(dept.getTotalEmp()+1);
			
			session.beginTransaction();
			session.saveOrUpdate(dept);
			
			session.getTransaction().commit();
	    }
	    catch(HibernateException e)
	    {
	    	System.out.println(e.getMessage());
	    }
	}

	@Override
	public void assignMgrToDept(int mgrId, int deptId)
	{
		try(Session session = HibernateUtil.getSession())
		{
			Manager mgr = session.get(Manager.class, mgrId);
			Department dept = session.get(Department.class, deptId);
			  
			dept.setMgr(mgr);
			  
			session.beginTransaction();
			session.saveOrUpdate(dept);
			  
			session.getTransaction().commit();
		}
		catch(HibernateException e)
		{
			System.out.println(e.getMessage());
		}
		catch(Exception e)
		{
			System.out.println(e.getMessage());
		}
	}


	@Override
	public void deleteDepartmentById(int id) 
	{
		try(Session session = HibernateUtil.getSession()) 
	    {
			Department dept = session.load(Department.class, id);
	      
			session.beginTransaction();
			int input = JOptionPane.showConfirmDialog(null, "Do You Wnt to Delete", "Are You Sure?", JOptionPane.YES_NO_OPTION);
			if(input==0)
			{
				System.out.println("\n INPUT VAL = " + input + " \n");
				session.delete(dept);
				System.out.println("\nRecord Deleted from ID: "+id);
	       
			}
			else 
			{
				System.out.println("\n INPUT VAL = " + input + " \n");
				JOptionPane.showMessageDialog(null, "Department wants to Retain It.");
				System.out.println("\nUser Denied to Deleted from ID: "+id);
			}
			session.getTransaction().commit();
	    }
	    catch(HibernateException e)
	    {
	    	System.out.println(e.getMessage());
	    }
		
	}
	 
	  
}
