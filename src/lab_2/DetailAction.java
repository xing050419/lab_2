package lab_2;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import com.opensymphony.xwork2.ActionSupport;

@SuppressWarnings("serial")
public class DetailAction extends ActionSupport {
	private String isbn;
	
	private String title;
	private String authorID;
	private String publisher;
	private String publishDate;
	private double price;
	
	private String name;
	private int age;
	private String country;
	
	public String getIsbn() {
		return this.isbn;
	}
	
	public void setIsbn(String ISBN) {
		this.isbn = ISBN;
	}
	
	public String getTitle() {
		return this.title;
	}
	
	public String getAuthorID() {
		return this.authorID;
	}
	
	public String getPublisher() {
		return this.publisher;
	}
	
	public String getPublishDate() {
		return this.publishDate;
	}
	
	public double getPrice() {
		return this.price;
	}
	
	public String getName() {
		return this.name;
	}
	
	public int getAge() {
		return this.age;
	}
	
	public String getCountry() {
		return this.country;
	}
	
	public String execute() throws SQLException {
		Connection con = ConnectionGetter.getConnection();
		Statement statement = con.createStatement();
		
		String sql1 = "select * from book where ISBN=\"" + isbn + "\"";
		ResultSet result = statement.executeQuery(sql1);
		if (result.first()) {
			title = result.getString("Title");
			authorID = result.getString("AuthorID");
			publisher = result.getString("Publisher");
			publishDate = result.getDate("PublishDate").toString();
			price = result.getDouble("price");
		}
		
		String sql2 = "select * from author where AuthorID=\"" + authorID + "\"";
		result = statement.executeQuery(sql2);
		if (result.first()) {
			name = result.getString("Name");
			age = result.getInt("Age");
			country = result.getString("Country");
		}
		con.close();
		return "success";
	}
}
