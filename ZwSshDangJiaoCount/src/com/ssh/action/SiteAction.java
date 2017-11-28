package com.ssh.action;

import java.util.HashMap;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;

import util.StringUtil;

import com.ssh.bean.SiteserverPublishmentSystem;

@Controller("siteAction")
@Scope("prototype")
public class SiteAction extends BaseAction<SiteserverPublishmentSystem> {

    /**
     * 
     */
    private static final long serialVersionUID = 1L;

    /**
     * 查询当前当前tvn对应的站点名称
     * 
     * @return
     * @throws Exception
     */
    public String getCurrentTvnSiteName() throws Exception {

	// 获取传递的tvn号参数
	tvn = request.getParameter("tvn");

	// 如果tvn为空或在数据库中不存在
	if (StringUtil.isNull(tvn) || false == siteService.isTvnExist(tvn)) {
	    // 实例化data 存放数据
	    data = new HashMap<String, Object>();
	    data.put("tvn", "不存在");
	    data.put("sitename", "不存在");
	} else {
	    // tvn不为空且在数据库中存在
	    // 获取站点名称
	    String sitename = siteService.getCurrentTvnSiteName(tvn);
	    // 实例化data 存放json数据
	    data = new HashMap<String, Object>();
	    data.put("tvn", tvn);
	    data.put("sitename", sitename);
	}
	return SUCCESS;
    }
}
