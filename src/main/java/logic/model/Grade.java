package logic.model;

import java.util.Date;

public class Grade {
	ClassCourse course;
	Integer mark;
	Date date;
	String description;
	
	public Grade(ClassCourse course, Integer mark, Date date, String description) {
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
	public Date getDate() {
		return date;
	}
	public void setCourse(ClassCourse course) {
		this.course = course;
	}
	public void setMark(Integer mark) {
		this.mark = mark;
	}
	public void setDate(Date date) {
		this.date = date;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
}
