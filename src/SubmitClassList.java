import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.net.URL;
import java.net.URLConnection;
import java.net.URLEncoder;

public class SubmitClassList {
	public static boolean submitClass (String student, String classname)
    {
        try
        {
	            String link = "https://php.radford.edu/~team05/importclasslist.php";
	            String data = URLEncoder.encode("username", "UTF-8") + "=" + URLEncoder.encode(student, "UTF-8");
	            data += "&" + URLEncoder.encode("class", "UTF-8") + "=" + URLEncoder.encode(classname, "UTF-8");
	      
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
	        System.out.println("error");

	    }
		return false;
	}
}

