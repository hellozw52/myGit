package zw.controller;

import java.util.ArrayList;
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
     * Create 中文乱码问题暂未解决!
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
	    SsmBook book = new SsmBook();
	    book.setIsbn(isbn);
	    book.setTitle(title);
	    book.setPublisher(publisher);
	    book.setAuthor(author);
	    
	    System.out.println(book.toString());
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
	    
	    //修改 设置为UTF8编码格式
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
    
    
//    @ResponseBody
//    @RequestMapping("/getBookInfoManyPara")
//    public Map<String, Object> getBookInfoManyPara(
//	    @RequestParam("id") String id,
//	    @RequestParam("isbn") String isbn,
//	    @RequestParam("title") String title,
//	    @RequestParam("page") String page, 
//	    @RequestParam("rows") String rows
//	    ) {
//
//	// 对查询结果计数
//	int bookcount;
//	
//	// 存放查询结果的数组
//	List<SsmBook> booklist = new ArrayList<>();
//	
//	// 参数只要有一个不为空
//	if(!id.isEmpty()||!isbn.isEmpty()||!title.isEmpty()){
//	    
//	    // 如果id为空
//	    if(id.isEmpty()){
//		
//		// 根据两个参数进行查询,分页,获取结果数。其中page，rows参数用于分页
//		booklist = bookService.getBookInfoManyPara(isbn,title,page,rows);
//		bookcount = bookService.getBookInfoManyParaTotalNum(isbn,title);
//	    }else{
//		// 根据三个参数进行查询,分页,获取结果数。其中page，rows参数用于分页
//		booklist = bookService.getBookInfoManyPara(Integer.parseInt(id),isbn,title,page,rows);
//		bookcount = bookService.getBookInfoManyParaTotalNum(Integer.parseInt(id),isbn,title);
//	    }
//	    
//	}else{
//	    // 所有参数均为空时，显示默认查询结果,分页,获取结果数
//	    booklist = bookService.getCurrentPageBookList(page,rows);
//	    bookcount = bookService.getTotalNum();
//	}
//
//	// 实例化data 存放数据， 注意！rows中存放的是数组！！！
//	data = new HashMap<String, Object>();
//	data.put("rows", booklist);
//	data.put("total", bookcount);
//
//	// 返回json数据
//	return data;
//    }
}
