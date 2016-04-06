import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.GridBagLayout;

import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class CreateClass extends JPanel
{

	/**
	 * Create Student GUI version 1
	 */
	private static final long serialVersionUID = 1L;
	
	private View view;
	
	//main panel
	private JPanel main = new JPanel();
	
	//fields panel
	private JPanel fieldsPanel = new JPanel();
	
	//Class Name
	private JPanel cNamePanel = new JPanel();
	private JLabel cName = new JLabel("Class Name: ");
	private JTextField cNameText = new JTextField(20);
	
	//Class ID fields
	private JPanel cIDPanel = new JPanel();
	private JLabel cID = new JLabel("ID: ");
	private JTextField cIDText = new JTextField(20);
	
	//Class location fields
	private JPanel cLocationPanel = new JPanel();
	private JLabel cLocation = new JLabel("Location: ");
	private JTextField cLocationText = new JTextField(20);
	
	//class days fields
	private JPanel cDaysPanel = new JPanel();
	private JLabel cDays = new JLabel("Meeting Days: ");
	private JTextField cDaysText = new JTextField(20);
	
	//class Teacher fields
	private JPanel cTeacherPanel = new JPanel();
	private JLabel cTeacher = new JLabel("Teacher ID: ");
	private JTextField cTeacherText = new JTextField(20);
	
	//submit button fields
	private JPanel submitButtonPanel = new JPanel();
	private JButton submitButton;
	
	//error fields
	private JPanel errorPanel = new JPanel();
	private JLabel error = new JLabel("BLARG");
	
	//logout button
	private JPanel logoutPanel = new JPanel();
	private JButton logoutButton = new LogoutButton("Log Out");
	
	public CreateClass(View v)
	{
		this.view = v;
		this.setLayout(new BorderLayout());
		setupComponents();
	}
	
	public void setupComponents()
	{
		//add panels
		this.add(main, BorderLayout.CENTER);
		main.setLayout(new GridBagLayout());
		main.add(fieldsPanel);
		fieldsPanel.setLayout(new BoxLayout(fieldsPanel, BoxLayout.PAGE_AXIS));
		fieldsPanel.add(cNamePanel);
		cNamePanel.setLayout(new FlowLayout(FlowLayout.RIGHT));
		fieldsPanel.add(cIDPanel);
		cIDPanel.setLayout(new FlowLayout(FlowLayout.RIGHT));
		fieldsPanel.add(cLocationPanel);
		cLocationPanel.setLayout(new FlowLayout(FlowLayout.RIGHT));
		fieldsPanel.add(cDaysPanel);
		cDaysPanel.setLayout(new FlowLayout(FlowLayout.RIGHT));
		fieldsPanel.add(cTeacherPanel);
		cTeacherPanel.setLayout(new FlowLayout(FlowLayout.RIGHT));
		fieldsPanel.add(submitButtonPanel);
		fieldsPanel.add(errorPanel);
		this.add(logoutPanel, BorderLayout.PAGE_END);
		
		//first name fields
		cNamePanel.add(cName);
		cNamePanel.add(cNameText);
		
		//location fields
		cLocationPanel.add(cLocation);
		cLocationPanel.add(cLocationText);
		
		//id fields
		cIDPanel.add(cID);
		cIDPanel.add(cIDText);
		
		//Days fields
		cDaysPanel.add(cDays);
		cDaysPanel.add(cDaysText);
		
		//Teacher fields
		cTeacherPanel.add(cTeacher);
		cTeacherPanel.add(cTeacherText);
		
		//submit fields
		submitButton = new ClassSubmitButton("Submit", view, this);
		submitButtonPanel.add(submitButton);
		
		//error field
		error.setForeground(Color.RED);
		errorPanel.add(error);
		error.setVisible(false);
		
		//logout fields
		logoutPanel.setLayout(new FlowLayout(FlowLayout.LEFT));
		logoutPanel.add(logoutButton);
	}
	
	public String getCName()
	{
		return this.cNameText.getText();
	}
	
	public String getLocationText()
	{
		return this.cLocationText.getText();
	}
	
	public String getID()
	{
		return this.cIDText.getText();
	}
	
	public String getDays()
	{
		return this.cDaysText.getText();
	}
	
	public String getTeacher()
	{
		return this.cTeacherText.getText();
	}
	
	public void error(String bad)
	{
		error.setText(bad);
		error.setVisible(true);
	}
	
	public void notANum()
	{
		error.setText("ID must be a number.");
		error.setVisible(true);
	}
}
