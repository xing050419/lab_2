package lab_2;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;

import com.opensymphony.xwork2.ActionSupport;

@SuppressWarnings("serial")
public class SearchAuthorAction extends ActionSupport {
	private String key;
	private ArrayList<Author> authors = new ArrayList<>();
	private ArrayList<Book> books = new ArrayList<>();
	
	public void setKey(String key) {
		this.key = key.trim();
	}
	
	public ArrayList<Author> getAuthors() {
		return this.authors;
	}
	
	public ArrayList<Book> getBooks() {
		return this.books;
	}
	
	@SuppressWarnings("resource")
	public String execute() throws SQLException {
		Connection con = ConnectionGetter.getConnection();
		Statement statement = con.createStatement();
		HashSet<String> authorIDs = new HashSet<>();
		
		HashMap<String, String> authorMap = new HashMap<>();
		ResultSet result = statement.executeQuery("select * from author");
		while (result.next()) {
			authorMap.put(result.getString("AuthorID"), result.getString("Name"));
		}
		
		if (key.matches("[0-9]+") && key.length() == 10) {
			String sql1 = "select * from author where authorID = \"" + key + "\"";
			result = statement.executeQuery(sql1);
			if (result.wasNull()) {
				con.close();
				return "fail";
			}
			while (result.next()) {
				Author author = new Author();
				author.setAuthorID(result.getString("AuthorID"));
				author.setName(result.getString("Name"));
				author.setAge(result.getInt("Age"));
				author.setCountry(result.getString("Country"));
				authorIDs.add(result.getString("AuthorID"));
				authors.add(author);
			}
			for (String id : authorIDs) {
				String sql2 = "select * from book where authorID = \"" + id + "\"";
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
			}
		} else {
			String sql1 = "select * from author where Name = \"" + key + "\"";
			result = statement.executeQuery(sql1);
			if (result.wasNull()) {
				con.close();
				return "fail";
			}
			while (result.next()) {
				Author author = new Author();
				author.setAuthorID(result.getString("AuthorID"));
				author.setName(result.getString("Name"));
				author.setAge(result.getInt("Age"));
				author.setCountry(result.getString("Country"));
				authorIDs.add(result.getString("AuthorID"));
				authors.add(author);
			}
			for (String id : authorIDs) {
				String sql2 = "select * from book where authorID = \"" + id + "\"";
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
			}
		}
		
		con.close();
		return "success";
	}
}
