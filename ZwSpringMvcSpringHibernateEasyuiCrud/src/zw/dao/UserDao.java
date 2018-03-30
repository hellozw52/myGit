package zw.dao;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import zw.model.SsmUser;

@Repository
public class UserDao {

    // 注入sessionfactory
    @Autowired
    public SessionFactory sessionFactory;

    // 获取当前session
    private Session getSession() {
	return sessionFactory.getCurrentSession();
    }

    /**
     * 判断该用户是否在数据库中存在
     * @param user
     * @return 存在 返回1
     */
    public int login(SsmUser user) {
	// TODO Auto-generated method stub
	
	// 获取登录信息
	String username = user.getUserName();
	String password = user.getPassword();
	
	// 查询数据库  采用sql语句进行查询
	int usercount = this.getSession()
		.createSQLQuery("select * from ssm_user user where user.userName = '"+username+"' and user.password = '"+password+"'")
		.list().size();
		
	return usercount;
    }

}
