package logic.model.bean;

import logic.control.ManageMeetingControl;
import logic.model.Meeting;

public class MeetingBean {

	private String date;
	private String subject;
	private String student;
	private String message;
	
	// aggiungere handling di errore per tipo di dato errato
	private void dataParser(String dataForm) {
		String[] param = dataForm.split(";", 4);
		date = param[0];
		subject = param[1];
		student = param[2];
		message = param[3];
	}
	public void newMeeting(String dataForm) {
		dataParser(dataForm);
		new ManageMeetingControl(date, subject, student, message);	
	}
	public void modifyMeeting(Meeting meeting, String dataForm) {
		dataParser(dataForm);
		new ManageMeetingControl(meeting).modifyMeeting(date, subject, student, message);
	}
}
