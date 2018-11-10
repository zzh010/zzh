package salary;
//download by http://www.codefans.net
import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.Shell;
import com.swtdesigner.SWTResourceManager;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.SWT;
import org.eclipse.swt.events.SelectionAdapter;
import org.eclipse.swt.events.SelectionEvent;
import org.eclipse.swt.graphics.Image;
import org.eclipse.swt.widgets.Label;
import org.eclipse.swt.events.MouseAdapter;
import org.eclipse.swt.events.MouseEvent;
import Mainwindow.Main;

public class WageManange {

	protected Shell shell;

	/**
	 * Launch the application.
	 * 
	 * @param args
	 */
	public static void main(String[] args) {
		try {
			WageManange window = new WageManange();
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
		shell.setBackground(SWTResourceManager.getColor(255, 255, 153));
		shell.setSize(632, 385);
		shell.setText("\u804C\u5DE5\u5DE5\u8D44\u7BA1\u7406\u7CFB\u7EDF");
		{
			Button button = new Button(shell, SWT.NONE);
			button.setFont(SWTResourceManager.getFont("华文细黑", 12, SWT.BOLD));
			button.addSelectionListener(new SelectionAdapter() {
				@Override
				public void widgetSelected(SelectionEvent e) {
					WageUpdate ep = new WageUpdate();
					shell.dispose();
					ep.open();
				}
			});
			button.setBounds(480, 107, 92, 26);
			button.setText(" \u5DE5\u8D44\u8C03\u6574 ");
		}
		{
			Label label = new Label(shell, SWT.NONE);
			label.setBounds(0, 0, 281, 341);
			label.setText("New Label");
			label.setImage(new Image(null, "images/4.jpg"));
		}
		{
			Button button = new Button(shell, SWT.NONE);
			button.setFont(SWTResourceManager.getFont("华文细黑", 12, SWT.BOLD));
			button.addSelectionListener(new SelectionAdapter() {
				public void widgetSelected(SelectionEvent e) {
					WageCheck ep = new WageCheck();
					shell.dispose();
					ep.open();
				}
			});
			button.setBounds(351, 48, 92, 26);
			button.setText(" \u5DE5\u8D44\u7F16\u8F91 ");
		}
		{
			Button button = new Button(shell, SWT.NONE);
			button.setFont(SWTResourceManager.getFont("华文细黑", 12, SWT.BOLD));
			button.addSelectionListener(new SelectionAdapter() {
				public void widgetSelected(SelectionEvent e) {
					stayup t = new stayup();
					shell.dispose();
					t.open();

				}
			});

			button.setBounds(351, 181, 92, 26);
			button.setText("\u52A0\u73ED\u7BA1\u7406");
		}
		{
			Button button = new Button(shell, SWT.NONE);
			button.setFont(SWTResourceManager.getFont("华文细黑", 12, SWT.BOLD));
			button.addSelectionListener(new SelectionAdapter() {
				public void widgetSelected(SelectionEvent e) {
					shell.dispose();
				}
			});
			button.setBounds(500, 259, 92, 26);
			button.setText("\u9000\u51FA");
		}
		{
			Button button = new Button(shell, SWT.NONE);
			button.addSelectionListener(new SelectionAdapter() {

				public void widgetSelected(SelectionEvent e) {
					Main mm = new Main();
					shell.dispose();
					mm.open();
				}
			});
			button.setFont(SWTResourceManager.getFont("华文细黑", 12, SWT.BOLD));
			button.setBounds(351, 270, 92, 26);
			button.setText("\u8FD4\u56DE");
		}

	}
}
