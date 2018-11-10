package salary;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import database.DBconnect;
import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.swt.widgets.Label;
import org.eclipse.swt.SWT;
import org.eclipse.swt.widgets.Text;
import javax.swing.JButton;
import javax.swing.JOptionPane;

import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.widgets.Group;
import com.swtdesigner.SWTResourceManager;
import org.eclipse.swt.events.SelectionAdapter;
import org.eclipse.swt.events.SelectionEvent;
import org.eclipse.swt.events.FocusAdapter;
import org.eclipse.swt.events.FocusEvent;
import org.eclipse.swt.graphics.Image;
import javax.swing.JOptionPane;

public class WageCount {

	protected Shell shell;
	private Text id;
	private Text base;
	private Text stayup;
	private Text expay;
	private Text fact;

	/**
	 * Launch the application.
	 * 
	 * @param args
	 */
	public static void main(String[] args) {
		try {
			WageCount window = new WageCount();
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
		shell.setBackground(SWTResourceManager.getColor(255, 248, 220));
		shell.setSize(606, 372);
		shell
				.setText("\u804C\u5DE5\u57FA\u672C\u5DE5\u8D44\u6C47\u603B\u7CFB\u7EDF");
		{
			Label label = new Label(shell, SWT.NONE);
			label.setBackground(SWTResourceManager.getColor(255, 245, 238));
			label.setBounds(32, 10, 128, 16);
			label.setText("\u8BF7\u8F93\u5165\u804C\u5DE5\u7F16\u53F7\uFF1A");
		}
		{
			id = new Text(shell, SWT.BORDER);
			id.setBounds(190, 7, 115, 22);
		}
		{
			Button button = new Button(shell, SWT.NONE);
			button.addSelectionListener(new SelectionAdapter() {
				public void widgetSelected(SelectionEvent e) {
					DBconnect db = new DBconnect();
					PreparedStatement prpdStmt = null;

					ResultSet rs = null;
					try {
						String sql = "select * from salary where id=?";
						prpdStmt = db.conn.prepareStatement(sql);
						prpdStmt.setInt(1, Integer.parseInt(id.getText()));
						rs = prpdStmt.executeQuery();
						if (rs.next()) {
							int gid = rs.getInt(2);
							int salarybase = rs.getInt(3);
							int  bonus = rs.getInt(4);
							int  extrawage = rs.getInt(5);

							base.setText(rs.getInt(3)+"");
							stayup.setText(rs.getInt(4)+"");
							expay.setText(rs.getInt(5)+"");
							int rresult = rs.getInt(3)+rs.getInt(4)+rs.getInt(5);
							fact.setText(rresult+"");

						} else {
							id.setText("");
							base.setText("");
							stayup.setText("");
							expay.setText("");
							fact.setText("");
							JOptionPane.showMessageDialog(null, "  ¿Õ¼ÇÂ¼");
						}
					} catch (SQLException e1) {
						e1.printStackTrace();
					} finally {
						try {
							if (rs != null)
								rs.close();
							if (prpdStmt != null)
								prpdStmt.close();

						} catch (SQLException e1) {
							e1.printStackTrace();
						}
					}
					db.closeDB();
				}

			});

			button.setBounds(57, 44, 82, 26);
			button.setText("\u786E\u5B9A");
		}
		{
			Button button = new Button(shell, SWT.NONE);
			button.addSelectionListener(new SelectionAdapter() {

				public void widgetSelected(SelectionEvent e) {
					id.setText(" ");
				}
			});
			button.setBounds(200, 44, 82, 26);
			button.setText(" \u91CD\u7F6E ");
		}
		{
			Group group = new Group(shell, SWT.NONE);
			group.setBackground(SWTResourceManager.getColor(255, 248, 220));
			group.setText("\u67E5\u8BE2\u7ED3\u679C\uFF1A");
			group.setBounds(10, 78, 332, 137);
			{
				Label lblNewLabel = new Label(group, SWT.NONE);
				lblNewLabel.setBackground(SWTResourceManager.getColor(255, 248,
						220));
				lblNewLabel.setBounds(61, 30, 82, 16);
				lblNewLabel.setText("\u57FA\u672C\u5DE5\u8D44\uFF1A ");
			}
			{
				base = new Text(group, SWT.BORDER);
				base.setEditable(false);
				base.setBounds(178, 27, 106, 22);
			}
			{
				Label label = new Label(group, SWT.NONE);
				label.setBackground(SWTResourceManager.getColor(255, 248, 220));
				label.setBounds(61, 66, 72, 16);
				label.setText("\u52A0 \u73ED \u8D39\uFF1A");
			}
			{
				stayup = new Text(group, SWT.BORDER);
				stayup.setEditable(false);
				stayup.setBounds(178, 63, 106, 22);
			}
			{
				Label label = new Label(group, SWT.NONE);
				label.setBackground(SWTResourceManager.getColor(255, 248, 220));
				label.setBounds(61, 105, 72, 19);
				label.setText("\u5956    \u91D1\uFF1A");
			}
			{
				expay = new Text(group, SWT.BORDER);
				expay.setEditable(false);
				expay.setBounds(178, 102, 106, 22);
			}
		}
		{
			Label label = new Label(shell, SWT.NONE);
			label.setBackground(SWTResourceManager.getColor(255, 248, 220));
			label.setBounds(67, 243, 105, 16);
			label.setText("\u5B9E \u9645 \u5DE5 \u8D44 \uFF1A");
		}
		{
			fact = new Text(shell, SWT.BORDER);
			fact.setEditable(false);

			fact.setBounds(190, 240, 106, 22);
		}
		{
			Label label = new Label(shell, SWT.NONE);
			label.setBounds(348, 0, 250, 328);
			label.setText("New Label");
			label.setImage(new Image(null,
					"D:/workspace1/Industry/src/images/6.jpg"));
		}
		{
			Button button = new Button(shell, SWT.NONE);
			button.addSelectionListener(new SelectionAdapter() {
				
				public void widgetSelected(SelectionEvent e) {
					WageManange ww=new WageManange();
					shell.dispose();
					ww.open();
				}
			});
			button.setBounds(107, 292, 92, 26);
			button.setText("\u9000\u51FA");
		}

	}
}
