package zw.tools;

import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import net.sf.json.JSONObject;

import org.apache.struts2.ServletActionContext;

public class StringUtil {
	
	/**
	 * 本方法封装了往前台设置的header,contentType等信息
	 * @param message       需要传给前台的数据
	 * @param type          指定传给前台的数据格式，如"html","json"等
	 * @param response      HttpServletResponse对象
	 * @throws IOException
	 */
	public static void writeToWeb(String message, String type, HttpServletResponse response) throws IOException{
		response.setHeader("Pragma", "No-cache");
		response.setHeader("Cache-Control", "no-cache");
		response.setContentType("text/" + type +"; charset=utf-8");
		response.getWriter().write(message);
		response.getWriter().close();
		
	}
	
	/**
	 * 本方法用于分页页面数据json处理
	 * @param list
	 * @param total
	 * @throws Exception
	 */
	public static void toBeJson(List list, int total) throws Exception{
		HttpServletResponse response = ServletActionContext.getResponse();
		HttpServletRequest request = ServletActionContext.getRequest();
		
		JSONObject jobj = new JSONObject();
		jobj.accumulate("total", total);
		jobj.accumulate("rows", list);
		response.setCharacterEncoding("utf-8");
		response.getWriter().write(jobj.toString());
	}
	
	/**
	 * 转为UTF8编码格式
	 * @param s
	 * @return
	 * @throws UnsupportedEncodingException
	 */
	public static String toUTF8(String s) throws UnsupportedEncodingException{
	    String s1 = new String(s.getBytes("iso-8859-1"),"utf-8");
	    return s1;
	}

}
