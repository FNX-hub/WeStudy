package logic.control;

import java.util.ArrayList;
import java.util.List;

import logic.model.User;
import logic.model.bean.LoginBean;
import logic.model.bean.Session;
import logic.model.dao.DaoFactory;


//@author Simone e Adriano
public class LoginControl {
	
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
	public String verifyUser(LoginBean bean) {
		List<User> userList = new ArrayList<>();
		userList.add(DaoFactory.getProfessorDao().getFromId(bean.getId()));
		userList.add(DaoFactory.getParentDao().getFromId(bean.getId()));
		userList.add(DaoFactory.getStudentDao().getFromId(bean.getId()));
		for(User user : userList) {
			if(user.getPassword().equals(bean.getPassword())) {
				String session = String.format("%d:%s", user.getId(), user.getName());
				Session.getIstance().addSession(session, user);
				return session;
			}
		}
		return null;
	}
}
