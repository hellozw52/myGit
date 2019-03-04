package hdfx.dao;

import org.springframework.stereotype.Repository;

import hdfx.entity.User;

/**
 * 继承父类，实现增删改查等常用操作
 * @author zhaowei
 */
@Repository
public class UserDao extends BaseDao {

    /**
     * 判断该用户是否在数据库中存在
     * @param user
     * @return 存在 返回1
     */
    public int login(User user) {
	// TODO Auto-generated method stub
	
	// 获取登录信息
	String username = user.getUsername();
	String password = user.getPassword();
	
	// 查询数据库  采用sql语句进行查询
	int usercount = super.getSession()
		.createSQLQuery("select * from user u where u.username = '"+username+"' and u.password = '"+password+"'")
		.list().size();
		
	return usercount;
    }

}
