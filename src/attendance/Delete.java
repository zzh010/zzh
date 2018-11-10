package attendance;

import org.eclipse.swt.graphics.Image;
import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.swt.widgets.Menu;
import org.eclipse.swt.SWT;
import org.eclipse.swt.widgets.MenuItem;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.widgets.Label;
import org.eclipse.swt.widgets.MessageBox;
import org.eclipse.swt.widgets.Text;
import org.eclipse.swt.events.SelectionAdapter;
import org.eclipse.swt.events.SelectionEvent;

import javax.swing.JOptionPane;
import database.DBconnect;
import java.sql.*;
import org.eclipse.swt.widgets.Combo;
import com.swtdesigner.SWTResourceManager;
public class Delete {
	private Text tid;
	private Combo year;
	private Combo month;
	private int sele = 0;
	

	/**
	 * Launch the application.
	 * @param args
	 */
	public static void main(String[] args) {
		try {
			Delete window = new Delete();
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
		shell.setBackground(SWTResourceManager.getColor(255, 204, 102));
		shell.setSize(534, 442);
		shell.setText("\u6309\u6761\u4EF6\u5220\u9664");
		{
			Label label = new Label(shell, SWT.NONE);
			label.setBounds(44, 26, 100, 106);
			label.setText("New Label");
			label.setImage(new Image(null,"images/delete.jpg"));
		}
		{
			Label label = new Label(shell, SWT.NONE);
			label.setBackground(SWTResourceManager.getColor(255, 204, 102));
			label.setForeground(SWTResourceManager.getColor(0, 0, 0));
			label.setBounds(40, 160, 48, 16);
			label.setText("\u5E74\u4EFD\uFF1A");
		}
		{
			Label label = new Label(shell, SWT.NONE);
			label.setBackground(SWTResourceManager.getColor(255, 204, 102));
			label.setForeground(SWTResourceManager.getColor(0, 0, 0));
			label.setBounds(40, 214, 48, 16);
			label.setText("\u6708\u4EFD\uFF1A");
		}
		{
			
			Button delete = new Button(shell, SWT.NONE);
			delete.setImage(new Image(null,"images/dust.jpg"));
			delete.addSelectionListener(new SelectionAdapter() {
				public void widgetSelected(SelectionEvent e) {
					int gyear = Integer.parseInt(year.getText());
					int gmonth = Integer.parseInt(month.getText());
					if(sele == 0)
					{
						JOptionPane.showMessageDialog(null, "必须要先选择条件");
					}else 
					{
						int id =0;
						if(!tid.getText().trim().equals(""))
							try
						{
							id =Integer.parseInt(tid.getText().trim());
						}catch(NumberFormatException e1)
						{
							JOptionPane.showMessageDialog(null, "请注意输入数据的格式");
						}
						Operate op = new Operate();
						String info = op.delete(id, sele, gyear, gmonth);
						JOptionPane.showMessageDialog(null, info);
						op.clo();
						tid.setText("");
						tid.setEditable(false);
						year.setEnabled(false);
						month.setEnabled(false);
					}
			 }	
				
		   }
		);
			delete.setBounds(205, 281, 109, 107);
			delete.setText("\u5220\u9664");
			
		}
		{
			Label label = new Label(shell, SWT.NONE);
			label.setBackground(SWTResourceManager.getColor(255, 204, 102));
			label.setForeground(SWTResourceManager.getColor(0, 0, 0));
			label.setBounds(44, 262, 48, 16);
			label.setText("\u7F16\u53F7 \uFF1A");
		}
		{
			tid = new Text(shell, SWT.BORDER);
			tid.setEditable(false);
			tid.setBounds(112, 262, 71, 22);
		}
		
			 year = new Combo(shell, SWT.NONE);
			year.setBounds(91, 160, 92, 24);
			year.setEnabled(false);
			year.setItems(new String[]{"2010","2009"});
			year.select(0);
		
		
			 month = new Combo(shell, SWT.NONE);
			month.setBounds(91, 206, 92, 24);
			month.setEnabled(false);
			month.setItems(new String[]{"1","2","3","4","5","6","7","8","9","10","11","12"});
			month.select(0);
			{
				Label label = new Label(shell, SWT.NONE);
				label.setBackground(SWTResourceManager.getColor(255, 204, 102));
				label.setForeground(SWTResourceManager.getColor(0, 0, 0));
				label.setFont(SWTResourceManager.getFont("华文中宋", 12, SWT.BOLD));
				label.setBounds(194, 15, 109, 23);
				label.setText("\u6309\u65F6\u95F4");
			}
			{
				Button time = new Button(shell, SWT.NONE);
				time.setImage(new Image(null,"images/sshijian.jpg"));
				time.addSelectionListener(new SelectionAdapter() {
					public void widgetSelected(SelectionEvent e) {
						tid.setEditable(false);
						month.setEnabled(true);
						year.setEnabled(true);
						sele = 1;
						
					}
				});
				time.setBounds(194, 15, 118, 103);
				time.setText("\u6309\u65F6\u95F4");
			}
			{
				Label label = new Label(shell, SWT.NONE);
				label.setBackground(SWTResourceManager.getColor(255, 204, 102));
				label.setForeground(SWTResourceManager.getColor(0, 0, 0));
				label.setFont(SWTResourceManager.getFont("华文中宋", 12, SWT.BOLD));
				label.setBounds(366, 20, 92, 26);
				label.setText("\u6309\u7F16\u53F7");
			}
			{
				Button aid = new Button(shell, SWT.NONE);
				aid.setImage(new Image(null,"images/bbian.jpg"));
				aid.addSelectionListener(new SelectionAdapter() {
					public void widgetSelected(SelectionEvent e) {
						tid.setEditable(true);
						month.setEnabled(false);
						year.setEnabled(false);
						sele = 2;
					}
				});
				aid.setBounds(366, 20, 92, 92);
				aid.setText("\u6309\u7F16\u53F7");
			}
			{
				Label label = new Label(shell, SWT.NONE);
				label.setBackground(SWTResourceManager.getColor(255, 204, 102));
				label.setForeground(SWTResourceManager.getColor(0, 0, 0));
				label.setFont(SWTResourceManager.getFont("仿宋_GB2312", 13, SWT.BOLD));
				label.setBounds(281, 138, 87, 22);
				label.setText("\u7EFC\u5408");
			}
			{
				Button dou = new Button(shell, SWT.NONE);
				dou.setImage(new Image(null,"images/bianhao.jpg"));
				dou.addSelectionListener(new SelectionAdapter() {
					public void widgetSelected(SelectionEvent e) {
						tid.setEditable(true);
						month.setEnabled(true);
						year.setEnabled(true);
						sele = 3;
					}
				});
				dou.setBounds(281, 138, 92, 92);
				dou.setText("\u6309\u65F6\u95F4\u7F16\u53F7 ");
			}
			{
				Button button = new Button(shell, SWT.NONE);
				button.setImage(new Image(null,"images/back.jpg"));
				button.addSelectionListener(new SelectionAdapter() {
					
					public void widgetSelected(SelectionEvent e) {
						Attendance att = new Attendance();
						shell.dispose();
						att.open();
					}
				});
				button.setBounds(366, 281, 109, 107);
				button.setText("New Button");
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
