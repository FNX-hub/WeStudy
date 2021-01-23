package logic.model.bean;

public class LoginBean {
	private Integer id;
	private String password;
	
	public LoginBean() {
	}
	
	public LoginBean(Integer id, String password) {
		this.id = id;
		this.password = password;
	}
	public Integer getId() {
		return id;
	}
	public String getPassword() {
		return password;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public void setPassword(String password) {
		this.password = password;
	}
}
