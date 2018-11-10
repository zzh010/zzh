package attendance;
//download by http://www.codefans.net
import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.swt.widgets.Label;
import org.eclipse.swt.SWT;
import org.eclipse.swt.widgets.Text;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.events.SelectionAdapter;
import org.eclipse.swt.events.SelectionEvent;
import org.eclipse.swt.graphics.Image;
import java.sql.*;
import beans.Attend;
import database.DBconnect;
import javax.swing.JOptionPane;
import org.eclipse.swt.widgets.Combo;
import com.swtdesigner.SWTResourceManager;
public class Add {
	private Text id;
	private Text actual;
	private Text note;
	Combo year;
	Combo month;

	/**
	 * Launch the application.
	 * @param args
	 */
	public static void main(String[] args) {
		try {
			Add window = new Add();
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
		shell.setSize(507, 408);
		shell.setText("\u6DFB\u52A0\u6570\u636E");
		{
			Label label = new Label(shell, SWT.NONE);
			label.setBackground(SWTResourceManager.getColor(224, 255, 255));
			label.setBounds(25, 72, 72, 16);
			label.setText("\u5458\u5DE5\u7F16\u53F7\uFF1A");
		}
		{
			id = new Text(shell, SWT.BORDER);
			id.setBackground(SWTResourceManager.getColor(255, 255, 255));
			id.setBounds(118, 69, 92, 22);
		}
		{
			Label label = new Label(shell, SWT.NONE);
			label.setBackground(SWTResourceManager.getColor(224, 255, 255));
			label.setBounds(25, 114, 32, 16);
			label.setText("\u5E74\uFF1A");
		}
		{
			Label label = new Label(shell, SWT.NONE);
			label.setBackground(SWTResourceManager.getColor(224, 255, 255));
			label.setBounds(25, 167, 32, 16);
			label.setText("\u6708\uFF1A");
		}
		{
			Label label = new Label(shell, SWT.NONE);
			label.setBackground(SWTResourceManager.getColor(224, 255, 255));
			label.setBounds(25, 214, 72, 16);
			label.setText("\u5B9E\u5230\u5929\u6570\uFF1A");
		}
		{
			actual = new Text(shell, SWT.BORDER);
			actual.setBounds(130, 214, 71, 22);
		}
		{
			Label label = new Label(shell, SWT.NONE);
			label.setBackground(SWTResourceManager.getColor(224, 255, 255));
			label.setBounds(35, 266, 72, 16);
			label.setText("\u5907\u6CE8\uFF1A");
		}
		{
			note = new Text(shell, SWT.BORDER);
			note.setBounds(118, 263, 332, 66);
		}
		{
			Button button = new Button(shell, SWT.NONE);
			button.setImage(new Image(null,"images/add.jpg"));
			button.addSelectionListener(new SelectionAdapter() {
				
				public void widgetSelected(SelectionEvent e) {
					
					String sid = id.getText();
					if (sid.equals("")) {
						JOptionPane.showMessageDialog(null, "必须要输入编号");
					}
					Operate op = new Operate();

					try {
						int iid = Integer.parseInt(sid);
						int iyear = Integer.parseInt(year.getText().trim());
						int imonth = Integer.parseInt(month.getText().trim());
						int iactual = Integer.parseInt(actual.getText().trim());
						String inote = note.getText().trim();
						if(iactual>31)
						{
							JOptionPane.showMessageDialog(null, "一个月有那么多天吗？");
							return;
						}
						Attend att = new Attend(iid, null, iactual, inote, 0);
						int aa = op.insert(att, iyear, imonth);
						if (aa == 3) {
							JOptionPane.showMessageDialog(null, "数据插入成功");
							
						} else if (aa == 2) {
							JOptionPane.showMessageDialog(null,
									"本月出勤表中已经有此员工记录，不可插入重复键");

						} else if (aa == 1) {
							JOptionPane.showMessageDialog(null, "无效的用户编号");
						}
					} catch (NumberFormatException e1) {
						JOptionPane.showMessageDialog(null, "请注意输入数据的格式");
					}
					op.clo();
					
				}
			});
			button.setBounds(307, 80, 132, 84);
			button.setText("New Button");
		}
		
			 year = new Combo(shell, SWT.NONE);
			year.setBounds(118, 114, 92, 24);
			year.setEnabled(true);
			year.setItems(new String[]{"2010","2009"});
			year.select(0);
		
		
			month = new Combo(shell, SWT.NONE);
			month.setBounds(118, 167, 92, 24);
			month.setEnabled(true);
			month.setItems(new String[]{"1","2","3","4","5","6","7","8","9","10","11","12"});
			month.select(0);
			{
				Button button = new Button(shell, SWT.NONE);
				button.addSelectionListener(new SelectionAdapter() {
					
					public void widgetSelected(SelectionEvent e) {
						Attendance ata = new Attendance();
						shell.dispose();
						ata.open();
					}
				});
				button.setBounds(327, 204, 92, 26);
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
