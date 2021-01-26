package logic.model.bean;

//TODO cancellare
public class LoginBeanWeb{
	private String insertedUsername;
	private String insertedPassword;
	private String role;
	
	public LoginBeanWeb(String insertedUsername,String insertedPassword) {
		this.insertedUsername = insertedUsername;
		this.insertedPassword = insertedPassword;
	}
	
	public String getInsertedUsername() {
		return insertedUsername;
	}
	public String getInsertedPassword() {
		return insertedPassword;
	}
	public String getRole() {
		return role;
	}
	public void setInsertedUsername(String insertedUsername) {
		this.insertedUsername = insertedUsername;
	}
	public void setInsertedPassword(String insertedPassword) {
		this.insertedPassword = insertedPassword;
	}
	public void setRole(String role) {
		this.role = role;
	}
	public void set(String insertedUsername,String insertedPassword) {
		this.insertedUsername = insertedUsername;
		this.insertedPassword = insertedPassword;
		
	}
}
