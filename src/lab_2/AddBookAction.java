package lab_2;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import com.opensymphony.xwork2.ActionSupport;

@SuppressWarnings("serial")
public class AddBookAction extends ActionSupport {
    private String isbn;
    private String title;
    private String authorID;
    private String publisher;
    private String publishDate;
    private double price;
    
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
    
    public String execute() throws SQLException {
    	System.out.println(title);
        Connection con = ConnectionGetter.getConnection();
        Statement statement = con.createStatement();
        String sql1 = "insert into book (ISBN, Title, AuthorID, Publisher, PublishDate, Price) values ('" 
            + isbn.trim() + "', '" 
        	+ title.trim() + "', '" 
            + authorID.trim() + "', '" 
        	+ publisher.trim() + "', "
            + publishDate.trim() + ", "
            + price + ")";
        statement.executeUpdate(sql1);
        String sql2 = "select * from author where AuthorID = '" + authorID + "'";
        ResultSet result = statement.executeQuery(sql2);
        if (!result.first()) {
        	con.close();
            return "unfinished";
        }
        con.close();
        return "finished";
    }
}
