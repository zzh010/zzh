package salary;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import javax.swing.JOptionPane;

import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.swt.widgets.Label;
import org.eclipse.swt.SWT;
import org.eclipse.swt.widgets.Text;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.events.SelectionAdapter;
import org.eclipse.swt.events.SelectionEvent;

import database.DBconnect;
import com.swtdesigner.SWTResourceManager;

public class ExtraDelete {

	protected Shell shell;
	private Text text;

	/**
	 * Launch the application.
	 * @param args
	 */
	public static void main(String[] args) {
		try {
			ExtraDelete window = new ExtraDelete();
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
		shell.setBackground(SWTResourceManager.getColor(204, 255, 255));
		shell.setSize(454, 262);
		shell.setText("\u5220\u9664\u8BB0\u5F55 ");
		{
			Label label = new Label(shell, SWT.NONE);
			label.setBackground(SWTResourceManager.getColor(204, 255, 255));
			label.setBounds(73, 51, 117, 16);
			label.setText("\u8BF7\u8F93\u5165\u804C\u5DE5\u7F16\u53F7\uFF1A");
		}
		{
			text = new Text(shell, SWT.BORDER);
			text.setBounds(225, 48, 90, 22);
		}
		{
			Button button = new Button(shell, SWT.NONE);
			button.addSelectionListener(new SelectionAdapter() {
				public void widgetSelected(SelectionEvent e) {
					DBconnect db = new DBconnect();
					PreparedStatement prpdStmt = null;
					ResultSet rs = null;
					Statement st = null;
					try {

						String sql = "delete from extrawork where id=?";
						prpdStmt = db.conn.prepareStatement(sql);
						prpdStmt.setInt(1, Integer.parseInt(text.getText().trim()));
						prpdStmt.executeUpdate();
						JOptionPane.showMessageDialog(null, "	数据删除成功");
                        
                        stayup ss = new stayup();
                        shell.dispose();
                        ss.open();
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
			button.setBounds(119, 116, 74, 26);
			button.setText("\u786E\u5B9A ");
		}
		{
			Button button = new Button(shell, SWT.NONE);
			button.addSelectionListener(new SelectionAdapter() {
				
				public void widgetSelected(SelectionEvent e) {
					stayup ss=new stayup();
					shell.dispose();
					ss.open();
				}
			});
			button.setBounds(253, 116, 74, 26);
			button.setText("\u8FD4\u56DE");
		}

	}

}
