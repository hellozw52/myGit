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
 * 针对前端开发的接口：电视门户系统视频信息查询
 * @author zhaowei
 */
@Controller    //使用该注解标志它是一个控制器
@RequestMapping("/video")
public class VideoController {
    
    //注入service
    @Autowired
    public VideoService videoService;
    
    /**
     * 根据id查询注入视频的数据  json格式
     * 	./getVideoInfoById?id=xxx
     * @param id
     * @return
     */
    @ResponseBody
    @RequestMapping("/getVideoInfoById")
    public Map<String, Object> getVideoInfoById(@RequestParam("id") String id) {
	
	Map<String, Object> map = new HashMap<String, Object>();
	//如果id为空  返回异常信息
	if(StringUtils.isEmpty(id)){
	  map.put("Result", "query failed");
	  map.put("Cause", "id param is null or empty!");
	}else{
	  //将字符串转成整形
	  List<WiredVideo> videolist = videoService.getVideoInfoManyPara(Integer.parseInt(id),"","");
	  //如果没有查到结果
	  if(videolist==null){
	      map.put("Result", "query failed");
	      map.put("Cause", "no data found");
	  }else{
	      //正常查到的结果
	      map.put("Result", "query success");
	      map.put("VideoId", id);
	      map.put("DataArea", videolist);
	  }
	}
	return map;
    }
    
    /**
     * 查询所有视频记录
     * @return
     */
    @ResponseBody
    @RequestMapping("/getAllVideoInfo")
    public Map<String, Object> getAllVideoInfo() {
	
	List<WiredVideo> videolist = videoService.getAllVideoInfo();
	Map<String, Object> map = new HashMap<String, Object>();
	map.put("Result", "query success");
	map.put("DataArea", videolist);
	map.put("TotalNum", videoService.getTotalNum());
	return map;
    }
}
