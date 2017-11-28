package com.ssh.dao.impl;

import java.util.List;
import javax.annotation.Resource;
import org.hibernate.SessionFactory;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
import com.ssh.dao.ShopCategoryDao;
import com.ssh.pojo.ShopCategory;

@Repository("shopcategoryDao")
@Transactional
public class ShopCategoryDaoImpl implements ShopCategoryDao {

    @Resource
    private SessionFactory sessionFactory;

    public void addCategory(ShopCategory category) {
	this.sessionFactory.getCurrentSession().save(category);
    }

    public void deleteCategory(int shopcid) {
	ShopCategory shopCategory = findCategoryById(shopcid);
	this.sessionFactory.getCurrentSession().delete(shopCategory);
    }

    public List<ShopCategory> findAllCategory() {
	return sessionFactory.getCurrentSession()
		.createQuery("from ShopCategory group by shopcategoryid")
		.list();
    }

    public ShopCategory findCategoryById(int shopcategoryid) {
	return (ShopCategory) sessionFactory.getCurrentSession().get(
		ShopCategory.class, shopcategoryid);
    }

    public void updateCategory(ShopCategory category) {
	this.sessionFactory.getCurrentSession().update(category);
    }

    // 根据第几页获取，每页几行获取数据
    public List getCategoryList(String page, String rows) {

	// 当为缺省值的时候进行赋值
	int currentpage = Integer.parseInt((page == null || page == "0") ? "1"
		: page);// 第几页
	int pagesize = Integer.parseInt((rows == null || rows == "0") ? "10"
		: rows);// 每页多少行

	List list = this.sessionFactory.getCurrentSession()
		.createQuery("from ShopCategory group by shopcategoryid")
		.setFirstResult((currentpage - 1) * pagesize)
		.setMaxResults(pagesize).list();

	return list;
    }

    // 统计一共有多少数据
    public int getCategoryTotal() throws Exception {
	return this.sessionFactory.getCurrentSession()
		.find("from ShopCategory").size();
    }

}
