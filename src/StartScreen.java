import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Image;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.IOException;
import javax.imageio.ImageIO;
import javax.swing.*;

public class StartScreen extends JPanel 
{
	// Buttons
	private JButton loginBtn;
	private JButton clearBtn;
	// TextFields
	private JTextField userField;
	private JPasswordField passField;
	// Labels
	private JLabel userLabel;
	private JLabel passLabel;
	private JLabel bufferLabel; // puts a space between login & clear buttons
	// Panel
	private JPanel loginPanel;
	// Frame
	private JFrame mainFrame; // Add/remove all panels from this window
	
	
	
	public StartScreen(JFrame main)
	{
		this.mainFrame= main;
		setWindow();
		makeButtons();
		makeFields();
		makeLabels();
		guiBuilder();

	}
	
	
	public void setWindow()
	{
		mainFrame.setTitle("Class Assist");	
		mainFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		//mainFrame.setBounds(100, 100, 800,600);
		//mainFrame.setLocationRelativeTo(null);
		
		// Adds background image to frame
		try {
			ImageIcon image = new ImageIcon(((new ImageIcon("src/res/coolblue.jpg").getImage().getScaledInstance(1920, 1080,java.awt.Image.SCALE_SMOOTH))));
			//http://stackoverflow.com/questions/13810213/java-stretch-icon-to-fit-button
			mainFrame.setContentPane(new JLabel(image));
		} 
		catch (Exception e){
			e.printStackTrace();
		}
	}
	
	public void makeButtons()
	{
		loginBtn = new JButton("Login");
		clearBtn = new JButton("Clear");
		
		// Set Button size
		loginBtn.setPreferredSize(new Dimension(110, 26));
		clearBtn.setPreferredSize(new Dimension(110, 26));
		
		// Add action listeners to each button
		loginBtn.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e) {
				loginAction(); // helper function for loginBtn
				}});
		clearBtn.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e) {
				clearAction(); // helper function for clearBtn
				}});
		
	}
	
	
	public void makeFields()
	{
		userField = new JTextField();
		passField = new JPasswordField();
		// Set TextField width
		userField.setColumns(15);
		passField.setColumns(15);
		
		// Code to add key listener to "Enter Key"
		//http://stackoverflow.com/questions/4419667/detect-enter-press-in-jtextfield
		Action submit = new AbstractAction(){
			@Override
			public void actionPerformed(ActionEvent e){
				loginAction();}
		};
		userField.addActionListener(submit);
		passField.addActionListener(submit);
	}
	
	public void makeLabels()
	{
		userLabel = new JLabel("Username: ");
		passLabel = new JLabel("Password: ");
		bufferLabel = new JLabel("   ");
		// Set Label Font color
		userLabel.setForeground(Color.white);
		passLabel.setForeground(Color.white);
	}
	
	public void guiBuilder()
	{
		
		//loginPanel.setLocation(dim.width/2-mainFrame.getSize().width/2, dim.height/2-mainFrame.getSize().height/2);
		// Add everything together
		loginPanel = new JPanel();
		loginPanel.setLayout(new FlowLayout());
		loginPanel.add(userLabel);
		loginPanel.add(userField);
		loginPanel.add(passLabel);
		loginPanel.add(passField);
		loginPanel.add(loginBtn);
		loginPanel.add(bufferLabel);
		loginPanel.add(clearBtn);
	
			
		mainFrame.add(loginPanel);
		loginPanel.setOpaque(false);
		frameSetting();
		//http://stackoverflow.com/questions/2442599/how-to-set-jframe-to-appear-centered-regardless-of-monitor-resolution
		loginPanel.setBounds((mainFrame.getSize().width/2)-150,
				(mainFrame.getSize().height/2)-75, 300, 300);
	}
	
	
	public void loginAction()
	{
		String userName = userField.getText();
		char[] passWord = passField.getPassword();
		String passString = "";
		for (int i = 0; i < passWord.length;i++) // Alex's code was length-1???
			passString=passString+passWord[i];
		// check input
		if (DesktopSignInActivity.logIn(new String[] {userName,passString}))
		{
			if (userName.equals("admin"))
				loadAdmin();
			
			else
			// needs to do teacher version here
				loadTeacher(userName);
		}
		else
		{
			userField.setForeground(Color.red);
			userField.setText("Invalid Credentials");
		}
	}
	
	public void clearAction()
	{
		userField.setText("");
		userField.setForeground(Color.BLACK);
		passField.setText("");
		userField.requestFocusInWindow();
	}
	
	public void frameSetting()
	{
		mainFrame.pack();
		mainFrame.setSize(1280,720);
		mainFrame.setVisible(true);
	}
	
	public void loadAdmin()
	{
		//AdminScreen admin = new AdminScreen(mainFrame);
		
		mainFrame.getContentPane().removeAll();
		//mainFrame.setVisible(false);
		this.paintImmediately(0,0,1280,720);
		View v = new View(mainFrame);
		
		//mainFrame.add(v);
		//mainFrame.add(admin); // Displays Admin view of application
		
		
		//frameSetting();
	}
	
	public void loadTeacher(String userName)
	{
		SelectClassScreen classes = new SelectClassScreen(mainFrame, userName);
		mainFrame.setContentPane(new JLabel());// remove background image
		mainFrame.getContentPane().removeAll();
		
		this.paintImmediately(0,0,1280,720);
		mainFrame.add(classes); // Displays teacher view of classes
		frameSetting();
	}
	

}
