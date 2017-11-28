package com.ssh.service;

import java.util.List;

import com.ssh.pojo.ShopCategory;

public interface ShopCategoryService {
    	//新增
	public void addCategory(ShopCategory category);
	//获取所有
	public List<ShopCategory> categoryList();
	//删除
	public void deleteCategory(int shopcid);
	//更新
	public void updateCategory(ShopCategory category);
	//获取当前页面数据
	public List getCategoryList(String page, String rows);
	//获取总数
	public int getCategoryTotal() throws Exception;

}
