package logic.model.dao;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import logic.control.SimpleLogger;
import logic.model.Student;

public class StudentDao implements Dao<Student> {

	private static final String ID = "id";
	private static final String SURNAME = "surname";
	private static final String NAME = "name";
	private static final String PASSWORD = "password";
	private static final String PARENT_ID = "parent_id";
	
	// SQL statements
	
	private static final String SELECT = "SELECT * FROM studnet";
	private static final String SELECT_BY_ID = "SELECT * FROM student WHERE id = '%s'";
	private static final String INSERT = "INSERT INTO student VALUES (%s,'%s','%s', '%s', '%s')";
	private static final String UPDATE = "UPDATE studnet SET id = '%s', surname = '%s', name = '%s', password = '%s', parent_id = '%s' WHERE id = '%s'";
	private static final String DELETE = "DELETE FROM student WHERE id = '%s'";
	
	// Error message
	
	private static final String ERROR = "Unable to execute %s: %s";
	
	@Override
	public List<Student> getAll() {
		List<Student> listStudent = new ArrayList<>();
		try (
				Connection c = DaoConnector.getIstance().getConnection();
				Statement stm = c.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY);
				ResultSet rs = stm.executeQuery(SELECT)
			)
		{
			if(!rs.first()) {
				return listStudent;
			}
			do {
				Student s = new Student(rs.getString(ID), rs.getString(SURNAME), rs.getString(NAME), rs.getString(PASSWORD), rs.getString(PARENT_ID));
				listStudent.add(s);
			} while(rs.next());
		} catch (SQLException e) {
			SimpleLogger.severe(String.format(ERROR, SELECT, e.getMessage()));
		}
		return listStudent;
	}
	public Student getFromId(String id) {
		String s = String.format(SELECT_BY_ID, id);
		Student st = null;
		try (
				Connection c = DaoConnector.getIstance().getConnection();
				Statement stm = c.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY);
				ResultSet rs = stm.executeQuery(s)
			)
		{
			if(!rs.first()) {
				return st;
			}
			 st = new Student(rs.getString(ID), rs.getString(SURNAME), rs.getString(NAME), rs.getString(PASSWORD), rs.getString(PARENT_ID));
		} catch (SQLException e) {
			SimpleLogger.severe(String.format(ERROR, s, e.getMessage()));
		}
		return st;
	}
	
	// CRUD operation
	
	@Override
	public void save(Student t) {
		String s = String.format(INSERT, t.getId(), t.getSurname(), t.getName(), t.getPassword(), t.getParentId());
		try (
				Connection c = DaoConnector.getIstance().getConnection();
				Statement stm = c.createStatement();
			)
		{
			stm.executeUpdate(s);
			SimpleLogger.info(String.format("Insert: %s", t.toString()));
		} catch (SQLException e) {
			SimpleLogger.severe(String.format(ERROR, s, e.getMessage()));
		}		
	}
	@Override
	public void update(Student t, String[] params) {
		String s = String.format(UPDATE, t.getId(), t.getSurname(), t.getName(), t.getPassword(), t.getParentId(), params[0]);
		if(params.length != 1) throw new IllegalArgumentException("Number of params must be 1");
		try (
				Connection c = DaoConnector.getIstance().getConnection();
				Statement stm = c.createStatement();
			)
		{
			stm.executeUpdate(s);
			SimpleLogger.info(String.format("Update: %s", t.toString()));
		}
		catch (SQLException e) {
			SimpleLogger.severe(String.format(ERROR, s, e.getMessage()));
		} catch (IllegalArgumentException e2) {
			SimpleLogger.severe(e2.getMessage());
		}
	}
	@Override
	public void delete(Student t) {
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
