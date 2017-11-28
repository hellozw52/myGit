package action;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import net.sf.json.JSONArray;
import net.sf.json.JSONObject;
import net.sf.json.JsonConfig;

import entity.Students;

import service.StudentsDAO;
import service.impl.StudentsDAOImpl;
import zw.util.JsonDateValueProcessor;
import zw.util.ResponseUtil;
import zw.util.StringUtil;



//学生操作Action
public class StudentsAction extends SuperAction {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	
	/**
	 * 分页查询所有学生
	 * @throws Exception 
	 */
	public void queryPage() throws Exception
	{
		//获取参数
		String page = request.getParameter("page");
		String rows = request.getParameter("rows");
		//转换参数
		int pageInt;
		int rowsInt;
		
		// 当page，rows 都为空时，赋值分别1和10；不为空时，传递参数
		if(StringUtil.isNullOrEmpty(page)&&StringUtil.isNullOrEmpty(rows))
		{
			pageInt = 1;
			rowsInt = 10;
		}
		else
		{
			pageInt = Integer.parseInt(page);
			rowsInt = Integer.parseInt(rows);
		}
		
		StudentsDAO sdao = new StudentsDAOImpl();
		
		//不传参数默认显示第一页
		List<Students> list = sdao.queryPagerStudents(pageInt, rowsInt);
		
		//json处理日期格式为  yyyy-MM-dd 形式
		JsonConfig jsonConfig = new JsonConfig();
		jsonConfig.registerJsonValueProcessor(Date.class, new JsonDateValueProcessor());
		
		//学生json数据
		JSONObject result = new JSONObject() ;
		//将学生集合转为json
		JSONArray jsonArray = JSONArray.fromObject(list,jsonConfig);
		
		//获取用户个数
		int total= sdao.countStudents();
		//每页记录
		result.put("rows", jsonArray);
		//总数
		result.put("total", total);
        
        ResponseUtil.write(response, result);
	}
	
	/**
	 * 根据sid删除学生信息
	 * @throws Exception 
	 */
	public void delete() throws Exception
	{
		StudentsDAO sdao = new StudentsDAOImpl();
		String delId = request.getParameter("delId");
		boolean isdel = sdao.deleteStudents(delId);//删除成功，返回true，反之false
		//返回删除结果json
		JSONObject result = new JSONObject();
		if(isdel)
		{
			result.put("success", "true");//删除成功
		}
		else
		{
			result.put("errorMsg", "删除失败");//删除失败
		}
		
		ResponseUtil.write(response, result);
	}
	
	
	
	/**
	 * 添加学生信息
	 * @throws Exception 
	 */
	public void add() throws Exception
	{
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
		//接收参数
		String sname = request.getParameter("sname");
		String gender = request.getParameter("gender");
		Date birthday = sdf.parse(request.getParameter("birthday"));
		String address = request.getParameter("address");
		
		JSONObject result = new JSONObject();//结果json
		StudentsDAO sdao = new StudentsDAOImpl();
		Students s = new Students();
		//赋值
		s.setSname(sname);
		s.setGender(gender);
		s.setBirthday(birthday);
		s.setAddress(address);
		
		//添加学生  创建一个最新的编号
		boolean isadded = sdao.addStudents(s);
		
		if(isadded)
		{
			result.put("success", "true");
		}
		else
		{
			result.put("errorMsg", "添加失败");
		}
		
		ResponseUtil.write(response, result);
	}
	
	
	/**
	 * 更新学生信息
	 * @throws Exception 
	 */
	public void update() throws Exception
	{
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
		
		//获取传递过来的参数  需要判断传递的sid是否为空
		String sid = request.getParameter("sid");
		String sname = request.getParameter("sname");
		String gender = request.getParameter("gender");
		Date birthday = sdf.parse(request.getParameter("birthday"));
		String address = request.getParameter("address");
		
		//结果json
		JSONObject result = new JSONObject();
		StudentsDAO sdao = new StudentsDAOImpl();
		Students s = sdao.queryStudentsBySid(sid);
		//赋值
		s.setSname(sname);
		s.setGender(gender);
		s.setBirthday(birthday);
		s.setAddress(address);
		//提交更新
		boolean isupdate = sdao.updateStudents(s);
		
		if(isupdate)
		{
			result.put("success", "true");
		}
		else
		{
			result.put("errorMsg", "修改失败");
		}
		
		ResponseUtil.write(response, result);
	}
	
	/**
	 * 根据sid查询学生信息（暂未启用）
	 * @throws Exception 
	 */
//	public void getStudentsBySid(String sid) throws Exception
//	{
//		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
//		//json处理日期格式为  yyyy-MM-dd 形式
//		JsonConfig jsonConfig = new JsonConfig();
//		jsonConfig.registerJsonValueProcessor(Date.class, new JsonDateValueProcessor());
//		StudentsDAO sdao = new StudentsDAOImpl();
//		
//		//获取传递过来的参数  需要判断传递的sid是否为空
//		String sId = request.getParameter("sid");
//		Students s = sdao.queryStudentsBySid(sId);
//		if(s!=null)
//		{
//			//json数据
//			JSONObject result = new JSONObject() ;
//			//将学生转为json
//			JSONArray jsonArray = JSONArray.fromObject(s,jsonConfig);
//			//获取用户个数
//			int total= sdao.countStudents();
//			//每页记录
//			result.put("rows", jsonArray);
//			//总数
//			result.put("total", total);
//	        
//	        ResponseUtil.write(response, result);
//		}
//		else
//		{
//			ResponseUtil.write(response, "no one found!");
//		}
//		
//	}
}
