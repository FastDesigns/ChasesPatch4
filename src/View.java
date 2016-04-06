import java.awt.Dimension;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class View 
{
	private JFrame chases;
	private JFrame mainWindow;
	private JPanel defaultWindow = new Classes(this);
	private JPanel currentWindow, previousWindow;

	
	public View(JFrame main)
	{
		mainWindow = new JFrame("Class Assist");
		chases = main;
		mainWindow.setPreferredSize(new Dimension(1280, 720));
		mainWindow.add(defaultWindow);
		currentWindow = defaultWindow;
		mainWindowCenter();
		mainWindow.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		mainWindow.setVisible(true);
		//chases.setDefaultCloseOperation(0);
		chases.dispose();
		//chases.setVisible(false);
		
	}
	
	public void mainWindowCenter()
	{
		mainWindow.pack();
		mainWindow.setLocationRelativeTo(chases);
	}
	
	public void setDisplay(JPanel newWindow)
	{
		mainWindow.remove(currentWindow);
		mainWindow.add(newWindow);
		previousWindow = currentWindow;
		currentWindow = newWindow;
		mainWindow.pack();
		mainWindow.invalidate();
		mainWindow.validate();
		mainWindow.repaint();
	}
	
	public void refresh()
	{
		mainWindow.pack();
		mainWindow.invalidate();
		mainWindow.validate();
		mainWindow.repaint();
	}
	
	public void getDefaultWindow()
	{
		setDisplay(new Classes(this));
	}
	
	public JPanel getCurrentWindow()
	{
		return this.currentWindow;
	}
	
	public JPanel getPreviousWindow()
	{
		return this.previousWindow;
	}
}