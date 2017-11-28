package com.ssh.service.impl;

import javax.annotation.Resource;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.ssh.pojo.ShopCategory;
import com.ssh.service.ShopCategoryService;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = "classpath:beans.xml")
public class ShopCategoryServiceImplTest {

    // 注入
    @Resource
    private ShopCategoryService shopCategoryService;

    @Test
    public void testAddManyShopCategory() {
	int num = 0;// 计数使用
	int categorynum = 100;// 添加数量

	for (int i = 0; i < categorynum; i++) {

	    ShopCategory shopCategory = new ShopCategory();

	    shopCategory.setShopcategoryid(i + 1);
	    shopCategory.setShopcategory("商店类型-" + String.valueOf(i + 1));
	    shopCategory.setPid(1);

	    // 添加
	    shopCategoryService.addCategory(shopCategory);
	    // 自增
	    num++;
	}
	System.out.println("添加完成！共添加 " + num + " 条记录！");
    }
}
