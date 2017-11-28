package com.ssh.dao;

import java.util.List;

import com.ssh.pojo.Shop;

public interface ShopDao {
	//增加
	public void addShop(Shop shop);
	//删除
	public void deleteShop(int id);
	//获取一个
	public Shop findShopById(int id);
	//获取所有
	public List<Shop> findAllShop();
	//更新
	public void updateShop(Shop shop);
	//获取当前页数据
	public List<Shop> getCurrentPageShopList(String page, String rows);
	//获取总数
	public int getShopTotal() throws Exception;

}
