import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;

public class StudentSubmitButton extends JButton implements ActionListener
{
	/**
	 * StudentSubmit Button version 1
	 */
	private static final long serialVersionUID = 1L;
	
	private View view;
	private CreateStudent create;
	private String fname, lname, id, user;
	
	public StudentSubmitButton(String text, View v, CreateStudent cs)
	{
		super(text);
		this.view = v;
		this.create = cs;
		this.addActionListener(this);
	}
	
	private void getInfo()
	{
		fname = create.getFName();
		lname = create.getLName();
		id = create.getID();
		user = create.getUser();
	}

	@Override
	public void actionPerformed(ActionEvent e)
	{
		getInfo();
		try
		{
			int idCheck = Integer.parseInt(id);
			new CreateStudentThread(fname, lname, id, user, this);
		}
		catch (NumberFormatException ex)
		{
			create.notANum();
			view.refresh();
		}
	}
	
	public void error(String news)
	{
		create.error(news);
	}
	
	public void home()
	{
		view.getDefaultWindow();
	}
}