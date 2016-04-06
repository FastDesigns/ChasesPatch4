import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.GridBagLayout;

import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class CreateStudent extends JPanel
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
	
	//Student first name fields
	private JPanel sFNamePanel = new JPanel();
	private JLabel sFName = new JLabel("First Name: ");
	private JTextField sFNameText = new JTextField(20);
	
	//Student last name fields
	private JPanel sLNamePanel = new JPanel();
	private JLabel sLName = new JLabel("Last Name: ");
	private JTextField sLNameText = new JTextField(20);
	
	//Student ID fields
	private JPanel sIDPanel = new JPanel();
	private JLabel sID = new JLabel("ID: ");
	private JTextField sIDText = new JTextField(20);
	
	//Student username fields
	private JPanel sUserPanel = new JPanel();
	private JLabel sUser = new JLabel("Username: ");
	private JTextField sUserText = new JTextField(20);
	
	//submit button fields
	private JPanel submitButtonPanel = new JPanel();
	private JButton submitButton;
	
	//error fields
	private JPanel errorPanel = new JPanel();
	private JLabel error = new JLabel("BLARG");
	
	//logout button
	private JPanel logoutPanel = new JPanel();
	private JButton logoutButton = new LogoutButton("Log Out");
	
	public CreateStudent(View v)
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
		fieldsPanel.setLayout(new BoxLayout(fieldsPanel, BoxLayout.Y_AXIS));
		main.add(fieldsPanel);
		fieldsPanel.add(sFNamePanel);
		sFNamePanel.setLayout(new FlowLayout(FlowLayout.RIGHT));
		fieldsPanel.add(sLNamePanel);
		sLNamePanel.setLayout(new FlowLayout(FlowLayout.RIGHT));
		fieldsPanel.add(sIDPanel);
		sIDPanel.setLayout(new FlowLayout(FlowLayout.RIGHT));
		fieldsPanel.add(sUserPanel);
		sUserPanel.setLayout(new FlowLayout(FlowLayout.RIGHT));
		fieldsPanel.add(submitButtonPanel);
		fieldsPanel.add(errorPanel);
		this.add(logoutPanel, BorderLayout.PAGE_END);
		
		//first name fields
		sFNamePanel.add(sFName);
		sFNamePanel.add(sFNameText);
		
		//last name fields
		sLNamePanel.add(sLName);
		sLNamePanel.add(sLNameText);
		
		//id fields
		sIDPanel.add(sID);
		sIDPanel.add(sIDText);
		
		//username fields
		sUserPanel.add(sUser);
		sUserPanel.add(sUserText);
		
		//submit fields
		submitButton = new StudentSubmitButton("Submit", view, this);
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
		return this.sFNameText.getText();
	}
	
	public String getLName()
	{
		return this.sLNameText.getText();
	}
	
	public String getID()
	{
		return this.sIDText.getText();
	}
	
	public String getUser()
	{
		return this.sUserText.getText();
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
