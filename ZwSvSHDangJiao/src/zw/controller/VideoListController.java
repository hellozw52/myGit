package zw.controller;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import zw.model.WiredVideo;

/**
 * VideoList
 * @author zhaowei 此controller用于easyui交互，供界面展示数据
 */
// 使用该注解标志它是一个控制器
@Controller
@RequestMapping("/videolist")
public class VideoListController extends BaseController {

    /**
     * 接收前端传递的数据page，rows 获取当前页数据 返回json数据
     *  ./getVideoInfoList?page=xxx&rows=xxx
     * @param page
     * @param rows
     * @return
     */
    @ResponseBody
    @RequestMapping("/getVideoInfoList")
    public Map<String, Object> getVideoInfoList(
	    @RequestParam("page") String page, 
	    @RequestParam("rows") String rows) {

	List<WiredVideo> videolist = videoService.getCurrentPageVideoList(page,
		rows);// 获取某页数据
	int videocount = videoService.getTotalNum();

	// 实例化data 存放数据
	data = new HashMap<String, Object>();
	data.put("rows", videolist);
	data.put("total", videocount);
	// 返回json数据
	return data;
    }
    
    /**
     * 接收前端传递的数据多个参数  获取信息记录
     * ./getVideoInfoManyPara?videoId=xxx&assetId=xxx&assetName=xxx
     * @param videoId
     * @param assetId
     * @param assetName
     * @return
     */
    @ResponseBody
    @RequestMapping("/getVideoInfoManyPara")
    public Map<String, Object> getVideoInfoManyPara(
	    @RequestParam("videoId") String videoId,
	    @RequestParam("assetId") String assetId,
	    @RequestParam("assetName") String assetName,
	    
	    @RequestParam("page") String page, 
	    @RequestParam("rows") String rows
	    ) {

	// 计数
	int videocount;
	
	// 存放查询结果
	List<WiredVideo> videolist = new ArrayList<>();
	
	// 参数只要有一个不为空
	if(!videoId.isEmpty()||!assetId.isEmpty()||!assetName.isEmpty()){
	    
	    // 如果videoId为空
	    if(videoId.isEmpty()){
		
		// 不传videoId参数进行查询
		videolist = videoService.getVideoInfoManyPara(
			assetId,
			assetName);
	    }else{
		// 如果videoId不为空，传递所有参数进行查询
		videolist = videoService.getVideoInfoManyPara(
			Integer.parseInt(videoId),
			assetId,
			assetName);
	    }
	    
	}else{
	    // 所有参数均为空时，显示默认查询结果
	    videolist = videoService.getCurrentPageVideoList(page,
			rows);
	}
	// 获取结果总数
	videocount = videolist.size();

	// 实例化data 存放数据， 注意！rows中存放的是数组！！！
	data = new HashMap<String, Object>();
	data.put("rows", videolist);
	data.put("total", videocount);

	// 返回json数据
	return data;
    }

    /**
     * 跳转至video.jsp页面
     * @return
     */
    @RequestMapping("/goToVideoTab")
    public String goToVideoTab() {
	return "video";
    }

}
