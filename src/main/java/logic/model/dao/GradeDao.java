package logic.model.dao;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import logic.control.SimpleLogger;
import logic.model.ExtendedGrade;
import logic.model.Grade;


//@author Adriano

public class GradeDao implements Dao<Grade> {

	// Name columns table
	private static final String ID = "id" ;
	private static final String STUDENT = "student_id";
	private static final String COURSE = "course_id";
	private static final String COURSENAME = "course.course_name";
	private static final String VALUE = "value";
	private static final String TYPE = "type";
	private static final String DESCRIPTION = "description";
	private static final String DATE = "date";
	
	// SQL statements
	private static final String SELECT_ALL = "SELECT * FROM grade";
	private static final String SELECT_COURSE = "SELECT * FROM grade WHERE course_id = %d";
	private static final String SELECT_STUDENT = "SELECT * FROM grade WHERE student_id = %d";
	private static final String EXTENDED_SELECT_STUDENT = "SELECT course.id, course_name, value, type, description, course FROM grade JOIN student WHERE student_id = %d";
	
	private static final String INSERT = "INSERT INTO grade VALUES (NULL,'%d','%d','%d','%s','%s','%s')";
	private static final String DUMMY_INSERT = "INSERT INTO grade VALUES (NULL,'%d','%d','%d','%s','%s',NULL)";
	private static final String UPDATE = "UPDATE grade SET student_id = '%d', course_id = '%d', value = '%d' , type = '%s' , description = '%s' , date = '%s' WHERE id = '%d'";
	private static final String DELETE = "DELETE FROM grade WHERE id = '%d'";
	
	
	// Error
	private static final String ERROR = "Unable to execute %s: %s";
	
	
	@Override
	public List<Grade> getAll() {
		List<Grade> listGrade = new ArrayList<Grade>();
		
		try (
				Connection c = DaoConnector.getIstance().getConnection();
				Statement stm = c.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY);
				ResultSet rs = stm.executeQuery(SELECT_ALL)
			)
		{
			if(!rs.first()) {
				return listGrade;
			}
			do { 
				//Estrai i valori dal DB
				//Integer studentId = rs.getInt(STUDENT);
				//Integer courseId = rs.getInt(COURSE);
				Integer mark = rs.getInt(VALUE);
				String type = rs.getString(TYPE);
				String description = rs.getString(DESCRIPTION);
				
				//Inizializza un Grade
				Grade grade = new Grade(mark,description,type);
				
				//Aggiungi il Grade alla lista di Grade ottenuti dalla query
				listGrade.add(grade);
				
				
			} while(rs.next()); //Ripeti finchè il resultSet rs contiene tuple
			
		}catch(SQLException e) {
			SimpleLogger.severe(String.format(ERROR, SELECT_ALL, e.getMessage()));
		}
		return listGrade;
	}
	
	
	public void save(Grade t, Integer studentId, Integer classCourseId) {
		//Integer gradeId = NULL;
		Integer student = studentId;
		Integer course = classCourseId;
		Integer value = t.getMark();
		String type = t.getType();
		String description = t.getDescription();
		
		//TODO GESTIRE LA DATA
		String query = String.format(DUMMY_INSERT, student, course, value, type, description);
		
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
	public void save(Grade t) {
		// Ereditato ma non utilizzato
		
	}
	
	@Override
	public void update(Grade t, String[] pkeys) {
		// Ereditato ma non utilizzato
	}

	@Override
	public void delete(Grade t) {
		// Ereditato ma non utilizzato
	}

	
	//Dato un ClassCourse - restituisci TUTTI i voti assegnati a TUTTI gli studenti
	public ArrayList<Grade> getCourseGrades(Integer courseId) {
		ArrayList<Grade> courseGrades = new ArrayList<Grade>();
		String query = String.format(SELECT_COURSE, courseId);

		try (
				Connection c = DaoConnector.getIstance().getConnection();
				Statement stm = c.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY);
				ResultSet rs = stm.executeQuery(query)
			)
		{
			if(!rs.first()) {
				return courseGrades;
			}
			do {				
				//Estrai i valori dal DB
				//Integer studentId = rs.getInt(STUDENT);
				//Integer courseId = rs.getInt(COURSE);
				Integer mark = rs.getInt(VALUE);
				String type = rs.getString(TYPE);
				String description = rs.getString(DESCRIPTION);
				
				//Inizializza un Grade
				Grade grade = new Grade(mark,description,type);
				
				//Aggiungi il Grade alla lista di Grade ottenuti dalla query
				courseGrades.add(grade);
				
				
			} while(rs.next()); //Ripeti finchè il resultSet rs contiene tuple
			
		}catch(SQLException e) {
			SimpleLogger.severe(String.format(ERROR, SELECT_COURSE, e.getMessage()));
		}
		return courseGrades;
	}

	//Restituisci TUTTI i voti assegnati a uno studente - vista dello studente o del genitore
	public ArrayList<Grade> getStudentGrades(Integer studentId) {
		ArrayList<Grade> courseGrades = new ArrayList<Grade>();
		String query = String.format(SELECT_STUDENT, studentId);

		try (
				Connection c = DaoConnector.getIstance().getConnection();
				Statement stm = c.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY);
				ResultSet rs = stm.executeQuery(query)
			)
		{
			if(!rs.first()) {
				return courseGrades;
			}
			do {				
				//Estrai i valori dal DB
				//Integer studentId = rs.getInt(STUDENT);
				//Integer courseId = rs.getInt(COURSE);
				Integer mark = rs.getInt(VALUE);
				String type = rs.getString(TYPE);
				String description = rs.getString(DESCRIPTION);
				
				//Inizializza un Grade
				Grade grade = new Grade(mark,description,type);
				
				//Aggiungi il Grade alla lista di Grade ottenuti dalla query
				courseGrades.add(grade);
				
				
			} while(rs.next()); //Ripeti finchè il resultSet rs contiene tuple
			
		}catch(SQLException e) {
			SimpleLogger.severe(String.format(ERROR, SELECT_STUDENT, e.getMessage()));
		}
		return courseGrades;
	}

	
	//Restituisci TUTTI i voti assegnati a uno studente - versione estesa - vista dello studente o del genitore
		public ArrayList<ExtendedGrade> getAllStudentGrades(Integer studentId) {
			//Inizializza la lista da returnare
			ArrayList<ExtendedGrade> results = new ArrayList<ExtendedGrade>();
			
			//Prepara la query
			String query = String.format(EXTENDED_SELECT_STUDENT, studentId);
			
			
			try (
					Connection c = DaoConnector.getIstance().getConnection();
					Statement stm = c.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY);
					ResultSet rs = stm.executeQuery(query)
				)
			{
				if(!rs.first()) {
					return results;
				}
				do {				
					//Estrai i valori dal DB
					//Integer studentId = rs.getInt(STUDENT);
					//Integer courseId = rs.getInt(COURSE);
					Integer mark = rs.getInt(VALUE);
					String type = rs.getString(TYPE);
					String description = rs.getString(DESCRIPTION);
					String coursename = rs.getString(COURSENAME);
					
					//Inizializza un Grade
					ExtendedGrade grade = new ExtendedGrade(mark,description,type,coursename);
					
					//Aggiungi il Grade alla lista di Grade ottenuti dalla query
					results.add(grade);
					
				} while(rs.next()); //Ripeti finchè il resultSet rs contiene tuple
				
			}catch(SQLException e) {
				SimpleLogger.severe(String.format(ERROR, EXTENDED_SELECT_STUDENT, e.getMessage()));
			}
			return results;
		}
}
