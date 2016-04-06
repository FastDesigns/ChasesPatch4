import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.SwingUtilities;

public class LogoutButton extends JButton implements ActionListener
{

	/**
	 * HomeButton Version 1
	 */
	private static final long serialVersionUID = 1L;
	//private JFrame main;
	
	public LogoutButton(String text)
	{
		super(text);
		this.addActionListener(this);
		//this.main = chases;
	}

	@Override
	public void actionPerformed(ActionEvent e)
	{
		JFrame frame = (JFrame) SwingUtilities.getWindowAncestor(this);
		frame.getContentPane().removeAll();
		frame.dispose();
		@SuppressWarnings("unused")
		//desktopGUI frames = desktopGUI.getFrame();
		//frames.setVisible(true);
		StartScreen ss = new StartScreen(frame);
	}
}