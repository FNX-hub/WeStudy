package logic.model.dao;

import java.sql.Connection;
import java.sql.Date;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import logic.control.SimpleLogger;
import logic.model.Grade;


//@author Adriano

public class GradeDao implements Dao<Grade> {

	// Name columns table
	private static final String VALUE = "value";
	private static final String TYPE = "type";
	private static final String DESCRIPTION = "description";
	private static final String DATE = "date";
	
	// SQL statements
	private static final String SELECT_ALL = "SELECT * FROM grade";
	private static final String SELECT_COURSE = "SELECT * FROM grade WHERE course_id = %d";
	private static final String SELECT_STUDENT = "SELECT * FROM grade WHERE student_id = %d";
	private static final String SELECT_STUDENT_COURSE = "SELECT * FROM grade WHERE student_id = %d AND course_id = %d";
	private static final String DUMMY_INSERT = "INSERT INTO grade VALUES (NULL,'%d','%d','%d','%s','%s',NULL)";
	
	
	
	// Error
	private static final String ERROR = "Unable to execute %s: %s";
	
	
	//Restituisci TUTTI i Grade presenti nel database
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
				Integer mark = rs.getInt(VALUE);
				String type = rs.getString(TYPE);
				String description = rs.getString(DESCRIPTION);
				Date databaseDate = rs.getDate(DATE);
				
				//Inizializza un Grade - NB la responsabilita' di associarlo al corretto ClassCourse NON appartiene a questa DAO
				Grade grade = new Grade(mark, databaseDate,description,type);
				
				//Aggiungi il Grade alla lista di Grade ottenuti dalla query
				listGrade.add(grade);
				
				
			} while(rs.next()); //Ripeti finchè il resultSet rs contiene tuple
			
		}catch(SQLException e) {
			SimpleLogger.severe(String.format(ERROR, SELECT_ALL, e.getMessage()));
		}
		return listGrade;
	}
	
	
	//Memorizza nella persistenza un grade, La data viene automaticamente calcolata dal DBMS
	public void save(Grade t, Integer studentId, Integer classCourseId) {
		Integer student = studentId;
		Integer course = classCourseId;
		Integer value = t.getMark();
		String type = t.getType();
		String description = t.getDescription();
		
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
		SimpleLogger.info("utilizzato un metodo con differente segnatura");
	}
	
	@Override
	public void update(Grade t, String[] pkeys) {
		SimpleLogger.info("operazione non prevista");
	}

	@Override
	public void delete(Grade t) {
		SimpleLogger.info("operazione non prevista");
	}

	
	
	//Dato uno Student e un ClassCourse - restituisci i voti di quello Student in quel ClassCourse
	public List<Grade> getStudentCourseGrades(Integer courseId, Integer studentId){
		List<Grade> courseGrades = new ArrayList<Grade>();
		String query = String.format(SELECT_STUDENT_COURSE, studentId, courseId);

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
				Integer mark = rs.getInt(VALUE);
				String type = rs.getString(TYPE);
				String description = rs.getString(DESCRIPTION);
				Date databaseDate = rs.getDate(DATE);
				
				//Inizializza un Grade - NB la responsabilita' di associarlo al corretto ClassCourse NON appartiene a questa DAO
				Grade grade = new Grade(mark, databaseDate,description,type);
				
				//Aggiungi il Grade alla lista di Grade ottenuti dalla query
				courseGrades.add(grade);
				
				
			} while(rs.next()); //Ripeti finchè il resultSet rs contiene tuple
			
		}catch(SQLException e) {
			SimpleLogger.severe(String.format(ERROR, SELECT_COURSE, e.getMessage()));
		}
		return courseGrades;
	}
	
	
	//Dato un ClassCourse - restituisci TUTTI i voti assegnati a TUTTI gli studenti
	public List<Grade> getCourseGrades(Integer courseId) {
		List<Grade> courseGrades = new ArrayList<Grade>();
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
				Integer mark = rs.getInt(VALUE);
				String type = rs.getString(TYPE);
				String description = rs.getString(DESCRIPTION);
				Date databaseDate = rs.getDate(DATE);
				
				//Inizializza un Grade - NB la responsabilita' di associarlo al corretto ClassCourse NON appartiene a questa DAO
				Grade grade = new Grade(mark, databaseDate,description,type);
				
				//Aggiungi il Grade alla lista di Grade ottenuti dalla query
				courseGrades.add(grade);
				
				
			} while(rs.next()); //Ripeti finchè il resultSet rs contiene tuple
			
		}catch(SQLException e) {
			SimpleLogger.severe(String.format(ERROR, SELECT_COURSE, e.getMessage()));
		}
		return courseGrades;
	}
	
	
	
	
	

	//Restituisci TUTTI i voti assegnati a uno studente - vista dello studente o del genitore
	public List<Grade> getStudentGrades(Integer studentId) {
		List<Grade> courseGrades = new ArrayList<Grade>();
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
				Integer mark = rs.getInt(VALUE);
				String type = rs.getString(TYPE);
				String description = rs.getString(DESCRIPTION);
				Date databaseDate = rs.getDate(DATE);
				
				//Inizializza un Grade - NB la responsabilita' di associarlo al corretto ClassCourse NON appartiene a questa DAO
				Grade grade = new Grade(mark, databaseDate,description,type);
				
				//Aggiungi il Grade alla lista di Grade ottenuti dalla query
				courseGrades.add(grade);
				
				
			} while(rs.next()); //Ripeti fino a che il resultSet rs contiene tuple
			
		}catch(SQLException e) {
			SimpleLogger.severe(String.format(ERROR, SELECT_STUDENT, e.getMessage()));
		}
		return courseGrades;
	}


}
