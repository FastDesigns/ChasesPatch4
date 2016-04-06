import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;

public class ClassSubmitButton extends JButton implements ActionListener
{
	/**
	 * Class Submit Button version 1
	 */
	private static final long serialVersionUID = 1L;
	
	private View view;
	private CreateClass create;
	private String name, location, id, days, teacher;
	
	public ClassSubmitButton(String text, View v, CreateClass cc)
	{
		super(text);
		this.view = v;
		this.create = cc;
		this.addActionListener(this);
	}
	
	private void getInfo()
	{
		name = create.getCName();
		location = create.getLocationText();
		id = create.getID();
		days = create.getDays();
		teacher = create.getTeacher();
	}

	@Override
	public void actionPerformed(ActionEvent e)
	{
		getInfo();
		try
		{
			int idCheck = Integer.parseInt(id);
			new CreateClassThread(name, id, location, days, teacher, this);
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