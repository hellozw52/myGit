package com.ssh.service.impl;

import java.util.List;

import javax.annotation.Resource;

import org.hibernate.SessionFactory;
import org.springframework.stereotype.Service;

import com.ssh.dao.UserDao;
import com.ssh.pojo.User;
import com.ssh.service.UserService;

@Service(value = "userService")
public class UserServiceImpl implements UserService {

    private UserDao userDao;

    // 注入dao
    @Resource
    public void setUserDao(UserDao userDao) {
	this.userDao = userDao;
    }

    public List<User> getCurrentPageUserList(String page, String rows) {

	return this.userDao.getCurrentPageUserList(page, rows);
    }

    public List<User> userList() {
	return this.userDao.findAllUser();
    }

    public void addUser(User user) {
	this.userDao.addUser(user);
    }

    public void deleteUser(int userid) {
	this.userDao.deleteUser(userid);
    }

    public void updateUser(User user) {
	this.userDao.updateUser(user);
    }

    // 统计一共有多少数据
    public int getUserTotal() throws Exception {
	return this.userDao.getUserTotal();
    }

}
