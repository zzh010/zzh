package salary;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.swing.JOptionPane;

import org.eclipse.jface.text.templates.GlobalTemplateVariables.Date;
import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.Shell;
import com.swtdesigner.SWTResourceManager;

import database.DBconnect;

import org.eclipse.swt.widgets.Label;
import org.eclipse.swt.SWT;
import org.eclipse.swt.widgets.Text;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.events.SelectionAdapter;
import org.eclipse.swt.events.SelectionEvent;
import org.eclipse.swt.widgets.DateTime;

public class ExtraInsert {

	protected Shell shell;
	private Text cno;
	private Text expay;
	DateTime ttime ;

	/**
	 * Launch the application.
	 * 
	 * @param args
	 */
	public static void main(String[] args) {
		try {
			ExtraInsert window = new ExtraInsert();
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
		shell.setBackground(SWTResourceManager.getColor(224, 255, 255));
		shell.setSize(453, 305);
		shell.setText("\u8BB0\u5F55\u63D2\u5165");
		{
			Label label = new Label(shell, SWT.NONE);
			label.setBackground(SWTResourceManager.getColor(224, 255, 255));
			label.setBounds(92, 10, 72, 16);
			label.setText("\u804C\u5DE5\u7F16\u53F7\uFF1A");
		}
		{
			cno = new Text(shell, SWT.BORDER);
			cno.setBounds(230, 10, 92, 22);
		}
		{
			Label label = new Label(shell, SWT.NONE);
			label.setBackground(SWTResourceManager.getColor(224, 255, 255));
			label.setBounds(92, 61, 72, 16);
			label.setText("\u52A0\u73ED\u8D39\uFF1A");
		}
		{
			expay = new Text(shell, SWT.BORDER);
			expay.setBounds(230, 58, 92, 22);
		}
		{
			Label label = new Label(shell, SWT.NONE);
			label.setBackground(SWTResourceManager.getColor(224, 255, 255));
			label.setBounds(92, 117, 72, 16);
			label.setText("\u52A0\u73ED\u65F6\u95F4\uFF1A");
		}
		{
			Button button = new Button(shell, SWT.NONE);
			button.addSelectionListener(new SelectionAdapter() {
				public void widgetSelected(SelectionEvent e) {
					DBconnect db = new DBconnect();
					PreparedStatement prpdStmt1 = null;
					PreparedStatement prpdStmt = null;
					ResultSet rs = null;
					
					try {
						if (!cno.getText().equals("")) {
							String sql = "select * from extrawork where id=?";
							int gid = Integer.parseInt(cno.getText().trim());
							prpdStmt1 = db.conn.prepareStatement(sql);
							prpdStmt1.setInt(1, gid);
							rs = prpdStmt1.executeQuery();
							if (prpdStmt1.executeQuery().next()) {
								JOptionPane.showMessageDialog(null, "此条记录已存在！");
								cno.setText("");
								expay.setText("");
								
							} else {

								int eexpay = Integer.parseInt(expay.getText());
								
										
								String sql1 = "insert into extrawork values(null,?,?,?)";
								prpdStmt = db.conn.prepareStatement(sql1);
								prpdStmt.setInt(1, gid);
								prpdStmt.setInt(2, eexpay);
								int year = ttime.getYear();
								int month = ttime.getMonth();
								int dayss = ttime.getDay();
								String rdate = year+"-"+month+"-"+dayss;
								prpdStmt.setString(3, rdate);
								prpdStmt.executeUpdate();
								
								JOptionPane.showMessageDialog(null, "插入数据成功");
								shell.dispose();
							}
						}
					} catch (SQLException e1) {
						e1.printStackTrace();
					} finally {
						try {
							if (rs != null)
								rs.close();
							if (prpdStmt != null)
								prpdStmt.close();
							if (prpdStmt1 != null)
								prpdStmt1.close();
						} catch (SQLException e1) {
							e1.printStackTrace();
						}
					}
					db.closeDB();
				}
			});
			button.setBounds(51, 172, 72, 26);
			button.setText("\u786E\u5B9A");
		}
		{
			Button button = new Button(shell, SWT.NONE);
			button.setBounds(176, 172, 72, 26);
			button.setText("\u91CD\u7F6E");
		}
		{
			Button button = new Button(shell, SWT.NONE);
			button.addSelectionListener(new SelectionAdapter() {
				@Override
				public void widgetSelected(SelectionEvent e) {
					stayup ss=new stayup();
					shell.dispose();
					ss.open();
				}
			});
			button.setBounds(299, 172, 92, 26);
			button.setText("\u8FD4\u56DE");
		}
		{
			 ttime = new DateTime(shell, SWT.BORDER);
			ttime.setBounds(218, 117, 117, 25);
		}

	}
}
