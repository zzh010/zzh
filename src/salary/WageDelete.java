package salary;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import database.DBconnect;
import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.swt.widgets.Label;
import org.eclipse.swt.SWT;
import org.eclipse.swt.widgets.Text;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.events.SelectionAdapter;
import org.eclipse.swt.events.SelectionEvent;
import com.swtdesigner.SWTResourceManager;
import javax.swing.JOptionPane;
public class WageDelete {

	protected Shell shell;
	private Text text;

	/**
	 * Launch the application.
	 * 
	 * @param args
	 */
	public static void main(String[] args) {
		try {
			WageDelete window = new WageDelete();
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
		shell.setSize(450, 234);
		shell.setText("\u5220\u9664\u8BB0\u5F55");
		{
			Label label = new Label(shell, SWT.NONE);
			label.setBackground(SWTResourceManager.getColor(224, 255, 255));
			label.setBounds(46, 49, 210, 16);
			label
					.setText("\u8BF7\u8F93\u5165\u4F60\u8981\u5220\u9664\u7684\u804C\u5DE5\u7F16\u53F7: ");
		}
		{
			text = new Text(shell, SWT.BORDER);
			text.setBounds(294, 46, 86, 22);
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

						String sql = "delete from salary where id=?";
						prpdStmt = db.conn.prepareStatement(sql);
						prpdStmt.setInt(1, Integer.parseInt(text.getText().trim()));
						prpdStmt.executeUpdate();
						JOptionPane.showMessageDialog(null, "	数据删除成功");
                        shell.dispose();
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
					WageCheck cc = new WageCheck();
					shell.dispose();
					cc.open();
				}
			});
			button.setBounds(76, 108, 92, 26);
			button.setText("\u786E\u5B9A");
		}
		{
			Button button = new Button(shell, SWT.NONE);
			button.addSelectionListener(new SelectionAdapter() {
				public void widgetSelected(SelectionEvent e) {
					WageCheck ww=new WageCheck();
					shell.dispose();
					ww.open();
				}
			});
			button.setBounds(229, 108, 92, 26);
			button.setText("\u8FD4\u56DE");
		}

	}

}
