import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.net.URL;
import java.net.URLConnection;
import java.net.URLEncoder;

public class SetAttendance {
	public static boolean setAttendance (String[] args)
    {
        try
        {
            String student = args[0];
        	String classname = args[1];
            String date = args[2];
            String link = "https://php.radford.edu/~team05/studentattendance.php";
            String data = URLEncoder.encode("student", "UTF-8") + "=" + URLEncoder.encode(student, "UTF-8");
            data += "&" + URLEncoder.encode("class", "UTF-8") + "=" + URLEncoder.encode(classname, "UTF-8");
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
          //read server response
            while((line = reader.readLine()) != null)
            {
                sb.append(line);
                break;
            }
            try
            {
                int r = Integer.parseInt(sb.toString());
                if(r == 1)
                {
                   return true;
                }
            }
            catch(NumberFormatException e)
            {
               return false;
            }
	     
	        
	    }
	    catch(Exception e)
	    {
	        e.printStackTrace();

	    }
		return false;
	}
}