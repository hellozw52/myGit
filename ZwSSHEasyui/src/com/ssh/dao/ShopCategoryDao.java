package com.ssh.dao;

import java.util.List;

import com.ssh.pojo.ShopCategory;

public interface ShopCategoryDao {
    
    //增加
    public void addCategory(ShopCategory category);
    //删除
    public void deleteCategory(int shopcid);
    //获取所有
    public List<ShopCategory> findAllCategory();
    //查询单个
    public ShopCategory findCategoryById(int shopcategoryid);
    //更新
    public void updateCategory(ShopCategory category);
    //获取当前页面数据
    public List getCategoryList(String page, String rows);
    //获取总数
    public int getCategoryTotal() throws Exception;

}
