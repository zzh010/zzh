package attendance;
//download by http://www.codefans.net
import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.swt.widgets.Label;
import org.eclipse.swt.SWT;
import org.eclipse.swt.widgets.Text;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.events.SelectionAdapter;
import org.eclipse.swt.events.SelectionEvent;
import org.eclipse.swt.graphics.Image;

import java.sql.*;

import database.DBconnect;
import javax.swing.JOptionPane;
import org.eclipse.swt.widgets.Combo;
import org.eclipse.swt.widgets.Spinner;
import com.swtdesigner.SWTResourceManager;
public class update {
	private Text id;
	private Text name;
	private Text actual;
	private Text note;
	private Combo month;
	private Combo year;
	

	/**
	 * Launch the application.
	 * @param args
	 */
	public static void main(String[] args) {
		try {
			update window = new update();
			window.open();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * Open the window.
	 */
	public void open() {
		Display display = Display.getDefault();
		final Shell shell = new Shell();
		shell.setBackground(SWTResourceManager.getColor(153, 255, 255));
		shell.setSize(503, 399);
		shell.setText("\u66F4\u65B0");
		{
			Label label = new Label(shell, SWT.NONE);
			label.setBackground(SWTResourceManager.getColor(153, 255, 255));
			label.setFont(SWTResourceManager.getFont("华文仿宋", 12, SWT.BOLD));
			label.setBounds(28, 10, 72, 16);
			label.setText("\u5458\u5DE5\u7F16\u53F7\uFF1A");
		}
		{
			Label label = new Label(shell, SWT.NONE);
			label.setBackground(SWTResourceManager.getColor(153, 255, 255));
			label.setFont(SWTResourceManager.getFont("华文仿宋", 12, SWT.BOLD));
			label.setBounds(39, 47, 41, 16);
			label.setText("\u5E74\uFF1A");
		}
		{
			Label label = new Label(shell, SWT.NONE);
			label.setBackground(SWTResourceManager.getColor(153, 255, 255));
			label.setFont(SWTResourceManager.getFont("华文仿宋", 12, SWT.BOLD));
			label.setBounds(38, 78, 26, 16);
			label.setText("\u6708\uFF1A");
		}
		{
			id = new Text(shell, SWT.BORDER);
			id.setBounds(136, 10, 71, 22);
		}
		{
			Label label = new Label(shell, SWT.NONE);
			label.setBackground(SWTResourceManager.getColor(153, 255, 255));
			label.setFont(SWTResourceManager.getFont("华文仿宋", 12, SWT.BOLD));
			label.setBounds(28, 158, 72, 16);
			label.setText("\u5458\u5DE5\u59D3\u540D\uFF1A");
		}
		{
			Label label = new Label(shell, SWT.NONE);
			label.setBackground(SWTResourceManager.getColor(153, 255, 255));
			label.setFont(SWTResourceManager.getFont("华文仿宋", 12, SWT.BOLD));
			label.setBounds(28, 205, 72, 16);
			label.setText("\u5B9E\u5230\u5929\u6570\uFF1A");
		}
		{
			name = new Text(shell, SWT.BORDER);
			name.setEditable(false);
			name.setBounds(136, 155, 71, 22);
		}
		{
			Label label = new Label(shell, SWT.NONE);
			label.setBackground(SWTResourceManager.getColor(153, 255, 255));
			label.setFont(SWTResourceManager.getFont("华文仿宋", 12, SWT.BOLD));
			label.setBounds(28, 286, 72, 16);
			label.setText("\u5907\u6CE8\uFF1A");
		}
		{
			actual = new Text(shell, SWT.BORDER);
			actual.setEditable(false);
			actual.setBounds(136, 205, 71, 22);
		}
		{
			note = new Text(shell, SWT.BORDER);
			note.setEditable(false);
			note.setBounds(136, 283, 337, 59);
		}
		{
			Button button = new Button(shell, SWT.NONE);
			button.setImage(new Image(null,"images/chczha.jpg"));
			button.addSelectionListener(new SelectionAdapter() {
				public void widgetSelected(SelectionEvent e) {
					PreparedStatement pstmt = null;
					ResultSet rs = null;
					DBconnect db = new DBconnect();
					try
					{
						int iid = Integer.parseInt(id.getText().trim());
						int iyear = Integer.parseInt(year.getText().trim());
						int imonth = Integer.parseInt(month.getText().trim());
						String sql = "select * from attendance where id=? and year =? and month =?";
						pstmt =db.conn.prepareStatement(sql);
						pstmt.setInt(1, iid);
						pstmt.setInt(2, iyear);
						pstmt.setInt(3, imonth);
						rs = pstmt.executeQuery();
						if(rs.next())
						{
							
							Statement stmt = db.conn.createStatement();
							ResultSet rrs = stmt.executeQuery("select name from emp_info where id ="+iid);
							rrs.next();
							name.setText(rrs.getString("name"));
							name.setEditable(true);
							actual.setText(rs.getInt("actual")+"");
							actual.setEditable(true);
							note.setText(rs.getString("notes"));
							note.setEditable(true);
							id.setEditable(false);
							year.setEnabled(false);
							month.setEnabled(false);
							rrs.close();
							stmt.close();
						}
						else
						{
							JOptionPane.showMessageDialog(null, " 空记录");
						}
					}catch(NumberFormatException e1)
					{
						JOptionPane.showMessageDialog(null, "注意输入的数据的格式");
					}catch(SQLException e1)
					{
						e1.printStackTrace();
					}finally
					{
						try
						{
							if(rs!=null)
							{
								rs.close();
							}
							if(pstmt!=null)
							{
								pstmt.close();
							}
						}catch(SQLException e1)
						{
							e1.printStackTrace();
						}
					}
					db.closeDB();
				}
			});
			button.setBounds(335, 28, 120, 87);
			button.setText("\u67E5\u8BE2");
		}
		{
			Button button = new Button(shell, SWT.NONE);
			button.setImage(new Image(null,"images/uupdate.jpg"));
			button.addSelectionListener(new SelectionAdapter() {
				public void widgetSelected(SelectionEvent e) {
					if(id.getText().trim().equals(""))
					{
						JOptionPane.showMessageDialog(null, "请输入信息，否则无法执行");
						return;
					}
					DBconnect db = new DBconnect();
					int iyear = Integer.parseInt(year.getText().trim());
					int imonth = Integer.parseInt(month.getText().trim());
					String iname = name.getText().trim();
					String inote = note.getText().trim();
					
					PreparedStatement pstmt = null;
					PreparedStatement pst = null;
					ResultSet rs = null;
					String sql ="update attendance set actual =?,notes=? where id=? and year = ? and month =?";
					try {
						
						int iactual=0;
						if(!actual.getText().trim().equals(""))
						{
						 iactual = Integer.parseInt(actual.getText().trim());
						}
						int iid = Integer.parseInt(id.getText().trim());
						String sqlll = "select * from attendance where id=? and year =? and month =?";
						pst=db.conn.prepareStatement(sqlll);
						pst.setInt(1, iid);
						pst.setInt(2, iyear);
						pst.setInt(3, imonth);
						rs = pst.executeQuery();
						if(rs.next())
						{
						db.conn.setAutoCommit(false);
						pstmt = db.conn.prepareStatement(sql);
						pstmt.setInt(1, iactual);
						pstmt.setString(2, inote);
						pstmt.setInt(3, iid);
						pstmt.setInt(4, iyear);
						pstmt.setInt(5, imonth);
						pstmt.executeUpdate();
						PreparedStatement ppstmt = db.conn.prepareStatement("update emp_info set name =? where id =?");
						ppstmt.setString(1, iname);
						ppstmt.setInt(2,iid);
						ppstmt.executeUpdate();
						ppstmt.close();
						db.conn.commit();
						JOptionPane.showMessageDialog(null, "数据修改成功");
						shell.dispose();
						}
						else
						{
							JOptionPane.showMessageDialog(null, "无效操作");
							return;
						}
					} catch(NumberFormatException e1)
					{
						JOptionPane.showMessageDialog(null, "请注意输入数据的格式");
						return;
					}catch (SQLException e1) {
						
						e1.printStackTrace();
					}finally
					{
						try
						{
							if(rs!=null)
								rs.close();
							if(pst!=null)
								pst.close();
							if(pstmt!=null)
							{
								pstmt.close();
							}
						}catch(SQLException e1)
						{
							e1.printStackTrace();
						}
					}
					db.closeDB();
					
				}
			});
			button.setBounds(335, 158, 120, 94);
			button.setText("\u4FEE\u6539");
		}
		
			 year = new Combo(shell, SWT.NONE);
			year.setBounds(128, 47, 92, 24);
			year.setEnabled(true);
			year.setItems(new String[]{"2010","2009"});
			year.select(0);
		
		
			 month = new Combo(shell, SWT.NONE);
			month.setBounds(128, 78, 92, 24);
			month.setEnabled(true);
			month.setItems(new String[]{"1","2","3","4","5","6","7","8","9","10","11","12"});
			month.select(0);
		

		shell.open();
		shell.layout();
		while (!shell.isDisposed()) {
			if (!display.readAndDispatch()) {
				display.sleep();
			}
		}
	}
}
