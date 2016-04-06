import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;

public class TeacherSubmitButton extends JButton implements ActionListener
{
	/**
	 * TeacherSubmit Button version 1
	 */
	private static final long serialVersionUID = 1L;
	
	private View view;
	private AddTeacher add;
	private String fname, lname, id, username;
	
	public TeacherSubmitButton(String text, View v, AddTeacher at)
	{
		super(text);
		this.view = v;
		this.add = at;
		this.addActionListener(this);
	}
	
	private void getInfo()
	{
		fname = add.getFName();
		lname = add.getLName();
		id = add.getID();
		username = add.getUser();
	}

	@Override
	public void actionPerformed(ActionEvent e)
	{
		getInfo();
		try
		{
			int idCheck = Integer.parseInt(id);
			new AddTeacherThread(fname, lname, id, username, this);
		}
		catch (NumberFormatException ex)
		{
			add.notANum();
			view.refresh();
		}
	}
	
	public void error(String news)
	{
		add.error(news);
	}
	
	public void home()
	{
		view.getDefaultWindow();
	}
}