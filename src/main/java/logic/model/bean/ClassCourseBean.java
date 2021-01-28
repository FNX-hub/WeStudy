package logic.model.bean;

public class ClassCourseBean {
	private Integer courseId;
	private String subject;

	
	public ClassCourseBean(Integer id) {
		this.courseId = id;
	}
	
	public ClassCourseBean(Integer id,String subject){
		this.courseId = id;
		this.subject = subject;
	}
	
	public Integer getCourseId() {
		return courseId;
	}
	
	public String getSubject() {
		return subject;
	}

	public void setCourseId(Integer courseId) {
		this.courseId = courseId;
	}
	
	public void setSubject(String subject) {
		this.subject = subject;
	}

	@Override
	public String toString() {
		return subject;
	}
	

}
