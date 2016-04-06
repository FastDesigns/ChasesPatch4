import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

import org.apache.poi.hssf.usermodel.HSSFCell;
import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;

//import org.apache.poi.hssf.usermodel.HSSFSheet;
//import org.apache.poi.hssf.usermodel.HSSFWorkbook;

// http://viralpatel.net/blogs/java-read-write-excel-file-apache-poi/
/**
 * 
 * @author Chase Abe
 *
 */
public class WriteFile {
	private String className;
	private String date;
	private String file;
	private String searchDate;
	//private File fileOut;
	
//	public WriteFile(String classname, String exportDate, String f){
//		this.file = f;
//		this.className = classname;
//		this.date = exportDate;
//	}
	
	public WriteFile(String classname, String exportDate, String f, String search){
		this.file = f;
		this.className = classname;
		this.date = exportDate;
		this.searchDate = search;
	}


	// ask for filetype or just create xlsx
	
	@SuppressWarnings("deprecation")
	public void print(){
		boolean isFileUnlocked= false;
	try{
		System.out.println(date);
	    isFileUnlocked = true;
	    
		FileOutputStream fileOut = new FileOutputStream(file + className +" "+ date+".xls");
		HSSFWorkbook work = new HSSFWorkbook();
		HSSFSheet sheet =  work.createSheet(date);
		
		String[] data = { className, searchDate};
		String[] export = GetAttendance.getAttendance(data);
		
		//Map<String, String> dat = new HashMap<String, String>();
//		dat.put(0, "Student");
		
		HSSFRow row1 = sheet.createRow((short) 0);
		HSSFCell cellA1 = row1.createCell((short) 0);
		cellA1.setCellValue("Student Name");
		
		for (int i = 0; i< export.length;i++){
//			dat.put(Integer.toString(i), export[i]);
			System.out.println(export[i]);
			row1 = sheet.createRow((short) i+1);
			cellA1 = row1.createCell((short) 0);
			cellA1.setCellValue(export[i]);
		}
		
		work.write(fileOut);
		fileOut.flush();
		fileOut.close();
	}
	//catch (Exception e){}
	catch (IOException e) {
		e.printStackTrace();
		}
	}
}
