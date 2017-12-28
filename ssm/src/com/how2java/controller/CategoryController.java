package com.how2java.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
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
     * get 根据id查询结果  使用ResponseBody注解  返回json格式  
     * 样例：http://127.0.0.1:8080/ssm/getCategoryInJson?id=3
     * @return  {"id":3,"name":"category3"}
     */
    @RequestMapping("getCategoryInJson")
    public @ResponseBody Category getCategoryInJson(@RequestParam("id") int id) {
	
	Category category = categoryService.getCategory(id);
	// 返回查到的数据
	return category;
    }
    
    /**
     * 查询所有结果集合  返回json格式
     * 样例：http://127.0.0.1:8080/ssm/listCategoryInJson
     * @return  [{"id":2,"name":"category2"},{"id":3,"name":"category3"},{"id":4,"name":"category4"},{"id":5,"name":"category5"},{"id":6,"name":"category6"},{"id":7,"name":"category7"},{"id":10,"name":"cc"},{"id":11,"name":"cc"},{"id":12,"name":"cc"},{"id":13,"name":"cc"},{"id":14,"name":"ccbb"},{"id":15,"name":"ccbb"},{"id":19,"name":"ccbb"},{"id":20,"name":"asdfasdf"},{"id":25,"name":"hiss"},{"id":10000,"name":"ccbb"},{"id":10001,"name":"asdf"},{"id":1003648,"name":"asdf"}]
     */
    @RequestMapping("listCategoryInJson")
    public @ResponseBody List<Category> listCategoryInJson() {
	
	List<Category> categorys = categoryService.list();
	// 返回查到的数据
	return categorys;
    }
    
    /**
     * 根据name进行模糊查询  返回json格式
     * 样例：http://127.0.0.1:8080/ssm/listCategoryInJsonByName?name=category
     * @return  [{"id":3,"name":"category3"},{"id":4,"name":"category4"},{"id":5,"name":"category5"},{"id":6,"name":"category6"},{"id":7,"name":"category7"}]
     */
    @RequestMapping("listCategoryInJsonByName")
    public @ResponseBody List<Category> listCategoryInJsonByName(@RequestParam("name") String name) {
	
	List<Category> categorys = categoryService.listCategoryByName(name);
	// 返回查到的数据
	return categorys;
    }
    
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
