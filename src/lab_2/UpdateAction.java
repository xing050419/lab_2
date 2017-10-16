package lab_2;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.HashMap;

import com.opensymphony.xwork2.ActionSupport;


@SuppressWarnings("serial")
public class UpdateAction extends ActionSupport {
    private String isbn;
    private String title;
    private String authorID;
    private String publisher;
    private String publishDate;
    private double price;
    private ArrayList<Book> books = new ArrayList<>();
    
    public void setIsbn(String isbn) {
        this.isbn = isbn;
    }
    
    public void setTitle(String title) {
    	this.title = title;
    }
    
    public String getAuthorID() {
    	return this.authorID;
    }
    
    public void setAuthorID(String authorID) {
        this.authorID = authorID;
    }
    
    public void setPublisher(String publisher) {
        this.publisher = publisher;
    }
    
    public void setPublishDate(String publishDate) { 
        this.publishDate = publishDate;
    }
    
    public void setPrice(double price) {
        this.price = price;
    }
    
    public ArrayList<Book> getBooks() {
    	return this.books;
    }
    
    public String execute() throws SQLException {
    	Connection con = ConnectionGetter.getConnection();
		Statement statement = con.createStatement();
		
		String sql1 = "select * from author";
		HashMap<String, String> authorMap = new HashMap<>();
		
		ResultSet result = statement.executeQuery(sql1);
		while (result.next()) {
			authorMap.put(result.getString("AuthorID"), result.getString("Name"));
		}
		
		if (!title.equals("")) {
			String sql = "update book set Title = \"" + title + "\" where ISBN = '" + isbn + "'";
			statement.executeUpdate(sql);
		}
		
		if (!authorID.equals("")) {
			String sql = "update book set AuthorID = '" + authorID + "' where ISBN = '" + isbn + "'";
			statement.executeUpdate(sql);
		}
		
		if (!publisher.equals("")) {
			String sql = "update book set Publisher = \"" + publisher + "\" where ISBN = '" + isbn + "'";
			statement.executeUpdate(sql);
		}
		if (!publishDate.equals("")) {
			String sql = "update book set PublishDate = " + publishDate + " where ISBN = '" + isbn + "'";
			statement.executeUpdate(sql);
		}
		if (price != 0.00) {
			String sql = "update book set price = " + price + " where ISBN = '" + isbn + "'";
			statement.executeUpdate(sql);
		}
		
		String sql2 = "select * from book";
		result = statement.executeQuery(sql2);
		while (result.next()) {
			Book book = new Book();
			book.setISBN(result.getString("ISBN"));
			book.setTitle(result.getString("title"));
			book.setAuthorID(result.getString("authorID"));
			book.setPublisher(result.getString("Publisher"));
			book.setPublishDate(result.getDate("PublishDate").toString());
			book.setPrice(result.getDouble("Price"));
			book.setAuthor(authorMap.get(result.getString("authorID")));
			books.add(book);
		}
		
		if (!authorID.equals("")) {
			String sql = "select * from author where AuthorID = \"" + authorID + "\"";
			result = statement.executeQuery(sql);
            if (!result.first()) {
            	con.close();
            	return "unfinished";
            }
		}
		
		con.close();
    	return "finished";
    }
}
