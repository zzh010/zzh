package StaffManagement;

import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.SWT;
import org.eclipse.swt.widgets.Label;
import org.eclipse.swt.events.SelectionAdapter;
import org.eclipse.swt.events.SelectionEvent;
import com.swtdesigner.SWTResourceManager;
import org.eclipse.swt.events.MouseAdapter;
import org.eclipse.swt.events.MouseEvent;
import org.eclipse.swt.graphics.Image;

import Mainwindow.Main;
import org.eclipse.swt.widgets.Menu;
import org.eclipse.swt.widgets.MenuItem;
public class MainMenu {

	protected Shell shell;

	/**
	 * Launch the application.
	 * @param args
	 */
	public static void main(String[] args) {
		try {
			MainMenu window = new MainMenu();
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
		shell.setSize(626, 540);
		shell.setText("\u5458\u5DE5\u7BA1\u7406");
		{
			Button button = new Button(shell, SWT.NONE);
			button.setImage(new Image(null,"images/return.jpg"));
			button.addSelectionListener(new SelectionAdapter() {
				
				public void widgetSelected(SelectionEvent e) {
					Main mmm = new Main();
					shell.dispose();
					mmm.open();
					
				}
			});
			button.setBounds(435, 333, 139, 114);
			button.setText("\u8FD4\u56DE");
		}
		{
			Label label = new Label(shell, SWT.NONE);
			label.setImage(SWTResourceManager.getImage("images/dfd.jpg"));
			label.setBounds(0, 0, 618, 498);
		}
		{
			Menu menu = new Menu(shell, SWT.BAR);
			shell.setMenuBar(menu);
			{
				MenuItem menuItem = new MenuItem(menu, SWT.CASCADE);
				menuItem.setText("\u5458\u5DE5\u4FE1\u606F");
				{
					Menu menu_1 = new Menu(menuItem);
					menuItem.setMenu(menu_1);
					{
						MenuItem menuItem_1 = new MenuItem(menu_1, SWT.NONE);
						menuItem_1.addSelectionListener(new SelectionAdapter() {
							
							public void widgetSelected(SelectionEvent e) {
								worker1 ww = new worker1();
								shell.dispose();
								ww.open();
								
							}
						});
						menuItem_1.setText("\u67E5\u770B\u5220\u9664");
					}
					{
						MenuItem menuItem_1 = new MenuItem(menu_1, SWT.NONE);
						menuItem_1.addSelectionListener(new SelectionAdapter() {
							
							public void widgetSelected(SelectionEvent e) {
								
								worker w = new worker();
								shell.dispose();
								w.open();
							}
							
						});
						menuItem_1.setText("\u4FEE\u6539\u6DFB\u52A0");
					}
				}
			}
			{
				MenuItem menuItem = new MenuItem(menu, SWT.CASCADE);
				menuItem.setText("\u90E8\u95E8\u7BA1\u7406");
				{
					Menu menu_1 = new Menu(menuItem);
					menuItem.setMenu(menu_1);
					{
						MenuItem menuItem_1 = new MenuItem(menu_1, SWT.NONE);
						menuItem_1.addSelectionListener(new SelectionAdapter() {
							
							public void widgetSelected(SelectionEvent e) {
								
								DepartmentSetup ds = new DepartmentSetup();
								ds.open();
								
							}
						});
						menuItem_1.setText("\u90E8\u95E8\u8BBE\u7F6E");
					}
				}
			}
			{
				MenuItem menuItem = new MenuItem(menu, SWT.CASCADE);
				menuItem.setText("\u5C97\u4F4D\u7BA1\u7406");
				{
					Menu menu_1 = new Menu(menuItem);
					menuItem.setMenu(menu_1);
					{
						MenuItem menuItem_1 = new MenuItem(menu_1, SWT.NONE);
						menuItem_1.addSelectionListener(new SelectionAdapter() {
							
							public void widgetSelected(SelectionEvent e) {
								job j = new job();
								shell.dispose();
								j.open();
							}
							
						});
						menuItem_1.setText("\u5C97\u4F4D\u8C03\u6574");
					}
				}
			}
		}

	}
}
