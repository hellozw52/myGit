package zw.action;

import java.io.IOException;
import java.io.PrintWriter;
import java.text.SimpleDateFormat;
import java.util.Date;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import zw.dao.VoteDao;
import zw.model.Vote;
import zw.util.ReturnJson;

public class GetOnceVoteResult extends HttpServlet
{

	/*
	 * 编写一个servlet 实现通过assetId来查询对应资产所有信息
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
		String tvn = request.getParameter("tvn");
		// 获取url传递的voteid参数
		String voteid = request.getParameter("voteid");
		// 投票结果标识： true为投票成功 false为投票失败 初始化为false
		boolean voteflag = false;
		// 设置日期格式
		SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd");

		try
		{
			if (tvn != null && voteid != null && !"".equals(tvn)
					&& !"".equals(voteid))
			{
				// 实例化一个vote对象 传递tvn,voteid，data,address参数
				Vote v = new Vote(tvn, voteid, df.format(new Date()),
						"Default Place");
				// 实例化业务逻辑层
				VoteDao vdao = new VoteDao();
				// 插入一条数据 返回插入结果
				if (vdao.queryExistTvn(v))
				{
					// 已经投过票
					// 生成操作失败的json数据
					ReturnJson jsonFalse = new ReturnJson();
					// 传递投票标识1 写入失败
					String strJsonFalse = jsonFalse.voteJson(1);
					// 接口显示插入数据表记录失败
					out.print(strJsonFalse);
				} else
				{
					// 开始投票 为true 表中插入数据
					voteflag = vdao.addVote(v);
					if (voteflag)
					{
						// 实例化要返回结果的json
						ReturnJson jsonTrue = new ReturnJson();
						// 传递投票标识0 写入一条数据成功
						String strJsonTrue = jsonTrue.voteJson(0);
						// 接口显示插入数据表记录成功
						out.print(strJsonTrue);
					}
				}
			} else
			{// 第一个if
				// 没有正常传递参数
				// out.println("传递参数不正确");
				// 实例化要返回结果的json
				ReturnJson jsonFalse2 = new ReturnJson();
				// 传递投票标识2 调取接口错误（参数不正确）
				String strJsonFalse2 = jsonFalse2.voteJson(2);
				// 接口显示插入数据表记录成功
				out.print(strJsonFalse2);
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
