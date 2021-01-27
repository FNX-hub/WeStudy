package logic.model.dao;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import logic.control.SimpleLogger;
import logic.model.ClassCourse;


//@author Adriano
public class ClassCourseDao implements Dao<ClassCourse>{

	
	// Name columns table
	
	private static final String ID = "id";
	private static final String COURSENAME = "course_name";
		
	private static final String COURSEID = "course.id";
	
	// SQL statements
	
	private static final String SELECT_ALL = "SELECT * FROM course";
	private static final String SELECT_BY_PRIMARY_KEY = "SELECT * FROM course WHERE course.id = '%d'";
	private static final String SELECT_BY_PROF_ID = "SELECT * FROM course WHERE professor_id = '%d'";
	private static final String SELECT_BY_STUDENT_ID = "SELECT  course.id, course.course_name  FROM student_course JOIN course WHERE student_id = '%d' AND student_course.course_id = course.id";
	private static final String INSERT = "INSERT INTO course(PROFESSOR_ID, COURSE_NAME) VALUES ('%d','%s')";
	private static final String DELETE = "DELETE FROM course WHERE id = '%d'";
	
	
	// Error message
	
	private static final String ERROR = "Unable to execute %s: %s";
	
	
	//Dato id di uno studente, restituisci TUTTI i corsi di cui fa parte
		public List<ClassCourse> getFromStudentId(Integer studentId){
			List<ClassCourse> courses = new ArrayList<>();
			
			String query = String.format(SELECT_BY_STUDENT_ID,studentId);
			
			try (
					Connection c = DaoConnector.getIstance().getConnection();
					Statement stm = c.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY);
					ResultSet rs = stm.executeQuery(query)
				)
			{
				if(!rs.first()) {
					return courses;
				}
				do { 
					//Estrai i valori dal DB
					Integer id = rs.getInt(ID);
					String subject = rs.getString(COURSENAME);
					
					//Inizializza 
					ClassCourse course = new ClassCourse(subject,id);
					
					//Aggiungilo agli altri ottenuti dalla query
					courses.add(course);
				} while(rs.next()); //Ripeti fino a che il resultSet rs contiene tuple
				
			}catch(SQLException e) {
				SimpleLogger.severe(String.format(ERROR, SELECT_BY_STUDENT_ID, e.getMessage()));
			}
			return courses;
		}
	
	
	//Dato id di un docente, restituisci TUTTI i corsi in cui insegna
	public List<ClassCourse> getFromProfessorId(Integer professorId){
		List<ClassCourse> courses = new ArrayList<>();
		
		String query = String.format(SELECT_BY_PROF_ID,professorId);
		
		try (
				Connection c = DaoConnector.getIstance().getConnection();
				Statement stm = c.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY);
				ResultSet rs = stm.executeQuery(query)
			)
		{
			if(!rs.first()) {
				return courses;
			}
			do { 
				//Estrai i valori dal DB
				Integer id = rs.getInt(ID);
				String subject = rs.getString(COURSENAME);
				
				//Inizializza 
				ClassCourse course = new ClassCourse(subject,id);
				
				//Aggiungilo agli altri ottenuti dalla query
				courses.add(course);
			} while(rs.next()); //Ripeti finchè il resultSet rs contiene tuple
			
		}catch(SQLException e) {
			SimpleLogger.severe(String.format(ERROR, SELECT_BY_PROF_ID, e.getMessage()));
		}
		return courses;
	}
	
	//Restituisci uno specifico ClassCourse in base al suo ID
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
	
	
	//restituisci TUTTI i course presenti
	@Override
	public List<ClassCourse> getAll() {
		List<ClassCourse> courses = new ArrayList<>();
		
		String query = String.format(SELECT_ALL);
		
		try (
				Connection c = DaoConnector.getIstance().getConnection();
				Statement stm = c.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY);
				ResultSet rs = stm.executeQuery(query)
			)
		{
			if(!rs.first()) {
				return courses;
			}
			do { 
				//Estrai i valori dal DB
				Integer id = rs.getInt(ID);
				String subject = rs.getString(COURSENAME);
				
				//Inizializza 
				ClassCourse course = new ClassCourse(subject,id);
				
				//Aggiungilo agli altri ottenuti dalla query
				courses.add(course);
			} while(rs.next()); //Ripeti finchè il resultSet rs contiene tuple
			
		}catch(SQLException e) {
			SimpleLogger.severe(String.format(ERROR, SELECT_BY_PROF_ID, e.getMessage()));
		}
		return courses;
	}

	//Dato un ClassCourse e il suo docente, memorizzali in persistenza
	public void save(ClassCourse course, Integer professorId) {
		String query = String.format(INSERT, professorId, course.getSubject());
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
	
	//Memorizza un nuovo classCourse
	@Override
	public void save(ClassCourse t) {
		SimpleLogger.info("Utilizzata una versione con diversa segnatura");
	}

	
	
	@Override
	public void update(ClassCourse t, String[] pkeys) {
		SimpleLogger.info("Non utilizzato");
		
		
	}
	
	@Override
	public void delete(ClassCourse t) {		
		String s = String.format(DELETE, t.getId());
		try (
				Connection c = DaoConnector.getIstance().getConnection();
				Statement stm = c.createStatement();
			)
		{
			stm.executeUpdate(s);
		} catch (SQLException e) {
			SimpleLogger.severe(String.format(ERROR, s, e.getMessage()));
		}
		
	}
}
