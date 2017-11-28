package com.ssh.service.impl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.ssh.dao.ShopCategoryDao;
import com.ssh.pojo.ShopCategory;
import com.ssh.service.ShopCategoryService;

@Service("shopcategoryService")
public class ShopCategoryServiceImpl implements ShopCategoryService{
	
    	@Resource
	private ShopCategoryDao shopcategoryDao;
	
	public void addCategory(ShopCategory category){
		this.shopcategoryDao.addCategory(category);
	}
	
	public List<ShopCategory> categoryList(){
		return this.shopcategoryDao.findAllCategory();
	}
	
	public void deleteCategory(int shopcid){
		this.shopcategoryDao.deleteCategory(shopcid);
	}
	
	public void updateCategory(ShopCategory category){
		this.shopcategoryDao.updateCategory(category);
	}
	
	public List getCategoryList(String page, String rows){
		return this.shopcategoryDao.getCategoryList(page, rows);
	}
	
	public int getCategoryTotal() throws Exception{
		return this.shopcategoryDao.getCategoryTotal();
	}

}
