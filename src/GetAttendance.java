import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.net.URL;
import java.net.URLConnection;
import java.net.URLEncoder;

public class GetAttendance {
	public static String[] getAttendance (String[] args)
    {
        try
        {
            String classname = args[0];
            String date =  args[1];
            String link = "https://php.radford.edu/~team05/teacherattendance.php";
            String data = URLEncoder.encode("class", "UTF-8") + "=" + URLEncoder.encode(classname, "UTF-8");
            data += "&" + URLEncoder.encode("date", "UTF-8") + "=" + URLEncoder.encode(date, "UTF-8");

           
            URL url = new URL(link);
            URLConnection conn = url.openConnection();

            conn.setDoOutput(true);
            OutputStreamWriter wr = new OutputStreamWriter(conn.getOutputStream());

            wr.write(data);
            wr.flush();

            BufferedReader reader = new BufferedReader(new InputStreamReader((conn.getInputStream())));
            StringBuilder sb = new StringBuilder();
            String line;

            //read server response
	        if((line = reader.readLine()) != null)
	        {
	            sb.append(line);
	            
	        }
	       return sb.toString().split("&");
	        
	    }
	    catch(Exception e)
	    {
	        e.printStackTrace();

	    }
		return new String[] {""};
	}
}
