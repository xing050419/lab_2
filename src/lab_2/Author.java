package lab_2;
public class Author {
    private String authorID;
    private String name;
    private int age;
    private String country;
    
    public Author() {
    	this.authorID = null;
    	this.name = null;
    	this.age = 0;
    	this.country = null;
    }
    
    public String getAuthorID() {
    	return this.authorID;
    }
    
    public void setAuthorID(String authorID) {
    	this.authorID = authorID;
    }
    
    public String getName() {
    	return this.name;
    }
    
    public void setName(String name) {
    	this.name = name;
    }
    
    public int getAge() {
    	return this.age;
    }
    
    public void setAge(int age) {
    	this.age = age;
    }
    
    public String getCountry() {
    	return this.country;
    }
    
    public void setCountry(String country) {
    	this.country = country;
    }
}

