
public class Person {
	private String fname;
	private String lname;
	private String uname;
	private int id;
	
	
	public Person(){
		fname = "bob";
		lname = "o";
		uname = "bobo";
		id = 12;
	}
	
	public void setFname(String name){
		this.fname = name;
	}
	
	public String getLname(){
		return lname;
	}
	
	public void setUname(String username){
		uname = username;
	}
	
	public void setId(int studentId){
		id = studentId;
	}
}
