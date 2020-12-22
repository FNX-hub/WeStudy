package logic.control;

import logic.model.Meeting;

public class ManageMeetingControl {
	
	private Meeting meeting;

	public ManageMeetingControl(Meeting meeting) {
		this.meeting = meeting;
	}
	public ManageMeetingControl(String date, String subject, String student, String message) {
		this.meeting = new Meeting(date, subject, message, student, Boolean.FALSE);
	}
	public void confirmMeeeting() {
		meeting.setConfirmed(true);
		SimpleLogger.info("meeting confirmed"); // DAO access to persistence
	}
	public void abortMeeeting() {
		SimpleLogger.info("meeting aborted"); // kill thread
	}
	public void deleteMeeeting() {
		SimpleLogger.info("meeting deleted"); //DAO access to persistence
	}
	public void modifyMeeting(String date, String subject, String student, String message) {
		meeting.modify(date, subject, student, message);
	}
}
