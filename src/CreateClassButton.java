import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;

public class CreateClassButton extends JButton implements ActionListener
{

	/**
	 * Create CLass button
	 */
	private static final long serialVersionUID = 1L;
	
	private View view;
	public CreateClassButton(String text, View v)
	{
		super(text);
		this.view = v;
		this.addActionListener(this);
	}

	@Override
	public void actionPerformed(ActionEvent e)
	{
		view.setDisplay(new CreateClass(view));
	}
}