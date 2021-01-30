package test.deliverable;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.fail;

import java.time.LocalDate;
import java.util.List;

import org.junit.Test;

import logic.control.ManageMeetingControl;
import logic.model.bean.MeetingBean;
import logic.model.bean.UserType;
import logic.model.bean.WrongDeclarationCustomException;

/**
 * @author Simone
 */
public class ManageBookingTest {

	private boolean success = false;

	@Test
	public void bookMeeting() {
		ManageMeetingControl control = new ManageMeetingControl();
		try {
			MeetingBean bean = new MeetingBean(1, 1, LocalDate.parse("2025-10-10"), "JUNIT");
			control.newMeeting(bean);
			bean.setConfirmed(true);
			List<MeetingBean> listMeeting = control.getUserMeeting(1, UserType.PROFESSOR);
			listMeeting.forEach(meeting ->{
				if(meeting.getMessage().equals(bean.getMessage())) {
					success  = true;
				}
			}
			);
			assertEquals(true, success);
			control.deleteMeeting(bean);
			control.stop();
		} catch (WrongDeclarationCustomException e) {
			fail();
		}
	}
}
