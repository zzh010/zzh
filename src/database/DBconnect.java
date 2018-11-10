package database;
import java.sql.*;

/**
 * 该类完成的是数据库的连接和关闭，因为每个操作都会使用到数据库的开和关，为了使代码可以复用，把这个专门封装成一个类，以方便其他类
 * 直接进行调用
 * 
 *
 */
public class DBconnect {
	
	public Connection conn = null;
	public DBconnect()
	{
		
		try {
			Class.forName("com.mysql.jdbc.Driver");
			String url = "jdbc:MySQL://localhost:3306/test?user=root&password=123" +
			"&uesUnicode=true&characterEncoding=gb2312";
						
			conn = DriverManager.getConnection(url);
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}catch(SQLException e)
		{
			e.printStackTrace();
		}
		
	}
	public void closeDB()
	{
		if(conn!=null)
		{
			try {
				conn.close();
			} catch (SQLException e) {
			
				e.printStackTrace();
			}
		}
	}
	
}
