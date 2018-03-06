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

    // 接收前端传递的数据page，rows 获取当前页数据 返回json数据
    @ResponseBody
    @RequestMapping("/getVideoInfoList")
    public Map<String, Object> getVideoInfoList(
	    @RequestParam("page") String page, @RequestParam("rows") String rows) {

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

    // 接收前端传递的数据videoId参数 获取信息记录
    // ./getVideoInfoByManyParam?videoId=xxx
    @ResponseBody
    @RequestMapping("/getVideoInfoByVideoId")
    public Map<String, Object> getVideoInfoByVideoId(
	    @RequestParam("videoId") String videoId) {

	// 创建一个数组
	List<WiredVideo> videolist = new ArrayList<>();
	// 计数
	int videocount;
	// 显示查询的结果 将string转为int类型
	WiredVideo wiredvideo = videoService.getVideoInfoById(Integer
		.parseInt(videoId));
	// 将结果数据添加至数组
	videolist.add(wiredvideo);
	// 获取结果总数
	videocount = videolist.size();

	// 实例化data 存放数据， 注意！rows中存放的是数组！！！
	data = new HashMap<String, Object>();
	data.put("rows", videolist);
	data.put("total", videocount);

	// 返回json数据
	return data;
    }

    // 跳转至video.jsp页面
    @RequestMapping("/goToVideoTab")
    public String goToVideoTab() {
	return "video";
    }

}
