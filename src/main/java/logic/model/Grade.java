package logic.model;

import java.time.LocalDate;

//author Adriano
public class Grade {
	protected ClassCourse course;
	protected Integer mark;
	protected LocalDate date;
	protected String description;
	protected String type;
	
	//Utilizzato per la DAO
	public Grade(Integer mark, String description, String type) {
		this.mark = mark;
		this.description = description;
		this.type = type;
	}
	
	public Grade(ClassCourse course, Integer mark, LocalDate date, String description) {
		this.course = course;
		this.mark = mark;
		this.date = date;
		this.description = description;
	}
	
	public ClassCourse getCourse() {
		return course;
	}
	public Integer getMark() {
		return mark;
	}
	public LocalDate getDate() {
		return date;
	}
	public void setCourse(ClassCourse course) {
		this.course = course;
	}
	public void setMark(Integer mark) {
		this.mark = mark;
	}
	public void setDate(LocalDate date) {
		this.date = date;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}
}
