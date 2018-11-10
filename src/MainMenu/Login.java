package MainMenu;

import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.swt.widgets.Label;
import org.eclipse.swt.SWT;
import org.eclipse.swt.widgets.Text;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.widgets.Group;
import com.swtdesigner.SWTResourceManager;
import database.DBconnect;
import org.eclipse.swt.events.FocusAdapter;
import org.eclipse.swt.events.FocusEvent;
import org.eclipse.swt.events.SelectionAdapter;
import org.eclipse.swt.events.SelectionEvent;
import Mainwindow.Main;
import javax.imageio.ImageIO;
import javax.swing.JOptionPane;

import java.awt.Image;
import java.sql.*;
import org.eclipse.ui.forms.widgets.FormToolkit;
import org.eclipse.swt.events.MouseAdapter;
import org.eclipse.swt.events.MouseEvent;


public class Login {

	protected Shell shell;
	private Text id;
	private Text password;

	/**
	 * Launch the application.
	 * @param args
	 */
	public static void main(String[] args) {
		try {
			Login window = new Login();
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
		createContents();
		shell.open();
		shell.layout();
		while (!shell.isDisposed()) {
			if (!display.readAndDispatch()) {
				display.sleep();
			}
		}
	}

	/**
	 * Create contents of the window.
	 */
	protected void createContents() {
		shell = new Shell();
		shell.setSize(613, 553);
		shell.setText("\u4F01\u4E1A\u4EBA\u4E8B\u7BA1\u7406\u7CFB\u7EDF");
		{
			Label lblid = new Label(shell, SWT.NONE);
			lblid.setBackground(SWTResourceManager.getColor(224, 255, 255));
			lblid.setBounds(227, 225, 72, 16);
			lblid.setText(" \u7528\u6237ID\uFF1A");
		}
		{
			id = new Text(shell, SWT.BORDER);
			id.setBounds(332, 222, 155, 22);
		}
		{
			Label label = new Label(shell, SWT.NONE);
			label.setBackground(SWTResourceManager.getColor(224, 255, 255));
			label.setBounds(227, 283, 72, 16);
			label.setText("  \u5BC6\u7801\uFF1A");
		}
		{
			password = new Text(shell, SWT.BORDER);
			password.setBounds(332, 280, 155, 22);
			password.setEchoChar('*');
		}
		{
			Button button = new Button(shell, SWT.NONE);
			button.addMouseListener(new MouseAdapter() {
				public void mouseDown(MouseEvent e) {
					PreparedStatement pstmt=null;
					ResultSet rs = null;
					
					   DBconnect db = new DBconnect();
						String ttid = id.getText().trim();
						String tpassword = password.getText().trim();
						try
						{
						if(!tpassword.equals("") && !ttid.equals(""))
						{
							
							String sql = "select * from userinfo  where id =?";
							pstmt = db.conn.prepareStatement(sql);
							pstmt.setString(1, ttid);
							rs = pstmt.executeQuery();
							if(rs.next())
							{
								String gpassword = rs.getString("password");
								if(tpassword.equals(gpassword))
								{
									Main mai = new Main();
									shell.dispose();
									mai.open();
								}
								else
								{
									JOptionPane.showMessageDialog(null, "密码错误");
								}
							}
							else
							{ 
								JOptionPane.showMessageDialog(null, "用户名不存在！");
							}
						}
						else
						{
							JOptionPane.showMessageDialog(null, "密码和用户名都不能为空");
						}
					
					}catch(SQLException e1)
					{
						e1.printStackTrace();
					}
				}
			});
			
			button.setBounds(227, 332, 92, 26);
			button.setText("\u786E\u5B9A");
		}
		{
			Button button = new Button(shell, SWT.NONE);
			button.addSelectionListener(new SelectionAdapter() {
				@Override
				public void widgetSelected(SelectionEvent e) {
					System.exit(0);
				}
			});
			button.setBounds(395, 332, 92, 26);
			button.setText("\u9000\u51FA");
		}
		{
			Label label = new Label(shell, SWT.NONE);
			label.setImage(SWTResourceManager.getImage("images/denglu.jpg"));
			label.setBounds(0, 0, 605, 514);
		}

	}
}
