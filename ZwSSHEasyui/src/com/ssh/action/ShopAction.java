package com.ssh.action;

import java.util.HashMap;
import java.util.List;

import org.apache.struts2.ServletActionContext;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;

import com.ssh.pojo.Shop;
import com.ssh.tools.*;

@Controller("shopAction")
@Scope("prototype")
public class ShopAction extends BaseAction<Shop> {

    /**
     * 
     */
    private static final long serialVersionUID = 1L;

    // 跳转至/admin/shopcontrol.jsp
    public String shop() throws Exception {
	return SUCCESS;
    }

    /**
     * 查询当前页面内容
     * 
     * @return
     * @throws Exception
     */
    public String list() throws Exception {

	List<Shop> shopList = shopService.getCurrentPageShopList(page, rows);// 获取某页数据
	int totalShopNum = shopService.getShopTotal();// 获取总数

	// 实例化data 存放数据
	data = new HashMap<String, Object>();
	data.put("rows", shopList);
	data.put("total", totalShopNum);

	return SUCCESS;
    }

    /**
     * 添加
     * 
     * @return
     * @throws Exception
     */
    public String add() throws Exception {
	try {
	    this.shopService.addShop(model);
	    // 前端返回{"success":true}
	    result = "{\"success\":true}";
	    StringUtil.writeToWeb(result, "html",
		    ServletActionContext.getResponse());
	} catch (Exception e) {
	    // 前端返回{"errorMsg":"保存失败"}
	    result = "{\"errorMsg\":\"保存失败\"}";
	    StringUtil.writeToWeb(result, "html",
		    ServletActionContext.getResponse());
	}
	return SUCCESS;
    }

    /**
     * 删除
     * 
     * @return
     * @throws Exception
     */
    public String delete() throws Exception {

	try {
	    this.shopService.deleteShop(model.getShopid());
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

    /**
     * 修改
     * 
     * @return
     * @throws Exception
     */
    public String update() throws Exception {
	try {
	    this.shopService.updateShop(model);
	    result = "{\"success\":true}";
	    StringUtil.writeToWeb(result, "html",
		    ServletActionContext.getResponse());
	} catch (Exception e) {
	    result = "{\"errorMsg\":\"修改失败\"}";
	    StringUtil.writeToWeb(result, "html",
		    ServletActionContext.getResponse());
	}
	return SUCCESS;
    }

}
