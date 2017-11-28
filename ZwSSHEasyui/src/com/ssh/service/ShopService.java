package com.ssh.service;

import java.util.List;

import com.ssh.pojo.Shop;

public interface ShopService {
    	
	/**
	 * 新增
	 * @param shop
	 */
	public void addShop(Shop shop);
	
	/**
	 * 获取所有
	 * @return
	 */
	public List<Shop> shopList();
	/**
	 * 删除
	 * @param shopid
	 */
	public void deleteShop(int shopid);
	/**
	 * 更新
	 * @param shop
	 */
	public void updateShop(Shop shop);
	/**
	 * 获取当前页面数据
	 * @param page
	 * @param rows
	 * @return
	 */
	public List<Shop> getCurrentPageShopList(String page, String rows);
	/**
	 * 获取总数
	 * @return
	 * @throws Exception
	 */
	public int getShopTotal() throws Exception;
}
