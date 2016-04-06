import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;

public class AddTeacherButton extends JButton implements ActionListener
{

	/**
	 * AddTeacher button
	 */
	private static final long serialVersionUID = 1L;
	
	private View view;
	public AddTeacherButton(String text, View v)
	{
		super(text);
		this.view = v;
		this.addActionListener(this);
	}

	@Override
	public void actionPerformed(ActionEvent e)
	{
		view.setDisplay(new AddTeacher(view));
	}
}