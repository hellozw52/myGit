package hdfx.controller;

import hdfx.service.BillService;
import hdfx.service.UserService;

import java.util.Map;

import javax.annotation.Resource;



/**
 * 基本controller 减少代码量
 * @author Administrator
 */
public class BaseController{

    // 封装显示的数据
    protected Map<String, Object> data;

    // 供前端页面显示操作结果
    protected String result = null;

    // 待注入的service对象
    @Resource
    protected UserService userService;
    @Resource
    protected BillService billService;

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
