package function;

import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.swt.widgets.Label;
import org.eclipse.swt.SWT;
import com.swtdesigner.SWTResourceManager;
import javax.swing.JOptionPane;
import javax.swing.JTextArea;

import org.eclipse.swt.widgets.TableColumn;
import org.eclipse.swt.widgets.TableItem;
import org.eclipse.swt.widgets.Text;
import org.eclipse.swt.widgets.Combo;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Table;
import org.eclipse.jface.layout.TableColumnLayout;
import org.eclipse.jface.viewers.ColumnPixelData;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.events.SelectionAdapter;
import org.eclipse.swt.events.SelectionEvent;
import org.eclipse.swt.graphics.Image;
import database.DBconnect;
import java.sql.*;
import org.eclipse.swt.browser.Browser;
import org.eclipse.ui.forms.widgets.FormToolkit;
import org.eclipse.ui.forms.widgets.Section;
import org.eclipse.ui.forms.widgets.FormText;
public class Addprize {
	private Text id;
	private Text reason;
	private Table table;
	private Combo status;
	private final FormToolkit formToolkit = new FormToolkit(Display.getDefault());

	/**
	 * Launch the application.
	 * @param args
	 */
	public static void main(String[] args) {
		try {
			Addprize window = new Addprize();
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
		final Shell  shell = new Shell();
		shell.setBackground(SWTResourceManager.getColor(255, 255, 153));
		shell.setSize(486, 427);
		shell.setText("\u589E\u52A0\u8BB0\u5F55");
		{
			Label label = new Label(shell, SWT.NONE);
			label.setBackground(SWTResourceManager.getColor(255, 255, 153));
			label.setFont(SWTResourceManager.getFont("仿宋_GB2312", 13, SWT.BOLD));
			label.setBounds(31, 30, 85, 27);
			label.setText("\u5458\u5DE5\u7F16\u53F7\uFF1A");
		}
		{
			Label label = new Label(shell, SWT.NONE);
			label.setBackground(SWTResourceManager.getColor(255, 255, 153));
			label.setFont(SWTResourceManager.getFont("仿宋_GB2312", 13, SWT.BOLD));
			label.setBounds(31, 81, 72, 16);
			label.setText("\u5956/\u7F5A\uFF1A");
		}
		{
			Label label = new Label(shell, SWT.NONE);
			label.setBackground(SWTResourceManager.getColor(255, 255, 153));
			label.setFont(SWTResourceManager.getFont("仿宋_GB2312", 13, SWT.BOLD));
			label.setBounds(31, 129, 72, 16);
			label.setText("\u539F\u56E0\uFF1A");
		}
		{
			id = new Text(shell, SWT.BORDER);
			id.setBounds(141, 30, 71, 22);
		}
		{
			 status = new Combo(shell, SWT.NONE);
			status.setBounds(141, 81, 92, 24);
			status.setItems(new String[]{"奖励","惩罚"});
		}
		{
			reason = new Text(shell, SWT.BORDER);
			reason.setBounds(141, 129, 304, 77);
		}
		{
			Button button = new Button(shell, SWT.NONE);
			button.setImage(new Image(null,"images/aue.jpg"));
			button.addSelectionListener(new SelectionAdapter() {
				
				public void widgetSelected(SelectionEvent e) {
					if(id.getText().equals(""))
					{
						JOptionPane.showMessageDialog(null, "请输入员工编号");
						return;
					}
					
					String gstatus = status.getText();
					String greason = reason.getText();
					DBconnect db = new DBconnect();
					PreparedStatement pstmt = null;
					ResultSet rs = null;
					String sql = "insert into rewards values(null,?,now(),?,?)";
					Statement stmt = null;
					
					try {
						int gid = Integer.parseInt(id.getText().trim());
						String sql1 = "select * from emp_info where id ="+gid;
						stmt = db.conn.createStatement();
						rs = stmt.executeQuery(sql1);
						if(!rs.next())
						{
							JOptionPane.showMessageDialog(null, "无此员工");
							return;
						}
						pstmt = db.conn.prepareStatement(sql);
						pstmt.setInt(1, gid);
						pstmt.setString(2, gstatus);
						pstmt.setString(3, greason);
						pstmt.executeUpdate();
						JOptionPane.showMessageDialog(null, "插入数据成功");
						shell.dispose();
					}
					catch(NumberFormatException e1)
					{
						JOptionPane.showMessageDialog(null, "输入的数据格式不正确");
					}catch (SQLException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}finally
					{
						try
						{
							if(rs!=null)
								rs.close();
							if(stmt!=null)
								stmt.close();
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
			button.setBounds(195, 283, 146, 77);
			button.setText("New Button");
		}
		{
			Label label = new Label(shell, SWT.NONE);
			label.setBounds(10, 202, 125, 140);
			label.setText("New Label");
			label.setImage(new Image(null,"images/reason.jpg"));
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
