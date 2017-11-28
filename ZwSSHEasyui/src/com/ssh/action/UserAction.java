package com.ssh.action;

import java.util.HashMap;
import java.util.List;

import javax.annotation.Resource;

import org.apache.struts2.ServletActionContext;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;

import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;
import com.ssh.pojo.Shop;
import com.ssh.pojo.User;
import com.ssh.service.UserService;
import com.ssh.tools.StringUtil;

@Controller("userAction")
@Scope("prototype")
public class UserAction extends BaseAction<User> {

    /**
     * 
     */
    private static final long serialVersionUID = 1L;

    public String user() throws Exception {
	return SUCCESS;
    }

    /**
     * 查询当前页面内容
     * 
     * @return
     * @throws Exception
     */
    public String list() throws Exception {
	
	List<User> userList = userService.getCurrentPageUserList(page, rows);// 获取某页数据
	int totalUserNum = userService.getUserTotal();//获取总数
	
	// 实例化data 存放数据
	data = new HashMap<String, Object>();
	data.put("rows", userList);
	data.put("total", totalUserNum);
	
	return SUCCESS;
    }

    public String add() throws Exception {
	try {
	    this.userService.addUser(model);
	    result = "{\"success\":true}";
	    StringUtil.writeToWeb(result, "html",
		    ServletActionContext.getResponse());
	} catch (Exception e) {
	    System.out.println("保存失败");
	    result = "{\"errorMsg\":\"保存失败\"}";
	    StringUtil.writeToWeb(result, "html",
		    ServletActionContext.getResponse());
	}
	return SUCCESS;
    }

    public String delete() throws Exception {
	try {
	    this.userService.deleteUser(model.getUserid());
	    result = "{\"success\":true}";
	    StringUtil.writeToWeb(result, "html",
		    ServletActionContext.getResponse());
	} catch (Exception e) {
	    result = "{\"errorMsg\":\"删除失败\"}";
	    StringUtil.writeToWeb(result, "html",
		    ServletActionContext.getResponse());
	}
	return SUCCESS;
    }

    public String update() throws Exception {

	try {
	    this.userService.updateUser(model);
	    result = "{\"success\":true}";
	    StringUtil.writeToWeb(result, "html",
		    ServletActionContext.getResponse());
	} catch (Exception e) {
	    result = "{\"errorMsg\":\"保存失败\"}";
	    StringUtil.writeToWeb(result, "html",
		    ServletActionContext.getResponse());
	}
	return SUCCESS;
    }

}
