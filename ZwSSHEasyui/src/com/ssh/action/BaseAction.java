package com.ssh.action;

import java.lang.reflect.ParameterizedType;
import java.util.Map;

import javax.annotation.Resource;

import org.apache.struts2.interceptor.ApplicationAware;
import org.apache.struts2.interceptor.RequestAware;
import org.apache.struts2.interceptor.SessionAware;

import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;
import com.ssh.service.ShopCategoryService;
import com.ssh.service.ShopService;
import com.ssh.service.UserService;

public class BaseAction<T> extends ActionSupport implements RequestAware,
	SessionAware, ApplicationAware, ModelDriven<T> {

    /**
     * 
     */
    private static final long serialVersionUID = 1L;
    // 封装数据
    protected Map<String, Object> data;

    // page和rows和分页有关
    protected String page;
    protected String rows;

    // 供easyui前端页面显示操作结果
    protected String result = null;

    // service对象
    @Resource
    protected ShopService shopService;
    @Resource
    protected ShopCategoryService shopCategoryService;
    @Resource
    protected UserService userService;

    // 域对象
    protected Map<String, Object> request;
    protected Map<String, Object> session;
    protected Map<String, Object> application;

    public void setApplication(Map<String, Object> application) {
	this.application = application;
    }

    public void setSession(Map<String, Object> session) {
	this.session = session;
    }

    public void setRequest(Map<String, Object> request) {
	this.request = request;
    }

    // ModelDriven
    protected T model;

    public T getModel() {
	ParameterizedType type = (ParameterizedType) this.getClass()
		.getGenericSuperclass();
	Class clazz = (Class) type.getActualTypeArguments()[0];
	try {
	    model = (T) clazz.newInstance();
	} catch (Exception e) {
	    throw new RuntimeException(e);
	}
	return model;
    }

    // get和set方法
    public String getPage() {
	return page;
    }

    public void setPage(String page) {
	this.page = page;
    }

    public String getRows() {
	return rows;
    }

    public void setRows(String rows) {
	this.rows = rows;
    }

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
