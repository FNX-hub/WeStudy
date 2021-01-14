package logic.view.boundary;

import java.util.ArrayList;
import java.util.List;

import logic.control.ManageMeetingControl;
import logic.control.SimpleLogger;
import logic.model.Meeting;
import logic.model.Parent;
import logic.model.Professor;
import logic.model.User;
import logic.model.UserType;
import logic.model.bean.MeetingBean;
import logic.model.dao.DaoFactory;
import logic.model.exceptio.FormException;

public abstract class ManageMeetingBoundary {
	
	private List<MeetingBean> meetingList;
	
	public ManageMeetingBoundary() {
		this.meetingList = new ArrayList<>();
	}
	
	public List<MeetingBean> getMeetings() {
		return null;
	}
	
	public void bookMeeting(String parentId, String professorId, String date, String message) {
	}
	
	public void deleteMeeting(Meeting bean) {
	}
	
	public void confirmMeeting(Meeting bean) {
	}
}