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

@Controller  // 告诉spring mvc 这是一个控制器类
@RequestMapping(value="/category")  // 处理ssm/category/...
public class CategoryController {

    // 注入categoryService
    @Autowired
    CategoryService categoryService;

    /**
     * get 根据id查询结果 使用ResponseBody注解 返回json格式
     * 样例：http://127.0.0.1:8080/ssm/category/getCategoryInJson?id=3
     * @return {"id":3,"name":"category3"}
     */
    @RequestMapping(value="/getCategoryInJson")
    public @ResponseBody
    Category getCategoryInJson(@RequestParam("id") int id) {

	Category category = categoryService.getCategory(id);
	// 返回查到的数据
	return category;
    }

    /**
     * 查询所有结果集合 返回json格式 样例：http://127.0.0.1:8080/ssm/category/listCategoryInJson
     * @return 
     *         [{"id":2,"name":"category2"},{"id":3,"name":"category3"},{"id":4,"name"
     *         :"category4"},{"id":5,"name":"category5"}...]
     */
    @RequestMapping(value="/listCategoryInJson")
    public @ResponseBody
    List<Category> listCategoryInJson() {

	List<Category> categorys = categoryService.list();
	// 返回查到的数据
	return categorys;
    }

    /**
     * 查询总数  返回json格式 样例：http://127.0.0.1:8080/ssm/category/getTotalNum
     * @return 21
     */
    @RequestMapping(value="getTotalNum")
    public @ResponseBody
    int getTotalNum() {

	int totalnum = categoryService.getTotalNum();
	// 返回查到的数据
	return totalnum;
    }

    /**
     * 根据name进行模糊查询 返回json格式
     * 样例：http://127.0.0.1:8080/ssm/category/listCategoryInJsonByName?name=category
     * @return 
     *         [{"id":3,"name":"category3"},{"id":4,"name":"category4"},{"id":5,"name"
     *         :"category5"},{"id":6,"name":"category6"},{"id":7,"name":
     *         "category7"}]
     */
    @RequestMapping(value="listCategoryInJsonByName")
    public @ResponseBody
    List<Category> listCategoryInJsonByName(@RequestParam("name") String name) {

	List<Category> categorys = categoryService.listCategoryByName(name);
	// 返回查到的数据
	return categorys;
    }

    /**
     * add 传递id、name参数 样例：http://127.0.0.1:8080/ssm/category/addCategory?id=1&name=cc
     * @return
     */
    @RequestMapping(value="addCategory")
    public ModelAndView addCategory(@RequestParam("id") String id,
	    @RequestParam("name") String name) {

	ModelAndView mav = new ModelAndView("listCategory");
	// 新建类别
	Category category = new Category(Integer.parseInt(id), name);
	// 添加类别
	categoryService.addCategory(category);

	// 查询所有最新数据
	List<Category> categorys = categoryService.list();
	// 存入参数
	mav.addObject("categorys", categorys);
	// 放入jsp路径 即跳转至listCategory.jsp页面
	return mav;
    }

    /**
     * delete 传递id参数 样例：http://127.0.0.1:8080/ssm/category/deleteCategory?id=1
     * @return
     */
    @RequestMapping(value="deleteCategory")
    public ModelAndView deleteCategory(@RequestParam("id") int id) {

	ModelAndView mav = new ModelAndView("listCategory");

	// 根据id参数，删除数据
	categoryService.deleteCategory(id);

	// 查询所有最新数据
	List<Category> categorys = categoryService.list();
	// 存入参数
	mav.addObject("categorys", categorys);
	// 放入jsp路径 即跳转至listCategory.jsp页面
	return mav;
    }

    /**
     * update 传递id、name参数
     * 样例：http://127.0.0.1:8080/ssm/category/updateCategory?id=1&name=cc
     * @return
     */
    @RequestMapping(value="updateCategory")
    public ModelAndView updateCategory(@RequestParam("id") int id,
	    @RequestParam("name") String name) {

	ModelAndView mav = new ModelAndView("listCategory");

	// 根据参数，更新数据
	Category category = categoryService.getCategory(id);
	category.setName(name);
	categoryService.updateCategory(category);

	// 查询所有最新数据
	List<Category> categorys = categoryService.list();
	// 存入参数
	mav.addObject("categorys", categorys);
	// 放入jsp路径 即跳转至listCategory.jsp页面
	return mav;
    }

    /**
     * get 传递id参数 样例：http://127.0.0.1:8080/ssm/category/getCategory?id=1
     * 
     * @return
     */
    @RequestMapping(value="getCategory")
    public ModelAndView getCategory(@RequestParam("id") int id) {
	// 创建视图
	ModelAndView mav = new ModelAndView("getCategory");
	Category category = categoryService.getCategory(id);

	// 存入数据
	mav.addObject("category", category);
	// 即跳转至getCategory.jsp页面
	return mav;
    }

    /**
     * list 样例：http://127.0.0.1:8080/ssm/category/listCategory
     * 
     * @return
     */
    @RequestMapping(value="listCategory")
    public ModelAndView listCategory() {
	// 创建一个listCategory的模型视图
	ModelAndView mav = new ModelAndView("listCategory");
	List<Category> categorys = categoryService.list();

	// 存入数据
	mav.addObject("categorys", categorys);
	// 跳转至页面
	return mav;
    }
}
