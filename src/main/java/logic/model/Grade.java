package logic.model;

import java.sql.Date;
import java.time.LocalDate;

//author Adriano
public class Grade {
	private ClassCourse course;
	private Integer mark;
	private Date date;
	private String description;
	private String type;
	
	
	//Utilizzato dalla DAO
	public Grade(Integer mark, Date date, String description, String type) {
		this.mark = mark;
		this.description = description;
		this.type = type;
		this.date = date;
	}
	
	//Utilizzato dalla GUI
	public Grade(ClassCourse course, Integer mark, String description, String type) {
		this.course = course;
		this.mark = mark;
		this.date = Date.valueOf(LocalDate.now());
		this.description = description;
		this.type = type;
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

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}
}
