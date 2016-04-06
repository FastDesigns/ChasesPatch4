import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.GridBagLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JList;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.border.EmptyBorder;

import org.jdesktop.swingx.JXDatePicker;

import com.sun.net.ssl.internal.www.protocol.https.Handler;
/**
 * 
 * @author Eddie Justice
 *
 */
public class ExportAttendance extends JFrame
{

	/**
	 * ExportAttendance version 1
	 */
	private static final long serialVersionUID = 1L;
	private JPanel contentPanel = new JPanel();
	private JPanel content = new JPanel();
	private JPanel actionsPanel = new JPanel();
	private JButton export = new JButton("Export");
	private JButton cancel = new JButton("Cancel");
	private String className;
	private String[] attendanceList = {"Select a date"};
	private JList attendance = new JList(attendanceList);
	private JScrollPane attendancePane = new JScrollPane(attendance);
	private final JXDatePicker picker = new JXDatePicker();
	private Handler handler = new Handler();
	
	public ExportAttendance(String cl)
	{
		className = cl;
		setup();
		exportContent();
		add(contentPanel);
		setUndecorated(true);
		setPreferredSize(new Dimension(500, 800));
		setVisible(true);
		pack();
		setLocationRelativeTo(null);
	}
	
	/**
	 * 
	 */
	private void setup()
	{
		contentPanel.setBorder(BorderFactory.createLineBorder(Color.black));
		contentPanel.setLayout(new BorderLayout());
		contentPanel.add(content, BorderLayout.CENTER);
		contentPanel.add(actionsPanel, BorderLayout.PAGE_END);
		
		actionsPanel.add(export);
		actionsPanel.add(cancel);
		attendance.setBorder(BorderFactory.createLineBorder(Color.black));
		addActionListeners();
	}
	
	/**
	 * 
	 */
	private void addActionListeners()
	{
		export.addActionListener(new ActionListener()
		{
			@Override
			public void actionPerformed(ActionEvent e)
			{
				final JFileChooser fc = new JFileChooser();
				JFrame mainFrame = new JFrame("Export");
				String filename = null;
				File fileToSave;
				DateFormat dateFormat = new SimpleDateFormat("hh_mm_ss");
				Date date = new Date();
				String searchDate = picker.getEditor().getText().toString();
				// http://www.codejava.net/java-se/swing/show-save-file-dialog-using-jfilechooser
				fc.setDialogTitle("Specify a file to save"); 
				int userSelection = fc.showSaveDialog(mainFrame);
				 
				if (userSelection == fc.APPROVE_OPTION) {
				    fileToSave = fc.getSelectedFile();
				    filename = fileToSave.getAbsolutePath();
				    //System.out.println("Save as file: " + fileToSave.getAbsolutePath());
				}
				WriteFile write = new WriteFile(className, dateFormat.format(date), filename, searchDate);
				write.print();
			}
		});
		cancel.addActionListener(new ActionListener()
		{
			@Override
			public void actionPerformed(ActionEvent e)
			{
				destroy();
			}
		});
	}
	
	/**
	 * 
	 */
	private void destroy()
	{
		dispose();
	}
	
	/**
	 * 
	 */
	private void exportContent()
	{
		DateFormat sdf = new SimpleDateFormat("hh:mm:ss");
		Date today = Calendar.getInstance().getTime();
		content.setLayout(new BorderLayout());
		JPanel temp = new JPanel();
		picker.setDate(new Date());
		picker.setFormats(new SimpleDateFormat("yyyy-MM-dd"));
		temp.add(picker);
		content.add(temp, BorderLayout.PAGE_START);
		attendancePane.setBorder(new EmptyBorder(20, 20, 20, 20));
		content.add(attendancePane, BorderLayout.CENTER);
		picker.addActionListener(new ActionListener()
		{
			@Override
			public void actionPerformed(ActionEvent e)
			{
				String[] list = {"Loading..."};
				setAttendance(list);
				new Attend(className, picker.getEditor().getText().toString());
			}
		});
	}
	
	/**
	 * 
	 * @param l
	 */
	private void setAttendance(String[] l)
	{
		attendance.setListData(l);
		refresh();
	}
	
	/**
	 * 
	 * @author Eddie Justice Jr
	 *
	 */
	private class Attend implements Runnable
	{
		private String clas, date;
		
		public Attend(String cl, String d)
		{
			clas = cl;
			date = d;
			run();
		}
		
		@Override
		public void run()
		{
			String[] l = {clas, date};
			setAttendance(GetAttendance.getAttendance(l));
		}
	}
	
	/**
	 * 
	 */
	private void refresh()
	{
		repaint();
	}
}