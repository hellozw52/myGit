package zw.action;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import net.sf.json.JSONObject;

import org.json.JSONArray;

import zw.dao.TvnDao;
import zw.model.Tvn;

public class isTvnInLeaderGroup extends HttpServlet
{

	/*
	 * 编写一个servlet 判断待处理tvn号是否为领导tvn
	 * 
	 * @see
	 * javax.servlet.http.HttpServlet#doGet(javax.servlet.http.HttpServletRequest
	 * , javax.servlet.http.HttpServletResponse)
	 */
	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException
	{
		response.setContentType("text/html");
		response.setCharacterEncoding("utf-8");

		PrintWriter out = response.getWriter();

		// 获取url传递的tvn参数
		String strTvn = request.getParameter("tvn");

		try
		{
			if (strTvn != null && !"".equals(strTvn))
			{
				// 实例化一个tvn对象 传递strTvn参数
				Tvn tvn = new Tvn(strTvn);
				// 实例化业务逻辑层
				TvnDao tdao = new TvnDao();
				// 插入一条数据 返回插入结果
				if (tdao.isTvnInGroup(tvn))
				{
					// 是领导的tvn号
					// 生成成功json数据
					JSONArray succArray = new JSONArray();
					JSONObject jsonObj = new JSONObject();
					String columnName = "success";
					String value = "1";
					jsonObj.put(columnName, value);
					succArray.put(jsonObj);
					// success:1
					out.print(succArray);
				} else
				{
					// 不是领导的tvn号
					// 返回失败的json数据
					JSONArray falureArray = new JSONArray();
					JSONObject jsonObj = new JSONObject();
					String columnName = "falure";
					String value = "0";
					jsonObj.put(columnName, value);
					falureArray.put(jsonObj);
					// falure:0
					out.print(falureArray);
				}
			} else
			// 传递参数为空或者""，直接打印没有数据
			{
				JSONArray falureArray = new JSONArray();
				JSONObject jsonObj = new JSONObject();
				String columnName = "nodata";
				String value = "0";
				jsonObj.put(columnName, value);
				falureArray.put(jsonObj);
				// nodata:0
				out.print(falureArray);
			}
			out.flush();
			out.close();
		} catch (Exception e)
		{
			e.printStackTrace();
		}
	}

	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException
	{
		this.doGet(request, response);
	}
}
