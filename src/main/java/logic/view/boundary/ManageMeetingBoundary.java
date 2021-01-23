package logic.view.boundary;

import java.util.List;

import logic.control.ManageMeetingControl;
import logic.model.bean.MeetingBean;
import logic.model.bean.UserBean;

public interface ManageMeetingBoundary {
		
	public default List<MeetingBean> getMeetings(UserBean userBean) {
		return new ManageMeetingControl().getUserMeeting(userBean.getId(), userBean.getType());
	}
	public default List<UserBean> getUserToMeet(UserBean bean) {
		return new ManageMeetingControl().getUserToMeet(bean);
	}
	public default void bookMeeting(MeetingBean bean) {
		ManageMeetingControl control = new ManageMeetingControl();
		control.newMeeting(bean);
	}
	public default void deleteMeeting(MeetingBean bean) {
		ManageMeetingControl control = new ManageMeetingControl();
		control.deleteMeeting(bean);
	}
	public default void confirmMeeting(MeetingBean bean) {
		bean.setConfirmed(true);
	}
	public default void abortMeeting(MeetingBean bean) {
		bean.setConfirmed(false);
	}
}