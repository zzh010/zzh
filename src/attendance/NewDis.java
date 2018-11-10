package attendance;
//download by http://www.codefans.net
import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.swt.widgets.TabFolder;
import org.eclipse.swt.SWT;
import org.eclipse.swt.widgets.TabItem;
import org.eclipse.swt.widgets.Table;
import org.eclipse.swt.widgets.TableItem;
import org.eclipse.swt.widgets.TableColumn;
import org.eclipse.swt.widgets.DateTime;



import beans.Attend;

import java.sql.*;
import java.util.*;


import database.DBconnect;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.events.SelectionAdapter;
import org.eclipse.swt.events.SelectionEvent;
import org.eclipse.swt.custom.ScrolledComposite;
import org.eclipse.swt.widgets.Combo;
import javax.swing.JOptionPane;
import com.swtdesigner.SWTResourceManager;
public class NewDis {
	private Table table;
	List<Attend> list = new LinkedList<Attend>();
	Combo year;
	Combo month;

	/**
	 * Launch the application.
	 * @param args
	 */
	public static void main(String[] args) {
		try {
			NewDis window = new NewDis();
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
		shell.setSize(711, 434);
		shell.setText("\u67E5\u770B");
		{
			table = new Table(shell, SWT.BORDER);
			table.setBounds(56, 55, 605, 278);
			table.setHeaderVisible(true);
			table.setLinesVisible(true);
			
			
			
				TableColumn id = new TableColumn(table, SWT.LEFT);
				id.setWidth(100);
				id.setText("\u5458\u5DE5\u7F16\u53F7");
				
			
			
				TableColumn name = new TableColumn(table, SWT.LEFT);
				name.setWidth(100);
				name.setText("\u5458\u5DE5\u59D3\u540D");
			
			
				TableColumn actual = new TableColumn(table, SWT.LEFT);
				actual.setWidth(100);
				actual.setText("\u5B9E\u5230\u5929\u6570");
			
			
				TableColumn takeoff = new TableColumn(table, SWT.LEFT);
				takeoff.setWidth(100);
				takeoff.setText("\u8BF7\u5047\u5929\u6570");
			
			
				TableColumn note = new TableColumn(table, SWT.LEFT);
				note.setWidth(201);
				note.setText("\u5907\u6CE8");
			
			 
			  
		}
		
		Button button = new Button(shell, SWT.NONE);
		button.addSelectionListener(new SelectionAdapter() {
			
			public void widgetSelected(SelectionEvent e) {
				
				 Operate op = new Operate();
				 int gyear = Integer.parseInt(year.getText());
				 int gmonth = Integer.parseInt(month.getText());
				 
				DBconnect db = new DBconnect();
				 ResultSet rs = op.query( gyear, gmonth);
				 try {
					
					while(rs.next())
					{
						Statement stmt = db.conn.createStatement();
						int count = 0;
					    String  ssql = "select days from leavenote where id ="+rs.getInt(1)+" and year ="+2010+" and month = "+6;
						ResultSet  rrs = stmt.executeQuery(ssql);
						while(rrs.next())
						{
							count+=rrs.getInt(1);
						}
						String sss = "select name from emp_info where id ="+rs.getInt("id");
						Statement sst = db.conn.createStatement();
						ResultSet srs = sst.executeQuery(sss);
						
						if(srs.next())
						{
						Attend attend = new Attend(rs.getInt(2),srs.getString(1),rs.getInt(5),rs.getString(6),count);
						list.add(attend);
						}
						srs.close();
						sst.close();
						stmt.close();
						rrs.close();
					}
					if(list.size()==0)
					{
						JOptionPane.showMessageDialog(null, "Ã»ÓÐ¼ÇÂ¼");
					}
					for(int i = 0;i < list.size();i++)
					{
						TableItem item =new  TableItem(table,SWT.None);
						item.setText(new String[]{list.get(i).id+"",list.get(i).name,list.get(i).actual+"",list.get(i).getTakeoff()+"",list.get(i).note});
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
					
					}catch(SQLException e1)
					{
						e1.printStackTrace();
					}
				}
				db.closeDB();
				op.clo();
		   }
		}
		);
		button.setBounds(458, 20, 92, 26);
		button.setText("\u67E5\u8BE2");
		
			 month = new Combo(shell, SWT.NONE);
			month.setBounds(306, 10, 92, 24);
			month.setEnabled(true);
			month.setItems(new String[]{"1","2","3","4","5","6","7","8","9","10","11","12"});
			month.select(0);
		
		
			 year = new Combo(shell, SWT.NONE);
			year.setBounds(141, 10, 92, 24);
			year.setEnabled(true);
			year.setItems(new String[]{"2010","2009"});
			year.select(0);
			
			Button button_1 = new Button(shell, SWT.NONE);
			button_1.addSelectionListener(new SelectionAdapter() {
				
				public void widgetSelected(SelectionEvent e) {
					Attendance aa = new Attendance();
					shell.dispose();
					aa.open();
				}
			});
			button_1.setBounds(306, 354, 92, 26);
			button_1.setText("\u8FD4\u56DE");
		
			
		shell.open();
		shell.layout();
		while (!shell.isDisposed()) {
			if (!display.readAndDispatch()) {
				display.sleep();
			 }
		}
	}
}
