package logic.model.bean;

import java.sql.Date;
import java.time.LocalDate;

import javafx.beans.property.IntegerProperty;
import javafx.beans.property.ObjectProperty;
import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleObjectProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;

public class ExtendedGrade {
	private IntegerProperty studentId;
	private StringProperty coursename;
	private StringProperty studentName;
	private StringProperty studentSurname;
	private ObjectProperty<LocalDate> databaseDate;
	private SimpleIntegerProperty mark;
	private StringProperty description;
	private StringProperty type;
	
	
	
	public ExtendedGrade(Integer studentId, String studentName, String studentSurname, Date date, Integer mark, String description, String type) {
		this.studentId = new SimpleIntegerProperty(studentId);
		this.studentName = new SimpleStringProperty(studentName);
		this.studentSurname = new SimpleStringProperty(studentSurname);
		this.databaseDate = new SimpleObjectProperty<>(LocalDate.parse(date.toString()));
		this.mark = new SimpleIntegerProperty(mark);
		this.description = new SimpleStringProperty(description);
		this.type = new SimpleStringProperty(type);		
	}
	
	
	public Integer getStudentId() {
		return studentId.get();
	}
	public String getCoursename() {
		return coursename.get();
	}
	public String getStudentName() {
		return studentName.get();
	}
	public String getStudentSurname() {
		return studentSurname.get();
	}
	public LocalDate getDatabaseDate() {
		return databaseDate.get();
	}
	public void setStudentId(Integer studentId) {
		this.studentId = new SimpleIntegerProperty(studentId);
	}
	public void setCoursename(String coursename) {
		this.coursename = new SimpleStringProperty(coursename);
	}
	public void setStudentName(String studentName) {
		this.studentName = new SimpleStringProperty(studentName);
	}
	public void setStudentSurname(String studentSurname) {
		this.studentSurname = new SimpleStringProperty(studentSurname);
	}
	public void setDatabaseDate(Date databaseDate) {
		this.databaseDate = new SimpleObjectProperty<>(LocalDate.parse(databaseDate.toString()));
	}

	public Integer getMark() {
		return mark.get();
	}

	public String getDescription() {
		return description.get();
	}

	public String getType() {
		return type.get();
	}

	public void setMark(Integer mark) {
		this.mark = new SimpleIntegerProperty(mark);
	}

	public void setDescription(String description) {
		this.description = new SimpleStringProperty(description);
	}

	public void setType(String type) {
		this.type = new SimpleStringProperty(type);
	}


	public ObjectProperty<LocalDate> dateProperty() {
		return databaseDate;
	}

	public IntegerProperty markProperty() {
		return mark;
	}


	public StringProperty coursenameProperty() {
		return coursename;
	}
	
	
	
}
