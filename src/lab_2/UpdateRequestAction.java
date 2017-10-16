package lab_2;
import javax.servlet.http.HttpServletRequest;

import org.apache.struts2.ServletActionContext;

import com.opensymphony.xwork2.ActionSupport;

@SuppressWarnings("serial")
public class UpdateRequestAction extends ActionSupport {
	private String redirectUrl;
    private String isbn;
    
    public String getRedirectUrl() {
    	return this.redirectUrl;
    }
    
    public String getIsbn() {
    	return this.isbn;
    }
    
    public void setIsbn(String isbn) {
    	this.isbn = isbn;
    }
    
    public String execute() {
    	HttpServletRequest request = ServletActionContext.getRequest();
		String requestUrl = request.getHeader("referer");
		int spliter = requestUrl.lastIndexOf('/');
		String action = requestUrl.substring(spliter + 1);
		redirectUrl = action;
		return "success";
    }
}
