package com.ems.daoimpl;

import javax.swing.JOptionPane;

import org.hibernate.HibernateException;
import org.hibernate.Session;

import com.ems.config.HibernateUtil;
import com.ems.dao.AdminDAO;
import com.ems.entity.Admin;
import com.ems.entity.Employee;

public class AdminDAOImpl implements AdminDAO
{

	@Override
	public void saveAdmin(Admin admin)
	{
		try(Session session= HibernateUtil.getSession())
		{
			session.beginTransaction();
			session.save(admin);
			session.getTransaction().commit();
			session.clear();
			
		}
		catch (HibernateException e) 
		{
			System.out.println(e.getMessage());
		}
		catch (Exception e) 
		{
			System.out.println(e.getMessage());
		}
		
	}
	
	@Override
	public Admin getAdminById(int id) 
	{
	    try(Session session = HibernateUtil.getSession()) 
	    {
	      Admin admin = session.get(Admin.class, id);
	      return admin;
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
	public Admin updateAdminById(int id, Admin adm)
	{
		try(Session session = HibernateUtil.getSession()) 
	    {
			session.beginTransaction();
			Admin admin = session.get(Admin.class, id);
	      
			//updating existing details with the new one
			admin.setAdminName(adm.getAdminName());
			admin.setAdminEmail(adm.getAdminEmail());
			admin.setUserName(adm.getUserName());
			admin.setPassword(adm.getPassword());
	      
			session.saveOrUpdate(admin);
			session.getTransaction().commit();
	      
			return admin;
	      
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
	public void deleteAdminById(int id) 
    {
	    try(Session session = HibernateUtil.getSession()) 
	    {
	    	Admin admin = session.load(Admin.class, id);
	      
	    	session.beginTransaction();
	    	int input = JOptionPane.showConfirmDialog(null, "Do You Wnt to Delete", "Are You Sure?", JOptionPane.YES_NO_OPTION);
	    	if(input==0)
	    	{
	    		System.out.println("\n INPUT VAL = " + input + " \n");
	    		session.delete(admin);
	    		System.out.println("\nRecord Deleted from ID: "+id);
	        
	    	}
	    	else 
	    	{
	    		System.out.println("\n INPUT VAL = " + input + " \n");
	    		JOptionPane.showMessageDialog(null, "User wants to Retain It.");
	    		System.out.println("\nAdmin Denied to Deleted from ID: "+id);
	    	}
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
			Admin admin=session.get(Admin.class, id);
			if(admin.getUserName().equals(userName) && admin.getPassword().equals(password) 
					&& admin.getRole().equals("admin"))
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
