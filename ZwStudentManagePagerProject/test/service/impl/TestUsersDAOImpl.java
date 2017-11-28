package service.impl;

import junit.framework.Assert;

import org.junit.Test;

import service.UsersDAO;

import entity.Users;

public class TestUsersDAOImpl {
	
	@Test
	public void testUsersLogin()
	{
		Users u = new Users("zhangsan","123456");
		UsersDAO udao = new UserDAOImpl();
		Assert.assertEquals(true, udao.usersLogin(u)); //≤…”√∂œ—‘≈–∂œ
	}
}
