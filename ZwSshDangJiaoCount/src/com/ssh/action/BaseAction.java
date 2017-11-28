package com.ssh.action;

import java.lang.reflect.ParameterizedType;
import java.util.Map;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

import org.apache.struts2.ServletActionContext;
import org.apache.struts2.interceptor.ApplicationAware;
import org.apache.struts2.interceptor.RequestAware;
import org.apache.struts2.interceptor.SessionAware;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;
import com.ssh.service.SiteService;

public class BaseAction<T> extends ActionSupport implements RequestAware,
	SessionAware, ApplicationAware, ModelDriven<T> {

    /**
     * 
     */
    private static final long serialVersionUID = 1L;
    
    // 封装数据
    protected Map<String, Object> data;

    // 待查询tvn号
    protected String tvn;
    
    // service对象
    @Resource
    protected SiteService siteService;

    
    // 在Action中取得HttpServletRequest对象，使用request.getParameter获取参数
    ActionContext context = ActionContext.getContext();
    HttpServletRequest request = (HttpServletRequest) context
	    .get(ServletActionContext.HTTP_REQUEST);

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
    public String getTvn() {
        return tvn;
    }

    public void setTvn(String tvn) {
        this.tvn = tvn;
    }

    public Map<String, Object> getData() {
	return data;
    }

    public void setData(Map<String, Object> data) {
	this.data = data;
    }


    @Override
    public void setApplication(Map<String, Object> arg0) {
	// TODO Auto-generated method stub
	
    }

    @Override
    public void setSession(Map<String, Object> arg0) {
	// TODO Auto-generated method stub
	
    }

    @Override
    public void setRequest(Map<String, Object> arg0) {
	// TODO Auto-generated method stub
	
    }
}
