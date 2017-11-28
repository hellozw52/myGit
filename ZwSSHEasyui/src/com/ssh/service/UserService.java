package com.ssh.service;

import java.util.List;

import com.ssh.pojo.User;

public interface UserService {
    
    // 获取当前页面数据
    public List<User> getCurrentPageUserList(String page, String rows);

    // 查询所有数据
    public List<User> userList();

    // 增加
    public void addUser(User user);

    // 删除
    public void deleteUser(int userid);

    // 修改
    public void updateUser(User user);

    // 获取总数
    public int getUserTotal() throws Exception;
}
