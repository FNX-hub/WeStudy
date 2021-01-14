package logic.model;

import java.util.ArrayList;
import java.util.List;

public class Student extends User {
	private List<Grade> grades; 
	
	public Student(String id, String surname, String name, String password, String parentId) {
		super(id, surname, name, password);
		this.grades = new ArrayList<Grade>(); 
		
	}

	public List<Grade> getGrades() {
		return grades;
	}

	public void setGrades(List<Grade> grades) {
		this.grades = grades;
	}

	public void addGrade(Grade grade) {
		this.grades.add(grade);
	}

	/*
	//TODO commentato perchè non so se ti serve, se nemmeno a te serve, cancellalalo
	@Override
	public String toString() {
		return String.format("%s%nParentId: %s", super.toString(), parentId) ;
	}
	*/

}
