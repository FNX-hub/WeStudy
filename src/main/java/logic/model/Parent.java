package logic.model;

import java.util.ArrayList;
import java.util.List;

public class Parent extends User {

	private String phoneNumber;
	private List<Student> children;
	
	public Parent(String id, String surname, String name, String password, String phoneNumber) {
		super(id, surname, name, password);
		this.phoneNumber = phoneNumber;
		this.children = new ArrayList<Student>();
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
