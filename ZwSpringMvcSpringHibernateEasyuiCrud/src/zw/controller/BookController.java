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
     * @return @ResponseBody json
     */
    @ResponseBody
    @RequestMapping("/list")
    public Map<String, Object> list(
	    @RequestParam("page") String page, 
	    @RequestParam("rows") String rows) {
	
	// 获取第几页、每页多少行 等参数；缺省赋值: page=1 rows=15
	int start = Integer.parseInt((page == null || page == "0") ? "1": page) - 1;// 开始位置
	int size = Integer.parseInt((rows == null || rows == "0") ? "15": rows);// 每页个数
	
	// 获取某页数据
	List<SsmBook> booklist = bookService.getCurrentPageDataList(start,size);
	// 获取总数
	int videocount = bookService.getTotalNum();

	// 实例化data 存放数据
	data = new HashMap<String, Object>();
	data.put("rows", booklist);
	data.put("total", videocount);
	// 返回json数据
	return data;
    }
    
    /**
     * 多条件模糊查询
     * @param id
     * @param isbn
     * @param title
     * @param page
     * @param rows
     * @return
     */
    @ResponseBody
    @RequestMapping("/search")
    public Map<String, Object> search(
	    @RequestParam("id") String id, 
	    @RequestParam("isbn") String isbn,
	    @RequestParam("title") String title, 
	    @RequestParam("page") String page, 
	    @RequestParam("rows") String rows) {
	
	//存放待查询的参数
	Map<String,Object> params = new HashMap<>();
	// 存放查询结果的数组
	List<SsmBook> booklist = new ArrayList<>();
	// 对查询结果计数
	int resultcount;
	
	int start = Integer.parseInt((page == null || page == "0") ? "1": page) - 1;// 开始位置
	int size = Integer.parseInt((rows == null || rows == "0") ? "15": rows);// 每页个数
		
	// 参数只要有一个不为空，即查询！
	if(!id.isEmpty()||!isbn.isEmpty()||!title.isEmpty()){
		    
	    // 根据三个参数进行查询，没有的参数为空。其中currentpage，pagesize参数用于分页
	    params.put("id", id);
	    params.put("isbn", isbn);
	    params.put("title", title);
	    params.put("start", start);
	    params.put("size", size);
		
	    booklist = bookService.search(params);
	    resultcount = bookService.getTotalNum(params);
	}else{
	    // 所有参数均为空时，显示默认查询结果
	    booklist = bookService.getCurrentPageDataList(start,size);
	    resultcount = bookService.getTotalNum();
	}

	// 实例化data 存放数据
	data = new HashMap<String, Object>();
	data.put("rows", booklist);
	data.put("total", resultcount);
	// 返回json数据
	return data;
    }
    
    /**
     * Create
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
     * Update
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
     * @param id
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
}
