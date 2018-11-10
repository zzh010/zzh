package StaffManagement;

import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.swt.widgets.Label;
import org.eclipse.swt.SWT;
import org.eclipse.swt.widgets.Text;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.widgets.Group;
import com.swtdesigner.SWTResourceManager;
import org.eclipse.swt.events.SelectionAdapter;
import org.eclipse.swt.events.SelectionEvent;

import org.eclipse.swt.events.FocusAdapter;
import org.eclipse.swt.events.FocusEvent;
import org.eclipse.swt.events.SelectionAdapter;
import org.eclipse.swt.events.SelectionEvent;
import javax.swing.JOptionPane;
import database.DBconnect;
import java.sql.*;
import org.eclipse.ui.forms.widgets.FormToolkit;
import org.eclipse.swt.events.MouseAdapter;
import org.eclipse.swt.events.MouseEvent;


public class DepartmentSetup {

	protected Shell shell;
	private Text cha;
	private Text dept_id;
	private Text dept_name;
	private Text description;
	private Text empnums;
	public String deptname;

	/**
	 * Launch the application.
	 * @param args
	 */
	public static void main(String[] args) {
		try {
			DepartmentSetup window = new DepartmentSetup();
			window.open();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * Open the window.
	 * @wbp.parser.entryPoint
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
		shell.setBackground(SWTResourceManager.getColor(224, 255, 255));
		shell.setSize(601, 599);
		shell.setText("\u90E8\u95E8\u8BBE\u7F6E");
		{
			Label label = new Label(shell, SWT.NONE);
			label.setBackground(SWTResourceManager.getColor(224, 255, 255));
			label.setBounds(56, 24, 100, 16);
			label.setText("    \u90E8\u95E8\u7F16\u53F7\uFF1A");
		}
		{
			cha = new Text(shell, SWT.BORDER);
			cha.setBounds(186, 21, 126, 22);
		}
		{
			Button search = new Button(shell, SWT.NONE);
			search.addSelectionListener(new SelectionAdapter() {
				
				public void widgetSelected(SelectionEvent e) {
					PreparedStatement pstmt=null;
					ResultSet rs = null;
					DBconnect db = new DBconnect();
					try {
						
						String tdept_id = cha.getText().trim();
						if(!tdept_id.equals("")){
							String sql = "select * from dept_info  where dept_id =?";
							pstmt = db.conn.prepareStatement(sql);
							pstmt.setString(1, tdept_id);
							rs = pstmt.executeQuery();	
							if(rs.next()){
								int a = rs.getInt(1);
								String b = rs.getString(2);
								String c = rs.getString(3);
								int d = rs.getInt(4);
								dept_id.setText(String.valueOf(a));
								dept_name.setText(b);
								description.setText(c);
								empnums.setText(String.valueOf(d));
								deptname = dept_name.getText();
							}
							else
							{ 
								JOptionPane.showMessageDialog(null, "Ϊ�ñ�ŵĲ��Ų����ڣ�");
							}
						}
						else
						{
							JOptionPane.showMessageDialog(null, "�������벿�ű�ţ�");
						}
					
					}catch(SQLException e1)
					{
						e1.printStackTrace();
					}
					db.closeDB();
				}							
			});
			search.setBounds(391, 19, 92, 26);
			search.setText("\u67E5\u8BE2");
		}
		{
			Button add = new Button(shell, SWT.NONE);
			add.setSelection(true);
			add.setForeground(SWTResourceManager.getColor(127, 255, 212));
			add.addMouseListener(new MouseAdapter() {
			
				public void mouseDown(MouseEvent e) {
					DBconnect db = new DBconnect();
					try{					
						if(!dept_id.getText().equals("")&&!dept_name.getText().equals("")&&!description.getText().equals("")&&!empnums.getText().equals("")){
							String sql1 ="select * from dept_info where dept_id = ?";
							PreparedStatement prpdStmt1 = db.conn.prepareStatement(sql1);
							prpdStmt1.setInt(1, Integer.parseInt(dept_id.getText()));
							prpdStmt1.executeQuery();
							if(prpdStmt1.executeQuery().next()){
								JOptionPane.showMessageDialog(null, "�ò��ű���Ѵ���");
								dept_id.setText("");
							}
							else{
								String sql = "insert into dept_info(dept_id,dept_name,description,empnums) values(?,?,?,?)";
								PreparedStatement prpdStmt = db.conn.prepareStatement(sql);
								prpdStmt.setInt(1, Integer.parseInt(dept_id.getText()));
								prpdStmt.setString(2, dept_name.getText());
								prpdStmt.setString(3, description.getText());
								prpdStmt.setInt(4, Integer.parseInt(empnums.getText()));
								prpdStmt.executeUpdate();
								prpdStmt.close();
								db.conn.close();
								JOptionPane.showMessageDialog(null, "��ӳɹ���");
								dept_id.setText("");
								dept_name.setText("");
								description.setText("");
								empnums.setText("");
							}
						}
						else{
							JOptionPane.showMessageDialog(null, "������ݲ���Ϊ�գ�");
						}		
					}catch(SQLException e2){
						e2.printStackTrace();
					} 
					db.closeDB();
				}
			});
			add.addSelectionListener(new SelectionAdapter() {
				public void widgetSelected(SelectionEvent e) {

				}
			});
			add.setBounds(83, 421, 92, 26);
			add.setText("\u589E\u52A0");
		}
		{
			Button delete = new Button(shell, SWT.NONE);
			delete.addSelectionListener(new SelectionAdapter() {
				
				public void widgetSelected(SelectionEvent e) {
				}
			});
			delete.addMouseListener(new MouseAdapter() {
				public void mouseDown(MouseEvent e) {
					DBconnect db = new DBconnect();
					PreparedStatement pstmt =null;
					PreparedStatement pst=null;
					ResultSet rs = null;
					try{
						if(!dept_id.getText().equals("")&&!dept_name.getText().equals("")&&!description.getText().equals("")&&!empnums.getText().equals("")){
							String sql = "delete from dept_info where dept_id = ?";
							String sql1 = "select * from emp_info where department =?";
							 pstmt = db.conn.prepareStatement(sql1);
							 pstmt.setString(1, dept_name.getText().trim());
							 rs= pstmt.executeQuery();
							 if(rs.next())
							 {
								 JOptionPane.showMessageDialog(null, "ĳЩԱ�����ڴ˲����У������Ƚ����ǵ����������Ųſ���ɾ���˲���");
								 return;
							 }
							 else
							 {
							pst = db.conn.prepareStatement(sql);
							pst.setInt(1, Integer.parseInt(dept_id.getText().trim()));
							pst.executeUpdate();
							 JOptionPane.showMessageDialog(null, "ɾ���ɹ���");
							 }
							dept_id.setText("");
							dept_name.setText("");
							description.setText("");
							empnums.setText("");
							cha.setText("");
						}
						else{
							JOptionPane.showMessageDialog(null, "ɾ�����ݲ���Ϊ�գ�");
						}
					}catch(Exception e5){
						e5.printStackTrace();
					}finally
					{
						try
						{
							if( rs!=null)
								 rs.close();
						if( pstmt!=null)
							 pstmt.close();
						if(pst!=null)
							 pst.close();
						
						
						
						}catch(SQLException e1)
						{
							e1.printStackTrace();
						}
					}
					db.closeDB();
				}
			});
			
			delete.setBounds(422, 421, 92, 26);
			delete.setText("\u5220\u9664");
		}
		{
			Label depid = new Label(shell, SWT.NONE);
			depid.setFont(SWTResourceManager.getFont("����", 12, SWT.BOLD));
			depid.setBackground(SWTResourceManager.getColor(204, 255, 255));
			depid.setBounds(56, 108, 100, 16);
			depid.setText("    \u90E8\u95E8\u7F16\u53F7\uFF1A");
		}
		{
			dept_id = new Text(shell, SWT.BORDER);
			dept_id.setBounds(186, 105, 126, 22);
		}
		{
			Label depname = new Label(shell, SWT.NONE);
			depname.setFont(SWTResourceManager.getFont("����", 12, SWT.BOLD));
			depname.setBackground(SWTResourceManager.getColor(204, 255, 255));
			depname.setBounds(56, 164, 119, 16);
			depname.setText("    \u90E8\u95E8\u540D\u79F0\uFF1A");
		}
		{
			dept_name = new Text(shell, SWT.BORDER);
			dept_name.setBounds(186, 161, 126, 22);
		}
		{
			Label depfun = new Label(shell, SWT.NONE);
			depfun.setFont(SWTResourceManager.getFont("����", 12, SWT.BOLD));
			depfun.setBackground(SWTResourceManager.getColor(204, 255, 255));
			depfun.setBounds(56, 227, 100, 16);
			depfun.setText("\u90E8\u95E8\u804C\u80FD\u63CF\u8FF0\uFF1A");
		}
		{
			description = new Text(shell, SWT.BORDER);
			description.setBounds(186, 224, 355, 101);
		}
		{
			Label depnum = new Label(shell, SWT.NONE);
			depnum.setFont(SWTResourceManager.getFont("����", 12, SWT.BOLD));
			depnum.setBackground(SWTResourceManager.getColor(204, 255, 255));
			depnum.setBounds(56, 368, 119, 16);
			depnum.setText("    \u90E8\u95E8\u4EBA\u6570\uFF1B");
		}
		{
			empnums = new Text(shell, SWT.BORDER);
			empnums.setBounds(203, 365, 109, 22);
		}
		{
			Group group = new Group(shell, SWT.NONE);
			group.setBackground(SWTResourceManager.getColor(204, 255, 255));
			group.setForeground(SWTResourceManager.getColor(SWT.COLOR_WIDGET_BORDER));
			group.setText("\u8BE6\u7EC6\u4FE1\u606F");
			group.setBounds(10, 69, 573, 406);
			{
				Button change = new Button(group, SWT.NONE);
				change.addSelectionListener(new SelectionAdapter() {
					
					public void widgetSelected(SelectionEvent e) {
					}
				});
				change.addMouseListener(new MouseAdapter() {
					
					public void mouseDown(MouseEvent e) {
						DBconnect db = new DBconnect();
						try{
							if(!dept_id.getText().equals("")&&!dept_name.getText().equals("")&&!description.getText().equals("")&&!empnums.getText().equals("")){
								String sql1 ="select * from dept_info where dept_id = ?";
								PreparedStatement prpdStmt1 = db.conn.prepareStatement(sql1);
								prpdStmt1.setInt(1, Integer.parseInt(dept_id.getText().trim()));
								prpdStmt1.executeQuery();
								if(prpdStmt1.executeQuery().next()&& !cha.getText().equals(dept_id.getText())){
									JOptionPane.showMessageDialog(null, "�ò��ű���Ѵ���");
									dept_id.setText(cha.getText());
								}
								else{
									String sql = "update dept_info set dept_id = ?,dept_name = ?,description = ?,empnums = ? where dept_id = ?";
									String sql2 = "update emp_info set department = ? where department = ?";
									String sql3 = "update job_info set olddept = ? where olddept = ?";
									String sql4 = "update job_info set newdept = ? where newdept = ?";
									PreparedStatement prpdStmt = db.conn.prepareStatement(sql);
									PreparedStatement prpdStmt2 = db.conn.prepareStatement(sql2);
									PreparedStatement prpdStmt3 = db.conn.prepareStatement(sql3);
									PreparedStatement prpdStmt4 = db.conn.prepareStatement(sql4);
									prpdStmt.setInt(1,Integer.parseInt(dept_id.getText()));
									prpdStmt.setString(2, dept_name.getText());
									prpdStmt.setString(3, description.getText());
									prpdStmt.setInt(4, Integer.parseInt(empnums.getText()));
									prpdStmt.setInt(5, Integer.parseInt(cha.getText()));
									prpdStmt2.setString(1, dept_name.getText());
									prpdStmt2.setString(2, deptname);
									prpdStmt3.setString(1, dept_name.getText());
									prpdStmt3.setString(2, deptname);
									prpdStmt4.setString(1, dept_name.getText());
									prpdStmt4.setString(2, deptname);
									prpdStmt.executeUpdate();
									prpdStmt.close();
									prpdStmt2.executeUpdate();
									prpdStmt2.close();
									prpdStmt3.executeUpdate();
									prpdStmt3.close();
									prpdStmt4.executeUpdate();
									prpdStmt4.close();
									db.conn.close();
									JOptionPane.showMessageDialog(null, "�޸ĳɹ���");
									cha.setText("");
								}
							}
							else{
								JOptionPane.showMessageDialog(null, "�޸����ݲ���Ϊ�գ�");
							}
						}catch(Exception e4){
							e4.printStackTrace();
						}
						db.closeDB();
					}
				});
				change.setBounds(250, 353, 92, 26);
				change.setText("\u4FEE\u6539");
			}
		}
		{
			Button exit = new Button(shell, SWT.NONE);
			exit.addSelectionListener(new SelectionAdapter() {
				
				public void widgetSelected(SelectionEvent e) {
				}
			});
			exit.addMouseListener(new MouseAdapter() {
				
				public void mouseDown(MouseEvent e) {
					shell.dispose();
				}
			});
			exit.setBounds(472, 519, 92, 26);
			exit.setText("\u9000\u51FA");
		}

	}
}
