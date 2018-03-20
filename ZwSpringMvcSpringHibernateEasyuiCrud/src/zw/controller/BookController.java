package zw.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import zw.model.SsmBook;
import zw.tools.StringUtil;

/**
 * 与前端easyui进行交互
 * CRUD
 * @author zhaowei 
 */
@Controller
@RequestMapping("/book")
public class BookController extends BaseController{
    
    /**
     * 跳转至book.jsp页面
     * @return
     */
    @RequestMapping("/goToBookTab")
    public String goToBookTab() {
	return "book";
    }

    /**
     * 接收前端传递的数据page，rows 获取当前页数据 返回json数据
     * @param page
     * @param rows
     * @return
     */
    @ResponseBody
    @RequestMapping("/list")
    public Map<String, Object> getVideoInfoList(
	    @RequestParam("page") String page, 
	    @RequestParam("rows") String rows) {

	List<SsmBook> booklist = bookService.getCurrentPageBookList(page,
		rows);// 获取某页数据
	int videocount = bookService.getTotalNum();

	// 实例化data 存放数据
	data = new HashMap<String, Object>();
	data.put("rows", booklist);
	data.put("total", videocount);
	// 返回json数据
	return data;
    }
    
    /**
     * Create 中文乱码问题暂未解决
     * @param request
     * @param response 
     * @param isbn  接收前端页面的参数
     * @param title
     * @param publisher
     * @param author
     * @return
     * @throws Exception
     */
    @RequestMapping("/add")
    public String add(
	    HttpServletRequest request,
	    HttpServletResponse response,
	    @RequestParam("isbn") String isbn, 
	    @RequestParam("title") String title,
	    @RequestParam("publisher") String publisher,
	    @RequestParam("author") String author
	    ) throws Exception {
	try {
	    // 创建一条记录
	    SsmBook book = new SsmBook();
	    book.setIsbn(isbn);
	    book.setTitle(title);
	    book.setPublisher(publisher);
	    book.setAuthor(author);
	    
	    // 新增
	    this.bookService.add(book);
	    // 给前端返回{"success":true}
	    result = "{\"success\":true}";
	    StringUtil.writeToWeb(result, "html",response);
	} catch (Exception e) {
	    // 给前端返回{"errorMsg":"保存失败"}
	    result = "{\"errorMsg\":\"保存失败\"}";
	    StringUtil.writeToWeb(result, "html",response);
	}
	return null;
    }
    
    /**
     * Update 中文乱码问题暂未解决
     * @param request
     * @param response
     * @param id     
     * @param isbn   接收修改后的参数
     * @param title
     * @param publisher
     * @param author
     * @return
     * @throws Exception
     */
    @RequestMapping("/update")
    public String update(
	    HttpServletRequest request,
	    HttpServletResponse response,
	    @RequestParam("id") String id,
	    @RequestParam("isbn") String isbn, 
	    @RequestParam("title") String title,
	    @RequestParam("publisher") String publisher,
	    @RequestParam("author") String author
	    ) throws Exception {
	try {
	    //获取待修改的条目
	    SsmBook book = bookService.getById(Integer.parseInt(id));
	    //修改
	    book.setIsbn(isbn);
	    book.setTitle(title);
	    book.setPublisher(publisher);
	    book.setAuthor(author);
	    //更新
	    this.bookService.update(book);
	    // 给前端返回{"success":true}
	    result = "{\"success\":true}";
	    StringUtil.writeToWeb(result, "html",response);
	} catch (Exception e) {
	    // 给前端返回{"errorMsg":"修改失败"}
	    result = "{\"errorMsg\":\"修改失败\"}";
	    StringUtil.writeToWeb(result, "html",response);
	}
	return null;
    }

    /**
     * Delete
     * @param request
     * @param response
     * @param id       delete by id
     * @return
     * @throws Exception
     */
    @RequestMapping("/delete")
    public String delete(
	    HttpServletRequest request,
	    HttpServletResponse response,
	    @RequestParam("id") String id
	    ) throws Exception {
	try {
	    // 获取待删除条目
	    SsmBook book = this.bookService.getById(Integer.parseInt(id));
	    // 删除条目
	    this.bookService.delete(book);
	    result = "{\"success\":true}";
	    StringUtil.writeToWeb(result, "html",response);
	} catch (Exception e) {
	    result = "{\"errorMsg\":\"删除失败\"}";
	    StringUtil.writeToWeb(result, "html",response);
	}
	return null;
    }
    
    
//    /**
//     * 接收前端传递的数据多个参数，查询视频信息
//     * ./getVideoInfoManyPara?videoId=xxx&assetId=xxx&assetName=xxx&page=xxx&rows=xxx
//     * @param videoId 查询字段
//     * @param assetId 查询字段
//     * @param assetName 查询字段
//     * @param page 用于easyui分页
//     * @param rows 用于easyui分页
//     * @return json数据
//     */
//    @ResponseBody
//    @RequestMapping("/getVideoInfoManyPara")
//    public Map<String, Object> getVideoInfoManyPara(
////	    @RequestParam("videoId") String videoId,
////	    @RequestParam("assetId") String assetId,
////	    @RequestParam("assetName") String assetName,
//	    @RequestParam("page") String page, 
//	    @RequestParam("rows") String rows
//	    ) {
//
//	// 对查询结果计数
//	int videocount;
//	
//	// 存放查询结果的数组
//	List<WiredVideo> videolist = new ArrayList<>();
//	
//	// 参数只要有一个不为空
//	if(!videoId.isEmpty()||!assetId.isEmpty()||!assetName.isEmpty()){
//	    
//	    // 如果videoId为空
//	    if(videoId.isEmpty()){
//		
//		// 根据两个参数进行查询,分页,获取结果数。其中page，rows参数用于分页
//		videolist = videoService.getVideoInfoManyPara(assetId,assetName,page,rows);
//		videocount = videoService.getVideoInfoManyParaTotalNum(assetId,assetName);
//	    }else{
//		// 根据三个参数进行查询,分页,获取结果数。其中page，rows参数用于分页
//		videolist = videoService.getVideoInfoManyPara(Integer.parseInt(videoId),assetId,assetName,page,rows);
//		videocount = videoService.getVideoInfoManyParaTotalNum(Integer.parseInt(videoId),assetId,assetName);
//	    }
//	    
//	}else{
//	    // 所有参数均为空时，显示默认查询结果,分页,获取结果数
//	    videolist = videoService.getCurrentPageVideoList(page,rows);
//	    videocount = videoService.getTotalNum();
//	}
//
//	// 实例化data 存放数据， 注意！rows中存放的是数组！！！
//	data = new HashMap<String, Object>();
//	data.put("rows", videolist);
//	data.put("total", videocount);
//
//	// 返回json数据
//	return data;
//    }
}
