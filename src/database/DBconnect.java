package database;
import java.sql.*;

/**
 * ������ɵ������ݿ�����Ӻ͹رգ���Ϊÿ����������ʹ�õ����ݿ�Ŀ��͹أ�Ϊ��ʹ������Ը��ã������ר�ŷ�װ��һ���࣬�Է���������
 * ֱ�ӽ��е���
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
