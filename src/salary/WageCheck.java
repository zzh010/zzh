package salary;
//download by http://www.codefans.net
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import database.DBconnect;
import javax.swing.JOptionPane;

import org.eclipse.swt.SWT;
import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.swt.widgets.Label;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.widgets.TableItem;
import org.eclipse.swt.widgets.Text;
import org.eclipse.swt.events.MouseAdapter;
import org.eclipse.swt.events.MouseEvent;
import org.eclipse.swt.graphics.Image;

import com.swtdesigner.SWTResourceManager;
import org.eclipse.swt.widgets.Table;
import org.eclipse.swt.widgets.TableColumn;
import org.eclipse.swt.events.SelectionAdapter;
import org.eclipse.swt.events.SelectionEvent;

public class WageCheck {

	protected Shell shell;

	private static int ID;
	private Table table;

	/**
	 * Launch the application.
	 * 
	 * @param args
	 */
	public static void main(String[] args) {
		try {
			WageCheck window = new WageCheck();
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
		shell.setToolTipText("");
		shell.setSize(617, 313);
		shell.setText("\u5DE5\u8D44\u7F16\u8F91");
		{
			Button button1 = new Button(shell, SWT.NONE);
			button1.addSelectionListener(new SelectionAdapter() {
				
				public void widgetSelected(SelectionEvent e) {
					DBconnect db = new DBconnect();
					
					ResultSet rs = null;
					wageop ww = new wageop();

					try {

						rs = ww.query();
						while (rs.next()) {
							Statement stmt =db.conn.createStatement();
							ResultSet  rrs = stmt.executeQuery("select name from emp_info where id ="+rs.getInt(2));
							
							if(rrs.next())
							{
							TableItem ite = new TableItem(table, SWT.NONE);
							int rresult = rs.getInt(3)+rs.getInt(4)+rs.getInt(5);
							int year = rs.getInt("year");
							
							int month = rs.getInt("month");
							String date = year+"-"+month;
							ite.setText(new String[] {
									              rs.getInt(1) + "",
									              rrs.getString(1) ,
									              rs.getInt(3)+"",
									              rs.getInt(4)+"",
									              rs.getInt(5)+"",
									              rresult+"",date});
							}
							stmt.close();
							rrs.close();
						}
									
						
					} catch (SQLException e1) {
						e1.printStackTrace();
					} finally {
						try {
							if (rs != null) {
								rs.close();
							}
							
						} catch (SQLException e1) {
							e1.printStackTrace();
						}
					}
					db.closeDB();
					ww.closes();
				}
			});
			
			button1.setBounds(140, 10, 80, 26);
			button1.setText("\u67E5\u8BE2");
		}
		{
			Button button2 = new Button(shell, SWT.NONE);
			button2.addSelectionListener(new SelectionAdapter() {
				
				public void widgetSelected(SelectionEvent e) {
					WageManange www = new WageManange();
					shell.dispose();
					www.open();
				}
			});
			button2.setBounds(463, 10, 80, 26);
			button2.setText("\u8FD4\u56DE");
		}
		{
			Label label = new Label(shell, SWT.NONE);
			label.setBounds(0, 0, 108, 341);
			label.setText("New Label");
			label.setImage(new Image(null,
					"images/0.jpg"));
		}
		{
			table = new Table(shell, SWT.BORDER | SWT.FULL_SELECTION);
			table.setBounds(114, 42, 511, 209);
			table.setHeaderVisible(true);
			table.setLinesVisible(true);
			{
				TableColumn tableColumn = new TableColumn(table, SWT.NONE);
				tableColumn.setWidth(73);
				tableColumn.setText("\u5DE5\u8D44\u7F16\u53F7");
			}
			{
				TableColumn tableColumn = new TableColumn(table, SWT.NONE);
				tableColumn.setWidth(84);
				tableColumn.setText("\u804C\u5DE5\u59D3\u540D");
			}
			{
				TableColumn tableColumn = new TableColumn(table, SWT.NONE);
				tableColumn.setWidth(83);
				tableColumn.setText("\u57FA\u672C\u5DE5\u8D44");
			}
			{
				TableColumn tableColumn = new TableColumn(table, SWT.NONE);
				tableColumn.setWidth(51);
				tableColumn.setText("\u5956\u91D1");
			}
			{
				TableColumn tableColumn = new TableColumn(table, SWT.NONE);
				tableColumn.setWidth(64);
				tableColumn.setText("\u52A0\u73ED\u8D39 ");
			}
			{
				TableColumn tableColumn = new TableColumn(table, SWT.NONE);
				tableColumn.setWidth(72);
				tableColumn.setText("\u5B9E\u9645\u5DE5\u8D44 ");
			}
			{
				TableColumn tableColumn = new TableColumn(table, SWT.NONE);
				tableColumn.setWidth(100);
				tableColumn.setText("\u5E74\u6708");
			}
		}
		{
			Button button = new Button(shell, SWT.NONE);
			button.addSelectionListener(new SelectionAdapter() {
				
				public void widgetSelected(SelectionEvent e) {
					WageInsert in =new WageInsert();
					shell.dispose();
					in.open();
				}
			});

			button.setBounds(261, 10, 70, 26);
			button.setText("      \u63D2\u5165      ");
		}
		{
			Button button = new Button(shell, SWT.NONE);
			button.addSelectionListener(new SelectionAdapter() {
				
				public void widgetSelected(SelectionEvent e) {
					WageDelete de = new WageDelete();
					shell.dispose();
					de.open();
				}
			});
			button.setBounds(354, 10, 80, 26);
			button.setText("\u5220\u9664");
		}
	}
}
