package com.how2java.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.how2java.pojo.Category;
import com.how2java.service.CategoryService;

// 告诉spring mvc这是一个控制器类
@Controller
@RequestMapping("")
public class CategoryController {
    
    //注入categoryService
    @Autowired
    CategoryService categoryService;

    /**
     * list
     * 样例：http://127.0.0.1:8080/ssm/listCategory
     * @return
     */
    @RequestMapping("listCategory")
    public ModelAndView listCategory() {
	ModelAndView mav = new ModelAndView();
	List<Category> categorys = categoryService.list();

	// 放入转发参数
	mav.addObject("categorys", categorys);
	// 放入jsp路径  即跳转至listCategory.jsp页面
	mav.setViewName("listCategory");
	return mav;
    }
    
    
    /**
     * get 传递id参数
     * 样例：http://127.0.0.1:8080/ssm/getCategory?id=1
     * @return
     */
    @RequestMapping("getCategory")
    public ModelAndView getCategory(@RequestParam("id") int id) {
	ModelAndView mav = new ModelAndView();
	Category category = categoryService.getCategory(id);

	// 放入转发参数
	mav.addObject("category", category);
	// 放入jsp路径    即跳转至getCategory.jsp页面
	mav.setViewName("getCategory");
	return mav;
    }
    
    /**
     * update 传递id、name参数
     * 样例：http://127.0.0.1:8080/ssm/updateCategory?id=1&name=cc
     * @return
     */
    @RequestMapping("updateCategory")
    public ModelAndView updateCategory(@RequestParam("id") int id,@RequestParam("name") String name) {
	ModelAndView mav = new ModelAndView();
	
	//根据参数，更新数据
	Category category = categoryService.getCategory(id);
	category.setName(name);
	int updated = categoryService.updateCategory(category);
	
	//查询所有最新数据
	List<Category> categorys = categoryService.list();

	// 放入转发参数
	mav.addObject("categorys", categorys);
	// 放入jsp路径  即跳转至listCategory.jsp页面
	mav.setViewName("listCategory");
	return mav;
    }

}
