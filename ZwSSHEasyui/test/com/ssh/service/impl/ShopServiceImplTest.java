package com.ssh.service.impl;

import javax.annotation.Resource;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.ssh.pojo.Shop;
import com.ssh.service.ShopService;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = "classpath:beans.xml")
public class ShopServiceImplTest {

    //注入
    @Resource
    private ShopService shopService;

    @Test
    public void testAddManyShops() {
	int num = 0;// 计数使用
	int shopnum = 100;// 添加数量

	for (int i = 0; i < shopnum; i++) {

	    Shop shop = new Shop();

	    shop.setShopid(i + 1);
	    shop.setShopname("商店-" + String.valueOf(i + 1));
	    shop.setShoplocation("郑州");
	    shop.setShopcid(1);
	    shop.setGoodsidlist("武汉仓库");
	    shop.setShopimage("商店图片-" + String.valueOf(i + 1));

	    // 添加
	    shopService.addShop(shop);
	    // 自增
	    num++;
	}
	System.out.println("添加完成！共添加 " + num + " 条记录！");
    }
}
