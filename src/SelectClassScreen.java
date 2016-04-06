import java.awt.CardLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.GridBagLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.IOException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;
import javax.swing.filechooser.FileNameExtensionFilter;

public class SelectClassScreen extends JPanel {
	// JButtons
	private JButton logoutBtn;
	private JButton enterBtn;
	private JButton importBtn;
	private JButton exportBtn;
	// Swing Tools
	private JLabel selectLabel;
	private JScrollPane classPane;
	private JComboBox classCombo;
	private JList classList;
	private JList students;
	private String[] classes;
	// JFrame
	private JFrame mainFrame;
	// JPanels
	private JPanel topPanel;
	private JPanel middlePanel;
	private JPanel bottomPanel;
	// JFileChooser Tools
	private String user;
	private JFileChooser fc;
	
	public SelectClassScreen(JFrame main, String teacher)
	{
		this.mainFrame = main;
		this.user = teacher;
		makeButtons();
		makeLabel();
		makeClasses();
		makePanels();
		addButtons();
	
		try {
			UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
		} catch (ClassNotFoundException | InstantiationException
				| IllegalAccessException | UnsupportedLookAndFeelException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		fc = new JFileChooser();
		fc.setCurrentDirectory(new File(System.getProperty("user.home")));
	}
	
	/**
	 * 
	 */
	public void makeButtons()
	{
		logoutBtn = new JButton("Logout");
		importBtn = new JButton("Import");
		enterBtn = new JButton("Take Attendance");
		exportBtn = new JButton("Export");
		
		logoutBtn.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e) {
				logoutAction(); // helper function for loginBtn
				}});
		enterBtn.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e) {
				enterAction(); // helper function for enterBtn
				}});
		importBtn.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e) {
				importAction(); // helper function for exportBtn
				}});
		exportBtn.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e) {
				exportAction(); // helper function for exportBtn			
				}});
	}
	
	/**
	 * 
	 */
	public void makeLabel()
	{
		selectLabel = new JLabel("Select Class");
		selectLabel.setForeground(Color.black);
	}
	
	/**
	 * 
	 */
	public void makeClasses()
	{
		classPane = new JScrollPane();
		String[] classes = GetClassListForTeacher.getClassList(new String[] {user});
		classCombo = new JComboBox(classes);
		students = new JList();

	}
	
	/**
	 * 
	 */
	public void makePanels()
	{
		topPanel = new JPanel();
		middlePanel = new JPanel(new GridLayout(1,1));
		bottomPanel = new JPanel();
		
		topPanel.setOpaque(false);
		middlePanel.setOpaque(false);
		bottomPanel.setOpaque(false);
	}
	
	/**
	 * 
	 */
	public void addButtons()
	{
		this.setLayout(new GridLayout(3,1));
		this.setBounds(0,0,1280,720);
		this.setOpaque(false);
		topPanel.add(selectLabel);
		topPanel.add(classCombo);
		middlePanel.add(students);
		bottomPanel.add(logoutBtn);
		bottomPanel.add(enterBtn);
		bottomPanel.add(importBtn);
		bottomPanel.add(exportBtn);
		this.add(topPanel);
		this.add(middlePanel);
		this.add(bottomPanel);
		mainFrame.add(this);
	}
	
	/**
	 * 
	 */
	public void logoutAction()
	{
		this.removeAll();
//		this.paintImmediately(0,0,1280,720); //https://community.oracle.com/thread/1350756?start=0&tstart=0
		StartScreen start = new StartScreen(mainFrame);
	}
	
	/**
	 * 
	 */
	public void enterAction()
	{
		DateFormat dateFormat = new SimpleDateFormat("yyyy/MM/dd");
		Date date = new Date();
		TakeAttendance.recordAttendance(classCombo.getSelectedItem().toString(),dateFormat.format(date));
		String[] Students = GetAttendance.getAttendance(new String[] {classCombo.getSelectedItem().toString(), dateFormat.format(date)}); 
		students.setListData(Students);
		students.repaint();
		middlePanel.repaint();
		
	}
	
	/**
	 * 
	 */
	public void importAction(){
		DateFormat dateFormat = new SimpleDateFormat("yyyy/MM/dd");
		Date date = new Date();
		String classname = (String) classCombo.getSelectedItem();
		JFrame pop = new JFrame();
		
		fc.setAcceptAllFileFilterUsed(false);
		FileNameExtensionFilter filter = new FileNameExtensionFilter("xls", "xls");
		fc.setFileFilter(filter);
		filter = new FileNameExtensionFilter("xlsx", "xlsx");
		fc.setFileFilter(filter);
		
		int result = fc.showOpenDialog(pop);
		
		if ( result == JFileChooser.APPROVE_OPTION) {
			
			File file = fc.getSelectedFile();
			String filename = file.getName();
			ReadFile read = new ReadFile(file, filename, classname);
			read.setInputFile(filename);
			try {
				read.read();}
			catch (IOException e) {
				System.out.println("Learn 2 read good");
				e.printStackTrace();
			}
		}
	}
	
	/**
	 * 
	 */
	private void exportAction()
	{
		String className = (String) classCombo.getSelectedItem();
		JFrame f = new ExportAttendance(className);
	}
}
