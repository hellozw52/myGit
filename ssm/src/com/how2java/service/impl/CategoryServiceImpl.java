package com.how2java.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.how2java.mapper.CategoryMapper;
import com.how2java.pojo.Category;
import com.how2java.service.CategoryService;

/**
 * @author zhaowei
 *
 */
@Service
public class CategoryServiceImpl implements CategoryService {
    
    //注入categoryMapper
    @Autowired
    CategoryMapper categoryMapper;

    /* 
     * add
     */
    public void addCategory(Category category) {
	categoryMapper.add(category);
    };
    
    /* 
     * delete
     */
    public void deleteCategory(int id) {
	categoryMapper.delete(id);
    }
    
    /* 
     * update 
     */
    public int updateCategory(Category category) {
	return categoryMapper.update(category);
    }
    
    /* 
     * get
     */
    public Category getCategory(int id) {
	return categoryMapper.get(id);
    }
    
    /* 
     * list
     */
    public List<Category> list() {
	return categoryMapper.list();
    }

    /* 
     * listCategoryInJsonByName
     */
    public List<Category> listCategoryByName(String name) {
	return categoryMapper.listCategoryByName(name);
    }

}
