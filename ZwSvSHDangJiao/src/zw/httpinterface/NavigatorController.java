package zw.httpinterface;

import java.util.HashMap;
import java.util.Map;

import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import zw.service.NavigatorService;

/**
 * 导航的功能 根据双向优先机顶盒tvn号 重定向至站点页面
 * 针对前端页面开发的接口：电视门户系统小导航
 * @author zhaowei
 */
@Controller
// 使用该注解标志它是一个控制器
@RequestMapping("/navigator")
public class NavigatorController {

    // 注入service
    @Autowired
    public NavigatorService navigatorService;

    /**
     * 根据tvn获取站点url路径 json格式
     *  ./getSiteUrlByTvn?tvn=xxx
     * @param tvn
     * @return
     */
    @ResponseBody
    @RequestMapping("/getSiteUrlByTvn")
    public Map<String, Object> getSiteUrlByTvn(@RequestParam("tvn") String tvn) {

	Map<String, Object> map = new HashMap<String, Object>();
	
	//System.out.println(tvn);
	
	// 如果tvn为空 返回异常信息
	if (StringUtils.isEmpty(tvn)) {
	    map.put("Result", "query failed");
	    map.put("Cause", "param is null or empty");
	} else
	// 如果tvn号在数据表中存在
	if (navigatorService.isTvnExist(tvn)) {
	    // 查询站点名称
	    String sitename = navigatorService.getCurrentTvnSiteName(tvn);
	    // 获取站点url地址
	    String siteurl = getSiteUrl(sitename);
	    map.put("Result", "query success");
	    map.put("Tvn", tvn);
	    map.put("SiteUrl", siteurl);
	} else 
	    // tvn不在数据表中
	    if(!navigatorService.isTvnExist(tvn)){
	    map.put("Result", "query failed");
	    map.put("Cause", "tvn not in DataBase");
	}
	
	//返回json
	return map;
    }
    
    /**
     * 拼接站点url地址
     * @param sitename
     * @return
     */
    public String getSiteUrl(String sitename){
	
	String url1 = "http://172.30.96.161/";
	String url2 = "http://172.30.96.175/";
	String url3 = "http://172.30.96.176/";
	String url4 = "http://172.30.96.177/";
	String url5 = "http://172.30.96.178/";
	
	String[] url={url1,url2,url3,url4,url5}; 
	
	//随机获取一个地址，拼接站点名称，获取站点url
	int random = (int) ( Math.random () * 5 );
	String finalurl = url[random]+sitename;
	
	return finalurl;
    }

}
