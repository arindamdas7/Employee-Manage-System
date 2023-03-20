package com.ems.daoimpl;

import java.util.ArrayList;
import java.util.List;

import javax.swing.JOptionPane;

import org.hibernate.HibernateException;
import org.hibernate.Session;

import com.ems.config.HibernateUtil;
import com.ems.dao.ManagerDAO;
import com.ems.entity.Employee;
import com.ems.entity.Manager;

public class ManagerDAOImpl implements ManagerDAO
{
	
	@Override
	public void saveManager(Manager mgr) 
	{
		try(Session session=HibernateUtil.getSession())
		{
			session.beginTransaction();
			session.save(mgr);
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
	public Manager getManagerById(int mgrId) 
	{
		try(Session session = HibernateUtil.getSession()) 
		{
			Manager mgr = session.get(Manager.class, mgrId);
		    return mgr;
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
	public Manager updateManagerById(int mgrId, Manager mgr1)
	{
	    try(Session session = HibernateUtil.getSession()) 
	    {
	    	session.beginTransaction();
	    	Manager manager = session.get(Manager.class, mgrId);
		      
	    	manager.setMgrName(mgr1.getMgrName());
		    manager.setMgrAddress(mgr1.getMgrAddress());
		    manager.setMgrContact(mgr1.getMgrContact());
		    manager.setMgrEmail(mgr1.getMgrEmail());
		    manager.setMgrSalary(mgr1.getMgrSalary());
		    manager.setUserName(mgr1.getUserName());
		    manager.setPassword(mgr1.getPassword());
		        
		    session.saveOrUpdate(manager);
		    session.getTransaction().commit();
		      
		    return manager;
		      
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
	public void assignEmpToMgr(int empId, int mgrId) 
	{
		try(Session session = HibernateUtil.getSession()) 
		{
			Employee emp = session.get(Employee.class, empId);
			Manager mgr = session.get(Manager.class, mgrId);
				
			List<Employee> employees = new ArrayList<>();
			employees.add(emp);
				
			mgr.setEmployee(employees);
			emp.setMgr(mgr);
				
			mgr.setMgrTotalEmp(mgr.getMgrTotalEmp()+1);
				
			session.beginTransaction();
			session.saveOrUpdate(mgr);
				
			session.getTransaction().commit();
		}
		catch(HibernateException e)
		{
			System.out.println(e.getMessage());
		}
	}
		  
	@Override
	public boolean login(String userName, String password) 
	{
		try(Session session=HibernateUtil.getSession())
		{
			int id = Integer.parseInt(JOptionPane.showInputDialog("Enter Id: ","Type here.."));
			Manager mgr=session.get(Manager.class, id);
			if(mgr.getUserName().equals(userName) && mgr.getPassword().equals(password) 
					&& mgr.getRole().equals("manager"))
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
	
	@Override
	public void deleteManagerById(int mgrId)
	{
		try(Session session = HibernateUtil.getSession()) 
		{
			Manager manager = session.load(Manager.class, mgrId);
			
			session.beginTransaction();
			int input = JOptionPane.showConfirmDialog(null, "Do You Wnt to Delete", "Are You Sure?", JOptionPane.YES_NO_OPTION);
			if(input==0)
			{
				System.out.println("\n INPUT VAL = " + input + " \n");
				session.delete(manager);
				System.out.println("\nRecord Deleted from ID: "+mgrId);
			}
			else 
			{
				System.out.println("\n INPUT VAL = " + input + " \n");
				JOptionPane.showMessageDialog(null, "Manager wants to Retain It.");
				System.out.println("\nUser Denied to Deleted from ID: "+mgrId);
			}
			session.getTransaction().commit();
		}
		catch(HibernateException e)
		{
			System.out.println(e.getMessage());
		}
			
	}
		 
}
