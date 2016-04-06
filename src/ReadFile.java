
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.Scanner;

import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.omg.Messaging.SyncScopeHelper;

// http://viralpatel.net/blogs/java-read-write-excel-file-apache-poi/
/**
 * 
 * @author Chase Abe
 *
 */
public class ReadFile {
	private String inputFile;
	private String extension;
	private File input;
	private String classname;
	
	public ReadFile(File file, String filename, String className){
		this.input = file;
		this.inputFile = filename;
		this.extension = filename.substring(filename.length()-3, filename.length());
		this.classname = className;
	}
	
	public void setInputFile(String filename) {
		this.inputFile = filename;
		this.extension = filename.substring(filename.length()-3, filename.length());
	}

	public void read() throws IOException {
		Boolean working = false;
		FileInputStream file = new FileInputStream(input);
		// Attempt to read XLSX format
						//System.out.println(extension);
		if (extension.equals("lsx"))
			XLSX(file);
		else if (extension.equals("xls"))
			XLS(file);
		else
			CSV(file);
		
		file.close();
		
	}
	
	public void XLSX(FileInputStream file){
		try {
			XSSFWorkbook book = new XSSFWorkbook(file);
			XSSFSheet sheet = book.getSheetAt(0); // selects page to get data from
			Iterator<Row> rowIterator = sheet.iterator();
			dataHandler(rowIterator);
		}
		catch (Exception e){
			System.out.println("XLSX failed");
			e.printStackTrace();
		}
		
	}
	
	public void XLS(FileInputStream file) {
		try {
			HSSFWorkbook book = new HSSFWorkbook(file);
			HSSFSheet sheet = book.getSheetAt(0);
			Iterator<Row> rowIterator = sheet.iterator();
			dataHandler(rowIterator);
			//System.out.println("Got here");
		}
		catch (IOException e){
			System.out.println("XLS failed");
			e.printStackTrace();
		
		}
	}

	public void CSV(FileInputStream file) {
		int comma, id;
		String line, first, last, username;
//		ArrayList<Person> list = new ArrayList<Person>();
		File csv = input;
		Scanner scan;
		SubmitClassList classlist = new SubmitClassList();
		try {
			scan = new Scanner(csv);
			while (scan.hasNextLine()) {
//				Person p = new Person();
				line = scan.nextLine();
				// last name
				comma = line.indexOf(',');
				last = line.substring(0, comma);
				line = line.substring(comma + 1, line.length());
				// first name
				comma = line.indexOf(",");
				first = line.substring(0,  comma);
				line = line.substring(comma + 1, line.length());
				// user name
				comma = line.indexOf(",");
				username = line.substring(0,  comma);
				line = line.substring(comma + 1, line.length());
				// id
				id = Integer.parseInt(line);
				// print check
				System.out.println(first + " " + last + " " + username+ " " + id);
//				p.setUname(username);
//				p.setId(id);
				classlist.submitClass(username, classname);
				
			}
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
	}
	
//	public void dataHandler(Iterator<Row> rowIterator) {
//		
//		while (rowIterator.hasNext()) {
//			Row row =rowIterator.next();
//		
//			Iterator<Cell> cellIterator = row.cellIterator();
//			while (cellIterator.hasNext()) {
//				Cell cell = cellIterator.next();
//			
//				switch (cell.getCellType()) {
//					case Cell.CELL_TYPE_STRING:
//						System.out.println(cell.getStringCellValue());
//						break;
//					case Cell.CELL_TYPE_NUMERIC:
//						System.out.println(cell.getNumericCellValue());
//						break;
//				}
//			}
//		}	
//	}
	
	//Isaac Weston's reader
	public void dataHandler(Iterator<Row> rowIterator) {
		int id;
		String first, last, username;
		SubmitClassList classlist = new SubmitClassList();
		while (rowIterator.hasNext()) {
			Row row =rowIterator.next();
			Iterator<Cell> cellIterator = row.cellIterator();
			Cell cell = cellIterator.next();
			Person p = new Person();
			// last name
			last = cell.getStringCellValue();
			cell = cellIterator.next();
			// first name
			first = cell.getStringCellValue();
			cell = cellIterator.next();
			// user name
			username = cell.getStringCellValue();
			cell = cellIterator.next();
			// id
			id = (int) cell.getNumericCellValue();
			//cell = cellIterator.next();
			// print check
			System.out.println(first + " " + last + " " + username+ " " + id);
//			p.setUname(username);
//			p.setId(id);
			classlist.submitClass(username, classname);
		}	
	}
}
