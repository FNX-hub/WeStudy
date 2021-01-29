package logic.model.dao;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import logic.control.SimpleLogger;
import logic.model.Assignment;
import logic.model.OralAssignment;
import logic.model.ProjectAssignment;
import logic.model.WrittenAssignment;

//@author Adriano
public class AssignmentDao implements Dao<Assignment> {

	// Name columns table
	private static final String DELIVERYDATE = "delivery_date";
	private static final String CREATIONDATE = "creation_date";
	private static final String TYPE = "type";
	private static final String DESCRIPTION = "description";
		
	// SQL statements
		
	private static final String SELECT_ALL = "SELECT * FROM assignment";
	private static final String INSERT = "INSERT INTO assignment (course_id,delivery_date,creation_date,type,description) VALUES ('%d','%s','%s','%s','%s')";	
	private static final String SELECT_CLASSCOURSE = "SELECT * FROM assignment WHERE course_id = '%d'";
	
	
	// Error message
	private static final String ERROR = "Unable to execute %s: %s";
	
	//Restituisci TUTTI gli Assignment memorizzati nel database
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
				LocalDate creationDate = rs.getDate(CREATIONDATE).toLocalDate();
				LocalDate deliveryDate = rs.getDate(DELIVERYDATE).toLocalDate();

				Assignment assignment;
				
				switch(type) {
					case "ORAL":
						assignment = new OralAssignment(type, description, creationDate, deliveryDate);
						break;
					case "WRITTEN":
						assignment = new WrittenAssignment(type, description, creationDate, deliveryDate);
						break;
					case "PROJECT":
						assignment = new ProjectAssignment(type, description, creationDate, deliveryDate);
						break;
					default:
						assignment = null;
						break;
				}
				
				listAssignment.add(assignment);
				
				
			} while(rs.next());
		} catch (SQLException e) {
			SimpleLogger.severe(String.format(ERROR, SELECT_ALL, e.getMessage()));
		}
		return listAssignment;
	}


	//memorizza un assignment nel database, richiede di conoscere la PK del ClassCourse
	public void save(Assignment t, Integer classCourseId) {
		//Valori da inserire
		LocalDate deliveryDate = t.getDeadlineDate();
		LocalDate creationDate = t.getCreationDate();
		String type = t.getType();
		String description = t.getDescription();
		
		//Creazione query
		String query = String.format(INSERT,classCourseId, deliveryDate, creationDate, type, description);
		
		
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
		SimpleLogger.info("Utilizzata una versione con diversa segnatura");
	}

	@Override
	public void update(Assignment t, String[] pkeys) {
		SimpleLogger.info("Ereditato ma non utilizzato");
	}

	@Override
	public void delete(Assignment t) {
		SimpleLogger.info("Ereditato ma non utilizzato");
		
	}
	
	
	//Dato id di un corso, restituisci TUTTI i suoi assignment
	public List<Assignment> getCourseAssignment(Integer idClassCourse){
		String query = String.format(SELECT_CLASSCOURSE, idClassCourse);
		List<Assignment> results = new ArrayList<>();
		
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
				LocalDate creationDate = rs.getDate(CREATIONDATE).toLocalDate();
				LocalDate deadlineDate = rs.getDate(DELIVERYDATE).toLocalDate();
				
				Assignment assignment;
				
				switch(type) {
				case "ORAL":
					assignment = new OralAssignment(type, description, creationDate, deadlineDate);
					break;
				case "WRITTEN":
					assignment = new WrittenAssignment(type, description, creationDate, deadlineDate);
					break;
				case "PROJECT":
					assignment = new ProjectAssignment(type, description, creationDate, deadlineDate);
					break;
				default:
					assignment = null;
					break;
			}
				
				results.add(assignment);
				
			}while(rs.next());
			 
		} catch (SQLException e) {
			SimpleLogger.severe(String.format(ERROR, query, e.getMessage()));
			results = null;
		}
		return results;
	}
}
