package zw.controller;

import java.lang.reflect.ParameterizedType;
import java.util.Map;
import javax.annotation.Resource;
import zw.service.BookService;


/**
 * 基本controller 减少代码量
 * @author Administrator
 */
public class BaseController{

    // 封装显示的数据
    protected Map<String, Object> data;

    // 供easyui前端页面显示操作结果
    protected String result = null;

    // 待注入的service对象
    @Resource
    protected BookService bookService;
    
//    // ModelDriven
//    protected T model;
//
//    public T getModel() {
//	ParameterizedType type = (ParameterizedType) this.getClass()
//		.getGenericSuperclass();
//	Class clazz = (Class) type.getActualTypeArguments()[0];
//	try {
//	    model = (T) clazz.newInstance();
//	} catch (Exception e) {
//	    throw new RuntimeException(e);
//	}
//	return model;
//    }
    
    // get和set方法
    public Map<String, Object> getData() {
	return data;
    }

    public void setData(Map<String, Object> data) {
	this.data = data;
    }

    public String getResult() {
	return result;
    }

    public void setResult(String result) {
	this.result = result;
    }
}
