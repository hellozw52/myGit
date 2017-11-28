package service;

import entity.Users;

//用户登录接口
public interface UsersDAO {
	
	//用户登录方法
	public boolean usersLogin(Users u);
}
