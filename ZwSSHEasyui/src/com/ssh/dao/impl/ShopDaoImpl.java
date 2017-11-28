package com.ssh.dao.impl;

import java.util.List;

import javax.annotation.Resource;

import org.hibernate.SessionFactory;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.ssh.dao.ShopDao;
import com.ssh.pojo.Shop;

@Repository("shopDao")
@Transactional
public class ShopDaoImpl implements ShopDao {

    // 注入sessionFactory
    @Resource
    private SessionFactory sessionFactory;

    public void addShop(Shop shop) {
	this.sessionFactory.getCurrentSession().save(shop);
    }

    public void deleteShop(int shopid) {
	Shop shop = findShopById(shopid);
	if (shop != null) {
	    this.sessionFactory.getCurrentSession().delete(shop);
	}
    }

    public Shop findShopById(int shopid) {
	return (Shop) sessionFactory.getCurrentSession()
		.get(Shop.class, shopid);
    }

    public List<Shop> findAllShop() {
	return sessionFactory.getCurrentSession()
		.createQuery("from Shop group by shopid").list();
    }

    public void updateShop(Shop shop) {
	sessionFactory.getCurrentSession().update(shop);
    }

    // 获取当前页面数据
    public List<Shop> getCurrentPageShopList(String page, String rows) {

	// 当为缺省值的时候进行赋值
	int currentpage = Integer.parseInt((page == null || page == "0") ? "1"
		: page);// 第几页
	int pagesize = Integer.parseInt((rows == null || rows == "0") ? "10"
		: rows);// 每页多少行

	List<Shop> list = this.sessionFactory.getCurrentSession()
		.createQuery("from Shop group by shopid")
		.setFirstResult((currentpage - 1) * pagesize)
		.setMaxResults(pagesize).list();

	return list;
    }

    // 统计一共有多少数据
    public int getShopTotal() throws Exception {
	return this.sessionFactory.getCurrentSession().find("from Shop").size();
    }

}
