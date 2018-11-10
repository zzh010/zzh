package StaffManagement;
//download by http://www.codefans.net
import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.swt.widgets.Label;
import org.eclipse.swt.SWT;
import org.eclipse.swt.widgets.Text;
import org.eclipse.swt.widgets.Group;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.events.SelectionAdapter;
import org.eclipse.swt.events.SelectionEvent;
import org.eclipse.swt.graphics.Image;

import java.sql.*;

import database.DBconnect;
import javax.swing.JOptionPane;
import com.swtdesigner.SWTResourceManager;
import database.DBconnect;
import org.eclipse.swt.widgets.Combo;
import org.eclipse.swt.widgets.DateTime;
public class job {

	protected Shell shell;
	private Text wid1;
	private Text old1;
	private Text note1;
	private Text qid;
	Combo newis;
	DateTime dateTime;

	/**
	 * Launch the application.
	 * @param args
	 */
	public static void main(String[] args) {
		try {
			job window = new job();
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
		shell.setSize(511, 586);
		shell.setText("\u5C97\u4F4D\u8C03\u6574\u4FE1\u606F");
		{
			Group group = new Group(shell, SWT.NONE);
			group.setBackground(SWTResourceManager.getColor(224, 255, 255));
			group.setText("\u8BF7\u586B\u5165\u8C03\u6574\u4FE1\u606F");
			group.setBounds(63, 79, 385, 269);
			{
				Label label = new Label(group, SWT.NONE);
				label.setBackground(SWTResourceManager.getColor(224, 255, 255));
				label.setBounds(53, 212, 72, 16);
				label.setText("\u5907\u6CE8:");
			}
			{
				note1 = new Text(group, SWT.BORDER);
				note1.setBackground(SWTResourceManager.getColor(SWT.COLOR_WHITE));
				note1.setBounds(159, 209, 198, 38);
				note1.setEditable(false);
			}
				newis = new Combo(group, SWT.NONE);
				newis.setBackground(SWTResourceManager.getColor(SWT.COLOR_WHITE));
				newis.setBounds(149, 108, 92, 24);
				newis.setItems(new String[]{"销售部","采购部","财务部","市场营销","人事资源部","生产部","后勤部"});
				newis.setEnabled(false);
				newis.select(1);
				{
					dateTime = new DateTime(group, SWT.BORDER);
					dateTime.setBackground(SWTResourceManager.getColor(SWT.COLOR_WHITE));
					dateTime.setBounds(153, 156, 117, 25);
					dateTime.setEnabled(false);
				}
				{
					Label label = new Label(group, SWT.NONE);
					label.setBounds(53, 41, 72, 16);
					label.setBackground(SWTResourceManager.getColor(224, 255, 255));
					label.setText("\u5458\u5DE5\u7F16\u53F7:");
				}
				{
					wid1 = new Text(group, SWT.BORDER);
					wid1.setEditable(false);
					wid1.setBounds(159, 35, 98, 22);
					wid1.setBackground(SWTResourceManager.getColor(SWT.COLOR_WHITE));
				}
				{
					Label label = new Label(group, SWT.NONE);
					label.setBounds(53, 75, 72, 16);
					label.setBackground(SWTResourceManager.getColor(224, 255, 255));
					label.setText("\u539F\u5C5E\u90E8\u95E8:");
				}
				{
					old1 = new Text(group, SWT.BORDER);
					old1.setBounds(159, 72, 98, 22);
					old1.setBackground(SWTResourceManager.getColor(SWT.COLOR_WHITE));
					old1.setEditable(false);
				}
				{
					Label label = new Label(group, SWT.NONE);
					label.setBounds(53, 116, 72, 16);
					label.setBackground(SWTResourceManager.getColor(224, 255, 255));
					label.setText("\u65B0\u5165\u90E8\u95E8:");
				}
				{
					Label label = new Label(group, SWT.NONE);
					label.setBounds(53, 165, 72, 16);
					label.setBackground(SWTResourceManager.getColor(224, 255, 255));
					label.setText("\u8C03\u52A8\u65F6\u95F4:");
				}
			
		}
		{
			Label label = new Label(shell, SWT.NONE);
			label.setBackground(SWTResourceManager.getColor(224, 255, 255));
			label.setBounds(63, 31, 124, 16);
			label.setText("\u8BF7\u8F93\u5165\u5458\u5DE5\u7F16\u53F7:");
		}
		{
			qid = new Text(shell, SWT.BORDER);
			qid.setBackground(SWTResourceManager.getColor(SWT.COLOR_WHITE));
			qid.setBounds(191, 28, 71, 22);
		}
		{
			Button button = new Button(shell, SWT.NONE);
			button.addSelectionListener(new SelectionAdapter() {
				
				public void widgetSelected(SelectionEvent e) {
					DBconnect db = new DBconnect();
					    newis.setEnabled(false);
					    dateTime.setEnabled(false);
					    note1.setEditable(false);
						PreparedStatement pre =null;
						ResultSet rs =null;
						try{
						if(qid.getText().equals("")){
							JOptionPane.showMessageDialog(null,"用户无输入");
						}
						else{
							String sql="select * from emp_info where id=?";
							pre=db.conn.prepareStatement(sql);
							String gid=qid.getText().trim();
							int ggid=Integer.parseInt(gid);
							pre.setInt(1, ggid);
							 rs=pre.executeQuery();
							if(rs.next()){
								wid1.setText(ggid+"");
								old1.setText(rs.getString(9));
							}
							else{
								
								JOptionPane.showMessageDialog(null,"用户不存在，请重新输入");
							}
						}
						}catch(NumberFormatException e1)
						{
							JOptionPane.showMessageDialog(null, "输入的编号格式不对");
							return;
						}
						catch(SQLException e3){
						e3.printStackTrace();
					}finally
					{
						try
						{
							if(rs!=null)
								rs.close();
							if(pre!=null)
							{
								pre.close();
							}
						}catch(SQLException e1)
						{
							e1.printStackTrace();
						}
					}
						db.closeDB();
				}
			});
			button.setBounds(286, 26, 79, 26);
			button.setText("\u67E5\u8BE2");
		}
		{
			Button button = new Button(shell, SWT.NONE);
			button.addSelectionListener(new SelectionAdapter() {
				public void widgetSelected(SelectionEvent e) {
					DBconnect db =new DBconnect();
					PreparedStatement pstmt  = null;
					ResultSet rrs = null;
					try
					{
						int ggid = Integer.parseInt(qid.getText().trim());
						String sql = "select * from emp_info where id =?";
						pstmt = db.conn.prepareStatement(sql);
						pstmt.setInt(1, ggid);
						rrs = pstmt.executeQuery();
						if(rrs.next())
						{
							newis.setEnabled(true);
							dateTime.setEnabled(true);
							note1.setEditable(true);
							
						}
						else
						{
							JOptionPane.showMessageDialog(null, "无效的用户编号");
							return;
						}
					}catch(NumberFormatException e1)
					{
						JOptionPane.showMessageDialog(null, "输入的编号格式不对");
						return;
					}catch(SQLException e1)
					{
						e1.printStackTrace();
					}finally
					{
						try
						{
							if(rrs!=null)
								rrs.close();
							if(pstmt!=null)
								pstmt.close();
						}catch(SQLException e1)
						{
							e1.printStackTrace();
						}
					}
					db.closeDB();
					
				}
			});
			button.setBounds(63, 374, 92, 26);
			button.setText("\u8C03\u6574");
		}
		{
			Button button = new Button(shell, SWT.NONE);
			button.addSelectionListener(new SelectionAdapter() {
				public void widgetSelected(SelectionEvent e) {
					DBconnect db = new DBconnect();
					PreparedStatement pr = null;
					PreparedStatement pre = null;
					PreparedStatement prepare =null;
					ResultSet rs =null;
					try{
						String gid=qid.getText().trim();
						int ggid=Integer.parseInt(gid);
						String sql2="insert into job_info values(null,?,?,?,?,?)";
						db.conn.setAutoCommit(false);
						int year = dateTime.getYear();
						int month = dateTime.getMonth();
						int day = dateTime.getDay();
						String date =year +"-"+month+"-"+day;
						pre = db.conn.prepareStatement(sql2);
						pre.setInt(1, ggid);
						Statement stmt = db.conn.createStatement();
						String ssql = "select department from emp_info where id ="+ggid;
						ResultSet rrss = stmt.executeQuery(ssql);
						rrss.next();
						pre.setString(2, rrss.getString(1));
						pre.setString(3,newis.getText());
						pre.setString(4,date);
						pre.setString(5, note1.getText().trim());
						pre.executeUpdate();
						
					  stmt.close();
					  rrss.close();
						String sql="update emp_info set department=? where id=?";
						int aid=Integer.parseInt(qid.getText());
						 pr=db.conn.prepareStatement(sql);
						pr.setString(1, newis.getText().trim());
						pr.setInt(2,aid);
						pr.executeUpdate();
						JOptionPane.showMessageDialog(null, "调整成功");
						db.conn.commit();
						}catch(NumberFormatException e1 ){
							JOptionPane.showMessageDialog(null, "输入的编号格式不对");
							return;
							
						}
					catch(SQLException e3){
						e3.printStackTrace();
					}finally
					{
						try
						{
							if(rs!=null)
								rs.close();
							if(pr!=null)
								pr.close();
							if(pre!=null)
								pre.close();
							if(prepare!=null)
								prepare.close();
						}catch(SQLException e1)
						{
							e1.printStackTrace();
						}
					}
						db.closeDB();
						wid1.setText("");
						wid1.setEditable(false);
						old1.setEditable(false);
						old1.setText("");
						newis.setEnabled(false);
						dateTime.setEnabled(false);
						note1.setText("");
						note1.setEditable(false);
						
				}
			});
			button.setBounds(191, 374, 92, 26);
			button.setText("\u4FDD\u5B58");
		}
		{
			Button button = new Button(shell, SWT.NONE);
			button.addSelectionListener(new SelectionAdapter() {
				
				public void widgetSelected(SelectionEvent e) {
					qid.setText("");
					wid1.setEditable(false);
					old1.setEditable(false);
					newis.setEnabled(false);
					dateTime.setEnabled(false);
					note1.setEditable(false);
					wid1.setText("");
					old1.setText("");
					note1.setText("");
				}
			});
			button.setBounds(332, 374, 92, 26);
			button.setText("\u53D6\u6D88");
		}
		{
			Button button = new Button(shell, SWT.NONE);
			button.setImage(new Image(null,"images/back.jpg"));
			button.addSelectionListener(new SelectionAdapter() {
				public void widgetSelected(SelectionEvent e) {
					MainMenu mm = new MainMenu();
					shell.dispose();
					mm.open();
				}
			});
			button.setBounds(203, 427, 115, 84);
			button.setText("\u8FD4\u56DE");
		}

	}
}
