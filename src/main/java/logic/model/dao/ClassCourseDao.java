package logic.model.dao;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.List;

import logic.control.SimpleLogger;
import logic.model.ClassCourse;
import logic.model.Parent;


//@author Adriano
public class ClassCourseDao implements Dao<ClassCourse>{

	
	// Name columns table
	
	private static final String ID = "id";
	//private static final String PROFESSOR = "professor_id";
	private static final String COURSENAME = "course_name";
		
	private static final String COURSEID = "course.id";
	//private static final String PROFNAME = "professor.name";
	//private static final String PROFSURNAME = "professor.surname";
	
	// SQL statements
	
	//private static final String SELECT_ALL = "SELECT * FROM course";
	private static final String SELECT_BY_PRIMARY_KEY = "SELECT * FROM course WHERE course.id = '%d'";
	//private static final String EXTENDED_SELECT_BY_PRIMARY_KEY = "SELECT * FROM course JOIN professor WHERE course.id = '%d'";
	//private static final String INSERT = "INSERT INTO course VALUES ('%d','%s','%s', '%s', '%s')";
	//private static final String UPDATE = "UPDATE course SET id = '%d', surname = '%s', name = '%s', password = '%s', phone_number = '%s' WHERE id = '%s'";
	private static final String DELETE = "DELETE FROM course WHERE id = '%d'";
	
	
	// Error message
		
	private static final String ERROR = "Unable to execute %s: %s";
	
	
	@Override
	public List<ClassCourse> getAll() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void save(ClassCourse t) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void update(ClassCourse t, String[] pkeys) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void delete(ClassCourse t) {
		String query = String.format(DELETE, t.getId());
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

	public ClassCourse getFromId(Integer classCourse) {

		String query = String.format(SELECT_BY_PRIMARY_KEY, classCourse);
		ClassCourse course = null;
		try (
				Connection c = DaoConnector.getIstance().getConnection();
				Statement stm = c.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY);
				ResultSet rs = stm.executeQuery(query)
			)
		{
			if(!rs.first()) {
				return course;
			}
			
			//Parametri ricevuti
			Integer courseId = rs.getInt(COURSEID);
			String subject = rs.getString(COURSENAME);
			
			course = new ClassCourse(subject, courseId);
		} catch (SQLException e) {
			SimpleLogger.severe(String.format(ERROR, query, e.getMessage()));
		}
		return course;

	}

}
