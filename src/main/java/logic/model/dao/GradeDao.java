package logic.model.dao;

import java.sql.Connection;
import java.sql.Date;
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
	private static final String STUDENT = "student.id";
	private static final String COURSE = "course_id";
	private static final String COURSENAME = "course.course_name";
	private static final String VALUE = "value";
	private static final String TYPE = "type";
	private static final String DESCRIPTION = "description";
	private static final String DATE = "date";
	private static final String STUDENTNAME = "student.name";
	private static final String STUDENTSURNAME = "student.surname";
	
	// SQL statements
	private static final String SELECT_ALL = "SELECT * FROM grade";
	private static final String SELECT_COURSE = "SELECT * FROM grade WHERE course_id = %d";
	private static final String SELECT_STUDENT = "SELECT * FROM grade WHERE student_id = %d";
	private static final String EXTENDED_SELECT_STUDENT = "SELECT course.course_name, value, type, description, date FROM course JOIN grade JOIN student WHERE student_id = '%d' AND course.id = grade.course_id AND grade.student_id = student.id";
	private static final String EXTENDED_SELECT_COURSE = "SELECT student.id, student.name, student.surname, value, type, description, date FROM student JOIN grade WHERE course_id = '%d' AND student.id = grade.student_id ORDER BY student.name, value";
	//SELECT student.id, student.name, student.surname, value, type, description, date FROM student JOIN grade WHERE course_id = 1 AND student.id = grade.student_id ORDER BY student.name, value;
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
	
	
	//Memorizza nella persistenza un grade, La data viene automaticamente calcolata dal DBMS
	public void save(Grade t, Integer studentId, Integer classCourseId) {
		//Integer gradeId = NULL;
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
	
	
	
	//Dato un ClassCourse - restituisci TUTTI i voti assegnati a TUTTI gli studenti - versione estesa
		public List<ExtendedGrade> getExtendedCourseGrades(Integer courseId) {
			List<ExtendedGrade> courseGrades = new ArrayList<ExtendedGrade>();
			
			
			String query = String.format(EXTENDED_SELECT_COURSE, courseId);

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
					
					/*
					 * private static final String EXTENDED_SELECT_COURSE = 
					 * "SELECT student.name, student.surname, value, type, description, 
					 * date FROM student JOIN grade WHERE course = %d";
					*/
					
					
					//Estrai i valori dal DB
					Integer studentId = rs.getInt(STUDENT);
					//Integer courseId = rs.getInt(COURSE);
					Integer mark = rs.getInt(VALUE);
					String type = rs.getString(TYPE);
					String description = rs.getString(DESCRIPTION);
					String name = rs.getString(STUDENTNAME);
					String surname = rs.getString(STUDENTSURNAME);
					Date date = rs.getDate(DATE);
					//Inizializza un Grade
					ExtendedGrade grade = new ExtendedGrade(mark,description,type,name,surname,date,studentId);
					
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
		public ArrayList<ExtendedGrade> getExtendedStudentGrades(Integer studentId) {
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
					
					//course.course_name, value, type, description, date 
					String coursename = rs.getString(COURSENAME);
					Integer mark = rs.getInt(VALUE);
					String type = rs.getString(TYPE);
					String description = rs.getString(DESCRIPTION);
					Date date = rs.getDate(DATE);
					
					//Inizializza un Grade	
					ExtendedGrade grade = new ExtendedGrade(mark,description,type,coursename, date);
					
					//Aggiungi il Grade alla lista di Grade ottenuti dalla query
					results.add(grade);
					
				} while(rs.next()); //Ripeti finchè il resultSet rs contiene tuple
				
			}catch(SQLException e) {
				SimpleLogger.severe(String.format(ERROR, EXTENDED_SELECT_STUDENT, e.getMessage()));
			}
			return results;
		}



}
