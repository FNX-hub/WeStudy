package logic.model;

import java.util.ArrayList;
import java.util.List;

public class Student extends User {
	private List<Grade> grades; 
	
	public Student(Integer id, String surname, String name, String password, String parentId) {
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

	@Override
	public String toString() {
		return String.format("%s%n", super.toString()) ;
	}

}
