package logic.model.bean;

import java.util.HashMap;
import java.util.Map;


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
	
	public void addSession(String id, UserBean value) {
		map.put(id, value);
	}
	
	public UserBean getSessionById(String id) {
		return map.get(id);
	}
	
	public void closeSession(String id) {
		map.remove(id);
	}
}
