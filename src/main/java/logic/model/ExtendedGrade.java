package logic.model;

import java.sql.Date;

//author Adriano
//Una classe in grado di contenere maggiori informazioni rispetto ad un comune Grade
//Utilizzata per accoppiare informazioni ottenute dalla DAO a seguito di una query su più tabelle
public class ExtendedGrade extends Grade{
	private Integer studentId;
	private String coursename;
	private String studentName;
	private String studentSurname;
	private Date databaseDate;
	
	public ExtendedGrade(Integer mark, String description, String type) {
		super(mark, description, type);
	}
	
	//Utilizzato
	public ExtendedGrade(Integer mark, String description, String type, String studentName, String studentSurname, Date databaseDate, Integer studentId) {
		super(mark, description, type);
		this.studentName = studentName;
		this.studentSurname = studentSurname;
		this.databaseDate = databaseDate;
		this.studentId = studentId;
	}
	
	public ExtendedGrade(Integer mark, String description, String type, String studentName, String studentSurname, String courseName, Date databaseDate) {
		super(mark, description, type);
		this.studentName = studentName;
		this.studentSurname = studentSurname;
		this.coursename = courseName;
		this.databaseDate = databaseDate;
	}
	
	public ExtendedGrade(Integer mark, String description, String type, String courseName, Date databaseDate) {
		super(mark, description, type);
		this.coursename = courseName;
		this.databaseDate = databaseDate;
	}
	
	public ExtendedGrade(Integer mark, String description, String type, String coursename) {
		super(mark, description, type);
		this.coursename = coursename;
	}

	public String getCoursename() {
		return coursename;
	}

	public void setCoursename(String coursename) {
		this.coursename = coursename;
	}

	public String getStudentName() {
		return studentName;
	}

	public String getStudentSurname() {
		return studentSurname;
	}

	public void setStudentName(String studentName) {
		this.studentName = studentName;
	}

	public void setStudentSurname(String studentSurname) {
		this.studentSurname = studentSurname;
	}

	public Date getDatabaseDate() {
		return databaseDate;
	}

	public void setDatabaseDate(Date databaseDate) {
		this.databaseDate = databaseDate;
	}


	public Integer getStudentId() {
		return studentId;
	}


	public void setStudentId(Integer studentId) {
		this.studentId = studentId;
	}
	
}
