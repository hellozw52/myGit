package entity;

import java.util.Date;

import hibernateutil.HibernateSessionFactory;

import org.hibernate.Session;
import org.hibernate.Transaction;
import org.junit.Test;

public class TestStudents {
	
	//保存学生
	@Test
	public void testSaveStudent()
	{
		//开启session
		Session session = HibernateSessionFactory.getSession();
		//开启事务
		Transaction tx = session.beginTransaction();
		
		Students s1 = new Students("S0000001","学生1", "男", new Date(), "开封");
		Students s2 = new Students("S0000002","学生2", "男", new Date(), "开封");
		Students s3 = new Students("S0000003","学生3", "女", new Date(), "开封");
		
		session.save(s1);
		session.save(s2);
		session.save(s3);
		
		tx.commit();
	}
	
	
}
