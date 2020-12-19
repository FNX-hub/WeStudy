package logic.model;


public class MeetingObserver implements Observer {

	private Meeting meeting;
	private String date;
	private String subject;
	private String student;
	private String message;
	private Boolean confirmed;
	
	public MeetingObserver(Meeting meeting) {
		this.meeting = meeting;
	}
	public Meeting getMeeting() {
		return meeting;
	}
	public String getString() {
		return date;
	}
	public String getSubject() {
		return subject;
	}
	public String getStudent() {
		return student;
	}
	public String getMessage() {
		return message;
	}
	public Boolean getConfirmed() {
		return confirmed;
	}
	@Override
	public void update() {
		date = meeting.getString();
		subject = meeting.getSubject();
		student = meeting.getStudent();
		message = meeting.getMessage();
		confirmed = meeting.getConfirmed();
	}


}
