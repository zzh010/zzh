package function;

import org.eclipse.swt.graphics.Image;
import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.swt.widgets.Table;
import org.eclipse.swt.widgets.TableItem;
import org.eclipse.swt.SWT;
import org.eclipse.swt.widgets.TableColumn;
import database.DBconnect;
import java.sql.*;
import java.util.List;
import java.util.LinkedList;
import org.eclipse.swt.widgets.Label;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.events.SelectionAdapter;
import org.eclipse.swt.events.SelectionEvent;
import com.swtdesigner.SWTResourceManager;
public class sf {
	private Table table;

	List<Integer> list = new LinkedList<Integer>();

	/**
	 * Launch the application.
	 * @param args
	 */
	public static void main(String[] args) {
		try {
			sf window = new sf();
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
		shell.setBackground(SWTResourceManager.getColor(255, 255, 204));
		shell.setSize(647, 437);
		shell.setText("\u5956\u7F5A\u60C5\u51B5");
		{
			table = new Table(shell, SWT.BORDER | SWT.FULL_SELECTION);
			table.setBounds(88, 54, 501, 239);
			table.setHeaderVisible(true);
			table.setLinesVisible(true);
			{
				TableColumn tableColumn = new TableColumn(table, SWT.NONE);
				tableColumn.setWidth(100);
				tableColumn.setText("\u7F16\u53F7");
			}
			{
				TableColumn tableColumn = new TableColumn(table, SWT.NONE);
				tableColumn.setWidth(100);
				tableColumn.setText("\u65F6\u95F4");
			}
			{
				TableColumn tableColumn = new TableColumn(table, SWT.NONE);
				tableColumn.setWidth(100);
				tableColumn.setText("\u59D3\u540D");
			}
			{
				TableColumn tableColumn = new TableColumn(table, SWT.NONE);
				tableColumn.setWidth(100);
				tableColumn.setText("\u5956/\u60E9");
			}
			{
				TableColumn tableColumn = new TableColumn(table, SWT.NONE);
				tableColumn.setWidth(199);
				tableColumn.setText("\u539F\u56E0");
			}
			
		}
		{
			Label label = new Label(shell, SWT.NONE);
			label.setBounds(10, 10, 72, 94);
			label.setText("New Label");
			label.setImage(new Image(null,"images/prize.jpg"));
		}
		{
			Button add = new Button(shell, SWT.NONE);
			add.setImage(new Image(null,"images/tian.jpg"));
			add.addSelectionListener(new SelectionAdapter() {
				
				public void widgetSelected(SelectionEvent e) {
					Addprize add = new Addprize();
					shell.dispose();
					add.open();
					
				}
			});
			add.setBounds(50, 304, 96, 84);
			add.setText("New Button");
		}
		{
			Button shua = new Button(shell, SWT.NONE);
			shua.addSelectionListener(new SelectionAdapter() {
				
				public void widgetSelected(SelectionEvent e) {
					 DBconnect db = new DBconnect();
				       Statement stmt = null;
				       ResultSet rs = null;
				       String sql = "select * from rewards order by time";
				       try {
						stmt = db.conn.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE,ResultSet.CONCUR_UPDATABLE);
						rs = stmt.executeQuery(sql);
						while(rs.next())
						{
							Integer aaa = new Integer(rs.getInt(1));
							
							if(!list.contains(aaa) )
							{
								list.add(aaa);
							Statement sstmt = db.conn.createStatement();
							ResultSet rrs = sstmt.executeQuery("select name from emp_info where id="+rs.getInt("id"));
							rrs.next();
							TableItem item = new TableItem(table,SWT.None);
							item.setText(new String[]{rs.getInt(1)+"",rs.getDate(3)+"",rrs.getString(1),rs.getString(4),rs.getString(5)});
							rrs.close();
							sstmt.close();
							
							}
						}
					} catch (SQLException e1) {
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
						}catch(SQLException e1)
						{
							e1.printStackTrace();
						}
					}
				       db.closeDB();
				      
				}
			});
			shua.setBounds(197, 304, 88, 84);
			shua.setText("New Button");
			shua.setImage(new Image(null,"images/shu.jpg"));
		}
		{
			Button button = new Button(shell, SWT.NONE);
			button.setImage(new Image(null,"images/xiugai.jpg"));
			button.addSelectionListener(new SelectionAdapter() {
				
				public void widgetSelected(SelectionEvent e) {
					shell.dispose();
					UpdatePrize up = new UpdatePrize();
					up.open();
					
				}
			});
			button.setBounds(354, 309, 82, 84);
			button.setText("New Button");
		}
		{
			Button button = new Button(shell, SWT.NONE);
			button.setImage(new Image(null,"images/delete.jpg"));
			button.addSelectionListener(new SelectionAdapter() {
			
				public void widgetSelected(SelectionEvent e) {
					deleteprize de = new deleteprize();
					shell.dispose();
					de.open();
				}
			});
			button.setBounds(493, 309, 72, 79);
			button.setText("New Button");
		}
        DBconnect db = new DBconnect();
       Statement stmt = null;
       ResultSet rs = null;
       String sql = "select * from rewards order by time";
       try {
		stmt = db.conn.createStatement();
		rs = stmt.executeQuery(sql);
		while(rs.next())
		{
			Integer aaa = new Integer(rs.getInt(1));
			list.add(aaa);
			Statement sstmt = db.conn.createStatement();
			ResultSet rrs = sstmt.executeQuery("select name from emp_info where id="+rs.getInt("id"));
			if(rrs.next())
			{
			TableItem item = new TableItem(table,SWT.None);
			item.setText(new String[]{rs.getInt(1)+"",rs.getDate(3)+"",rrs.getString(1),rs.getString(4),rs.getString(5)});
			rrs.close();
			sstmt.close();
			}
		}
	} catch (SQLException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}finally
	{
		try
		{
			if(rs!=null)
				rs.close();
			if(stmt!=null)
				stmt.close();
		}catch(SQLException e)
		{
			e.printStackTrace();
		}
	}
       db.closeDB();
		shell.open();
		shell.layout();
		while (!shell.isDisposed()) {
			if (!display.readAndDispatch()) {
				display.sleep();
			}
		}
	}
}
