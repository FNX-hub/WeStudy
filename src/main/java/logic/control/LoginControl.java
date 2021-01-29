package logic.control;

import java.util.ArrayList;
import java.util.List;

import logic.model.User;
import logic.model.bean.LoginBean;
import logic.model.bean.Session;
import logic.model.bean.UserBean;
import logic.model.bean.UserType;
import logic.model.dao.DaoFactory;


//@author Simone e Adriano
public class LoginControl {
	private static final String ID = "%d:%s";
	
	public LoginControl() {
		SimpleLogger.info("LoginControl creato con successo");
	}
	
	//Utilizzato nell'applicazione web
	public String verifyUserWeb(LoginBean bean) {
		
		//Parametri ricevuti
		Integer id = bean.getId();
		String password = bean.getPassword();
		
		User extractedUser;
		
		SimpleLogger.info("[" + id + "] [" + password + "]");
		
		//Cerca tra i professori
		try {
			extractedUser = DaoFactory.getProfessorDao().getFromId(id);
			if(extractedUser.getPassword().equals(password)) {
				return "Professor";
			}
		}catch(NullPointerException e) {
			SimpleLogger.info("Non esiste un professor con questo id");
		}
			
		//Cerca tra gli studenti
		try {
			
			extractedUser = DaoFactory.getStudentDao().getFromId(id);
			if(extractedUser.getPassword().equals(password)) {
				return "Student";
			}
		}
		catch(NullPointerException e) {
			SimpleLogger.info("Non esiste uno student con questo id");
		}	
			
		//Cerca tra i genitori
		try {
			extractedUser = DaoFactory.getParentDao().getFromId(id);
			if(extractedUser.getPassword().equals(password)) {
				return "Parent";
			}
		}
		catch(NullPointerException e) {
			SimpleLogger.info("Non esiste un parent con questo id");
		}

		return "ERROR";
	}
	
	//Utilizzato nell'applicazione standAlone
	public UserBean verifyUser(LoginBean bean) {
		List<User> userList = new ArrayList<>();
		UserBean userSession = null;
		UserType type = null;
		User user = DaoFactory.getProfessorDao().getFromId(bean.getId());
		if(user != null && bean.getPassword().equals(user.getPassword())) {
			type = UserType.PROFESSOR;
			userSession = new UserBean(type, user.getId(), user.getSurname(), user.getName());
			String id = String.format(ID, userSession.getId(), userSession.getName());
			Session.getIstance().addSession(id, userSession);
			userList.add(user);
			return userSession;
		}
		user = DaoFactory.getParentDao().getFromId(bean.getId());
		if(user != null && bean.getPassword().equals(user.getPassword())) {
			type = UserType.PARENT;
			userSession = new UserBean(type, user.getId(), user.getSurname(), user.getName());
			String id = String.format(ID, userSession.getId(), userSession.getName());
			Session.getIstance().addSession(id, userSession);
			userList.add(user);
			return userSession;			
		}
		user = DaoFactory.getStudentDao().getFromId(bean.getId());
		if(user != null && bean.getPassword().equals(user.getPassword())) {
			type = UserType.STUDENT;
			userSession = new UserBean(type, user.getId(), user.getSurname(), user.getName());
			String id = String.format(ID, userSession.getId(), userSession.getName());
			Session.getIstance().addSession(id, userSession);
			userList.add(user);
			return userSession;	
		}
		return userSession;
	}
	
	public void logout(UserBean session) {
		String id = String.format(ID, session.getId(), session.getName());
		Session.getIstance().closeSession(id);
	}
}
