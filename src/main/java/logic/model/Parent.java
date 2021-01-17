package logic.model;

import java.util.List;

import logic.model.dao.DaoFactory;

public class Parent extends User {

	private String phoneNumber;
	private List<Student> children;
	
	
	public Parent(Integer id, String surname, String name, String password, String phoneNumber) {
		super(id, surname, name, password);
		this.phoneNumber = phoneNumber;
		this.children = DaoFactory.getStudentDao().getAll();
	}

	
	public String getPhoneNumber() {
		return phoneNumber;
	}

	public void setPhoneNumber(String phoneNumber) {
		this.phoneNumber = phoneNumber;
	}


	public List<Student> getChildren() {
		return children;
	}

	public void setChildren(List<Student> children) {
		this.children = children;
	}
	
	public void addChildren(Student child) {
		this.children.add(child);
	}
}
