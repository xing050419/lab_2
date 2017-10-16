package lab_2;

import java.sql.Connection;
import java.sql.Statement;
import com.opensymphony.xwork2.ActionSupport;

@SuppressWarnings("serial")
public class AddAuthorAction extends ActionSupport {
    private String authorID;
    private String name;
    private int age;
    private String country;
    
    public void setAuthorID(String authorID) {
    	this.authorID = authorID;
    }
    
    public void setName(String name) {
    	this.name = name;
    }
    
    public void setAge(int age) {
    	this.age = age;
    }
    
    public void setCountry(String country) {
    	this.country = country;
    }
    
    public String execute() throws Exception {
    	Connection con = ConnectionGetter.getConnection();
		Statement statement = con.createStatement();
		String sql1 = "insert into author (AuthorID, Name, Age, Country) values (\"" 
		    + authorID + "\", \"" 
		    + name + "\", "
		    + age + ", \"" 
		    + country + "\")";
		statement.executeUpdate(sql1);
		con.close();
    	return "success";
    }
}
