/**
 * This is an older version of the GUI that does not match the current iteration of code.
 * We are well aware that this class displays as an error. Currently, (3-2-2016) this class 
 * is not called upon and will not cause any runtime errors. -Chase Abe
 */

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JTextField;
import javax.swing.JPasswordField;
import javax.swing.JLabel;
import javax.swing.JButton;
import java.awt.CardLayout;
import javax.swing.JTabbedPane;
import javax.swing.JTextArea;
import javax.swing.JComboBox;
import javax.swing.JList;
import javax.swing.UIManager;
import java.awt.SystemColor;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Scanner;

import javax.swing.SwingConstants;

@SuppressWarnings("serial")
public class desktopGUI extends JFrame {

	private static JPanel contentPane;
	public static desktopGUI frame;
	private JPasswordField passwordField;
	private JTextField usernameField;
	private JTextField logInTitle;
	private JLabel passwordLabel;

	private JPanel teacherMenuPanel;
	private JTextField textField;
	private JTextField textField_1;
	private JTextField textField_2;
	private JTextField textField_3;
	private JTextField textField_4;
	private JTextField adminStudentClassSearch;

	public desktopGUI(){
	
		setTitle("Quick Class");	
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 960, 960);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(new CardLayout(0, 0));
		CardLayout c1 = (CardLayout)contentPane.getLayout();
		JPanel logInPanel = new JPanel();
		contentPane.add(logInPanel, "Log In Pane");
		passwordField = new JPasswordField();
		passwordField.setBounds(304, 387, 342, 26);

		usernameField = new JTextField();
		usernameField.setBounds(304, 352, 342, 26);
		usernameField.setColumns(10);

		logInTitle = new JTextField();
		logInTitle.setBounds(343, 44, 242, 37);
		logInTitle.setHorizontalAlignment(JTextField.CENTER);
		logInTitle.setText("Quick Class");
		logInTitle.setEditable(false);
		
			JLabel logInUsername = new JLabel("Username: ");
			logInUsername.setBounds(180, 355, 82, 20);

			passwordLabel = new JLabel("Password: ");
			passwordLabel.setBounds(180, 390, 78, 20);

			teacherMenuPanel = new JPanel();
			contentPane.add(teacherMenuPanel, "Teacher Menu Pane");
			teacherMenuPanel.setLayout(null);

			JTabbedPane tabbedPane = new JTabbedPane(JTabbedPane.TOP);
			tabbedPane.setBounds(10, 101, 914, 799);
			teacherMenuPanel.add(tabbedPane);

			JPanel quizPanel = new JPanel();
			tabbedPane.addTab("Quizes    ", null, quizPanel,null);
			quizPanel.setLayout(null);

				JButton teacherNewQuizButton = new JButton("New Quiz");
				teacherNewQuizButton.setBounds(10, 634, 110, 23);
				quizPanel.add(teacherNewQuizButton);

				JButton teacherRemoveQuizButton = new JButton("Remove Quiz");
				teacherRemoveQuizButton.setBounds(250, 634, 110, 23);
				quizPanel.add(teacherRemoveQuizButton);

				JButton teacherEditQuizButton = new JButton("Edit");
				teacherEditQuizButton.setBounds(155, 634, 60, 23);
				quizPanel.add(teacherEditQuizButton);

				JButton teachShowQuizResultsButton = new JButton("Show Results");
				teachShowQuizResultsButton.setBounds(110, 691, 150, 23);
				quizPanel.add(teachShowQuizResultsButton);
		
			JList list_1 = new JList();
			list_1.setBounds(425, 10, 400, 295);
			quizPanel.add(list_1);

			JList list_3 = new JList();
			list_3.setBounds(425, 315, 400, 295);
			quizPanel.add(list_3);

			JList list = new JList();
			list.setBounds(10, 10, 350, 600);
			quizPanel.add(list);

			JButton quizAddQuestionButton = new JButton("+ Question");
			quizAddQuestionButton.setBounds(425, 634, 110, 23);
			quizPanel.add(quizAddQuestionButton);

			JButton quizDeleteQuestion = new JButton("- Question");
			quizDeleteQuestion.setBounds(715, 634, 110, 23);
			quizPanel.add(quizDeleteQuestion);

			JButton quizEditQuestion = new JButton("Edit Question");
			quizEditQuestion.setBounds(570, 634, 110, 23);
			quizPanel.add(quizEditQuestion);
			teacherMenuPanel.add(tabbedPane);

			JPanel classPanel = new JPanel();
			tabbedPane.addTab("Attendance", null, classPanel,null);
			classPanel.setLayout(null);

			JTextArea textArea_3 = new JTextArea();
			textArea_3.setBounds(10, 46, 200, 714);
			classPanel.add(textArea_3);

			JLabel exportAttendanceLabel = new JLabel("Export Attendance");
			exportAttendanceLabel.setBounds(400, 60, 120, 14);
			classPanel.add(exportAttendanceLabel);

			JLabel importAttendanceLabel = new JLabel("Import Attendance");
			importAttendanceLabel.setBounds(400, 250, 120, 14);
			classPanel.add(importAttendanceLabel);

			textField = new JTextField();
			textField.setBounds(10, 11, 86, 20);
			classPanel.add(textField);
			textField.setColumns(10);

			textField_1 = new JTextField();
			textField_1.setBounds(336, 90, 86, 20);
			classPanel.add(textField_1);
			textField_1.setColumns(10);

			textField_2 = new JTextField();
			textField_2.setBounds(469, 90, 86, 20);
			classPanel.add(textField_2);
			textField_2.setColumns(10);

			textField_3 = new JTextField();
			textField_3.setBounds(336, 280, 86, 20);
			classPanel.add(textField_3);
			textField_3.setColumns(10);

			textField_4 = new JTextField();
			textField_4.setBounds(469, 280, 86, 20);
			classPanel.add(textField_4);
			textField_4.setColumns(10);

			JButton SaveAsButton = new JButton("Save As...");
			SaveAsButton.setBounds(605, 90, 120, 23);
			classPanel.add(SaveAsButton);

			JButton btnNewButton_5 = new JButton("Select File...");
			btnNewButton_5.setBounds(605, 280, 120, 23);
			classPanel.add(btnNewButton_5);

			JButton btnNewButton_6 = new JButton("Begin Attendance");
			btnNewButton_6.setBounds(336, 620, 130, 23);
			classPanel.add(btnNewButton_6);

			JButton btnNewButton_7 = new JButton("Stop Attendance");
			btnNewButton_7.setBounds(595, 620, 130, 23);
			classPanel.add(btnNewButton_7);

			JTextArea currentClass = new JTextArea("Current class: \n ITEC 471");
			currentClass.setBackground(UIManager.getColor("Panel.background"));
			currentClass.setBounds(10, 10, 90, 80);
			currentClass.setEditable(false);
			teacherMenuPanel.add(currentClass);

			JButton teacherBackToClassList = new JButton("Back to class list");
			teacherBackToClassList.setBounds(110,35, 140, 30);
			teacherMenuPanel.add(teacherBackToClassList);

			JButton teacherHelpButton = new JButton("Help");
			teacherHelpButton.setBounds(844, 11, 80, 30);
			teacherMenuPanel.add(teacherHelpButton);

			JButton teacherLogOutButton = new JButton("Log Out");
			teacherLogOutButton.setBounds(844, 60, 80, 30);
			teacherLogOutButton.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent arg0) {
					c1.show(contentPane,"Log In Pane");
				}	
			});
			teacherMenuPanel.add(teacherLogOutButton);
			setVisible(true);

			JButton logInSubmitButton = new JButton("Log in");
			logInSubmitButton.setBounds(304, 568, 77, 29);
			logInSubmitButton.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent arg0) {
					String passString = "";
					char[] passArray = passwordField.getPassword();
					for(int x=0;x<=passArray.length-1;x++){
						passString=passString+passArray[x];
					}	
					if(DesktopSignInActivity.logIn(new String[] {usernameField.getText(),passString})){
						if(usernameField.getText().equals("admin"))
						{
							View view = new View();
							frame.setVisible(false);
							//c1.show(contentPane,"Admin Menu Pane"); 
						}
						else c1.show(contentPane,"Teacher Class List Pane");
						usernameField.setText("");
						passwordField.setText("");
					}
					else{ 
						usernameField.setText("Invalid Credentials");
						passwordField.setText("");
					}
				}	
			});
			logInPanel.add(logInSubmitButton);

			JButton logInClearButton = new JButton("Clear");

			logInClearButton.setBounds(577, 568, 69, 29);
			logInPanel.setLayout(null);
			logInPanel.add(logInTitle);
			logInPanel.add(passwordLabel);
			logInPanel.add(logInUsername);

			logInPanel.add(logInClearButton);
			logInPanel.add(usernameField);
			logInPanel.add(passwordField);

			JPanel teacherSelectClassPanel = new JPanel();
			contentPane.add(teacherSelectClassPanel, "Teacher Class List Pane");
			teacherSelectClassPanel.setLayout(null);

			JLabel teacherClassListSelectClassLabel = new JLabel("Select class");
			teacherClassListSelectClassLabel.setBounds(10, 11, 100, 40);
			teacherSelectClassPanel.add(teacherClassListSelectClassLabel);

			JButton teacherSignOutButton = new JButton("Sign out");
			teacherSignOutButton.setBounds(323, 800, 89, 23);
			teacherSelectClassPanel.add(teacherSignOutButton);

			JButton enterButton = new JButton("Enter");
			enterButton.setBounds(422, 800, 89, 23);
			enterButton.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent arg0) {
					c1.show(contentPane, "Teacher Menu Pane");
				}});
			teacherSelectClassPanel.add(enterButton);

			JButton teacherClassListExportButton = new JButton("Export");
			teacherClassListExportButton.setBounds(521, 800, 89, 23);
			teacherSelectClassPanel.add(teacherClassListExportButton);

			JList teacherClassList = new JList();
			teacherClassList.setBounds(10, 62, 914, 727);
			teacherSelectClassPanel.add(teacherClassList);

			JPanel adminMenuPanel = new JPanel();
			contentPane.add(adminMenuPanel, "Admin Menu Pane");
			adminMenuPanel.setLayout(null);

			JLabel label_1 = new JLabel("Admin");
			label_1.setBounds(10, 10, 100, 40);
			adminMenuPanel.add(label_1);

			JComboBox adminSelectTeacherComboBox = new JComboBox();
			adminSelectTeacherComboBox.setToolTipText("Select a teacher:");
			adminSelectTeacherComboBox.setBounds(120, 20, 150, 20);
			adminMenuPanel.add(adminSelectTeacherComboBox);

			JButton adminAddClassSecction = new JButton("+ Class Section");
			adminAddClassSecction.setBounds(10, 60, 110, 23);
			adminMenuPanel.add(adminAddClassSecction);

			JButton adminDeleteClassSecction = new JButton("- Class Section");
			adminDeleteClassSecction.setBounds(160, 60, 110, 23);
			adminMenuPanel.add(adminDeleteClassSecction);

			JList adminClassList = new JList();
			adminClassList.setBounds(10, 100, 914, 600);
			adminMenuPanel.add(adminClassList);

			JButton adminEditClass = new JButton("Edit Class");
			adminEditClass.setBounds(10, 711, 110, 23);
			adminEditClass.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent arg0) {
					c1.show(contentPane, "Admin Edit Class Pane");
				}});
			adminMenuPanel.add(adminEditClass);

			JPanel adminEditClassPanel = new JPanel();
			adminEditClassPanel.setLayout(null);
			contentPane.add(adminEditClassPanel, "Admin Edit Class Pane");

			JTextArea adminCurrentClassLabel = new JTextArea("Current class: \n ITEC 471");
			adminCurrentClassLabel.setEditable(false);
			adminCurrentClassLabel.setBackground(SystemColor.menu);
			adminCurrentClassLabel.setBounds(10, 10, 90, 80);
			adminEditClassPanel.add(adminCurrentClassLabel);

			JButton adminBackToClassListButton = new JButton("Back to class list");
			adminBackToClassListButton.setBounds(110, 35, 140, 30);
			adminBackToClassListButton.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent arg0) {
					c1.show(contentPane, "Admin Menu Pane");
				}});
			adminEditClassPanel.add(adminBackToClassListButton);

			JButton adminHelpButton = new JButton("Help");
			adminHelpButton.setBounds(844, 11, 80, 30);
			adminEditClassPanel.add(adminHelpButton);

			JButton adminLogOutButton = new JButton("Log Out");
			adminLogOutButton.setBounds(844, 60, 80, 30);
			adminLogOutButton.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent arg0) {
					c1.show(contentPane,"Log In Pane");
				}	
			});
			adminEditClassPanel.add(adminLogOutButton);

			adminStudentClassSearch = new JTextField();
			adminStudentClassSearch.setBounds(10, 100, 90, 20);
			adminEditClassPanel.add(adminStudentClassSearch);
			adminStudentClassSearch.setColumns(10);

			JButton adminStudentSearchButton = new JButton("Search");
			adminStudentSearchButton.setBounds(110, 99, 80, 23);
			adminEditClassPanel.add(adminStudentSearchButton);

			JList adminStudentList = new JList();
			adminStudentList.setBounds(10, 130, 310, 600);
			adminEditClassPanel.add(adminStudentList);

			JButton adminAddStudent = new JButton("+ Student");
			adminAddStudent.setBounds(10, 740, 90, 23);
			adminEditClassPanel.add(adminAddStudent);

			JButton adminEditStudent = new JButton("Edit Student");
			adminEditStudent.setBounds(110, 740, 110, 23);
			adminEditClassPanel.add(adminEditStudent);

			JButton adminDeleteStudent = new JButton("- Student");
			adminDeleteStudent.setBounds(230, 740, 90, 23);
			adminEditClassPanel.add(adminDeleteStudent);

			JLabel adminExportClassListLabel = new JLabel("Export Class List");
			adminExportClassListLabel.setHorizontalAlignment(SwingConstants.CENTER);
			adminExportClassListLabel.setBounds(417, 131, 100, 14);
			adminEditClassPanel.add(adminExportClassListLabel);

			JLabel adminImportClassListLabel = new JLabel("Import Class List");
			adminImportClassListLabel.setHorizontalAlignment(SwingConstants.CENTER);
			adminImportClassListLabel.setBounds(417, 300, 100, 14);
			adminEditClassPanel.add(adminImportClassListLabel);

			JButton adminExportClassListButton = new JButton("Save as...");
			adminExportClassListButton.setBounds(420, 156, 112, 23);
			adminEditClassPanel.add(adminExportClassListButton);

			JButton adminSelectFileButton = new JButton("Select file...");
			adminSelectFileButton.setBounds(417, 325, 115, 23);
			adminEditClassPanel.add(adminSelectFileButton);	

		}
		
		
		
		public static void main(String[] args){
			frame = new desktopGUI();
			//		c1.show(contentPane,"Teacher Class List Pane");
			//		c1.show(contentPane, "Teacher Menu Pane");
			//		c1.show(contentPane,"Admin Menu Pane");
			//		c1.show(contentPane, "Admin Edit Class Pane");
			frame.setVisible(true);
		}

		public static desktopGUI getFrame()
		{
			return frame;
		}
	}
