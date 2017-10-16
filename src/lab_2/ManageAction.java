package lab_2;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.HashMap;

import com.opensymphony.xwork2.ActionSupport;

@SuppressWarnings("serial")
public class ManageAction extends ActionSupport {
	private ArrayList<Book> books = new ArrayList<>();
	
	public ArrayList<Book> getBooks() {
		return this.books;
	}
	
	public String execute() throws SQLException {
		Connection con = ConnectionGetter.getConnection();
		Statement statement = con.createStatement();
		String sql1 = "select * from author";
		String sql2 = "select * from book";
		HashMap<String, String> authorMap = new HashMap<>();
		
		ResultSet result = statement.executeQuery(sql1);
		while (result.next()) {
			authorMap.put(result.getString("AuthorID"), result.getString("Name"));
		}
		
		result = statement.executeQuery(sql2);
		while (result.next()) {
			Book book = new Book();
			book.setISBN(result.getString("ISBN"));
			book.setTitle(result.getString("Title"));
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

