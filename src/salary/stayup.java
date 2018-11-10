package salary;
import java.sql.*;

import java.sql.SQLException;
import database.DBconnect;
import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.swt.widgets.Table;
import org.eclipse.swt.widgets.TableItem;
import org.eclipse.swt.SWT;
import org.eclipse.swt.widgets.TableColumn;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.events.SelectionAdapter;
import org.eclipse.swt.events.SelectionEvent;
import org.eclipse.swt.graphics.Image;
import org.eclipse.swt.widgets.Label;
import org.eclipse.swt.widgets.Text;
import com.swtdesigner.SWTResourceManager;
import javax.swing.JOptionPane;
public class stayup {
	private Table table;

	/**
	 * Launch the application.
	 * 
	 * @param args
	 */
	public static void main(String[] args) {
		try {
			stayup window = new stayup();
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
		shell.setBackground(SWTResourceManager.getColor(224, 255, 255));
		shell.setSize(626, 471);
		shell.setText("\u52A0\u73ED\u4FE1\u606F\u7BA1\u7406");
		{
			table = new Table(shell, SWT.BORDER | SWT.FULL_SELECTION);
			table.setBounds(25, 85, 518, 281);
			table.setHeaderVisible(true);
			table.setLinesVisible(true);
			{
				TableColumn tableColumn = new TableColumn(table, SWT.LEFT);
				tableColumn.setWidth(86);
				tableColumn.setText("\u6D41\u6C34\u7F16\u53F7");
			}
			{
				TableColumn tableColumn = new TableColumn(table, SWT.NONE);
				tableColumn.setWidth(100);
				tableColumn.setText("\u804C\u5DE5\u7F16\u53F7 ");
			}
			{
				TableColumn tableColumn = new TableColumn(table, SWT.NONE);
				tableColumn.setWidth(90);
				tableColumn.setText("\u5458\u5DE5\u59D3\u540D");
			}
			{
				TableColumn tableColumn = new TableColumn(table, SWT.NONE);
				tableColumn.setWidth(104);
				tableColumn.setText("\u52A0\u73ED\u8D39");
			}
			{
				TableColumn tableColumn = new TableColumn(table, SWT.NONE);
				tableColumn.setWidth(100);
				tableColumn.setText("\u52A0\u73ED\u65F6\u95F4");
			}
			{
				Button button = new Button(shell, SWT.NONE);
				button.addSelectionListener(new SelectionAdapter() {
					public void widgetSelected(SelectionEvent e) {
						DBconnect db = new DBconnect();
						PreparedStatement pstmt = null;
						Statement stmt = null;
						ResultSet rs = null;
						int count = 0;
						try {

							String sql = "select * from extrawork order by eid";
							stmt = db.conn.createStatement();
							rs = stmt.executeQuery(sql);
							
							while (rs.next()) {
								String ssql ="select name from emp_info where id =?";
								count++;
								try
								{
								pstmt = db.conn.prepareStatement(ssql);
								pstmt.setInt(1, rs.getInt("id"));
								ResultSet rrs = pstmt.executeQuery();
								 rrs.next();
								 String dddd = rs.getString(4);
									TableItem ite = new TableItem(table,SWT.NONE);
									ite.setText(new String[] {rs.getInt(1)+"",
											                  rs.getInt("id") + "",rrs.getString(1),
											                  rs.getInt("extrawage")+"",dddd });
									rrs.close();
									//pstmt.close();
								}catch(SQLException e1)
								{
									e1.printStackTrace();
								}
                                
							}
							 pstmt.close(); 
							if(count==0)
							{
								JOptionPane.showMessageDialog(null, "目前无记录");
							}
						} catch (SQLException e1) {
							e1.printStackTrace();
						} finally {
							try {
								if (rs != null)
									rs.close();
								
								
								if (stmt != null)
									stmt.close();

							} catch (SQLException e1) {
								e1.printStackTrace();
							}
						}
						db.closeDB();
					}
				});
				button.setBounds(103, 22, 68, 26);
				button.setText("\u67E5\u8BE2 ");
			}

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
			button.setBounds(451, 22, 92, 26);
			button.setText("\u8FD4\u56DE");
		}
		{
			Label label = new Label(shell, SWT.NONE);
			label.setBounds(0, 0, 82, 58);
			label.setText("New Label");
			label.setImage(new Image(null,
			"images/08.jpg"));
		}
		{
			Button button = new Button(shell, SWT.NONE);
			button.addSelectionListener(new SelectionAdapter() {
			
				public void widgetSelected(SelectionEvent e) {
				ExtraInsert er = new ExtraInsert();
				shell.dispose();
				er.open();
				
				
				}
			});
			button.setBounds(217, 22, 73, 26);
			button.setText("\u63D2\u5165");
		}
		{
			Button button = new Button(shell, SWT.NONE);
			button.addSelectionListener(new SelectionAdapter() {
				public void widgetSelected(SelectionEvent e){
					ExtraDelete ex = new ExtraDelete();
					shell.dispose();
					ex.open();
				}
			});
			button.setBounds(325, 22, 82, 26);
			button.setText("\u5220\u9664");
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
