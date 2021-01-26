package logic.model;

import java.util.List;

/* author Adriano */
public class ClassCourse {
	private Integer id; 
	private String subject; //coincide con courseName
	private List<Assignment> assignments;
	private List<Student> students;
	
	
	public ClassCourse(Integer id) {
		this.id = id;
	}
	
	public ClassCourse(String subject, Integer id) {
		this.subject = subject;
		this.id = id;
	}
	
	public ClassCourse(String subject) {
		this.subject = subject;
	}
	
	public String getSubject() {
		return subject;
	}
	public List<Assignment> getAssignments() {
		return assignments;
	}
	public void setSubject(String subject) {
		this.subject = subject;
	}
	public void setAssignments(List<Assignment> assignments) {
		this.assignments = assignments;
	}
	
	public void addAssignment(Assignment newAssignment) {
		//Aggiungi alla lista
		this.assignments.add(newAssignment);
	}

	public Integer getId() {
		return id;
	}


	public void setId(Integer id) {
		this.id = id;
	}

	public List<Student> getStudents() {
		return students;
	}

	public void setStudents(List<Student> students) {
		this.students = students;
	}

}
