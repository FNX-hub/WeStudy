package logic.model.dao;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import logic.model.UserType;


/**
 * @author Simone
 */
public class UserDao implements Dao {
	
	private static final String ID = "id";
	private static final String PARENT_ID = "parent_id";
	private static final String PASSWORD = "password";
	private static final String TYPE = "type";
	private static final String NAME = "name";
	private static final String SURNAME = "surname";
	private static final String QUERY = "SELECT * FROM %s WHERE id = %s";
	
	public List<HashMap<String,String>> getParent() {
		return sqlToJava("SELECT * FROM parent");
	}
	public List<HashMap<String,String>> getProfessors() {
		return sqlToJava("SELECT * FROM professor");		
	}
	public List<HashMap<String,String>> getStudents() {
		return sqlToJava("SELECT * FROM student");		
	}
	
	
	
	/**
	 * Try to query the DB to verify if the given user is valid
	 * 
	 * @param username String
	 * @param password String
	 * @return A {@link List}{@code <String>} with:
	 * <ol>
	 * <li>{@code userId}
	 * <li>{@link UserType}
	 * </ol>
	 * Or an empty {@link List}
	 */
	public List<String> verifyUser(String username, String password) {
		List<HashMap<String, String>> table = sqlToJava("CALL `getUsers`()");
		List<String> s = null;
		for(HashMap<String, String> m : table) {
			if(m.get(ID).equals(username) && m.get(PASSWORD).equals(password)) {
				s = new ArrayList<>();
				s.add(m.get(ID));
				s.add(m.get(TYPE));
				break;
			}
		}
		return s;
	}
	
	/**
	 * Try to query the DB to get the {@code user} given its {@code id}
	 * 
	 * @param userId String
	 * @param userType UserType
	 * @return A {@link List}{@code <String>} with the user information:
	 * <ol>
	 * <li> user id 
	 * <li> user surname 
	 * <li> user name 
	 * <li> user password
	 * <br> if {@link UserType} = {@code STUDENT} 
	 * <li> parent id
	 */
	public List<String> getUserFromId(String userId, UserType userType) {
		List<HashMap<String,String>> table = sqlToJava(String.format(QUERY, userType, userId));
		List<String> s = null;
		if(!table.isEmpty()) {
			s = new ArrayList<>();
			s.add(table.get(0).get(ID));
			s.add(table.get(0).get(SURNAME));
			s.add(table.get(0).get(NAME));
			s.add(table.get(0).get(PASSWORD));
			if(userType.equals(UserType.STUDENT)) {
				s.add(table.get(0).get(PARENT_ID));
			}
		}
		return s;
	}
}