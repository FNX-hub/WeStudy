package logic.model;

import java.util.ArrayList;
import java.util.List;

import logic.model.dao.DaoFactory;

public class Parent extends User {

	private String phoneNumber;
	private List<Student> childrenList;
	
	
	public Parent(Integer id, String surname, String name, String password, String phoneNumber) {
		super(id, surname, name, password);
		this.phoneNumber = phoneNumber;
		this.childrenList = new ArrayList<>();
	}

	public String getPhoneNumber() {
		return phoneNumber;
	}
	public void setPhoneNumber(String phoneNumber) {
		this.phoneNumber = phoneNumber;
	}
	
	public List<Student> getChildren() {
		if(childrenList.isEmpty()) {
			childrenList.addAll(DaoFactory.getStudentDao().getFromParentId(getId()));
		}
		return childrenList;
	}
 
	public void addChildren(Student child) {
		this.childrenList.add(child);
	}
	
	public void removeChildren(Student child) {
		this.childrenList.remove(child);
	}
	
	@Override
	public String toString() {
		return String.format("%sUserType: Parent%n", super.toString());
	}
}
