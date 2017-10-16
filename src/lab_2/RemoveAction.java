package lab_2;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.HashMap;

import javax.servlet.http.HttpServletRequest;

import org.apache.struts2.ServletActionContext;

import com.opensymphony.xwork2.ActionSupport;

@SuppressWarnings("serial")
public class RemoveAction extends ActionSupport {
	private String requestUrl;
	private String isbn;
	private String name;
	private ArrayList<Book> books = new ArrayList<>();
	
	public String getRequestUrl() {
		return this.requestUrl;
	}
	
	public void setIsbn(String isbn) {
		this.isbn = isbn;
	}
	
	public String getName() {
		return this.name;
	}
	
	public ArrayList<Book> getBooks() {
		return this.books;
	}
	
	public String execute() throws SQLException {
		HttpServletRequest request = ServletActionContext.getRequest();
		requestUrl = request.getHeader("referer");
		int spliter = requestUrl.lastIndexOf('/');
		String action = requestUrl.substring(spliter + 1);
		
		Connection con = ConnectionGetter.getConnection();
		Statement statement = con.createStatement();
		String authorID = null;
		
		HashMap<String, String> authorMap = new HashMap<>();
		ResultSet result = statement.executeQuery("select * from author");
		while (result.next()) {
			authorMap.put(result.getString("AuthorID"), result.getString("Name"));
		}
		
		//记录AuthorID
		String sql1 = "select * from book where ISBN = " + "\"" + isbn + "\"";
		result = statement.executeQuery(sql1);
		if (result.first()) {
			authorID = result.getString("AuthorID");
		}
		
		//删除图书信息
		String sql2 = "delete from book where ISBN = \"" + isbn + "\"";
		statement.executeUpdate(sql2);
		
		//重定向到所有图书列表
		if (action.equalsIgnoreCase("manage?")) {
			String sql3 = "select * from book";
			result = statement.executeQuery(sql3);
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
		}
		//重定向到作者图书列表
		if (action.equalsIgnoreCase("searchauthor?")) {
			String sql3 = "select * from book where AuthorID = \"" + authorID + "\"";
			result = statement.executeQuery(sql3);
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
		}
		
		String sql4 = "select * from author where AuthorID = \"" + authorID + "\"";
		result = statement.executeQuery(sql4);
		if (result.first()) {
			name = result.getString("Name");
		}
		
		con.close();
		return "success";
	}
}
