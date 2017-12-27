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
     * add 传递id、name参数
     * 样例：http://127.0.0.1:8080/ssm/addCategory?id=1&name=cc
     * @return
     */
    @RequestMapping("addCategory")
    public ModelAndView addCategory(@RequestParam("id") String id,@RequestParam("name") String name) {
	
	ModelAndView mav = new ModelAndView("listCategory");
	// 新建类别
	Category category = new Category(Integer.parseInt(id), name);
	// 添加类别
	categoryService.addCategory(category);
	
	//查询所有最新数据
	List<Category> categorys = categoryService.list();
	// 存入参数
	mav.addObject("categorys", categorys);
	// 放入jsp路径  即跳转至listCategory.jsp页面
	return mav;
    }
    
    /**
     * delete 传递id参数
     * 样例：http://127.0.0.1:8080/ssm/deleteCategory?id=1
     * @return
     */
    @RequestMapping("deleteCategory")
    public ModelAndView deleteCategory(@RequestParam("id") int id) {
	
	ModelAndView mav = new ModelAndView("listCategory");
	
	//根据id参数，删除数据
	categoryService.deleteCategory(id);
	
	//查询所有最新数据
	List<Category> categorys = categoryService.list();
	// 存入参数
	mav.addObject("categorys", categorys);
	// 放入jsp路径  即跳转至listCategory.jsp页面
	return mav;
    }
    
    /**
     * update 传递id、name参数
     * 样例：http://127.0.0.1:8080/ssm/updateCategory?id=1&name=cc
     * @return
     */
    @RequestMapping("updateCategory")
    public ModelAndView updateCategory(@RequestParam("id") int id,@RequestParam("name") String name) {
	
	ModelAndView mav = new ModelAndView("listCategory");
	
	//根据参数，更新数据
	Category category = categoryService.getCategory(id);
	category.setName(name);
	int updated = categoryService.updateCategory(category);
	
	//查询所有最新数据
	List<Category> categorys = categoryService.list();
	// 存入参数
	mav.addObject("categorys", categorys);
	// 放入jsp路径  即跳转至listCategory.jsp页面
	return mav;
    }
    
    /**
     * get 传递id参数
     * 样例：http://127.0.0.1:8080/ssm/getCategory?id=1
     * @return
     */
    @RequestMapping("getCategory")
    public ModelAndView getCategory(@RequestParam("id") int id) {
	//创建视图
	ModelAndView mav = new ModelAndView("getCategory");
	Category category = categoryService.getCategory(id);

	// 存入数据
	mav.addObject("category", category);
	// 即跳转至getCategory.jsp页面
	return mav;
    }
    
    /**
     * list
     * 样例：http://127.0.0.1:8080/ssm/listCategory
     * @return
     */
    @RequestMapping("listCategory")
    public ModelAndView listCategory() {
	//创建一个listCategory的模型视图
	ModelAndView mav = new ModelAndView("listCategory");
	List<Category> categorys = categoryService.list();

	// 存入数据
	mav.addObject("categorys", categorys);
	// 跳转至页面
	return mav;
    }

}
