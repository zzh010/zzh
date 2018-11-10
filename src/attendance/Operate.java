package attendance;
import database.DBconnect;
import java.sql.*;

import org.eclipse.swt.SWT;

import beans.Attend;
public class Operate {
	DBconnect db ;
	PreparedStatement pstmt;
	ResultSet rs ;
	public Operate()
	{
		db = new DBconnect();
		pstmt = null;
		rs = null;
	}
	public ResultSet query(int year,int month)
	{
		String sql ="select * from attendance where  year =? and month =?";
		try {
			pstmt = db.conn.prepareStatement(sql);
			pstmt.setInt(1, year);
			pstmt.setInt(2, month);
			rs = pstmt.executeQuery();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return rs;
	}
	public int insert(Attend att,int year,int month)
	{
		int id = att.getId();
		int  flag = 0;
		try {
			Statement stmt = db.conn.createStatement();
			ResultSet rrs = stmt.executeQuery("select * from emp_info where id="+id);
			if(rrs.next())
			{
				String sql ="select * from attendance where id =? and year =? and month=?";
				pstmt = db.conn.prepareStatement(sql);
				pstmt.setInt(1, id);
				pstmt.setInt(2, year);
				pstmt.setInt(3, month);
				ResultSet srr = pstmt.executeQuery();
				if(!srr.next())
				{
					pstmt =db.conn.prepareStatement("insert into attendance(aid,id,year,month,actual,notes) values(null,?,?,?,?,?)");
			    	pstmt.setInt(1, id);
			    	pstmt.setInt(2, year);
			    	pstmt.setInt(3, month);
			    	pstmt.setInt(4, att.getActual());
			    	pstmt.setString(5, att.getNote());
			    	pstmt.executeUpdate();
			    	flag =3;//插入成功
				}else
				{
					flag = 2;//该月的考勤已经存在了
					
				}
				srr.close();
			}
			else
			{
				flag = 1;//输入的用户编号无效
			}
			stmt.close();
			rrs.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		return flag;
	}
	public String delete(int id,int method,int year,int month)
	{
		String flag ="";
		if(method == 1)
		{
			String sql ="delete from attendance where year=? and month = ?";
		    try {
				pstmt = db.conn.prepareStatement(sql);
				pstmt.setInt(1, year);
				pstmt.setInt(2, month);
				int count =pstmt.executeUpdate();
				flag +="共删除了"+count+"行数据";
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}else if(method == 2)
		{
			String sql ="delete from attendance where id=?";
			PreparedStatement pstmt;
			try {
				Statement stmt = db.conn.createStatement();
				String sqql ="select * from attendance where id ="+id;
				ResultSet ff = stmt.executeQuery(sqql);
				if(ff.next())
				{
					pstmt = db.conn.prepareStatement(sql);
					pstmt.setInt(1, id);
					int cou = pstmt.executeUpdate();
					flag +="共有"+cou+"条数据被删除";
				}
				else
				{
					flag+="无此条数据可删除";
					}
				stmt.close();
				ff.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
		}else if(method == 3)
		{
			String sql ="delete from attendance where id=? and year=? and month = ?";
			PreparedStatement pstmt;
			try {
				Statement stmt = db.conn.createStatement();
				String sqql ="select * from attendance where id ="+id;
				ResultSet ff = stmt.executeQuery(sqql);
				if(ff.next())
				{
					pstmt = db.conn.prepareStatement(sql);
					pstmt.setInt(1, id);
					pstmt.setInt(2, year);
					pstmt.setInt(3, month);
					int count = pstmt.executeUpdate();
					flag +="共有"+count+"条记录被删除";
				}
				else
				{
					flag+="数据库中不存在符合条件的数据可以删除";
				}
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
		}
	
		return flag;
	}
	
	public void clo()
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
