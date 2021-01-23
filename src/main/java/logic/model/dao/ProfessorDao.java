package logic.model.dao;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import logic.control.SimpleLogger;
import logic.model.Professor;

public class ProfessorDao implements Dao<Professor> {

	// Name columns table
	
	private static final String ID = "id";
	private static final String SURNAME = "surname";
	private static final String NAME = "name";
	private static final String PASSWORD = "password";
	
	// SQL statements
	
	private static final String SELECT_ALL = "SELECT * FROM professor";
	private static final String SELECT_BY_PRIMARY_KEY = "SELECT * FROM professor WHERE id = '%d'";
	private static final String INSERT = "INSERT INTO professor VALUES ('%d','%s','%s', '%s')";
	private static final String UPDATE = "UPDATE professor SET id = %d, surname = '%s', name = '%s', password = '%s' WHERE id = '%s'";
	private static final String DELETE = "DELETE FROM professor WHERE id = %d";
	
	// Error message
	
	private static final String ERROR = "Unable to execute %s: %s";
				
	@Override
	public List<Professor> getAll(){
		List<Professor> listProfessor = new ArrayList<>();
		try (
				Connection c = DaoConnector.getIstance().getConnection();
				Statement stm = c.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY );
				ResultSet rs = stm.executeQuery(SELECT_ALL)
			)
		{
			if(!rs.first()) {
				return listProfessor;
			}
			do {
				Professor p = new Professor(rs.getInt(ID), rs.getString(SURNAME), rs.getString(NAME), rs.getString(PASSWORD));
				listProfessor.add(p);
			} while(rs.next());
		} catch (SQLException e) {
			SimpleLogger.severe(String.format(ERROR, SELECT_ALL, e.getMessage()));
		}
		return listProfessor;
	}
	public Professor getFromId(Integer id) {
		String query = String.format(SELECT_BY_PRIMARY_KEY, id);
		Professor prof = null;
		try (
				Connection c = DaoConnector.getIstance().getConnection();
				Statement stm = c.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY);
				ResultSet rs = stm.executeQuery(query)
			)
		{
			if(!rs.first()) {
				return prof;
			}
			 prof = new Professor(rs.getInt(ID), rs.getString(SURNAME), rs.getString(NAME), rs.getString(PASSWORD));
		} catch (SQLException e) {
			SimpleLogger.severe(String.format(ERROR, query, e.getMessage()));
		}
		return prof;
	}
	
	// CRUD operation
	
	@Override
	public void save(Professor t) {
		String query = String.format(INSERT, t.getId(), t.getSurname(), t.getName(), t.getPassword());
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
	public void update(Professor t, String[] params) {
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
	public void delete(Professor t) {
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
