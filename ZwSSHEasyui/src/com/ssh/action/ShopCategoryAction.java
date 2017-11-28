package com.ssh.action;

import java.util.HashMap;
import java.util.List;

import org.apache.struts2.ServletActionContext;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;

import com.ssh.pojo.ShopCategory;
import com.ssh.tools.*;

@Controller("shopCategoryAction")
@Scope("prototype")
public class ShopCategoryAction extends BaseAction<ShopCategory> {

    /**
     * 
     */
    private static final long serialVersionUID = 1L;
    
    // 跳转至/admin/shopcategory.jsp
    public String shopCategory() throws Exception {
	return SUCCESS;
    }
    
    /**
     * 查询当前页面内容
     * @return
     * @throws Exception
     */
    public String list() throws Exception {
	// 获取当前页数据
	@SuppressWarnings("unchecked")
	List<ShopCategory> shopCategoryList = shopCategoryService.getCategoryList(page, rows);
	// 获取总数
	int totalShopCategoryNum = shopCategoryService.getCategoryTotal();
	
	// 实例化data 存放数据
	data = new HashMap<String, Object>();
	data.put("rows", shopCategoryList);
	data.put("total", totalShopCategoryNum);
	
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
	    this.shopCategoryService.addCategory(model);
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
	    this.shopCategoryService.deleteCategory(model.getShopcategoryid());
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
	    this.shopCategoryService.updateCategory(model);
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
