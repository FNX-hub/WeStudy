package logic.model.bean;

import logic.model.UserType;

public class UserBean {
	
	private UserType type;
	private Integer id;
	private String surname;
	private String name;
	
	public UserBean(Integer id) {
		this.id = id;
	}
	
	public UserBean(UserType type, Integer id, String surname, String name) {
		this.id = id;
		this.name = name;
		this.surname = surname;
		this.type = type;
	}
	
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

	public String getName() {
		return name;
	}

	public void setType(UserType type) {
		this.type = type;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public void setSurname(String surname) {
		this.surname = surname;
	}

	public void setName(String name) {
		this.name = name;
	}
}
