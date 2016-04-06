import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.net.URL;
import java.net.URLConnection;
import java.net.URLEncoder;

public class CreateClassThread extends Thread
{
	private String name, location, id, days, teacher;
	private ClassSubmitButton submit;
	
	public CreateClassThread(String n, String i, String l, String d, String t, ClassSubmitButton c)
	{
		this.name = n;
		this.id = i;
		this.location = l;
		this.days = d;
		this.teacher = t;
		this.submit = c;
		this.start();
	}
	
	public void run()
	{
		try
		{
			String link = "https://php.radford.edu/~team05/addclass.php";
	        String data = URLEncoder.encode("name", "UTF-8") + "=" + URLEncoder.encode(name, "UTF-8");
	        data += "&" + URLEncoder.encode("id", "UTF-8") + "=" + URLEncoder.encode(id, "UTF-8");
	        data += "&" + URLEncoder.encode("loc", "UTF-8") + "=" + URLEncoder.encode(location, "UTF-8");
	        data += "&" + URLEncoder.encode("days", "UTF-8") + "=" + URLEncoder.encode(days, "UTF-8");
	        data += "&" + URLEncoder.encode("teacher", "UTF-8") + "=" + URLEncoder.encode(teacher, "UTF-8");
	
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