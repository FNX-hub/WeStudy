package logic.view.boundary;

import logic.control.LoginControl;
import logic.model.bean.LoginBean;

public interface LoginBoundary {

	public default String verifyUser(LoginBean bean) {
		return new LoginControl().verifyUser(bean);		
	}
}
