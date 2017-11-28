package com.ssh.action;

import java.lang.reflect.ParameterizedType;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

import org.apache.struts2.ServletActionContext;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;
import com.ssh.service.VoteService;
import com.ssh.until.StringUtil;

public class BaseAction<T> extends ActionSupport implements ModelDriven<T> {

    /**
     * 
     */
    private static final long serialVersionUID = 1L;

    // 显示结果
    protected String result = null;

    //注入service对象
    @Resource
    protected VoteService voteService;

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
    public String getResult() {
	return result;
    }

    public void setResult(String result) {
	this.result = result;
    }
    
}
