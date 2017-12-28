package com.how2java.mapper;
 
import java.util.List;

import com.how2java.pojo.Category;
 
public interface CategoryMapper {
      
    public void add(Category category);  
       
    public void delete(int id);  
       
    public void update(Category category);  
    
    public Category get(int id);  
     
    public List<Category> list();
    
    //根据name模糊查询
    public List<Category> listCategoryByName(String name);
    
    public int count();  
    
}