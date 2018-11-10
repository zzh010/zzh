package salary;
import java.awt.Component;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import database.DBconnect;
import javax.swing.JOptionPane;
//download by http://www.codefans.net
import org.eclipse.swt.widgets.Decorations;
import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.swt.widgets.Label;
import org.eclipse.swt.SWT;
import org.eclipse.swt.widgets.Text;
import org.eclipse.swt.widgets.Button;
import com.swtdesigner.SWTResourceManager;
import org.eclipse.swt.events.MouseAdapter;
import org.eclipse.swt.events.MouseEvent;
import org.eclipse.swt.events.SelectionAdapter;
import org.eclipse.swt.events.SelectionEvent;
import org.eclipse.swt.events.FocusAdapter;
import org.eclipse.swt.events.FocusEvent;
import org.eclipse.swt.graphics.Image;

public class WageUpdate {

	protected Shell shell;
	private Text id;
	private Text result;
	private Text tiaozheng;

	/**
	 * Launch the application.
	 * 
	 * @param args
	 */

	public static void main(String[] args) {
		try {
			WageUpdate window = new WageUpdate();
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

		shell.setBackground(SWTResourceManager.getColor(255, 255, 204));
		shell.setSize(597, 347);
		shell.setText("\u804C\u5DE5\u5DE5\u8D44\u8C03\u6574\u7CFB\u7EDF");
		{
			Label label = new Label(shell, SWT.NONE);
			label.setFont(SWTResourceManager.getFont("华文细黑", 12, SWT.BOLD));
			label.setBackground(SWTResourceManager.getColor(255, 255, 204));
			label.setBounds(10, 30, 128, 16);
			label.setText("\u8BF7\u8F93\u5165\u804C\u5DE5\u7F16\u53F7\uFF1A");
		}
		{
			id = new Text(shell, SWT.BORDER);
			id.setBounds(173, 27, 93, 22);
		}
		{
			Label label = new Label(shell, SWT.NONE);
			label.setFont(SWTResourceManager.getFont("华文细黑", 12, SWT.BOLD));
			label.setBackground(SWTResourceManager.getColor(255, 255, 204));
			label.setBounds(10, 94, 128, 16);
			label.setText("\u8BF7\u8F93\u5165\u8C03\u6574\u91D1\u989D\uFF1A");
		}
		{
			tiaozheng = new Text(shell, SWT.BORDER);
			tiaozheng.setBounds(173, 91, 93, 22);
		}
		{
			Button zhang = new Button(shell, SWT.NONE);
			zhang.addSelectionListener(new SelectionAdapter() {

				public void widgetSelected(SelectionEvent e) {
					DBconnect db = new DBconnect();
					PreparedStatement prpdStmt = null;
					PreparedStatement pstmt = null;
					ResultSet rs = null;
					try {
						String sql = "select * from salary where id=?";
						prpdStmt = db.conn.prepareStatement(sql);
						prpdStmt.setInt(1, Integer.parseInt(id.getText()));
						rs = prpdStmt.executeQuery();
						if (rs.next()) {

							int id = rs.getInt(2);
							int salarybase = rs.getInt(3);
                            int rresult = rs.getInt(3)+ Integer.parseInt(tiaozheng.getText());
                            
							result.setText(rresult+"");
							String ssql ="update salary set salarybase = ? where sid =?";
							pstmt = db.conn.prepareStatement(ssql);
							pstmt.setInt(1, rresult);
							pstmt.setInt(2, rs.getInt(1));
							pstmt.executeUpdate();;		

						} else {
							id.setText("");
							tiaozheng.setText("");
							result.setText("");
							JOptionPane.showMessageDialog(null, "请您输入正确的职工编号");
						}

					} catch (SQLException ex) {
						ex.printStackTrace();
					} finally {
						try {
							if (rs != null)
								rs.close();
							if (prpdStmt != null)
								prpdStmt.close();
							if (pstmt != null)
								pstmt.close();

						} catch (SQLException e1) {
							e1.printStackTrace();
						}
					}
					db.closeDB();
				}

			});
			zhang.setBounds(27, 151, 56, 26);
			zhang.setText(" \u6DA8");
		}
		{
			Button jiang = new Button(shell, SWT.NONE);
			jiang.addSelectionListener(new SelectionAdapter() {
				
				public void widgetSelected(SelectionEvent e) {
					DBconnect db = new DBconnect();
					PreparedStatement prpdStmt = null;
					PreparedStatement pstmt = null;
					ResultSet rs = null;

					try {

						String sql = "select * from salary where id=?";

						prpdStmt = db.conn.prepareStatement(sql);

						prpdStmt.setInt(1, Integer.parseInt(id.getText()));
						rs = prpdStmt.executeQuery();

						if (rs.next()) {
							int id = rs.getInt(2);
							int sala = rs.getInt(3);
							int rresult = Integer.parseInt(rs.getString(3))	- Integer.parseInt(tiaozheng.getText());
							if(rresult <= 0)
                            {
                            	JOptionPane.showMessageDialog(null, "你还让人活不，都成了白干了");
                            	return;
                            }
							result.setText(rresult+"");
							String sqls = "update salary set salarybase = ? where sid =?";
							pstmt = db.conn.prepareStatement(sqls);
							pstmt.setInt(1, rresult);
							pstmt.setInt(2, rs.getInt(1));
							pstmt.executeUpdate();
							
						} else {
							id.setText("");
							result.setText("");
							tiaozheng.setText("");
							JOptionPane.showMessageDialog(null, "请您输入正确的职工编号");
						}

					} catch (SQLException e1) {
						e1.printStackTrace();
					} finally {
						try {
							if (rs != null)
								rs.close();
							if (prpdStmt != null)
								prpdStmt.close();
							if (pstmt != null)
								pstmt.close();

						} catch (SQLException e1) {
							e1.printStackTrace();
						}
					}
					db.closeDB();
				}

			});
			jiang.setBounds(224, 151, 56, 26);
			jiang.setText(" \u964D ");
		}
		{
			Label label = new Label(shell, SWT.NONE);
			label.setFont(SWTResourceManager.getFont("华文细黑", 12, SWT.BOLD));
			label.setBackground(SWTResourceManager.getColor(255, 255, 204));
			label.setBounds(10, 215, 128, 16);
			label.setText("\u8C03\u6574\u540E\u804C\u5DE5\u5DE5\u8D44\uFF1A");
		}
		{
			result = new Text(shell, SWT.BORDER);
			result.setEditable(false);
			result.setBounds(173, 212, 107, 22);
		}
		{
			Button button = new Button(shell, SWT.NONE);
			button.addSelectionListener(new SelectionAdapter() {

				public void widgetSelected(SelectionEvent e) {
					tiaozheng.setText(" ");
					id.setText("");
				}
			});
			button.setBounds(124, 151, 56, 26);
			button.setText("\u91CD\u7F6E");
		}
		{
			Label label = new Label(shell, SWT.NONE);
			label.setBounds(316, 0, 276, 313);
			label.setText("New Label");
			label.setImage(new Image(null,
					"images/1.jpg"));
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
			button.setBounds(88, 267, 92, 26);
			button.setText("\u8FD4\u56DE");
		}

	}
}
