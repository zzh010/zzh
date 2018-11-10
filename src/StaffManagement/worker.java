package StaffManagement;
//download by http://www.codefans.net
import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.swt.widgets.Label;
import org.eclipse.swt.SWT;
import org.eclipse.swt.widgets.Text;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.events.SelectionAdapter;
import org.eclipse.swt.events.SelectionEvent;
import java.sql.*;
import java.util.LinkedList;
import java.util.List;

import database.DBconnect;

import javax.swing.ButtonGroup;
import javax.swing.JOptionPane;
import javax.swing.JRadioButton;

import org.eclipse.swt.events.MouseTrackAdapter;
import org.eclipse.swt.events.MouseEvent;
import org.eclipse.swt.graphics.Image;
import org.eclipse.swt.widgets.DateTime;


import org.eclipse.swt.widgets.Combo;
import com.swtdesigner.SWTResourceManager;

public class worker {

	protected Shell shell;
	private Text id;
	private Text name;
	private Text ethnic;
	private Text address;
	private Text tele;
	private Text plitic;
	private Text post;
	private Text wage;
	private Text note;
	private Text qid;
	Combo depart;
	Combo wenhua;
	Combo position;
	Combo provin;
	Button boy;
	Button girl;
	DateTime worktime;
	DateTime born;
	Combo married;
	
	
	/**
	 * Launch the application.
	 * @param args
	 */
	public static void main(String[] args) {
		try {
			worker window = new worker();
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
	 * @wbp.parser.entryPoint
	 */
	protected void createContents() {
		shell = new Shell();
		shell.setBackground(SWTResourceManager.getColor(255, 255, 153));
		shell.setSize(660, 624);
		shell.setText("\u5458\u5DE5\u57FA\u672C\u4FE1\u606F\uFF1A");
		{
			Label label = new Label(shell, SWT.NONE);
			label.setBackground(SWTResourceManager.getColor(255, 255, 153));
			label.setBounds(25, 78, 72, 16);
			label.setText("\u5458\u5DE5\u7F16\u53F7\uFF1A");
		}
		{
			Label label = new Label(shell, SWT.NONE);
			label.setBackground(SWTResourceManager.getColor(255, 255, 153));
			label.setBounds(25, 115, 72, 16);
			label.setText("\u59D3\u540D\uFF1A");
		}
		{
			Label label = new Label(shell, SWT.NONE);
			label.setBackground(SWTResourceManager.getColor(255, 255, 153));
			label.setBounds(25, 159, 72, 16);
			label.setText("\u7C4D\u8D2F\uFF1A");
		}
		{
			Label label = new Label(shell, SWT.NONE);
			label.setBackground(SWTResourceManager.getColor(255, 255, 153));
			label.setBounds(25, 200, 72, 16);
			label.setText("\u6027\u522B\uFF1A");
		}
		{
			Label label = new Label(shell, SWT.NONE);
			label.setBackground(SWTResourceManager.getColor(255, 255, 102));
			label.setBounds(25, 238, 72, 16);
			label.setText("\u6C11\u65CF\uFF1A");
		}
		{
			Label label = new Label(shell, SWT.NONE);
			label.setBackground(SWTResourceManager.getColor(255, 255, 153));
			label.setBounds(25, 273, 72, 16);
			label.setText("\u5BB6\u5EAD\u4F4F\u5740\uFF1A");
		}
		{
			Label label = new Label(shell, SWT.NONE);
			label.setBackground(SWTResourceManager.getColor(255, 255, 153));
			label.setBounds(25, 329, 72, 16);
			label.setText("\u51FA\u751F\u65E5\u671F\uFF1A");
		}
		{
			Label label = new Label(shell, SWT.NONE);
			label.setBackground(SWTResourceManager.getColor(255, 255, 153));
			label.setBounds(25, 375, 72, 16);
			label.setText("\u5A5A\u5426\uFF1A");
		}
		{
			Label label = new Label(shell, SWT.NONE);
			label.setBackground(SWTResourceManager.getColor(255, 255, 153));
			label.setBounds(256, 78, 72, 16);
			label.setText("\u6240\u5C5E\u90E8\u95E8\uFF1A");
		}
		{
			Label label = new Label(shell, SWT.NONE);
			label.setBackground(SWTResourceManager.getColor(255, 255, 153));
			label.setBounds(256, 115, 72, 16);
			label.setText("\u8054\u7CFB\u7535\u8BDD\uFF1A");
		}
		{
			Label label = new Label(shell, SWT.NONE);
			label.setBackground(SWTResourceManager.getColor(255, 255, 153));
			label.setBounds(256, 159, 72, 16);
			label.setText("\u653F\u6CBB\u9762\u8C8C\uFF1A");
		}
		{
			Label label = new Label(shell, SWT.NONE);
			label.setBackground(SWTResourceManager.getColor(255, 255, 153));
			label.setBounds(242, 200, 102, 16);
			label.setText("\u53C2\u52A0\u5DE5\u4F5C\u65F6\u95F4\uFF1A");
		}
		{
			Label label = new Label(shell, SWT.NONE);
			label.setBackground(SWTResourceManager.getColor(255, 255, 153));
			label.setBounds(256, 238, 72, 16);
			label.setText("\u804C\u79F0\uFF1A");
		}
		{
			Label label = new Label(shell, SWT.NONE);
			label.setBackground(SWTResourceManager.getColor(255, 255, 153));
			label.setBounds(256, 273, 72, 16);
			label.setText("\u6587\u5316\u7A0B\u5EA6\uFF1A");
		}
		{
			Label label = new Label(shell, SWT.NONE);
			label.setBackground(SWTResourceManager.getColor(255, 255, 153));
			label.setBounds(256, 329, 72, 16);
			label.setText("\u5DE5\u8D44\uFF1A");
		}
		{
			Label label = new Label(shell, SWT.NONE);
			label.setBackground(SWTResourceManager.getColor(255, 255, 153));
			label.setBounds(256, 375, 72, 16);
			label.setText("\u73B0\u4EFB\u804C\u4F4D\uFF1A");
		}
		{
			Label label = new Label(shell, SWT.NONE);
			label.setBackground(SWTResourceManager.getColor(255, 255, 153));
			label.setBounds(25, 426, 72, 16);
			label.setText("\u5907\u6CE8\uFF1A");
		}
		{
			id = new Text(shell, SWT.BORDER);
			id.setBounds(125, 78, 71, 22);
		}
		{
			name = new Text(shell, SWT.BORDER);
			name.setBounds(125, 115, 71, 22);
		}
		{
			ethnic = new Text(shell, SWT.BORDER);
			ethnic.setBounds(125, 238, 71, 22);
		}
		{
			address = new Text(shell, SWT.BORDER);
			address.setBounds(125, 273, 71, 22);
		}
		{
			tele = new Text(shell, SWT.BORDER);
			tele.setBounds(364, 115, 102, 22);
		}
		{
			plitic = new Text(shell, SWT.BORDER);
			plitic.setBounds(364, 159, 102, 22);
		}
		{
			post = new Text(shell, SWT.BORDER);
			post.setBounds(364, 235, 106, 22);
		}
		{
			wage = new Text(shell, SWT.BORDER);
			wage.setBounds(364, 326, 117, 22);
		}
		{
			note = new Text(shell, SWT.BORDER);
			note.setBounds(135, 423, 310, 43);
		}
		{
			Label label = new Label(shell, SWT.NONE);
			label.setBounds(109, 20, 128, 16);
			label.setText("\u8BF7\u8F93\u5165\u5458\u5DE5\u7F16\u53F7\uFF1A");
		}
		{
			qid = new Text(shell, SWT.BORDER);
			qid.setBounds(243, 20, 71, 22);
		}
		{
			Button query = new Button(shell, SWT.NONE);
			query.addSelectionListener(new SelectionAdapter() {
				
				public void widgetSelected(SelectionEvent e) {
					DBconnect db = new DBconnect();
					PreparedStatement pre = null;
					ResultSet rs = null;
					try{
						if(qid.getText().equals("")){
							JOptionPane.showMessageDialog(null,"用户无输入");
						}
						else{
							String sql="select * from emp_info where id=?";
							pre=(PreparedStatement) db.conn.prepareStatement(sql);
							String gid=qid.getText().trim();
							int ggid=Integer.parseInt(gid);
							pre.setInt(1, ggid);
						    rs=pre.executeQuery();
							if(rs.next()){
								id.setText(rs.getInt(1)+"");
								name.setText(rs.getString(2));
								String ddepart = rs.getString("department");
								depart.setText(ddepart);
								String ssex = rs.getString("sex");
								if(ssex.equals("男"))
								{
									boy.setSelection(true);
									girl.setSelection(false);
								}
								else
								{
									girl.setSelection(true);
									boy.setSelection(false);
								}
								married.setText(rs.getString("mStatus"));
								
								
								ethnic.setText(rs.getString(5));
								address.setText(rs.getString(6));
								wenhua.setText(rs.getString("education"));
								provin.setText(rs.getString("hometown"));
								position.setText(rs.getString("nowpost"));
								tele.setText(rs.getString(10));
								plitic.setText(rs.getString(11));							
								post.setText(rs.getString(13));								
								wage.setText(rs.getString(15));	
								note.setText(rs.getString(17));	
								
								
								
							}
							
							else{
								JOptionPane.showMessageDialog(null,"用户不存在，请重新输入");
							}
						}
					
					}catch(SQLException e1){
						e1.printStackTrace();
						
					}finally
					{
						try
						{
							if(rs!=null)
								rs.close();
							if(pre!=null)
								pre.close();
						}catch(SQLException e1)
						{
							e1.printStackTrace();
						}
					}
					db.closeDB();
				}
			});
			query.setBounds(343, 16, 92, 26);
			query.setText("\u67E5\u8BE2");
		}
		{
			Button xiu = new Button(shell, SWT.NONE);
			xiu.setFont(SWTResourceManager.getFont("华文细黑", 12, SWT.BOLD));
			xiu.addSelectionListener(new SelectionAdapter() {
				public void widgetSelected(SelectionEvent e) {
                 if(id.getText().trim().equals(""))
                 {
                	 JOptionPane.showMessageDialog(null, "先添加或者修改信息再选择操作");
                	 return;
                 }
					DBconnect db = new DBconnect();
					PreparedStatement pstmt = null;
					try
					{
						int gid = Integer.parseInt(id.getText().trim());
						
						String gname = name.getText();
						String sql ="delete from emp_info where id =?";
					pstmt = (PreparedStatement) db.conn.prepareStatement(sql);
					pstmt.setInt(1, gid);
					pstmt.executeUpdate();
					String sql1 ="insert into emp_info values(?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)";
					pstmt = db.conn.prepareStatement(sql1);
					pstmt.setInt(1, gid);
					pstmt.setString(2, name.getText().trim());
					pstmt.setString(3, provin.getText());
					if(boy.getSelection())
						pstmt.setString(4, "男");
					else
						pstmt.setString(4, "女");
					pstmt.setString(5, ethnic.getText());
					pstmt.setString(6, address.getText());
					int year = born.getYear();
					int month = born.getMonth();
					int day = born.getDay();
					String da = year+"-"+month+"-"+day;
					pstmt.setString(7, da);
					pstmt.setString(8, married.getText().trim());
					pstmt.setString(9, depart.getText());
					pstmt.setString(10, tele.getText());
					pstmt.setString(11, plitic.getText());
					year = worktime.getYear();
					month = worktime.getMonth();
					day = worktime.getDay();
					String dat = year+"-"+month+"-"+day;
					pstmt.setString(12, dat);
					pstmt.setString(13, post.getText());
					pstmt.setString(14, wenhua.getText());
					pstmt.setInt(15, Integer.parseInt(wage.getText()));
					pstmt.setString(16,position.getText());
					pstmt.setString(17, note.getText());
					pstmt.executeUpdate();
					JOptionPane.showMessageDialog(null, "数据修改成功");
					id.setText("");
					qid.setText("");
					name.setText("");
					tele.setText("");
					ethnic.setText("");
					plitic.setText("");
					post.setText("");
					note.setText("");
					wage.setText("");
					}catch(SQLException e1)
					{
						e1.printStackTrace();
					}finally
					{
						try
					{
						if(pstmt!=null)
						{
							pstmt.close();
						}
					}catch(SQLException e1)
					{
						e1.printStackTrace();
					}
					}
					db.closeDB();
				}
			});
			xiu.setBounds(512, 88, 111, 26);
			xiu.setText("\u4FEE\u6539");
		}
		{
			Button add = new Button(shell, SWT.NONE);
			add.setFont(SWTResourceManager.getFont("华文细黑", 12, SWT.BOLD));
			add.addSelectionListener(new SelectionAdapter() {
			
				public void widgetSelected(SelectionEvent e) {
					if(id.getText().trim().equals(""))
	                 {
	                	 JOptionPane.showMessageDialog(null, "先添加或者修改信息再选择操作");
	                	 return;
	                 }
					
					DBconnect db = new DBconnect();
					PreparedStatement pstmt = null;
					try
					{
						int gid = Integer.parseInt(id.getText().trim());
						
						String gname = name.getText();
						String sql ="delete from emp_info where id =?";
					pstmt = (PreparedStatement) db.conn.prepareStatement(sql);
					pstmt.setInt(1, gid);
					String sql1 ="insert into emp_info values(?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)";
					pstmt = db.conn.prepareStatement(sql1);
					pstmt.setInt(1, gid);
					pstmt.setString(2, name.getText().trim());
					pstmt.setString(3, provin.getText());
					if(boy.getSelection()&&!girl.getSelection())
					{
						pstmt.setString(4, "男");
					}
					else if(!boy.getSelection() && girl.getSelection())
					{
						pstmt.setString(4, "女");
					}
					pstmt.setString(5, ethnic.getText());
					pstmt.setString(6, address.getText());
					int year = born.getYear();
					int month = born.getMonth();
					int day = born.getDay();
					String da = year+"-"+month+"-"+day;
					pstmt.setString(7, da);
					pstmt.setString(8, married.getText().trim());
					pstmt.setString(9, depart.getText());
					pstmt.setString(10, tele.getText());
					pstmt.setString(11, plitic.getText());
					year = worktime.getYear();
					month = worktime.getMonth();
					day = worktime.getDay();
					String dat = year+"-"+month+"-"+day;
					pstmt.setString(12, dat);
					pstmt.setString(13, post.getText());
					pstmt.setString(14, wenhua.getText());
					pstmt.setInt(15, Integer.parseInt(wage.getText()));
					pstmt.setString(16,position.getText());
					pstmt.setString(17, note.getText());
					pstmt.executeUpdate();
					JOptionPane.showMessageDialog(null, "数据添加成功");
					id.setText("");
					qid.setText("");
					name.setText("");
					tele.setText("");
					ethnic.setText("");
					plitic.setText("");
					post.setText("");
					note.setText("");
					wage.setText("");
					}catch(SQLException e1)
					{
						e1.printStackTrace();
					}finally
					{
						try
					{
						if(pstmt!=null)
						{
							pstmt.close();
						}
					}catch(SQLException e1)
					{
						e1.printStackTrace();
					}
					}
					db.closeDB();

					
				}
						
						
			
			});
			add.setBounds(512, 182, 117, 26);
			add.setText("\u6DFB\u52A0\u65B0\u8BB0\u5F55");
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
			button.setBounds(227, 493, 117, 87);
			button.setText("\u8FD4\u56DE");
		}
		{
			 boy = new Button(shell, SWT.RADIO);
			 boy.setEnabled(true);
			boy.setBounds(120, 200, 37, 16);
			boy.setText("\u7537");
			boy.setSelection(true);
			
		}
		{
			 girl = new Button(shell, SWT.RADIO);
			 girl.setEnabled(true);
			girl.setBounds(160, 200, 37, 16);
			girl.setText("\u5973");
			girl.setSelection(false);
		}
		{
			
			 depart = new Combo(shell, SWT.NONE);
			depart.setBounds(359, 78, 111, 24);
			
			depart.setItems(new String[]{"客户服务部","人力资源部","财务部","销售部","生产部","采购部"});
			depart.select(0);
		}
		{
			 provin = new Combo(shell, SWT.NONE);
			provin.setBounds(104, 159, 106, 24);
			String pp []={"陕西","山西","河北","河南","山东","辽宁","云南","广西","吉林","内蒙古","黑龙江","江西","浙江","湖北","湖南"};
			provin.setItems(pp);
			provin.select(0);
		}
		{
		    wenhua = new Combo(shell, SWT.NONE);
			wenhua.setBounds(364, 270, 92, 24);
			wenhua.setItems(new String[]{"高中","本科","硕士"});
			wenhua.select(0);
		}
		{
			 position = new Combo(shell, SWT.NONE);
			position.setBounds(364, 372, 124, 24);
			position.setItems(new String[]{"经理","小组长","组员"});
			position.select(0);
		}
		{
			 born = new DateTime(shell, SWT.BORDER);
			born.setBounds(100, 321, 117, 25);
		}
		{
			 worktime = new DateTime(shell, SWT.BORDER);
			worktime.setBounds(364, 191, 117, 25);
		}
		{
			 married = new Combo(shell, SWT.NONE);
			married.setBounds(125, 372, 92, 24);
			married.setItems(new String[]{"是","否"});
			married.select(0);
		}

	}
}
