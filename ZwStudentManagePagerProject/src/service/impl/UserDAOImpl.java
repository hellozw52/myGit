package service.impl;

import java.util.List;

import hibernateutil.HibernateSessionFactory;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;

import entity.Users;
import service.UsersDAO;

public class UserDAOImpl implements UsersDAO {

	public boolean usersLogin(Users u) {
		// TODO Auto-generated method stub
		//事务
		Transaction tx = null;
		String hql = "";
		
		try
		{
			Session session = HibernateSessionFactory.getSession();
			tx = session.beginTransaction();//开启事务
			hql = " from Users where username=? and password=? ";
			Query query = session.createQuery(hql);
			query.setParameter(0, u.getUsername());
			query.setParameter(1, u.getPassword());
			List list = query.list();
			tx.commit();//提交事务
			if(list.size()>0)
			{
				return true;
			}
			else
			{
				return false;
			}
		}
		catch(Exception ex)
		{
			ex.printStackTrace();
			return false;
		}
		finally
		{
			if(tx!=null)
			{
				tx = null;
			}
		}
	}

}
