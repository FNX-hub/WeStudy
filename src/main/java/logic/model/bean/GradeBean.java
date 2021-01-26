package logic.model.bean;

public class GradeBean {
	Integer studentId;
	Integer classCourse;
	
	Integer value;
	String description;
	String type; //ORAL, WRITTEN, PROJECT
	
	public GradeBean(Integer grade, String description, Integer classCourse, String type) {
		this.value = grade;
		this.description = description;
		this.type = type;
		this.classCourse = classCourse;
	}
	
	public Integer getValue() {
		return value;
	}
	public String getDescription() {
		return description;
	}
	public void setValue(Integer grade) {
		this.value = grade;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public Integer getClassCourse() {
		return classCourse;
	}
	public void setClassCourse(Integer classCourse) {
		this.classCourse = classCourse;
	}
	public Integer getStudentId() {
		return studentId;
	}
	public void setStudentId(Integer studentId) {
		this.studentId = studentId;
	}
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}
	
	
}
