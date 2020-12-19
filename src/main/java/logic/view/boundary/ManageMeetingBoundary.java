package logic.view.boundary;

import java.util.ArrayList;
import java.util.List;

import logic.control.ManageMeetingControl;
import logic.model.Meeting;
import logic.model.bean.MeetingBean;

public abstract class ManageMeetingBoundary {
	
	private List<Meeting> meetingList;
	protected MeetingBean bean;
	
	public ManageMeetingBoundary() {
		this.meetingList = new ArrayList<>();
		this.bean = new MeetingBean();
	}
	public List<Meeting> getMeetings() {
		return null;	// TODO DAO access to persistence
	}
	public void bookMeeting(String dataForm) {
		bean.newMeeting(dataForm);
	}
	public void modifyMeeting(Meeting meeting, String dataForm) {
		bean.modifyMeeting(meeting, dataForm);
	}
	public void deleteMeeting(Meeting meeting) {
		new ManageMeetingControl(meeting).deleteMeeeting();
		meetingList.remove(meeting);
	}
}