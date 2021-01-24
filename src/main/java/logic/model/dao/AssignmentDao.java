package logic.model.dao;

import java.sql.Connection;
import java.sql.Date;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import logic.control.SimpleLogger;
import logic.model.Assignment;
import logic.model.ExtendedAssignment;

//@author Adriano
public class AssignmentDao implements Dao<Assignment> {

	// Name columns table
	
	private static final String ID = "id";
	private static final String COURSE = "course_id";
	private static final String DELIVERYDATE = "delivery_date";
	private static final String CREATIONDATE = "creation_date";
	private static final String TYPE = "type";
	private static final String DESCRIPTION = "description";
	private static final String COURSENAME = "course.course_name";
		
	// SQL statements
		
	private static final String SELECT_ALL = "SELECT * FROM assignment";
	//private static final String SELECT_BY_PRIMARY_KEY = "SELECT * FROM assignment WHERE id = '%d'";
	private static final String INSERT = "INSERT INTO assignment (course_id,delivery_date,creation_date,type,description) VALUES ('%d','%s','%s','%s','%s')";	
	private static final String SELECT_CLASSCOURSE = "SELECT * FROM assignment WHERE course_id = '%d'";
	private static final String SELECT_STUDENT = "SELECT * FROM student_course JOIN course WHERE student_course.student_id = '%d'";
	//private static final String UPDATE = "UPDATE assignment SET id = '%d', surname = '%s', name = '%s', password = '%s', phone_number = '%s' WHERE id = '%s'";
	//private static final String DELETE = "DELETE FROM assignment WHERE id = '%d'";
		
	// Error message
		
	private static final String ERROR = "Unable to execute %s: %s";
	
	@Override
	public List<Assignment> getAll() {
		List<Assignment> listAssignment = new ArrayList<>();
		try (
				Connection c = DaoConnector.getIstance().getConnection();
				Statement stm = c.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY);
				ResultSet rs = stm.executeQuery(SELECT_ALL)
			)
		{
			if(!rs.first()) {
				return listAssignment;
			}
			do {
				
				String type = rs.getString(TYPE);
				String description = rs.getString(DESCRIPTION);
				Date creationDate = rs.getDate(CREATIONDATE);
				Date deliveryDate = rs.getDate(DELIVERYDATE);

				
				Assignment assignment = new ExtendedAssignment(type, description, creationDate, deliveryDate);
				
				listAssignment.add(assignment);
			} while(rs.next());
		} catch (SQLException e) {
			SimpleLogger.severe(String.format(ERROR, SELECT_ALL, e.getMessage()));
		}
		return listAssignment;
	}

	
	public void save(Assignment t, Integer classCourseId) {

		//Valori da inserire
		Date deliveryDate = t.getDeadlineDate();
		Date creationDate = t.getCreationDate();
		String type = t.getType();
		String description = t.getDescription();
		
		//Creazione query
		String query = String.format(INSERT, classCourseId, deliveryDate, creationDate, type, description);
		
		
		try (
				Connection c = DaoConnector.getIstance().getConnection();
				Statement stm = c.createStatement();
			)
		{
			stm.executeUpdate(query);
		} catch (SQLException e) {
			SimpleLogger.severe(String.format(ERROR, query, e.getMessage()));
		}
		
	}
	
	@Override
	public void save(Assignment t) {
		//Non utilizzabile - applicato overloading
	}

	@Override
	public void update(Assignment t, String[] pkeys) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void delete(Assignment t) {
		// TODO Auto-generated method stub
	}
	
	
	//Dato id di un corso, restituisci TUTTI i suoi assignment
	public List<ExtendedAssignment> getCourseAssignment(Integer idClassCourse){
		String query = String.format(SELECT_CLASSCOURSE, idClassCourse);
		List<ExtendedAssignment> results = new ArrayList<ExtendedAssignment>();
		
		try (
				Connection c = DaoConnector.getIstance().getConnection();
				Statement stm = c.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY);
				ResultSet rs = stm.executeQuery(query)
			)
		{
			if(!rs.first()) {
				results = null;
				return results;
			}
			do {
				String type = rs.getString(TYPE);
				String description = rs.getString(DESCRIPTION);
				Date creationDate = rs.getDate(CREATIONDATE);
				Date deadlineDate = rs.getDate(DELIVERYDATE);
				
				ExtendedAssignment assignment = new ExtendedAssignment(type,description,creationDate,deadlineDate);
				
				results.add(assignment);
			}while(rs.next());
			
		} catch (SQLException e) {
			SimpleLogger.severe(String.format(ERROR, query, e.getMessage()));
			results = null;
		}
		return results;
	}
	
	//Dato id di uno studente, restituisci TUTTI gli assignment che lo riguardano
	public List<ExtendedAssignment> getStudentAssignment(Integer studentId){
		String query = String.format(SELECT_STUDENT, studentId);
		List<ExtendedAssignment> results = new ArrayList<ExtendedAssignment>();
		
		try (
				Connection c = DaoConnector.getIstance().getConnection();
				Statement stm = c.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY);
				ResultSet rs = stm.executeQuery(query)
			)
		{
			if(!rs.first()) {
				results = null;
				return results;
			}
			do {
				String type = rs.getString(TYPE);
				String description = rs.getString(DESCRIPTION);
				Date creationDate = rs.getDate(CREATIONDATE);
				Date deadlineDate = rs.getDate(DELIVERYDATE);
				String courseName = rs.getString(COURSENAME);
				
				ExtendedAssignment assignment = new ExtendedAssignment(type,description,creationDate,deadlineDate,courseName);
				
				results.add(assignment);
			}while(rs.next());
			
		} catch (SQLException e) {
			SimpleLogger.severe(String.format(ERROR, query, e.getMessage()));
			results = null;
		}
		return results;
	}
}
