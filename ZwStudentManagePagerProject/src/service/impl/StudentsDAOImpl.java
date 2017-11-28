package service.impl;

import hibernateutil.HibernateSessionFactory;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;

import entity.Students;
import service.StudentsDAO;

public class StudentsDAOImpl implements StudentsDAO{

	//查询所有学生
	public List<Students> queryAllStudents() {
		// TODO Auto-generated method stub
		Transaction tx = null;
		List<Students> list = null;
		String hql = "";
		try
		{
			Session session = HibernateSessionFactory.getSessionFactory().getCurrentSession();
			tx = session.beginTransaction();
			hql = "from Students";
			Query query = session.createQuery(hql);
			
			list = query.list();
			tx.commit();
			
			return list;
		}
		catch(Exception ex)
		{
			ex.printStackTrace();
			tx.commit();
			return list;
		}
		finally
		{
			if(tx!=null)
			{
				tx = null;
			}
		}
		
	}
	
	//根据id查询学生
	public Students queryStudentsBySid(String sid) {
		// TODO Auto-generated method stub
		Transaction tx = null;
		Students s = null;
		try
		{
			Session session = HibernateSessionFactory.getSessionFactory().getCurrentSession();
			tx = session.beginTransaction();
			s = (Students)session.get(Students.class, sid);
			
			tx.commit();
			
			return s;
		}
		catch(Exception ex)
		{
			ex.printStackTrace();
			tx.commit();
			return s;
		}
		finally
		{
			if(tx!=null)
			{
				tx = null;
			}
		}
		
	}
	
	//添加学生
	public boolean addStudents(Students s) {
		// TODO Auto-generated method stub
		
		s.setSid(getNewSid());//设置学生学号
		Transaction tx = null;
		
		try
		{
			Session session = HibernateSessionFactory.getSessionFactory().getCurrentSession();
			tx = session.beginTransaction();
			session.merge(s);
			tx.commit();
			return true;
			
		} 
		catch (Exception ex)
		{
			ex.printStackTrace();
			tx.commit();
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

	//修改学生
	public boolean updateStudents(Students s) {
		// TODO Auto-generated method stub
		Transaction tx = null;
		try 
		{
			Session session = HibernateSessionFactory.getSessionFactory().getCurrentSession();
			tx = session.beginTransaction();
			session.update(s);
			tx.commit();
			return true;
		} 
		catch (Exception ex) 
		{
			ex.printStackTrace();
			tx.commit();
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
	
	//根据sid删除学生
	public boolean deleteStudents(String sid) {
		// TODO Auto-generated method stub
		Transaction tx = null;
		
		try 
		{
			Session session = HibernateSessionFactory.getSessionFactory().getCurrentSession();
			tx = session.beginTransaction();
			Students s = (Students)session.get(Students.class, sid);
			session.delete(s);
			tx.commit();
			return true;
		} 
		catch (Exception ex) 
		{
			ex.printStackTrace();
			tx.commit();
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
	
	//添加学生时，生成最新的sid
	public String getNewSid() 
	{
		Transaction tx = null;
		String hql = "";
		String sid = null;
		
		try 
		{
			Session session = HibernateSessionFactory.getSessionFactory().getCurrentSession();
			tx = session.beginTransaction();
			//获取表中最大的sid
			hql = "select max(sid) from Students";
			Query query = session.createQuery(hql);
			sid = (String)query.uniqueResult();
			if(sid==null||"".equals(sid))
			{
				//提交事务
				tx.commit();
				//默认sid为"S0000001"
				sid = "S0000001";
			}
			else
			{
				String temp = sid.substring(1);//获取最后7位
				int i = Integer.parseInt(temp);//String转int
				i++;//加1
				//int转String
				temp = String.valueOf(i);
				int len = temp.length();
				//补全0  例如 8-> 0000008
				for (int j = 0; j < 7-len; j++) 
				{
					temp = "0" +temp;
				}
				tx.commit();
				sid = "S" + temp;//添加S
			}
			return sid;
		} 
		catch (Exception ex) 
		{
			ex.printStackTrace();
			tx.commit();
			return null;
		}
		finally
		{
			if(tx!=null)
			{
				tx = null;
			}
		}
	}
	
	//分页查询学生信息
	public List<Students> queryPagerStudents(int page, int rows)
	{
		// TODO Auto-generated method stub
		Transaction tx = null;
		List<Students> list = null;
		String hql = "";
		
		int currentpage = page;
		int pagesize = rows;
		
		try
		{
			Session session = HibernateSessionFactory.getSessionFactory().getCurrentSession();
			tx = session.beginTransaction();
			hql = "from Students";
			Query query = session.createQuery(hql);
			query.setFirstResult((currentpage - 1) * pagesize);
			query.setMaxResults(pagesize);
			
			list = query.list();
			tx.commit();
			
			return list;
		}
		catch(Exception ex)
		{
			ex.printStackTrace();
			tx.commit();
			return list;
		}
		finally
		{
			if(tx!=null)
			{
				tx = null;
			}
		}
	}
	
	public int countStudents()
	{
		// TODO Auto-generated method stub
		Transaction tx = null;
		String hql = "";
		int countnum;//个数
		List<Students> list;//学生集合
		try 
		{
			Session session = HibernateSessionFactory.getSessionFactory().getCurrentSession();
			tx = session.beginTransaction();
			hql  = "from Students";
			Query query = session.createQuery(hql);
			
			list = query.list();
			//集合 
			countnum = list.size();
			
			tx.commit();
			return countnum;
		} 
		catch (Exception ex) 
		{
			ex.printStackTrace();
			tx.commit();
			return 0;
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
