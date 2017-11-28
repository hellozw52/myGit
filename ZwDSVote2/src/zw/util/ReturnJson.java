package zw.util;

import java.sql.SQLException;
import org.json.JSONArray;
import flexjson.JSONException;
import net.sf.json.JSONObject;

public class ReturnJson
{
	/**
	 * @param resultflag 结果标识 0 投票成功  1 重复投票  2 投票失败  
	 * @return resultjson 返回投票结果 json格式
	 * @throws SQLException
	 * @throws JSONException
	 */
	public String voteJson(int resultflag) throws SQLException,
			JSONException
	{
		// 获取投票结果标识 flag
		int flag = resultflag;
		// json数组
		JSONArray array = new JSONArray();

		if (flag==0)
		{
			//投票标识为0 投票成功  写入数据库一条数据
			JSONObject jsonObj = new JSONObject();
			String columnName = "success";
			String value = "0";
			jsonObj.put(columnName, value);
			array.put(jsonObj);

		}if(flag==1) 
		{
			//投票标识为1 重复投票  不进行数据库写入操作
			JSONObject jsonObj = new JSONObject();
			String columnName = "success";
			String value = "1";
			jsonObj.put(columnName, value);
			array.put(jsonObj);
		}if(flag==2) 
		{
			//投票标识为2 投票失败（网络异常等）  不进行数据库写入操作
			JSONObject jsonObj = new JSONObject();
			String columnName = "success";
			String value = "2";
			jsonObj.put(columnName, value);
			array.put(jsonObj);
		}
		return array.toString();
	}
}
