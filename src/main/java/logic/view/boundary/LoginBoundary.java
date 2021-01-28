package logic.view.boundary;

import logic.control.LoginControl;
import logic.model.bean.LoginBean;
import logic.model.bean.UserBean;

public interface LoginBoundary {

	public default UserBean verifyUser(LoginBean bean) {
		return new LoginControl().verifyUser(bean);		
	}
	public default void logout(UserBean session) {
		new LoginControl().logout(session);		
	}
}
