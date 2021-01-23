package logic.model.dao;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import logic.control.SimpleLogger;
import logic.model.Parent;

public class ParentDao implements Dao<Parent> {

	// Name columns table
	
	private static final String ID = "id";
	private static final String SURNAME = "surname";
	private static final String NAME = "name";
	private static final String PASSWORD = "password";
	private static final String PHONE = "phone_number";
	
	// SQL statements
	
	private static final String SELECT_ALL = "SELECT * FROM parent";
	private static final String SELECT_BY_PRIMARY_KEY = "SELECT * FROM parent WHERE id = '%d'";
	private static final String INSERT = "INSERT INTO parent VALUES ('%d','%s','%s', '%s', '%s')";
	private static final String UPDATE = "UPDATE parent SET id = '%d', surname = '%s', name = '%s', password = '%s', phone_number = '%s' WHERE id = '%s'";
	private static final String DELETE = "DELETE FROM parent WHERE id = '%d'";
	
	// Error message
	
	private static final String ERROR = "Unable to execute %s: %s";
				
	@Override
	public List<Parent> getAll() {
		List<Parent> listParent = new ArrayList<>();
		try (
				Connection c = DaoConnector.getIstance().getConnection();
				Statement stm = c.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY);
				ResultSet rs = stm.executeQuery(SELECT_ALL)
			)
		{
			if(!rs.first()) {
				return listParent;
			}
			do {
				Parent p = new Parent(rs.getInt(ID), rs.getString(SURNAME), rs.getString(NAME), rs.getString(PASSWORD), rs.getString(PHONE));
				listParent.add(p);
			} while(rs.next());
		} catch (SQLException e) {
			SimpleLogger.severe(String.format(ERROR, SELECT_ALL, e.getMessage()));
		}
		return listParent;
	}
	
	
	public Parent getFromId(Integer id) {
		String query = String.format(SELECT_BY_PRIMARY_KEY, id);
		Parent par = null;
		try (
				Connection c = DaoConnector.getIstance().getConnection();
				Statement stm = c.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY);
				ResultSet rs = stm.executeQuery(query)
			)
		{
			if(!rs.first()) {
				return par;
			}
			 par = new Parent(rs.getInt(ID), rs.getString(SURNAME), rs.getString(NAME), rs.getString(PASSWORD), rs.getString(PHONE));
		} catch (SQLException e) {
			SimpleLogger.severe(String.format(ERROR, query, e.getMessage()));
		}
		return par;
	}
	
	
	// CRUD operation
	
	@Override
	public void save(Parent t) {
		String query = String.format(INSERT, t.getId(), t.getSurname(), t.getName(), t.getPassword(), t.getPhoneNumber());
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
	public void update(Parent t, String[] params) {
		String query = String.format(UPDATE, t.getId(), t.getSurname(), t.getName(), t.getPassword(), t.getPhoneNumber(), params[0]);
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
	public void delete(Parent t) {
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
