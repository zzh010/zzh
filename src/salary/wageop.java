package salary;
import database.DBconnect;
import java.sql.*;

public class wageop {
	DBconnect db;
	PreparedStatement pstmt;
	ResultSet rs;
	public wageop()
	{
		db = new DBconnect();
		pstmt = null;
		rs = null;
	}
	public ResultSet query()
	{
		String sql = "select * from salary  ";
		try {
			pstmt =db.conn.prepareStatement(sql);
			rs = pstmt.executeQuery();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return rs;
	}
	public int insert(mysalary my)
	{
		int flag=0;
		String sql1="select * from salary where id =? and year =? and month =?";
		String sql2="insert into salary values(null,?,?,?,?,?,?)";
		try {
			pstmt = db.conn.prepareStatement(sql1);
			pstmt .setInt(1,my.getId());
			pstmt.setInt(2, my.getYear());
			pstmt.setInt(3, my.getMonth());
			rs = pstmt.executeQuery();
			if(rs.next())
			{
				flag = 1;//说明这个月这个员工的工资情况已存在
			}else
			{
				pstmt = db.conn.prepareStatement(sql2);
				pstmt.setInt(1, my.getId());
				pstmt.setInt(2, my.getSalarybase());
				pstmt.setInt(3, my.getBonus());
				pstmt.setInt(4, my.getExtrawage());
				pstmt.setInt(5, my.getYear());
				pstmt.setInt(6, my.getMonth());
				pstmt.executeUpdate();
				flag = 2;//插入成功
			}
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return flag;
	}
	public void closes()
	{
		try
		{
			if(rs!=null)
				rs.close();
			if(pstmt!=null)
				pstmt.close();
			db.closeDB();
		}catch(SQLException e)
		{
			e.printStackTrace();
		}
	}
  
}
