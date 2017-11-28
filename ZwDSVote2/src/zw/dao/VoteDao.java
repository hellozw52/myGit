package zw.dao;

import java.sql.*;
import java.text.SimpleDateFormat;
import java.util.*;
import java.util.Date;

import zw.model.Vote;
import zw.util.MYSQLUtil;

public class VoteDao
{
	
	/**
	 * 添加一条投票记录
	 * @param v 待处理vote对象
	 * @return true 插入一条数据成功  false 插入一条数据失败
	 * @throws Exception
	 */
	public boolean addVote(Vote v) throws Exception
	{
		Connection conn = MYSQLUtil.getConnection();
		// sql语句不再采用拼接方式，用占位符问号的方式写sql语句
		String sql = "insert into vote(tvn,voteid,votetime,address) values(?,?,?,?)";
		PreparedStatement ptmt = conn.prepareStatement(sql);
		// 对占位符设置值，占位符顺序从1开始，第一个参数是占位符的位置，第二个参数是占位符的值
		ptmt.setString(1, v.getTvn());
		ptmt.setString(2, v.getVoteid());
		ptmt.setString(3, v.getVotetime());
		ptmt.setString(4, v.getAddress());
		// 如果b为false 表示写入数据成功  正常b为false
		boolean b = ptmt.execute();
//		System.out.println(b);
		ptmt.close();
		conn.close();
		if(b){
			//没有写入数据
			return false;
		}else{
			//写入的有数据
			return true;
		}
	}
	
	/**
	 * 判断待处理tvn是否已经存在
	 * @param v 待处理vote对象
	 * @return true 本日已经投过票   false 本日没有投过票
	 * @throws Exception
	 */
	public boolean queryExistTvn(Vote v) throws Exception
	{
		Connection conn = MYSQLUtil.getConnection();
		
		// 根据tvn号和当前日期 插叙该tvn号当日是否投票。如果有数据即投过票，否者没有投票
		// 样例sql ：SELECT v.votetime FROM vote v WHERE v.tvn = '21386078' AND SUBSTR(votetime,1,10)= '2016-12-23'
		String sql = "SELECT v.votetime FROM vote v WHERE v.tvn = ? AND SUBSTR(votetime,1,10)= ? ";
		PreparedStatement ptmt = conn.prepareStatement(sql);
		// 传递用户tvn号  "21386078"
		ptmt.setString(1, v.getTvn());
		// 传递当前日期时间  格式为"yyyy-MM-dd"
		ptmt.setString(2, v.getVotetime());
		ResultSet rs = ptmt.executeQuery();
		//这个tvn号的投票集合
		List<Vote> votelist =new ArrayList<Vote>();
		Vote vote = null;
		while(rs.next()){
			 vote = new Vote();
			 vote.setVotetime(rs.getString("votetime"));
			 votelist.add(vote);
		}
		ptmt.close();
		conn.close();
		
		 
		//如果查询的结果数目大于0 则认为本日已投票，返回true
		if(votelist.size()>0){
			//测试打印数据个数 一般为1
			//System.out.println(list.size());
			return true; 
		}else{
			//本日没有投票数据，返回false
			return false; 
		}
	}

}
