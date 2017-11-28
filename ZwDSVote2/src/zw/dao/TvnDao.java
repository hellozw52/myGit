package zw.dao;

import java.sql.*;
import zw.model.Tvn;
import zw.util.MYSQLUtil;

public class TvnDao
{

	/**
	 * 判断机顶盒的tvn号是否在领导tvn表中
	 * 
	 * @param tvn
	 *            待处理tvn对象
	 * @return true 存在
	 * @return false 不在
	 * @throws Exception
	 */
	public boolean isTvnInGroup(Tvn tvn) throws Exception
	{
		Connection conn = MYSQLUtil.getConnection();
		// sql语句不再采用拼接方式，用占位符问号的方式写sql语句
		String sql = " select * from tvn t where t.tvn = ? ";
		PreparedStatement ptmt = conn.prepareStatement(sql);
		// 对占位符设置值，占位符顺序从1开始，第一个参数是占位符的位置，第二个参数是占位符的值
		ptmt.setString(1, tvn.getTvn());
		// 查询数据表后生成数据集
		ResultSet rs = ptmt.executeQuery();
		// 如果数据集不为空，返回true
		if (rs.next())
		{
			ptmt.close();
			conn.close();
			rs.close();
			// System.out.println("不为null");
			return true;
		}
		// 如果数据集为空，返回false
		else
		{
			ptmt.close();
			conn.close();
			rs.close();
			// System.out.println("为null");
			return false;
		}

	}

}
