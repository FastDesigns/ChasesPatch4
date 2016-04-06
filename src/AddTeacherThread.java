import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.net.URL;
import java.net.URLConnection;
import java.net.URLEncoder;

public class AddTeacherThread extends Thread
{
	private String fname, lname, id, username;
	private TeacherSubmitButton submit;
	
	public AddTeacherThread(String f, String l, String i, String u, TeacherSubmitButton t)
	{
		this.fname = f;
		this.lname = l;
		this.id = i;
		this.username = u;
		this.submit = t;
		this.start();
	}
	
	public void run()
	{
		try
		{
			String link = "https://php.radford.edu/~team05/addteacher.php";
	        String data = URLEncoder.encode("fname", "UTF-8") + "=" + URLEncoder.encode(fname, "UTF-8");
	        data += "&" + URLEncoder.encode("lname", "UTF-8") + "=" + URLEncoder.encode(lname, "UTF-8");
	        data += "&" + URLEncoder.encode("id", "UTF-8") + "=" + URLEncoder.encode(id, "UTF-8");
	        data += "&" + URLEncoder.encode("user", "UTF-8") + "=" + URLEncoder.encode(username, "UTF-8");
	        
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
	            System.out.println(sb.toString());
	            submit.error(sb.toString());
	        }
	        else
	        {
	        	submit.home();
	        }
	        this.interrupt();
	    }
	    catch(Exception e)
	    {
	        e.printStackTrace();
	        this.interrupt();
	    }
	}
}