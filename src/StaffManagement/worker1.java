package StaffManagement;

import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.swt.widgets.Label;
import org.eclipse.swt.SWT;
import org.eclipse.swt.widgets.Text;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.events.SelectionAdapter;
import org.eclipse.swt.events.SelectionEvent;
import java.sql.*;
import database.DBconnect;
import javax.swing.JOptionPane;
import org.eclipse.swt.events.MouseTrackAdapter;
import org.eclipse.swt.events.MouseEvent;
import org.eclipse.swt.graphics.Image;
import org.eclipse.swt.widgets.DateTime;
import javax.swing.JOptionPane;
import com.swtdesigner.SWTResourceManager;
public class worker1 {

	protected Shell shell;
	private Text id;
	private Text name;
	private Text province;
	private Text sex;
	private Text ethnic;
	private Text address;
	private Text merry;
	private Text department;
	private Text tele;
	private Text plitic;
	private Text post;
	private Text education;
	private Text wage;
	private Text nowpost;
	private Text note;
	private Text qid;
	private Text born;
	private Text worktime;
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
			label.setBackground(SWTResourceManager.getColor(255, 255, 153));
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
			label.setBounds(25, 313, 72, 16);
			label.setText("\u51FA\u751F\u65E5\u671F\uFF1A");
		}
		{
			Label label = new Label(shell, SWT.NONE);
			label.setBackground(SWTResourceManager.getColor(255, 255, 153));
			label.setBounds(25, 359, 72, 16);
			label.setText("\u5A5A\u59FB\u72B6\u51B5\uFF1A");
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
			label.setBounds(256, 200, 102, 16);
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
			label.setBounds(256, 313, 72, 16);
			label.setText("\u5DE5\u8D44\uFF1A");
		}
		{
			Label label = new Label(shell, SWT.NONE);
			label.setBackground(SWTResourceManager.getColor(255, 255, 153));
			label.setBounds(256, 359, 72, 16);
			label.setText("\u73B0\u4EFB\u804C\u4F4D\uFF1A");
		}
		{
			Label label = new Label(shell, SWT.NONE);
			label.setBackground(SWTResourceManager.getColor(255, 255, 153));
			label.setBounds(25, 417, 72, 16);
			label.setText("\u5907\u6CE8\uFF1A");
		}
		{
			id = new Text(shell, SWT.BORDER);
			id.setEditable(false);
			id.setBounds(125, 78, 71, 22);
		}
		{
			name = new Text(shell, SWT.BORDER);
			name.setEditable(false);
			name.setBounds(125, 115, 71, 22);
		}
		{
			province = new Text(shell, SWT.BORDER);
			province.setEditable(false);
			province.setBounds(125, 159, 71, 22);
		}
		{
			sex = new Text(shell, SWT.BORDER);
			sex.setEditable(false);
			sex.setBounds(125, 200, 71, 22);
		}
		{
			ethnic = new Text(shell, SWT.BORDER);
			ethnic.setEditable(false);
			ethnic.setBounds(125, 238, 71, 22);
		}
		{
			address = new Text(shell, SWT.BORDER);
			address.setEditable(false);
			address.setBounds(125, 273, 71, 22);
		}
		{
			merry = new Text(shell, SWT.BORDER);
			merry.setEditable(false);
			merry.setBounds(125, 359, 71, 22);
		}
		{
			department = new Text(shell, SWT.BORDER);
			department.setEditable(false);
			department.setBounds(364, 78, 107, 22);
		}
		{
			tele = new Text(shell, SWT.BORDER);
			tele.setEditable(false);
			tele.setBounds(364, 115, 107, 22);
		}
		{
			plitic = new Text(shell, SWT.BORDER);
			plitic.setEditable(false);
			plitic.setBounds(364, 159, 107, 22);
		}
		{
			post = new Text(shell, SWT.BORDER);
			post.setEditable(false);
			post.setBounds(364, 238, 107, 22);
		}
		{
			education = new Text(shell, SWT.BORDER);
			education.setEditable(false);
			education.setBounds(364, 273, 107, 22);
		}
		{
			wage = new Text(shell, SWT.BORDER);
			wage.setEditable(false);
			wage.setBounds(364, 313, 107, 22);
		}
		{
			nowpost = new Text(shell, SWT.BORDER);
			nowpost.setEditable(false);
			nowpost.setBounds(364, 359, 107, 22);
		}
		{
			note = new Text(shell, SWT.BORDER);
			note.setEditable(false);
			note.setBounds(125, 417, 346, 43);
		}
		{
			Label label = new Label(shell, SWT.NONE);
			label.setBackground(SWTResourceManager.getColor(255, 255, 153));
			label.setBounds(109, 20, 128, 16);
			label.setText("\u8BF7\u8F93\u5165\u5458\u5DE5\u7F16\u53F7\uFF1A");
		}
		{
			qid = new Text(shell, SWT.BORDER);
			qid.setBounds(243, 20, 71, 22);
		}
		{
			Button button = new Button(shell, SWT.NONE);
			button.addSelectionListener(new SelectionAdapter() {
				
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
							pre=db.conn.prepareStatement(sql);
							String gid=qid.getText().trim();
							int ggid=Integer.parseInt(gid);
							pre.setInt(1, ggid);
						     rs=pre.executeQuery();
							if(rs.next()){
								id.setText(rs.getInt(1)+"");
								name.setText(rs.getString(2));
								province.setText(rs.getString(3));
								sex.setText(rs.getString(4));
								ethnic.setText(rs.getString(5));
								address.setText(rs.getString(6));
								
								born.setText(rs.getString(7));
								merry.setText(rs.getString(8));
								department.setText(rs.getString(9));
								tele.setText(rs.getString(10));
								plitic.setText(rs.getString(11));
								
								worktime.setText(rs.getString(12));
								post.setText(rs.getString(13));
								education.setText(rs.getString(14));
								wage.setText(rs.getString(15));
								nowpost.setText(rs.getString(16));
								note.setText(rs.getString(17));
								
							}
							
							else{
								JOptionPane.showMessageDialog(null,"用户不存在，请重新输入");
							}
						}
					
					}catch(NumberFormatException e1)
					{
						JOptionPane.showMessageDialog(null, "用户编号输入无效");
						return;
					}
					catch(SQLException e1){
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
			button.setBounds(343, 16, 92, 26);
			button.setText("\u67E5\u8BE2");
		}
		{
			Button button = new Button(shell, SWT.NONE);
			button.setImage(new Image(null,"images/ddelete.jpg"));
			button.addSelectionListener(new SelectionAdapter() {
			
				public void widgetSelected(SelectionEvent e) {
					DBconnect db = new DBconnect();
					PreparedStatement prepa = null;
					PreparedStatement prepa2 = null;
					PreparedStatement pre = null;
					if(id.getText().equals(""))
					{
						JOptionPane.showMessageDialog(null, "无数据可删除");
						return;
						}
					try{
						int iid =Integer.parseInt(id.getText().trim());
						String sql="delete from emp_info where id=?";
						 prepa=db.conn.prepareStatement(sql);
						prepa.setInt(1, Integer.parseInt(id.getText().trim()));
						prepa.executeUpdate();
						
						
						String sql2="delete from job_info where id=?";
						 prepa2=db.conn.prepareStatement(sql2);
						prepa2.setInt(1,iid );
						prepa2.executeUpdate();
						
						String sql1 = "delete from attendance where id=?";
						pre = db.conn.prepareStatement(sql1);
						pre.setInt(1, iid);
						pre.executeUpdate();
						
						String sql3="delete leavenote where id +?";
						pre = db.conn.prepareStatement(sql1);
						pre.setInt(1, iid);
						pre.executeUpdate();
						
						String sql4="delete rewards where id +?";
						pre = db.conn.prepareStatement(sql1);
						pre.setInt(1, iid);
						pre.executeUpdate();
						
						String sql5="delete salary where id +?";
						pre = db.conn.prepareStatement(sql1);
						pre.setInt(1, iid);
						pre.executeUpdate();
						
						String sql6="delete extrawork where id +?";
						pre = db.conn.prepareStatement(sql1);
						pre.setInt(1, iid);
						pre.executeUpdate();
						
						String sql7="delete job_info where id +?";
						pre = db.conn.prepareStatement(sql1);
						pre.setInt(1, iid);
						pre.executeUpdate();
						JOptionPane.showMessageDialog(null, "数据删除成功");
						id.setText("");
						name.setText("");
						province.setText("");
						sex.setText("");
						ethnic.setText("");
						address.setText("");
						merry.setText("");
						department.setText("");
						tele.setText("");
						plitic.setText("");
						post.setText("");
						education.setText("");
						wage.setText("");
						nowpost.setText("");
						note.setText("");
						qid.setText("");
						born.setText("");
						worktime.setText("");
						
					}
					catch(SQLException e1){
						e1.printStackTrace();
					}finally
					{
						try
						{
							if(pre!=null)
								pre.close();
							if(prepa!=null)
								prepa.close();
							if(prepa2!=null)
								prepa2.close();
						}catch(SQLException e1)
						{
							e1.printStackTrace();
						}
					}
					db.closeDB();
					JOptionPane.showMessageDialog(null, "信息已删除");
					qid.setText("");
					id.setText("");
					name.setText("");
					sex.setText("");
					province.setText("");
					ethnic.setText("");
					address.setText("");
					born.setEditable(false);
					merry.setText("");
					department.setText("");
					tele.setText("");
					plitic.setText("");
					worktime.setEditable(false);
					post.setText("");
					education.setText("");
					wage.setText("");
					nowpost.setText("");
					note.setText("");
				}
			});
			button.setBounds(322, 483, 128, 87);
			button.setText("\u5220\u9664\u8BE5\u5458\u5DE5\u8BB0\u5F55");
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
			button.setBounds(125, 483, 117, 87);
			button.setText("New Button");
		}
		{
			born = new Text(shell, SWT.BORDER);
			born.setEditable(false);
			born.setBounds(125, 313, 71, 22);
		}
		{
			worktime = new Text(shell, SWT.BORDER);
			worktime.setEditable(false);
			worktime.setBounds(364, 200, 107, 22);
		}

	}
}
