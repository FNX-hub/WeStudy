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
		System.out.println("meeting confirmed");	//TODO DAO access to persistence
	}
	public void abortMeeeting() {
		System.out.println("meeting aborted");		//TODO kill thread
	}
	public void deleteMeeeting() {
		System.out.println("meeting deleted");		//TODO DAO access to persistence
	}
	public void modifyMeeting(String date, String subject, String student, String message) {
		meeting.modify(date, subject, student, message);
	}
}
