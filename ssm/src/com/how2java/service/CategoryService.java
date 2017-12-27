package com.how2java.service;

import java.util.List;

import com.how2java.pojo.Category;

public interface CategoryService {

    void addCategory(Category category);
    
    void deleteCategory(int id);
    
    int updateCategory(Category category);
    
    Category getCategory(int id);
    
    List<Category> list();

}
