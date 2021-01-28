package logic.model.bean;

import java.util.HashMap;
import java.util.Map;

import logic.model.Professor;
import logic.model.Student;
import logic.model.User;


/**
 * @author Simone
 */
public class Session {
	private static Session istance = new Session();
	private Map<String, UserBean> map;
	
	private Session() {
		this.map = new HashMap<>();
	}
	
	public static Session getIstance() {
		return istance;
	}
	
	public void addSession(String id, User value) {
		if(value.getClass().equals(Professor.class)) {
			map.put(id, new UserBean(UserType.PROFESSOR, value.getId(), value.getSurname()));
		}
		else if(value.getClass().equals(Student.class)) {
			map.put(id, new UserBean(UserType.STUDENT, value.getId(), value.getSurname()));
		}
		else map.put(id, new UserBean(UserType.PARENT, value.getId(), value.getSurname()));
	}
	
	public UserBean getSessionById(String id) {
		return map.get(id);
	}
}
