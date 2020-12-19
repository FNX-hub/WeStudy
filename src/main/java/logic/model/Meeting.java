package logic.model;

public class Meeting extends ObservableObject {
	
	private String date;
	private String subject;
	private String student;
	private String message;
	private Boolean confirmed;
	
	public Meeting(String date, String subject, String student, String message, Boolean confirmed) {
		super();
		this.date = date;
		this.subject = subject;
		this.student = student;
		this.message = message;
		this.confirmed = confirmed;
	}
	public String getString() {
		return date;
	}
	public void setString(String date) {
		this.date = date;
		notifyObservers();
	}
	public String getSubject() {
		return subject;
	}
	public void setSubject(String subject) {
		this.subject = subject;
		notifyObservers();
	}
	public String getStudent() {
		return student;
	}
	public void setStudent(String student) {
		this.student = student;
		notifyObservers();
	}
	public String getMessage() {
		return message;
	}
	public void setMessage(String message) {
		this.message = message;
		notifyObservers();
	}
	public Boolean getConfirmed() {
		return confirmed;
	}
	public void setConfirmed(Boolean confirmed) {
		this.confirmed = confirmed;
		notifyObservers();
	}
	public void modify(String date, String subject, String student, String message) {
		if(date != null) this.date = date;
		if(subject != null) this.subject = subject;
		if(student != null) this.student = student;
		if(message != null) this.message = message;
		notifyObservers();
	}
}
