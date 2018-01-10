package zw.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import zw.model.WiredVideo;
import zw.service.VideoService;


/**
 * 关于注入视频的功能
 * @author zhaowei
 */
@Controller    //使用该注解标志它是一个控制器
@RequestMapping("/video")
public class VideoController {
    
    //注入service
    @Autowired
    public VideoService videoService;
    
    //根据id查询注入视频的数据  json格式
    @ResponseBody
    @RequestMapping("/getVideoInfoById")
    public Map<String, Object> getVideoInfoById(@RequestParam("id") String id) {
	
	Map<String, Object> map = new HashMap<String, Object>();
	//如果id为空  返回异常信息
	if(StringUtils.isEmpty(id)){
	  map.put("error", "id param is null or empty!");
	}else{
	  //将字符串转成整形
	  WiredVideo wiredVideo = videoService.getVideoInfoById(Integer.parseInt(id));
	  //如果没有查到结果
	  if(wiredVideo==null){
	      map.put("error", "no data found!");
	  }else{
	      //正常查到的结果
	      map.put("DataArea", wiredVideo);
	  }
	}
	return map;
    }
    
    //查询所有视频记录
    @ResponseBody
    @RequestMapping("/getAllVideoInfo")
    public Map<String, Object> getAllVideoInfo() {
	
	List<WiredVideo> videolist = videoService.getAllVideoInfo();
	Map<String, Object> map = new HashMap<String, Object>();
	map.put("DataArea", videolist);
	map.put("TotalNum", videoService.getTotalNum());
	return map;
    }
}