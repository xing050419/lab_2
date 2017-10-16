package lab_2;

public class Book {
    private String ISBN;
    private String title;
    private String authorID;
    private String publisher;
    private String publishDate;
    private double price;
    private String author;
    
    public Book() {
    	this.ISBN = null;
    	this.title = null;
    	this.authorID = null;
    	this.publisher = null;
    	this.publishDate = null;
    	this.price = 0;
    	this.author = null;
    }
    
    public String getISBN() {
    	return this.ISBN;
    }
    
    public void setISBN(String ISBN) {
    	this.ISBN = ISBN;
    }
    
    public String getTitle() {
    	return this.title;
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
    
    public String getPublisher() {
    	return this.publisher;
    }
    
    public void setPublisher(String publisher) {
    	this.publisher = publisher;
    }
    
    public String getPublishDate() {
    	return this.publishDate;
    }
    
    public void setPublishDate(String publishDate) {
    	this.publishDate = publishDate;
    }
    
    public double getPrice() {
    	return this.price;
    }
    
    public void setPrice(double price) {
    	this.price = price;
    }
    
    public String getAuthor() {
    	return this.author;
    }
    
    public void setAuthor(String author) {
    	this.author = author;
    }
}
