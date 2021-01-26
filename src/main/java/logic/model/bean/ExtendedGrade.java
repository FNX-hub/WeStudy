package logic.model.bean;

import java.sql.Date;

public class ExtendedGrade {
	private Integer studentId;
	private String coursename;
	private String studentName;
	private String studentSurname;
	private Date databaseDate;
	private Integer mark;
	private String description;
	private String type;
	
	
	
	public ExtendedGrade(Integer studentId, String studentName, String studentSurname, Date date, Integer mark, String description, String type) {
		this.studentId = studentId;
		this.studentName = studentName;
		this.studentSurname = studentSurname;
		this.databaseDate = date;
		this.mark = mark;
		this.description = description;
		this.type = type;		
	}
	
	
	public ExtendedGrade(Integer studentId, String courseName, String studentName, String studentSurname, Date date, Integer mark, String description, String type) {
		this.studentId = studentId;
		this.coursename = courseName;
		this.studentName = studentName;
		this.studentSurname = studentSurname;
		this.databaseDate = date;
		this.mark = mark;
		this.description = description;
		this.type = type;		
	}
	
	public Integer getStudentId() {
		return studentId;
	}
	public String getCoursename() {
		return coursename;
	}
	public String getStudentName() {
		return studentName;
	}
	public String getStudentSurname() {
		return studentSurname;
	}
	public Date getDatabaseDate() {
		return databaseDate;
	}
	public void setStudentId(Integer studentId) {
		this.studentId = studentId;
	}
	public void setCoursename(String coursename) {
		this.coursename = coursename;
	}
	public void setStudentName(String studentName) {
		this.studentName = studentName;
	}
	public void setStudentSurname(String studentSurname) {
		this.studentSurname = studentSurname;
	}
	public void setDatabaseDate(Date databaseDate) {
		this.databaseDate = databaseDate;
	}

	public Integer getMark() {
		return mark;
	}

	public String getDescription() {
		return description;
	}

	public String getType() {
		return type;
	}

	public void setMark(Integer mark) {
		this.mark = mark;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public void setType(String type) {
		this.type = type;
	}
	
	
	
}
