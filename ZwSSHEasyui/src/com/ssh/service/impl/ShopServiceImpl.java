package com.ssh.service.impl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.ssh.dao.ShopDao;
import com.ssh.pojo.Shop;
import com.ssh.service.ShopService;

@Service("shopService")
public class ShopServiceImpl implements ShopService {

    //注入dao
    @Resource
    private ShopDao shopDao;

    //增加
    public void addShop(Shop shop) {
	this.shopDao.addShop(shop);
    }

    //获取所有
    public List<Shop> shopList() {
	return this.shopDao.findAllShop();
    }

    //删除
    public void deleteShop(int shopid) {
	this.shopDao.deleteShop(shopid);
    }

    //更新
    public void updateShop(Shop shop) {
	this.shopDao.updateShop(shop);
    }

    //获取当前页面数据
    public List<Shop> getCurrentPageShopList(String page, String rows) {

	return this.shopDao.getCurrentPageShopList(page, rows);
    }

    //统计总数
    public int getShopTotal() throws Exception {
	return this.shopDao.getShopTotal();
    }

}
