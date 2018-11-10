package Mainwindow;
//download by http://www.codefans.net
import org.eclipse.swt.graphics.Image;
import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.swt.widgets.Label;
import org.eclipse.swt.SWT;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.widgets.Menu;
import org.eclipse.swt.widgets.MenuItem;
import com.swtdesigner.SWTResourceManager;
import org.eclipse.swt.events.SelectionAdapter;
import org.eclipse.swt.events.SelectionEvent;
import salary.*;
import StaffManagement.MainMenu;
public class Main {

	/**
	 * Launch the application.
	 * @param args
	 */
	public static void main(String[] args) {
		try {
			Main window = new Main();
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
		shell.setBackground(SWTResourceManager.getColor(255, 255, 204));
		shell.setSize(712, 519);
		shell.setText("\u4F01\u4E1A\u4EBA\u4E8B\u7BA1\u7406\u7CFB\u7EDF\u4E3B\u754C\u9762 ");
		{
			Label label = new Label(shell, SWT.NONE);
			label.setBounds(0, 0, 704, 268);
			label.setText("New Label");
			label.setImage(new Image(null, "images/2008101722346167.jpg"));
		}
		{
			Button button = new Button(shell, SWT.NONE);
			button.addSelectionListener(new SelectionAdapter() {
				
				public void widgetSelected(SelectionEvent e) {
					MainMenu maa = new MainMenu();
					shell.dispose();
					maa.open();
					
				}
			});
			button.setFont(SWTResourceManager.getFont("仿宋_GB2312", 12, SWT.BOLD));
			button.setForeground(SWTResourceManager.getColor(SWT.COLOR_WHITE));
			button.setBounds(78, 370, 100, 26);
			button.setText("\u5458\u5DE5\u7BA1\u7406");
		}
		{
			Button button = new Button(shell, SWT.NONE);
			button.addSelectionListener(new SelectionAdapter() {
				
				public void widgetSelected(SelectionEvent e) {
					WageManange ww = new WageManange();
					shell.dispose();
					ww.open();
					
				}
			});
			button.setFont(SWTResourceManager.getFont("华文仿宋", 12, SWT.BOLD));
			button.setBounds(307, 371, 92, 26);
			button.setText("\u5DE5\u8D44\u7BA1\u7406");
		}
		{
			Button button = new Button(shell, SWT.NONE);
			button.addSelectionListener(new SelectionAdapter() {
				
				public void widgetSelected(SelectionEvent e) {
					Score ss = new Score();
					shell.dispose();
					ss.open();
					
				}
			});
			button.setFont(SWTResourceManager.getFont("华文仿宋", 12, SWT.BOLD));
			button.setBounds(509, 371, 92, 26);
			button.setText("\u4E1A\u7EE9\u7BA1\u7406");
		}
		{
			Label label = new Label(shell, SWT.NONE);
			label.setBounds(78, 306, 100, 91);
			label.setText("New Label");
			label.setImage(new Image(null, "images/200923162814741.gif"));
		}
		{
			Label label = new Label(shell, SWT.NONE);
			label.setBounds(307, 303, 92, 93);
			label.setText("New Label");
			label.setImage(new Image(null,"images/a977589437dee02e7af4805b.gif"));
		}
		{
			Label label = new Label(shell, SWT.NONE);
			label.setBounds(509, 304, 92, 93);
			label.setText("New Label");
			label.setImage(new Image(null,"images/231343522135.jpg"));
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
