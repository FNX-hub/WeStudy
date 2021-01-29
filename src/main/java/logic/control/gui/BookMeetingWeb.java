package logic.control.gui;

import logic.control.ManageMeetingControl;
import logic.model.bean.MeetingBean;
import logic.view.boundary.ManageMeetingBoundary;

//@author Simone
public class BookMeetingWeb implements ManageMeetingBoundary{
	
		private MeetingBean meeting;
		private ManageMeetingControl control;
		
		public BookMeetingWeb(MeetingBean meetingBean){
			this.meeting = meetingBean;
			this.control = new ManageMeetingControl();
			
			control.newMeeting(meeting);
			meeting.setConfirmed(true);
		}
		
		/*
		public void confirm() {
			this.confirmMeeting(meeting);
			this.meeting = null;
			control.stop();
			this.control = null;
		}
		
		public void abort() {
			this.abortMeeting(meeting);
			this.meeting = null;
			control.stop();
			this.control = null;
		}
		*/
}
