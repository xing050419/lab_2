package lab_2;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.HashMap;

import com.opensymphony.xwork2.ActionSupport;

@SuppressWarnings("serial")
public class UpdateAddAuthorAction extends ActionSupport {
    private String authorID;
    private String name;
    private int age;
    private String country;
    
    private ArrayList<Book> books = new ArrayList<>();
    
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
    
    public ArrayList<Book> getBooks() {
    	return this.books;
    }
    
    public String execute() throws SQLException {
    	Connection con = ConnectionGetter.getConnection();
		Statement statement = con.createStatement();
		
		HashMap<String, String> authorMap = new HashMap<>();
		ResultSet result = statement.executeQuery("select * from author");
		while (result.next()) {
			authorMap.put(result.getString("AuthorID"), result.getString("Name"));
		}
		
		String sql1 = "insert into author (AuthorID, Name, Age, Country) values (\"" 
		    + authorID + "\", \"" 
		    + name + "\", "
		    + age + ", \"" 
		    + country + "\")";
		statement.executeUpdate(sql1);
		
		String sql2 = "select * from book";
		result = statement.executeQuery(sql2);
		while (result.next()) {
			Book book = new Book();
			book.setISBN(result.getString("ISBN"));
			book.setTitle(result.getString("title"));
			book.setAuthorID(result.getString("AuthorID"));
			book.setPublisher(result.getString("Publisher"));
			book.setPublishDate(result.getDate("PublishDate").toString());
			book.setPrice(result.getDouble("Price"));
			book.setAuthor(authorMap.get(result.getString("AuthorID")));
			books.add(book);
		}
		
		con.close();
    	return "success";
    }
}
