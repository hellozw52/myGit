package com.ssh.dao.impl;

import java.util.List;

import javax.annotation.Resource;

import org.hibernate.SessionFactory;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.ssh.dao.UserDao;
import com.ssh.pojo.User;

@Repository(value = "userDao")
@Transactional
public class UserDaoImpl implements UserDao {

    private SessionFactory sessionFactory;

    // 注入sessionfactory
    @Resource
    public void setSessionFactory(SessionFactory sessionFactory) {
	this.sessionFactory = sessionFactory;
    }

    public void addUser(User user) {
	this.sessionFactory.getCurrentSession().save(user);
    }

    public void deleteUser(int userid) {
	User user = findUserById(userid);
	if (user != null) {
	    this.sessionFactory.getCurrentSession().delete(user);
	}
    }

    public User findUserById(int userid) {
	return (User) sessionFactory.getCurrentSession()
		.get(User.class, userid);
    }

    public List<User> findAllUser() {
	return sessionFactory.getCurrentSession()
		.createQuery("from User group by userid").list();
    }

    public void updateUser(User user) {
	sessionFactory.getCurrentSession().update(user);
    }

    // 根据第几页获取，每页几行获取数据

    public List<User> getCurrentPageUserList(String page, String rows) {

	// 当为缺省值的时候进行赋值
	int currentpage = Integer.parseInt((page == null || page == "0") ? "1"
		: page);// 第几页
	int pagesize = Integer.parseInt((rows == null || rows == "0") ? "10"
		: rows);// 每页多少行

	List list = this.sessionFactory.getCurrentSession()
		.createQuery("from User group by userid")
		.setFirstResult((currentpage - 1) * pagesize)
		.setMaxResults(pagesize).list();

	return list;
    }

    // 统计一共有多少数据
    public int getUserTotal() throws Exception {
	return this.sessionFactory.getCurrentSession().find("from User").size();
    }

}
