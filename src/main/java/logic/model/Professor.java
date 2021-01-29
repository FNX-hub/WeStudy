package logic.model;

import java.util.ArrayList;
import java.util.List;

public class Professor extends User {
	private List<ClassCourse> courseList;
	
	public Professor(Integer id, String surname, String name, String password) {
		super(id, surname, name, password);
		this.courseList = new ArrayList<>();
	}	
	public List<ClassCourse> getClassCourses() {
		return courseList;
	}
	public void addCourse(ClassCourse course) {
		courseList.add(course);
	}
	
	public void removeCourse(ClassCourse course) {
		courseList.remove(course);
	}
	
	@Override
	public String toString() {
		return String.format("%sUserType: Professor%n", super.toString());
	}
}
