package com.how2java.mapper;
 
import java.util.List;

import com.how2java.pojo.Category;
 
public interface CategoryMapper {
      
    public void add(Category category);  
       
    public void delete(int id);  
       
    public int update(Category category);  
    
    public Category get(int id);  
     
    public List<Category> list();
    
    public int count();  
    
}