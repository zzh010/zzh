package function;

import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.swt.widgets.Label;
import org.eclipse.swt.SWT;
import com.swtdesigner.SWTResourceManager;
import org.eclipse.swt.widgets.DateTime;
import org.eclipse.swt.widgets.Text;
import org.eclipse.swt.widgets.Combo;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.events.SelectionAdapter;
import org.eclipse.swt.events.SelectionEvent;
import org.eclipse.swt.graphics.Image;
import java.sql.*;

import javax.swing.JOptionPane;

import database.DBconnect;
public class UpdatePrize {
	private Text id;
	private Text reason;
	private Combo status;
	private Text time;

	/**
	 * Launch the application.
	 * @param args
	 */
	public static void main(String[] args) {
		try {
			UpdatePrize window = new UpdatePrize();
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
		shell.setSize(450, 337);
		shell.setText("\u66F4\u65B0");
		{
			Label label = new Label(shell, SWT.NONE);
			label.setBackground(SWTResourceManager.getColor(255, 255, 153));
			label.setFont(SWTResourceManager.getFont("仿宋_GB2312", 13, SWT.BOLD));
			label.setBounds(44, 27, 95, 23);
			label.setText("\u5956\u7F5A\u5355\u7F16\u53F7\uFF1A");
		}
		{
			Label label = new Label(shell, SWT.NONE);
			label.setBackground(SWTResourceManager.getColor(255, 255, 153));
			label.setFont(SWTResourceManager.getFont("仿宋_GB2312", 13, SWT.BOLD));
			label.setBounds(55, 79, 72, 16);
			label.setText("\u65F6\u95F4\uFF1A");
		}
		{
			id = new Text(shell, SWT.BORDER);
			id.setBounds(145, 28, 93, 22);
		}
		{
			Label label = new Label(shell, SWT.NONE);
			label.setBackground(SWTResourceManager.getColor(255, 255, 153));
			label.setFont(SWTResourceManager.getFont("仿宋_GB2312", 13, SWT.BOLD));
			label.setBounds(44, 135, 72, 16);
			label.setText("\u5956/\u7F5A\uFF1A");
		}
		{
			 status = new Combo(shell, SWT.NONE);
			 status.setEnabled(false);
			status.setBounds(146, 135, 92, 24);
			status.setItems(new String[]{"奖励","惩罚"});
			
		}
		{
			Label label = new Label(shell, SWT.NONE);
			label.setBackground(SWTResourceManager.getColor(255, 255, 153));
			label.setFont(SWTResourceManager.getFont("仿宋_GB2312", 13, SWT.BOLD));
			label.setBounds(44, 190, 72, 16);
			label.setText("\u539F\u56E0\uFF1A");
		}
		{
			reason = new Text(shell, SWT.BORDER);
			reason.setEditable(false);
			reason.setBounds(122, 190, 221, 45);
		}
		{
			Button button = new Button(shell, SWT.NONE);
			button.setImage(new Image(null,"images/chczha.jpg"));
			button.addSelectionListener(new SelectionAdapter() {
				
				public void widgetSelected(SelectionEvent e) {
					if(id.getText().trim().equals(""))
					{
						JOptionPane.showMessageDialog(null, "请输入员工编号");
						return;
					}
					DBconnect db = new DBconnect();
					PreparedStatement pstmt = null;
					ResultSet rs = null;
					String sql ="select * from rewards where rid =? ";
					status.setEnabled(true);
					reason.setEditable(true);
					
					
					try {
						int rid = Integer.parseInt(id.getText().trim());
						pstmt = db.conn.prepareStatement(sql);
						pstmt.setInt(1, rid);
						
						rs = pstmt.executeQuery();
						if(!rs.next())
						{
							JOptionPane.showMessageDialog(null, "无效的奖罚单编号");
							return;
						}
						reason.setText(rs.getString("reason"));
						if(rs.getString("status").equals("奖励"))
							status.select(0);
						else
							status.select(1);
						    time.setText(rs.getDate("time").toString());
						    id.setEditable(false);
					} catch(NumberFormatException e1)
					{
						JOptionPane.showMessageDialog(null, "请注意输入数据的格式");
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
			button.setBounds(318, 27, 95, 56);
			button.setText("New Button");
		}
		{
			Button button = new Button(shell, SWT.NONE);
			button.setImage(new Image(null,"images/uupdate.jpg"));
			button.addSelectionListener(new SelectionAdapter() {
				
				public void widgetSelected(SelectionEvent e) {
				if(id.getText().trim().equals(""))
				{
					JOptionPane.showMessageDialog(null, "请输入员工编号");
					return;
				}
					
					String sstatus = status.getText();
					String rea = reason.getText();
					DBconnect db = new DBconnect();
					PreparedStatement pstmt = null;
					ResultSet rs = null;
					String sql ="select * from rewards where rid =?";
					try {
						int rrid = Integer.parseInt(id.getText().trim());
						pstmt = db.conn.prepareStatement(sql);
						pstmt.setInt(1, rrid);
						rs = pstmt.executeQuery();
						if(!rs.next())
						{
							JOptionPane.showMessageDialog(null, "无效的奖罚单编号");
							return;
						}
						String ssql = "update rewards set status =?,reason = ? where rid =?";
						pstmt = db.conn.prepareStatement(ssql);
						pstmt.setString(1, sstatus);
						pstmt.setString(2, rea);
						pstmt.setInt(3, rrid);
						pstmt.executeUpdate();
						JOptionPane.showMessageDialog(null, "修改数据成功 ");
						shell.dispose();
						 sf s = new sf();
						 s.open();
					} catch(NumberFormatException e1)
					{
						JOptionPane.showMessageDialog(null, "请注意输入数据的格式");
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
			button.setBounds(318, 109, 95, 71);
			button.setText("New Button");
		}
		{
			time = new Text(shell, SWT.BORDER);
			time.setEditable(false);
			time.setBounds(145, 83, 93, 22);
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
