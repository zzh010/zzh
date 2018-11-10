package salary;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import database.DBconnect;
import javax.swing.JOptionPane;

import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.swt.widgets.Label;
import org.eclipse.swt.widgets.Table;
import org.eclipse.swt.widgets.TableItem;
import org.eclipse.swt.SWT;
import org.eclipse.swt.widgets.Text;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.events.SelectionAdapter;
import org.eclipse.swt.events.SelectionEvent;
import com.swtdesigner.SWTResourceManager;
import org.eclipse.swt.widgets.Combo;

public class WageInsert {
	private Text id;
	private Text jiben;
	private Text prize;
	private Text extra;
	Combo year;
	Combo month;

	/**
	 * Launch the application.
	 * 
	 * @param args
	 */
	public static void main(String[] args) {
		try {
			WageInsert window = new WageInsert();
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
		shell.setSize(550, 314);
		shell.setText("\u63D2\u5165\u8BB0\u5F55");
		{
			Label label = new Label(shell, SWT.NONE);
			label.setBackground(SWTResourceManager.getColor(224, 255, 255));
			label.setBounds(47, 64, 72, 16);
			label.setText("\u804C\u5DE5\u7F16\u53F7:");
		}
		{
			Label label = new Label(shell, SWT.NONE);
			label.setBackground(SWTResourceManager.getColor(224, 255, 255));
			label.setBounds(281, 64, 72, 16);
			label.setText("\u57FA\u672C\u5DE5\u8D44:");
		}
		{
			Label label = new Label(shell, SWT.NONE);
			label.setBackground(SWTResourceManager.getColor(224, 255, 255));
			label.setBounds(47, 107, 72, 16);
			label.setText("\u5956   \u91D1:");
		}
		{
			Label label = new Label(shell, SWT.NONE);
			label.setBackground(SWTResourceManager.getColor(224, 255, 255));
			label.setBounds(281, 108, 72, 16);
			label.setText("\u52A0 \u73ED \u8D39:");
		}
		{
			id = new Text(shell, SWT.BORDER);
			id.setBounds(153, 61, 89, 22);
		}
		{
			jiben = new Text(shell, SWT.BORDER);
			jiben.setBounds(406, 61, 89, 22);
		}
		{
			prize = new Text(shell, SWT.BORDER);
			prize.setBounds(153, 103, 89, 22);
		}
		{
			extra = new Text(shell, SWT.BORDER);
			extra.setBounds(406, 105, 89, 22);
		}
		{
			Button button = new Button(shell, SWT.NONE);
			button.addSelectionListener(new SelectionAdapter() {

				public void widgetSelected(SelectionEvent e) {
					   if (id.getText().trim().equals("")) {
						JOptionPane.showMessageDialog(null, "必须要输入编号");
						return;
					} else {
						try {
							int iid = Integer.parseInt(id.getText().trim());
							int base = Integer.parseInt(jiben.getText().trim());
							int prizz = Integer
									.parseInt(prize.getText().trim());
							int es = Integer.parseInt(extra.getText().trim());
							int yyear = Integer.parseInt(year.getText());
							int mmonth = Integer.parseInt(month.getText());
							mysalary my = new mysalary(iid, base, prizz, es,
									yyear, mmonth);
							wageop ww = new wageop();
							int ss = ww.insert(my);
							if (ss == 1) {
								JOptionPane.showMessageDialog(null,
										"此员工该月工资已存在！");
								id.setText("");
								jiben.setText("");
								prize.setText("");
								extra.setText("");
							} else if (ss == 2) {
								JOptionPane.showMessageDialog(null, "插入数据成功");
								WageCheck cc = new WageCheck();
								shell.dispose();
								cc.open();
							}
							ww.closes();
						} catch (NumberFormatException e1) {
							JOptionPane.showMessageDialog(null, "全部要输入整型数据");
							
						}
					}
					
					
				}
			});
			button.setBounds(74, 200, 98, 26);
			button.setText("\u786E\u5B9A");
		}
		{
			Button button = new Button(shell, SWT.NONE);
			button.addSelectionListener(new SelectionAdapter() {
				
				public void widgetSelected(SelectionEvent e) {
					id.setText("");
					jiben.setText("");
					prize.setText("");
					extra.setText("");
					
				}
			});
			button.setBounds(385, 200, 92, 26);
			button.setText("\u91CD\u7F6E");
		}
		{
			 year = new Combo(shell, SWT.NONE);
			year.setBounds(155, 159, 87, 20);
			year.setItems(new String[]{"2009","2010"});
			year.select(1);
		}
		{
			 month = new Combo(shell, SWT.NONE);
			month.setBounds(406, 159, 87, 20);
			month.setItems(new String[]{"1","2","3","4","5","6","7","8","9","10","11","12"});
			month.select(0);
			
		}
		{
			Label label = new Label(shell, SWT.NONE);
			label.setBackground(SWTResourceManager.getColor(224, 255, 255));
			label.setBounds(58, 162, 39, 12);
			label.setText("\u5E74\uFF1A");
		}
		{
			Label label = new Label(shell, SWT.NONE);
			label.setBackground(SWTResourceManager.getColor(224, 255, 255));
			label.setBounds(281, 159, 54, 12);
			label.setText("\u6708\uFF1A");
		}
		{
			Button button = new Button(shell, SWT.NONE);
			button.addSelectionListener(new SelectionAdapter() {
				@Override
				public void widgetSelected(SelectionEvent e) {
					WageCheck www = new WageCheck();
					shell.dispose();
					www.open();
				}
			});
			button.setBounds(237, 200, 98, 26);
			button.setText("\u8FD4\u56DE");
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
