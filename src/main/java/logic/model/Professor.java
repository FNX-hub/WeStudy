package logic.model;

import java.util.List;

public class Professor extends User {
	private List<ClassCourse> courseList;
	
	public Professor(Integer id, String surname, String name, String password) {
		super(id, surname, name, password);
		//TODO add--> this.classCourses =  DaoFacroty.getClassCouresDao().getCourseByProfessorId(id);
	}	
	public List<ClassCourse> getClassCourses() {
		return courseList;
	}
	public void addCourse(ClassCourse course) {
		courseList.add(course);
		//TODO add--> DaoFacroty.getClassCouresDao().saveCourese(course);
	}
	
	public void removeCourse(ClassCourse course) {
		courseList.remove(course);
		//TODO add--> DaoFacroty.getClassCouresDao().deleteCourese(course);
	}
	
	@Override
	public String toString() {
		return String.format("%sUserType: Professor%n", super.toString());
	}
}
