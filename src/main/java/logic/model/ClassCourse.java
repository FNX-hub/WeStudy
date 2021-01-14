package logic.model;

import java.util.ArrayList;
import java.util.List;

public class ClassCourse {
	private String subject;
	private List<Assignment> assignments;
	
	
	public ClassCourse(String subject) {
		this.subject = subject;
		this.assignments = new ArrayList<Assignment>();
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
}
