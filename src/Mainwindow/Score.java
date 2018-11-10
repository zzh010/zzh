package Mainwindow;
//download by http://www.codefans.net
import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.swt.widgets.Menu;
import org.eclipse.swt.SWT;
import org.eclipse.swt.widgets.MenuItem;
import org.eclipse.swt.events.SelectionAdapter;
import org.eclipse.swt.events.SelectionEvent;
import org.eclipse.swt.graphics.Image;

import attendance.Attendance;
import function.sf;
import org.eclipse.swt.widgets.Label;
import com.swtdesigner.SWTResourceManager;
import org.eclipse.swt.widgets.Button;
public class Score {

	/**
	 * Launch the application.
	 * @param args
	 */
	public static void main(String[] args) {
		try {
			Score window = new Score();
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
		shell.setBackground(SWTResourceManager.getColor(255, 255, 102));
		shell.setSize(503, 355);
		shell.setText("\u4E1A\u7EE9\u4FE1\u606F\u7BA1\u7406");
		{
			Menu menu = new Menu(shell, SWT.BAR);
			shell.setMenuBar(menu);
			{
				MenuItem menuItem = new MenuItem(menu, SWT.CASCADE);
				menuItem.setText("\u8D44\u6E90\u4FE1\u606F");
				{
					Menu menu_1 = new Menu(menuItem);
					menuItem.setMenu(menu_1);
					{
						MenuItem menuItem_1 = new MenuItem(menu_1, SWT.CASCADE);
						menuItem_1.addSelectionListener(new SelectionAdapter() {
							public void widgetSelected(SelectionEvent e) {
								Attendance att = new Attendance();
								att.open();
							}
						});
						menuItem_1.setText("\u8003\u52E4");
					}
					{
						MenuItem menuItem_1 = new MenuItem(menu_1, SWT.NONE);
						menuItem_1.addSelectionListener(new SelectionAdapter() {
							
							public void widgetSelected(SelectionEvent e) {
								
								sf ss = new sf ();
								ss.open();
							}
						});
						menuItem_1.setText("\u5956\u7F5A");
					}
				}
			}
			{
				MenuItem menuItem = new MenuItem(menu, SWT.CASCADE);
				menuItem.setText("\u9000\u51FA");
				{
					Menu menu_1 = new Menu(menuItem);
					menuItem.setMenu(menu_1);
					{
						MenuItem menuItem_1 = new MenuItem(menu_1, SWT.NONE);
						menuItem_1.addSelectionListener(new SelectionAdapter() {
							
							public void widgetSelected(SelectionEvent e) {
								shell.dispose();
							}
						});
						menuItem_1.setText("\u9000\u51FA\u9875\u9762");
					}
				}
			}
		}
		{
			Label label = new Label(shell, SWT.NONE);
			label.setBounds(0, 0, 245, 290);
			label.setText("New Label");
			label.setImage(new Image(null,"images/6.jpg"));
		}
		{
			Button button = new Button(shell, SWT.NONE);
			button.setImage(new Image(null,"images/back.jpg"));
			button.addSelectionListener(new SelectionAdapter() {
				
				public void widgetSelected(SelectionEvent e) {
					
					Main mm  = new Main();
					shell.close();
					mm.open();
				}
			});
			button.setBounds(301, 135, 115, 104);
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
