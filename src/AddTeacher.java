import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.GridBagLayout;

import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class AddTeacher extends JPanel
{

	/**
	 * AddTeacher GUI version 1
	 */
	private static final long serialVersionUID = 1L;
	
	private View view;
	
	//main panel
	private JPanel main = new JPanel();
	
	//fields panel
	private JPanel fieldsPanel = new JPanel();
	
	//Teacher first name fields
	private JPanel tFNamePanel = new JPanel();
	private JLabel tFName = new JLabel("First Name: ");
	private JTextField tFNameText = new JTextField(20);
	
	//Teacher last name fields
	private JPanel tLNamePanel = new JPanel();
	private JLabel tLName = new JLabel("Last Name: ");
	private JTextField tLNameText = new JTextField(20);
	
	//Teacher ID fields
	private JPanel tIDPanel = new JPanel();
	private JLabel tID = new JLabel("ID: ");
	private JTextField tIDText = new JTextField(20);
	
	//Teacher username
	private JPanel tUserPanel = new JPanel();
	private JLabel tUser = new JLabel("Username: ");
	private JTextField tUserText = new JTextField(20);
	
	//submit button fields
	private JPanel submitButtonPanel = new JPanel();
	private JButton submitButton;
	
	//error fields
	private JPanel errorPanel = new JPanel();
	private JLabel error = new JLabel("BLARG");
	
	//logout button
	private JPanel logoutPanel = new JPanel();
	private JButton logoutButton = new LogoutButton("Log Out");
	
	public AddTeacher(View v)
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
		fieldsPanel.setLayout(new BoxLayout(fieldsPanel, BoxLayout.Y_AXIS));
		fieldsPanel.add(tFNamePanel);
		tFNamePanel.setLayout(new FlowLayout(FlowLayout.RIGHT));
		fieldsPanel.add(tLNamePanel);
		tLNamePanel.setLayout(new FlowLayout(FlowLayout.RIGHT));
		fieldsPanel.add(tIDPanel);
		tIDPanel.setLayout(new FlowLayout(FlowLayout.RIGHT));
		fieldsPanel.add(tUserPanel);
		tUserPanel.setLayout(new FlowLayout(FlowLayout.RIGHT));
		fieldsPanel.add(submitButtonPanel);
		fieldsPanel.add(errorPanel);
		this.add(logoutPanel, BorderLayout.PAGE_END);
		
		//first name fields
		tFNamePanel.add(tFName);
		tFNamePanel.add(tFNameText);
		
		//last name fields
		tLNamePanel.add(tLName);
		tLNamePanel.add(tLNameText);
		
		//id fields
		tIDPanel.add(tID);
		tIDPanel.add(tIDText);
		
		//username fields
		tUserPanel.add(tUser);
		tUserPanel.add(tUserText);
		
		//submit fields
		submitButton = new TeacherSubmitButton("Submit", view, this);
		submitButtonPanel.add(submitButton);
		
		//error field
		error.setForeground(Color.RED);
		errorPanel.add(error);
		error.setVisible(false);
		
		//logout fields
		logoutPanel.setLayout(new FlowLayout(FlowLayout.LEFT));
		logoutPanel.add(logoutButton);
	}
	
	public String getFName()
	{
		return this.tFNameText.getText();
	}
	
	public String getLName()
	{
		return this.tLNameText.getText();
	}
	
	public String getID()
	{
		return this.tIDText.getText();
	}
	
	public String getUser()
	{
		return this.tUserText.getText();
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
