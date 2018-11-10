package attendance;

import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.MessageBox;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.swt.widgets.Menu;
import org.eclipse.swt.SWT;
import org.eclipse.swt.widgets.MenuItem;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.events.SelectionAdapter;
import org.eclipse.swt.events.SelectionEvent;
import org.eclipse.swt.graphics.Image;
import org.eclipse.swt.widgets.Label;
import com.swtdesigner.SWTResourceManager;


public class Attendance {

	/**
	 * Launch the application.
	 * @param args
	 */
	public static void main(String[] args) {
		try {
			Attendance window = new Attendance();
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
		shell.setSize(515, 409);
		shell.setText("\u8003\u52E4\u4FE1\u606F\u7BA1\u7406");
		{
			Label label = new Label(shell, SWT.NONE);
			label.setBounds(110, 119, 222, 246);
			label.setText("New Label");
			label.setImage(new Image(null,"images/laodong.jpg"));
		{
			Label label1 = new Label(shell, SWT.NONE);
			label1.setBounds(338, 10, 150, 179);
			label1.setText("New Label");
			label1.setImage(new Image(null,"images/labor.jpg"));
		}
		{
			Button button = new Button(shell, SWT.NONE);
			button.addSelectionListener(new SelectionAdapter() {
				public void widgetSelected(SelectionEvent e) {
					
					NewDis ne = new NewDis();
					shell.dispose();
					ne.open();
					
					
				}
			});
			button.setFont(SWTResourceManager.getFont("仿宋_GB2312", 12, SWT.BOLD));
			button.setBounds(61, 27, 92, 26);
			button.setText("\u67E5\u770B\u8003\u52E4");
		}
		{
			Button button = new Button(shell, SWT.NONE);
			button.addSelectionListener(new SelectionAdapter() {
				public void widgetSelected(SelectionEvent e) {
					Add ad = new Add();
					shell.dispose();
					ad.open();
				}
			});
			button.setForeground(SWTResourceManager.getColor(SWT.COLOR_YELLOW));
			button.setFont(SWTResourceManager.getFont("华文仿宋", 12, SWT.BOLD));
			button.setBounds(61, 87, 92, 26);
			button.setText("\u6DFB\u52A0\u8BB0\u5F55");
		}
		{
			Button button = new Button(shell, SWT.NONE);
			button.addSelectionListener(new SelectionAdapter() {
			
				public void widgetSelected(SelectionEvent e) {
					update up = new update();
					up.open();
				}
			});
			button.setFont(SWTResourceManager.getFont("华文仿宋", 12, SWT.BOLD));
			button.setBounds(375, 251, 92, 26);
			button.setText("\u4FEE\u6539\u8BB0\u5F55");
		}
		{
			Button button = new Button(shell, SWT.NONE);
			button.addSelectionListener(new SelectionAdapter() {
				public void widgetSelected(SelectionEvent e) {
					Delete de = new Delete();
					shell.dispose();
					de.open();
				}
			});
			button.setFont(SWTResourceManager.getFont("华文仿宋", 12, SWT.BOLD));
			button.setBounds(375, 311, 92, 26);
			button.setText("\u5220\u9664\u8BB0\u5F55");
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
}



