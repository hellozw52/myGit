package zw.dao;

import java.util.List;

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
    
    /**
     * 获取当前页面数据
     * @param currentpage
     * @param pagesize
     * @return
     */
    @SuppressWarnings("unchecked")
    public List<SsmUser> getCurrentPageDataList(int currentpage, int pagesize) {
	// TODO Auto-generated method stub
	List<SsmUser> list = this.getSession()
			.createQuery("from SsmUser")
			.setFirstResult((currentpage - 1) * pagesize)
			.setMaxResults(pagesize).list();
	return list;
    }

    /**
     * 获取总数
     * @return
     */
    public int getTotalNum() {
	// TODO Auto-generated method stub
	return this.getSession().createQuery("from SsmUser").list().size();
    }
    
    /**
     * 获取某个
     * @param id
     * @return
     */
    public SsmUser getById(int id) {
	// TODO Auto-generated method stub
	return (SsmUser)this.getSession().get(SsmUser.class, id);
    }

    /**
     * 增
     * @param user
     * @return
     */
    public void add(SsmUser user) {
	// TODO Auto-generated method stub
	this.getSession().save(user);
    }

    /**
     * 改
     * @param user
     */
    public void update(SsmUser user) {
	// TODO Auto-generated method stub
	this.getSession().update(user);
    }

    /**
     * 删
     * @param user
     */
    public void delete(SsmUser user) {
	// TODO Auto-generated method stub
	this.getSession().delete(user);
    }

}
