package hdfx.controller;

import hdfx.entity.Bill;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by hellozw on 2019/3/4.
 * 
 * 话单控制器
 */
@Controller
@RequestMapping("/bill")
public class BillController extends BaseController {

	/**
	 * 跳转至话单页面
	 * 
	 * @return
	 */
	@RequestMapping("/goToBillTab")
	public String goToBillTab() {
		return "bill";
	}

	/**
	 * 接收前端传递的数据page，rows 获取当前页数据 返回json数据
	 * 
	 * @param page
	 * @param rows
	 * @return @ResponseBody json
	 */
	@ResponseBody
	@RequestMapping("/list")
	public Map<String, Object> list(@RequestParam("page") String page, @RequestParam("rows") String rows) {

		// 获取第几页、每页多少行 等参数；缺省赋值: page=1 rows=15
		int start = Integer.parseInt((page == null || page == "0") ? "1" : page) - 1;// 开始位置
		int size = Integer.parseInt((rows == null || rows == "0") ? "15" : rows);// 每页个数

		// 获取某页数据
		List<Bill> billist = billService.getCurrentPageDataList(start, size);
		// 获取总数
		int billcount = billService.getTotalNum();

		// 实例化data 存放数据
		data = new HashMap<String, Object>();
		data.put("rows", billist);
		data.put("total", billcount);
		// 返回json数据
		return data;
	}

	/**
	 * 多条件模糊查询
	 */
//	@ResponseBody
//	@RequestMapping("/search")
//	public Map<String, Object> search(@RequestParam("id") String id, @RequestParam("isbn") String isbn,
//			@RequestParam("title") String title, @RequestParam("page") String page, @RequestParam("rows") String rows) {
//
//		// 存放待查询的参数
//		Map<String, Object> params = new HashMap<>();
//		// 存放查询结果的数组
//		List<SsmBook> booklist = new ArrayList<>();
//		// 对查询结果计数
//		int resultcount;
//
//		int start = Integer.parseInt((page == null || page == "0") ? "1" : page) - 1;// 开始位置
//		int size = Integer.parseInt((rows == null || rows == "0") ? "15" : rows);// 每页个数
//
//		// 参数只要有一个不为空，即查询！
//		if (!id.isEmpty() || !isbn.isEmpty() || !title.isEmpty()) {
//
//			// 根据三个参数进行查询，没有的参数为空。其中currentpage，pagesize参数用于分页
//			params.put("id", id);
//			params.put("isbn", isbn);
//			params.put("title", title);
//			params.put("start", start);
//			params.put("size", size);
//
//			booklist = bookService.search(params);
//			resultcount = bookService.getTotalNum(params);
//		} else {
//			// 所有参数均为空时，显示默认查询结果
//			booklist = bookService.getCurrentPageDataList(start, size);
//			resultcount = bookService.getTotalNum();
//		}
//
//		// 实例化data 存放数据
//		data = new HashMap<String, Object>();
//		data.put("rows", booklist);
//		data.put("total", resultcount);
//		// 返回json数据
//		return data;
//	}
}
