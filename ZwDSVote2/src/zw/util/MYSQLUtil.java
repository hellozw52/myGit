package zw.util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
public class MYSQLUtil {
	public static Connection getConnection() throws Exception{
		Connection conn=null;
		String url="jdbc:mysql://172.30.96.162:3306/dsvote?useUnicode=true&amp;characterEncoding=utf-8";
		String user="root";
		String password="123456";
		try {
			Class.forName("com.mysql.jdbc.Driver");
			conn = DriverManager.getConnection(url,user,password);
		} catch (Exception e) {
			e.printStackTrace();
			throw e;
		}
		return conn;
	}
	
	//关闭连接
	public static void close(Connection conn){
		if(conn !=null){
			try {
				conn.close();
			} catch (SQLException e) {
			}
		}
	}

}
