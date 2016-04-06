import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.JComboBox;

public class TList extends JComboBox implements ActionListener
{
	private Classes classes;
	
	public TList(String[] l, Classes c)
	{
		super(l);
		this.classes = c;
		this.addActionListener(this);
	}
	
	@Override
	public void actionPerformed(ActionEvent e)
	{
		String[] load = {"Loading..."};
		setList(load);
		JComboBox cb = (JComboBox)e.getSource();
		String name = (String)cb.getSelectedItem();
		String base = "Select Teacher";
		if(name != base)
		{
			String[] names = name.split(" ");
			new GetTeachersClasses(this, names);
		}
		else
		{
			String[] list = {"Select a Teacher"};
			setList(list);
		}
	}
	
	public void setList(String[] l)
	{
		classes.setClasses(l);
	}
}