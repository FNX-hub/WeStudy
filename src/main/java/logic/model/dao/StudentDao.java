package logic.model.dao;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import logic.control.SimpleLogger;
import logic.model.Student;

//@author Adriano e Simone
public class StudentDao implements Dao<Student> {

	private static final String ID = "id";
	private static final String SURNAME = "surname";
	private static final String NAME = "name";
	private static final String PASSWORD = "password";
	private static final String PARENT_ID = "parent_id";
	
	// SQL statements
	
	private static final String SELECT_ALL = "SELECT * FROM student";
	private static final String SELECT_BY_PRIMARY_KEY = "SELECT * FROM student WHERE id = '%d'";
	private static final String SELECT_BY_PARENT_ID = "SELECT * FROM student WHERE parent_id = '%d'";
	private static final String INSERT = "INSERT INTO student VALUES ('%d','%s','%s', '%s', '%d')";
	private static final String UPDATE = "UPDATE student SET id = '%d', surname = '%s', name = '%s', password = '%s' WHERE id = '%s'";
	private static final String DELETE = "DELETE FROM student WHERE id = '%d'";
	private static final String SELECT_STUDENDS_BY_COURSE_ID = "SELECT student.id, student.name, student.surname, student.password, student.id, student.parent_id, student_course.course_id FROM student_course JOIN student WHERE student_course.course_id = '%d' AND student_course.student_id = student.id";

	// Error message
	private static final String ERROR = "Unable to execute %s: %s";
	
	
	public List<Student> getFromCourseId(Integer courseId){
		List<Student> listStudent = new ArrayList<>();
		String query = String.format(SELECT_STUDENDS_BY_COURSE_ID, courseId);
		try (
				Connection c = DaoConnector.getIstance().getConnection();
				Statement stm = c.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY);
				ResultSet rs = stm.executeQuery(query)
			)
		{
			if(!rs.first()) {
				SimpleLogger.info("DEBUG: query restituisce 0 tuple");
				return listStudent;
			}
			do {
				SimpleLogger.info("DEBUG: ottenuto student con id: "+ rs.getInt(ID));
				Student s = new Student(rs.getInt(ID), rs.getString(SURNAME), rs.getString(NAME), rs.getString(PASSWORD), rs.getInt(PARENT_ID));
				listStudent.add(s);
			} while(rs.next());
		} catch (SQLException e) {
			SimpleLogger.severe(String.format(ERROR, SELECT_STUDENDS_BY_COURSE_ID, e.getMessage()));
		}
		return listStudent;
	}
	
	
	@Override
	public List<Student> getAll() {
		List<Student> listStudent = new ArrayList<>();
		try (
				Connection c = DaoConnector.getIstance().getConnection();
				Statement stm = c.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY);
				ResultSet rs = stm.executeQuery(SELECT_ALL)
			)
		{
			if(!rs.first()) {
				return listStudent;
			}
			do {
				Student s = new Student(rs.getInt(ID), rs.getString(SURNAME), rs.getString(NAME), rs.getString(PASSWORD), rs.getInt(PARENT_ID));
				listStudent.add(s);
			} while(rs.next());
		} catch (SQLException e) {
			SimpleLogger.severe(String.format(ERROR, SELECT_ALL, e.getMessage()));
		}
		return listStudent;
	}
	public Student getFromId(Integer id) {
		String query = String.format(SELECT_BY_PRIMARY_KEY, id);
		Student std = null;
		try (
				Connection c = DaoConnector.getIstance().getConnection();
				Statement stm = c.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY);
				ResultSet rs = stm.executeQuery(query)
			)
		{
			if(!rs.first()) {
				return std;
			}
			 std = new Student(rs.getInt(ID), rs.getString(SURNAME), rs.getString(NAME), rs.getString(PASSWORD), rs.getInt(PARENT_ID));
		} catch (SQLException e) {
			SimpleLogger.severe(String.format(ERROR, query, e.getMessage()));
		}
		return std;
	}
	
	public List<Student> getFromParentId(Integer id) {
		String query = String.format(SELECT_BY_PARENT_ID, id);
		List<Student> listStudent = new ArrayList<>();
		try (
				Connection c = DaoConnector.getIstance().getConnection();
				Statement stm = c.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY);
				ResultSet rs = stm.executeQuery(query)
				)
		{
			if(!rs.first()) {
				return listStudent;
			}
			do {
				Student std = new Student(rs.getInt(ID), rs.getString(SURNAME), rs.getString(NAME), rs.getString(PASSWORD), rs.getInt(PARENT_ID));
				listStudent.add(std);
			} while(rs.next());
		} catch (SQLException e) {
			SimpleLogger.severe(String.format(ERROR, query, e.getMessage()));
		}
		return listStudent;
	}
	
	// CRUD operation
	
	@Override
	public void save(Student t) {
		String query = String.format(INSERT, t.getId(), t.getSurname(), t.getName(), t.getPassword(), t.getParentId());
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
	public void update(Student t, String[] params) {
		String query = String.format(UPDATE, t.getId(), t.getSurname(), t.getName(), t.getPassword(), params[0]);
		try (
				Connection c = DaoConnector.getIstance().getConnection();
				Statement stm = c.createStatement();
			)
		{
			stm.executeUpdate(query);
		}
		catch (SQLException e) {
			SimpleLogger.severe(String.format(ERROR, query, e.getMessage()));
		}
	}
	@Override
	public void delete(Student t) {
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

}
