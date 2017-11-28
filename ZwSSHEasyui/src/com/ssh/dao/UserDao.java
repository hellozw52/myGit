package com.ssh.dao;

import java.util.List;

import com.ssh.pojo.User;

public interface UserDao {

    // 查询单个
    public User findUserById(int id);

    // 查询所有
    public List<User> findAllUser();

    // 查询当前页数据
    public List<User> getCurrentPageUserList(String page, String rows);

    // 增加
    public void addUser(User user);

    // 删除
    public void deleteUser(int id);

    // 修改
    public void updateUser(User User);

    // 总数
    public int getUserTotal() throws Exception;

}
