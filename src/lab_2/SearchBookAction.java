package lab_2;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.HashMap;

import com.opensymphony.xwork2.ActionSupport;

@SuppressWarnings("serial")
public class SearchBookAction extends ActionSupport {
	private String key;
	private ArrayList<Book> books = new ArrayList<>();
	
	public void setKey(String key) {
		this.key = key.trim();
	}
	
	public ArrayList<Book> getBooks() {
		return this.books;
	}
	
	@SuppressWarnings("resource")
	public String execute() throws SQLException {
		Connection con = ConnectionGetter.getConnection();
		Statement statement = con.createStatement();

		HashMap<String, String> authorMap = new HashMap<>();
		ResultSet result = statement.executeQuery("select * from author");
		while (result.next()) {
			authorMap.put(result.getString("AuthorID"), result.getString("Name"));
		}
		
		if (key.startsWith("978-7") && key.length() == 17) {
			String sql = "select * from book where ISBN = \"" + key + "\"";
			result = statement.executeQuery(sql);
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
		} else {
			String sql = "select * from book where Title = \"" + key + "\"";
			result = statement.executeQuery(sql);
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
		}
		
		con.close();
		return "success";
	}
}

