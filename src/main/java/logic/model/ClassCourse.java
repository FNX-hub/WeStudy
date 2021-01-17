package logic.model;

import java.util.List;

/* author Adriano */
public class ClassCourse {
	private Integer id;
	private String subject; //coincide con courseName
	private List<Assignment> assignments;
	private List<Student> students;
	
	
	public ClassCourse(String subject) {
		this.subject = subject;
		//this.assignments = new ArrayList<Assignment>();
		//TODO
		//this.assignments = ChiamaLaDao (SELECT * FROM ASSIGNMENT WHERE COURSE_ID = this.id)
		//TODO
		//this.students = ChiamaLaDao (SELECT * FROM student_course WHERE COURSE_ID = this.id)
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
		
		this.assignments.add(newAssignment);
		
	}

	public Integer getId() {
		return id;
	}


	public void setId(Integer id) {
		this.id = id;
	}

}
