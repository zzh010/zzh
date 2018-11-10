package function;

import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.MessageBox;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.swt.widgets.Label;
import org.eclipse.swt.SWT;
import com.swtdesigner.SWTResourceManager;
import org.eclipse.swt.widgets.Text;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.events.SelectionAdapter;
import org.eclipse.swt.events.SelectionEvent;
import org.eclipse.swt.graphics.Image;
import database.DBconnect;
import java.sql.*;

import javax.swing.JOptionPane;

public class deleteprize {
	private Text rid;
	private Text name;
	private Text time;
	private Text status;
	private Text reason;

	/**
	 * Launch the application.
	 * @param args
	 */
	public static void main(String[] args) {
		try {
			deleteprize window = new deleteprize();
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
		shell.setBackground(SWTResourceManager.getColor(255, 255, 153));
		shell.setSize(513, 380);
		shell.setText("\u5220\u9664\u8BB0\u5F55 ");
		{
			Label label = new Label(shell, SWT.NONE);
			label.setBackground(SWTResourceManager.getColor(255, 255, 153));
			label.setFont(SWTResourceManager.getFont("仿宋_GB2312", 13, SWT.BOLD));
			label.setBounds(30, 28, 105, 22);
			label.setText("\u5956\u7F5A\u5355\u7F16\u53F7\uFF1A");
		}
		{
			Label label = new Label(shell, SWT.NONE);
			label.setBackground(SWTResourceManager.getColor(255, 255, 153));
			label.setFont(SWTResourceManager.getFont("仿宋_GB2312", 13, SWT.BOLD));
			label.setBounds(64, 73, 54, 29);
			label.setText("\u59D3\u540D\uFF1A");
		}
		{
			Label label = new Label(shell, SWT.NONE);
			label.setBackground(SWTResourceManager.getColor(255, 255, 153));
			label.setFont(SWTResourceManager.getFont("仿宋_GB2312", 13, SWT.BOLD));
			label.setBounds(64, 108, 54, 22);
			label.setText("\u65F6\u95F4:");
		}
		{
			Label label = new Label(shell, SWT.NONE);
			label.setBackground(SWTResourceManager.getColor(255, 255, 153));
			label.setFont(SWTResourceManager.getFont("仿宋_GB2312", 13, SWT.BOLD));
			label.setBounds(49, 156, 54, 22);
			label.setText("\u5956/\u60E9\uFF1A");
		}
		{
			Label label = new Label(shell, SWT.NONE);
			label.setBackground(SWTResourceManager.getColor(255, 255, 153));
			label.setFont(SWTResourceManager.getFont("仿宋_GB2312", 13, SWT.BOLD));
			label.setBounds(49, 219, 54, 22);
			label.setText("\u539F\u56E0\uFF1A");
		}
		{
			rid = new Text(shell, SWT.BORDER);
			rid.setBounds(147, 26, 104, 18);
		}
		{
			name = new Text(shell, SWT.BORDER);
			name.setEditable(false);
			name.setBounds(147, 73, 104, 18);
		}
		{
			time = new Text(shell, SWT.BORDER);
			time.setEditable(false);
			time.setBounds(147, 108, 104, 18);
		}
		{
			status = new Text(shell, SWT.BORDER);
			status.setEditable(false);
			status.setBounds(147, 154, 104, 18);
		}
		{
			reason = new Text(shell, SWT.BORDER);
			reason.setEditable(false);
			reason.setBounds(147, 194, 215, 93);
		}
		{
			Button button = new Button(shell, SWT.NONE);
			button.setImage(new Image(null,"images/chczha.jpg"));
			button.addSelectionListener(new SelectionAdapter() {
				
				public void widgetSelected(SelectionEvent e) {
					DBconnect db = new DBconnect();
					PreparedStatement pstmt = null;
					ResultSet rs = null;
					if(rid.getText().trim().equals(""))
					{
						JOptionPane.showMessageDialog(null, "请输入员工编号");
						return;
					}
					String sql ="select * from rewards where rid =? ";
					
					
					try {
						int rrid = Integer.parseInt(rid.getText().trim());
						pstmt = db.conn.prepareStatement(sql);
						pstmt.setInt(1, rrid);
						
						rs = pstmt.executeQuery();
						if(!rs.next())
						{
							JOptionPane.showMessageDialog(null, "无效的奖罚单编号");
							return;
						}
						int id = rs.getInt("id");
						Statement stmt = db.conn.createStatement();
						ResultSet ss = stmt.executeQuery("select name from emp_info where id ="+id);
						ss.next();
						name.setText(ss.getString(1));
						ss.close();
						stmt.close();
						reason.setText(rs.getString("reason"));
						status.setText(rs.getString("status"));
						time.setText(rs.getDate("time").toString());
						   
					} catch(NumberFormatException  e1)
					{
						JOptionPane.showMessageDialog(null, "请注意输入的数据的格式");
						return;
					}catch (SQLException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}finally
					{
						try
						{
							if(rs!=null)
								rs.close();
							if(pstmt!=null)
								pstmt.close();
						}catch(SQLException e1)
						{
							e1.printStackTrace();
						}
					}
					db.closeDB();
					
				}
			});
			button.setBounds(356, 28, 104, 57);
			button.setText("New Button");
		}
		{
			Button button = new Button(shell, SWT.NONE);
			button.setImage(new Image(null,"images/delete.jpg"));
			button.addSelectionListener(new SelectionAdapter() {
				
				public void widgetSelected(SelectionEvent e) {
					if(rid.getText().trim().equals(""))
					{
						JOptionPane.showMessageDialog(null, "请输入员工编号");
						return;
					}
					DBconnect db = new DBconnect();
					PreparedStatement pstmt = null;
					ResultSet rs = null;
					
					String sql ="delete  from rewards where rid =? ";
					String asql ="select * from rewards where rid =?";
					
					try {
						int rrid = Integer.parseInt(rid.getText().trim());
						pstmt =db.conn.prepareStatement(asql);
						pstmt.setInt(1, rrid);
						rs = pstmt.executeQuery();
						if(rs.next())
						{
						pstmt = db.conn.prepareStatement(sql);
						pstmt.setInt(1, rrid);
						MessageBox message = new MessageBox(shell,SWT.OK|SWT.CANCEL);
						message.setMessage("一旦删除将无法恢复");
						if(message.open()==SWT.CANCEL)
						{
							return;
						}
						pstmt.executeUpdate();
						JOptionPane.showMessageDialog(null, "数据删除成功");
						shell.dispose();
						sf ss = new sf();
						ss.open();
						}
						else
						{
							JOptionPane.showMessageDialog(null, "无效的员工编号");
						}
					} 
					catch(NumberFormatException e1)
					{
						JOptionPane.showMessageDialog(null, "请注意输入的数据的格式");
						return;
					}catch (SQLException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}finally
					{
						try
						{
							if(pstmt!=null)
								pstmt.close();
						}catch(SQLException e1)
						{
							e1.printStackTrace();
						}
					}
					db.closeDB();
				}
			});
			button.setBounds(378, 123, 82, 85);
			button.setText("New Button");
		}

		shell.open();
		shell.layout();
		while (!shell.isDisposed()) {
			if (!display.readAndDispatch()) {
				display.sleep();
			}
		}
	}
}
