package logic.model.bean;

import logic.model.UserType;

public class UserBean {
	private UserType type;
	private Integer id;
	private String surname;
	public UserBean(UserType type, Integer id, String surname) {
		this.type = type;
		this.id = id;
		this.surname = surname;
	}
	public UserType getType() {
		return type;
	}
	public Integer getId() {
		return id;
	}
	public String getSurname() {
		return surname;
	}
	@Override
	public String toString() {
		return surname;
		//return super.toString();
	}
}
