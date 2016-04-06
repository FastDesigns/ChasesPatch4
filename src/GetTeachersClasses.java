import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.net.URL;
import java.net.URLConnection;
import java.net.URLEncoder;

public class GetTeachersClasses extends Thread
{
	private TList tlist;
	private String[] list;
	private String fname, lname;
	
	public GetTeachersClasses(TList t, String[] names)
	{
		this.tlist = t;
		this.start();
		this.fname = names[0];
		this.lname = names[1];
	}
	
	public void run()
	{
		try
		{
			String link = "https://php.radford.edu/~team05/getClassListForTeacher.php";
	        String data = URLEncoder.encode("fname", "UTF-8") + "=" + URLEncoder.encode(fname, "UTF-8");
	        
	
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
	            list = sb.toString().split("&");
	        }
	        else
	        {
	        	String[] result = {"No Classes Found"};
	        	list = result;
	        }
	        tlist.setList(list);
	        this.interrupt();
	    }
	    catch(Exception e)
	    {
	        e.printStackTrace();
	        this.interrupt();
	    }
	}
	
	public String[] getList()
	{
		return list;
	}
}